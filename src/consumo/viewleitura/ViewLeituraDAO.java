package consumo.viewleitura;

import java.util.Date;
import java.util.List;

import consumo.equipamento.Equipamento;
import consumo.local.Local;

public interface ViewLeituraDAO {
	public List<ViewLeitura> listar(Local local);
	
}
