package consumo.viewtotalleitura;

import java.util.List;

import consumo.equipamento.Equipamento;
import consumo.util.DAOFactory;

public class ViewTotalLeituraRN {
	private  ViewTotalLeituraDAO viewTotalLeituraDAO;
	
	public ViewTotalLeituraRN(){
		this.viewTotalLeituraDAO = DAOFactory.criarViewTotalLeituraDAO();
	}
	
	public List<ViewTotalLeitura> listar(Equipamento equipamento){
		return this.viewTotalLeituraDAO.listar(equipamento);
	}
	
}
