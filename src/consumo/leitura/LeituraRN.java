package consumo.leitura;

import java.util.Date;
import java.util.List;

import consumo.equipamento.Equipamento;
import consumo.util.DAOFactory;

public class LeituraRN {
	private  LeituraDAO leituraDAO;
	
	public LeituraRN(){
		this.leituraDAO = DAOFactory.criarLeituraDAO();
	}
	
	public void salvar(Leitura leitura){
		leituraDAO.salvar(leitura);
	}
	
	public void excluir(Leitura leitura){
		leituraDAO.excluir(leitura);
	}
	public Leitura carregar(Integer leitura){
		return this.leituraDAO.carregar(leitura);
	}
	
	public List<Leitura> listar(Equipamento equipamento, Date dataInicio, Date dataFim){
		return this.leituraDAO.listar(equipamento, dataInicio, dataFim);
	}
	
}
