package consumo.viewleitura;

import java.util.List;

import consumo.local.Local;
import consumo.util.DAOFactory;

public class ViewLeituraRN {
	private  ViewLeituraDAO viewLeituraDAO;
	
	public ViewLeituraRN(){
		this.viewLeituraDAO = DAOFactory.criarViewLeituraDAO();
	}
	
	public List<ViewLeitura> listar(Local local){
		return this.viewLeituraDAO.listar(local);
	}
	
}
