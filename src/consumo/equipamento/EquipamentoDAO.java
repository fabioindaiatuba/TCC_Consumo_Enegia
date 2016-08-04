package consumo.equipamento;

import java.util.List;

import consumo.local.Local;

public interface EquipamentoDAO {
	public void salvar(Equipamento equipamento);
	public void excluir(Equipamento equipamento);
	public Equipamento carregar(Integer equipamento);
	public List<Equipamento> listar(Local local);
	public Equipamento carregarPorID(String id);
}
