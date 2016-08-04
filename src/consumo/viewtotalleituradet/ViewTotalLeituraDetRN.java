package consumo.viewtotalleituradet;

import java.util.List;

import consumo.equipamento.Equipamento;
import consumo.util.DAOFactory;

public class ViewTotalLeituraDetRN {
	private  ViewTotalLeituraDetDAO viewTotalLeituraDetDAO;
	
	public ViewTotalLeituraDetRN(){
		this.viewTotalLeituraDetDAO = DAOFactory.criarViewTotalLeituraDetDAO();
	}
	
	public List<ViewTotalLeituraDet> listar(Equipamento equipamento, String mes){
		return this.viewTotalLeituraDetDAO.listar(equipamento, mes);
	}
	
}
