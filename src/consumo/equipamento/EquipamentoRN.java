package consumo.equipamento;

import java.util.List;

import consumo.local.Local;
import consumo.util.DAOFactory;

public class EquipamentoRN {
	private EquipamentoDAO equipamentoDAO;
	
	public EquipamentoRN() {
		this.equipamentoDAO = DAOFactory.criarEquipamentoDAO();
	}
	
	public List<Equipamento> listar(Local local){
		return this.equipamentoDAO.listar(local);
	}
	
	public Equipamento carregar(Integer equipamento){
		return this.equipamentoDAO.carregar(equipamento);
	}
	public void salvar(Equipamento equipamento){
		this.equipamentoDAO.salvar(equipamento);
	}
	public void excluir(Equipamento equipamento){
		this.equipamentoDAO.excluir(equipamento);
	}
	
	public Equipamento carregarPorID(String id){
		return this.equipamentoDAO.carregarPorID(id);
	}
}
