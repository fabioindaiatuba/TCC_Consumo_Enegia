package consumo.leitura;

import java.util.Date;
import java.util.List;

import consumo.equipamento.Equipamento;
import consumo.local.Local;

public interface LeituraDAO {
	public void salvar(Leitura leitura);
	public void excluir(Leitura leitura);
	public Leitura carregar(Integer leitura);
	public List<Leitura> listar(Equipamento equipamento, Date dataInicio, Date dataFim);
	
}
