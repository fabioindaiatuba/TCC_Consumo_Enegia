package consumo.viewtotalleituradet;

import java.util.Date;
import java.util.List;

import consumo.equipamento.Equipamento;
import consumo.local.Local;

public interface ViewTotalLeituraDetDAO {
	public List<ViewTotalLeituraDet> listar(Equipamento equipamento, String mes);
	
}
