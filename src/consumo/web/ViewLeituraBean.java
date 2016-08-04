package consumo.web;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import consumo.equipamento.EquipamentoRN;
import consumo.leitura.Leitura;
import consumo.leitura.LeituraRN;
import consumo.local.Local;
import consumo.util.ContextoUtil;
import consumo.viewleitura.ViewLeitura;
import consumo.viewleitura.ViewLeituraRN;

@ManagedBean(name="viewLeituraBean")
@ViewScoped
public class ViewLeituraBean {
	private ViewLeitura editado;
	private List<ViewLeitura> leituras;
	
	
	
	public ViewLeituraBean(){
	}
	
	public void novo(){
	}
	
	public void editar(){
	}
	
	public void salvar(){
	}

	public List<ViewLeitura> getLeituras() {
		ContextoBean contextoBean = ContextoUtil.getContextoBean();
		Local local = contextoBean.getLocalAtivo();
		
		ViewLeituraRN viewLeituraRN = new ViewLeituraRN();
		
		List<ViewLeitura> viewLeitura = viewLeituraRN.listar(local);

		return viewLeituraRN.listar(local);
		
	}

	public void setLeituras(List<ViewLeitura> leituras) {
		this.leituras = leituras;
	}
	
		
}
