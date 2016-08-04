use consumoenergia;

insert into usuario (codigo, ativo, email, login, nome, senha) 
values (1, 1, 'admin@admin.com.br', 'admin', 'Administrador', md5('admin'));

insert into usuario_permissao (usuario, permissao) values (1, 'ROLE_USUARIO');
insert into usuario_permissao (usuario, permissao) values (1, 'ROLE_ADMINISTRADOR');

insert into local (descricao, favorito, usuario) values ('Local Padrão', 1, 1);
commit;

CREATE OR REPLACE VIEW ultima_leitura_equipamento_aux AS
    select equipamento, max(codigo) AS codigo_leitura
    from consumoenergia.leitura
    group by equipamento;

CREATE OR REPLACE VIEW viewleitura AS
    select l.codigo, e.local, e.codigo AS equipamento, e.descricao, l.data, l.leitura_kwh, e.tensao, e.potencia_max, 
           l.corrente, l.corrente * e.tensao AS potencia, date(NOW()) ,
	EXTRACT(DAY FROM NOW()) dia1, 
	EXTRACT(DAY FROM DATE_SUB(NOW(), INTERVAL 1 DAY)) dia2,
	EXTRACT(DAY FROM DATE_SUB(NOW(), INTERVAL 2 DAY)) dia3,
	EXTRACT(DAY FROM DATE_SUB(NOW(), INTERVAL 3 DAY)) dia4,
	EXTRACT(DAY FROM DATE_SUB(NOW(), INTERVAL 4 DAY)) dia5,
	IFNULL((select avg(x.corrente) corrente_media from leitura x
		where x.equipamento = l.equipamento and Date(x.data) = date(NOW()) 
	group by x.equipamento, Date(x.data)),0) media1, 
	
    IFNULL((select avg(x.corrente) corrente_media from leitura x
		where x.equipamento = l.equipamento and Date(x.data) = Date(DATE_SUB(NOW(), INTERVAL 1 DAY)) 
	group by x.equipamento, Date(x.data)),0) media2,
	
	IFNULL((select avg(x.corrente) corrente_media from leitura x
		where x.equipamento = l.equipamento and Date(x.data) = Date(DATE_SUB(NOW(), INTERVAL 2 DAY)) 
	group by x.equipamento, Date(x.data)),0) media3,
	
	IFNULL((select avg(x.corrente) corrente_media from leitura x
		where x.equipamento = l.equipamento and Date(x.data) = Date(DATE_SUB(NOW(), INTERVAL 3 DAY))
	group by x.equipamento, Date(x.data)),0) media4,
	
	IFNULL((select avg(x.corrente) corrente_media from leitura x
		where x.equipamento = l.equipamento and Date(x.data) = Date(DATE_SUB(NOW(), INTERVAL 4 DAY))
	group by x.equipamento, Date(x.data)),0) media5 
    from equipamento e, leitura l, ultima_leitura_equipamento_aux u
        
    where u.codigo_leitura = l.codigo and l.equipamento = e.codigo;


CREATE OR REPLACE VIEW viewtotal_leitura AS
SELECT  l.equipamento, DATE_FORMAT(l.data,'%m/%Y') AS data, SEC_TO_TIME(sum(l.tempo) DIV 1000) tempo, 
DATE_FORMAT(l.data,'%m/%Y') AS mes, sum(l.leitura_kwh) AS consumo, (sum(l.leitura_kwh) * o.valorKWh) AS valor
from  leitura l, equipamento e, local o, viewleitura u 
where l.equipamento = e.codigo and e.local = o.codigo and l.equipamento = u.equipamento
and l.data between  DATE(DATE_FORMAT(u.data - INTERVAL 1 MONTH,'%Y-%m-01')) 
			    and (DATE(DATE_FORMAT(u.data + INTERVAL 1 MONTH,'%Y-%m-01')) - INTERVAL 1 DAY)
group by l.equipamento, DATE_FORMAT(l.data,'%m/%Y'), o.valorKWh
order by l.equipamento, l.data desc;

CREATE OR REPLACE VIEW viewtotal_leitura_det AS
SELECT l.equipamento, DATE_FORMAT(l.data,'%d/%m/%Y') AS data, SEC_TO_TIME(sum(l.tempo) DIV 1000) tempo, 
DATE_FORMAT(l.data,'%m/%Y') AS mes, sum(l.leitura_kwh) AS consumo,sum(l.leitura_kwh) * o.valorKWh AS valor
from  leitura l, equipamento e, local o, viewleitura u 
where l.equipamento = e.codigo and e.local = o.codigo and l.equipamento = u.equipamento
and l.data between  DATE(DATE_FORMAT(u.data - INTERVAL 1 MONTH,'%Y-%m-01')) 
			    and (DATE(DATE_FORMAT(u.data + INTERVAL 1 MONTH,'%Y-%m-01')) - INTERVAL 1 DAY)
group by l.equipamento, DATE_FORMAT(l.data,'%d/%m/%Y'), o.valorKWh
order by l.equipamento, l.data desc;

-- Ativa os events
SET GLOBAL event_scheduler = ON;
SET GLOBAL event_scheduler = OFF;
-- select @@event_scheduler

-- CRIA UM JOB PARA ZERAR A LEITURA SE A MESMA NÃO GRAVADA ATÉ 3 SEGUNDOS
DELIMITER $$
DROP EVENT grava_leitura_zero$$
CREATE EVENT grava_leitura_zero ON SCHEDULE EVERY 3 SECOND DO BEGIN
   INSERT INTO LEITURA (CORRENTE, DATA, EQUIPAMENTO, TEMPO, LEITURA_KWH)   
			(select distinct 0 CORRENTE, CURRENT_TIMESTAMP data_leitura, u.equipamento,0 tempo, 0 leitura_kwh from 
			(select c.equipamento, c.data, c.corrente 
				from leitura c, equipamento e, (select equipamento, max(data) ultima_leitura from leitura group by equipamento) u
				where c.equipamento = e.codigo
				and c.equipamento = u.equipamento
				and c.data = u.ultima_leitura) u 					
	where (u.data + INTERVAL 3 SECOND) < CURRENT_TIMESTAMP 
	and u.corrente > 0);

END$$
DELIMITER ;