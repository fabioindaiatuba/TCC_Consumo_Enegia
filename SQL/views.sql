
use consumoenergia;

CREATE OR REPLACE VIEW ultima_leitura_equipamento_aux AS
    select equipamento, max(codigo) AS codigo_leitura
    from consumoenergia.leitura
    group by equipamento;

CREATE OR REPLACE VIEW viewleitura AS
    select l.codigo, e.local, e.codigo AS equipamento, e.descricao, l.data, l.leitura_kwh, e.tensao, e.potencia_max, l.corrente, 
			l.corrente * e.tensao AS potencia
    from equipamento e, leitura l, ultima_leitura_equipamento_aux u
        
    where u.codigo_leitura = l.codigo and l.equipamento = e.codigo;
