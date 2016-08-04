package consumo.viewtotalleitura;

import java.util.Date;
import java.util.List;

import consumo.equipamento.Equipamento;
import consumo.local.Local;

public interface ViewTotalLeituraDAO {
	public List<ViewTotalLeitura> listar(Equipamento equipamento);
	
}
