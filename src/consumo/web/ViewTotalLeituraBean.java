package consumo.web;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.event.ValueChangeEvent;

import consumo.equipamento.Equipamento;
import consumo.equipamento.EquipamentoRN;
import consumo.viewtotalleitura.ViewTotalLeitura;
import consumo.viewtotalleitura.ViewTotalLeituraRN;
import consumo.viewtotalleituradet.ViewTotalLeituraDet;
import consumo.viewtotalleituradet.ViewTotalLeituraDetRN;

@ManagedBean(name="viewTotalLeituraBean")
@ViewScoped
public class ViewTotalLeituraBean {
	private ViewTotalLeitura editado;
	private List<ViewTotalLeitura> leituras;
	
	private ViewTotalLeituraDet editadoDet;
	private List<ViewTotalLeituraDet> leiturasDet;
	
	private Equipamento equipamento;
	private String mes;
	
	public ViewTotalLeituraBean(){
		//Seleciona o primeiro da lista de equipamentos
		EquipamentoBean equipamentoBean = new EquipamentoBean();
		if(equipamentoBean.getLista() != null){
			EquipamentoRN equipamentoRN = new EquipamentoRN();
			this.equipamento = equipamentoRN.carregar(equipamentoBean.getLista().get(0).getEquipamento());
		}
	}
	
	public void listar(){
		this.mes = editado.getMes();
	}
	
	public ViewTotalLeitura getEditado() {
		return editado;
	}

	public void setEditado(ViewTotalLeitura editado) {
		this.editado = editado;
	}

	public List<ViewTotalLeitura> getLeituras() {
		
		
		ViewTotalLeituraRN viewTotalLeituraRN = new ViewTotalLeituraRN();
		
		List<ViewTotalLeitura> viewTotalLeitura = viewTotalLeituraRN.listar(this.equipamento);
		
		this.leiturasDet = null;
		return viewTotalLeitura;
		
	}

	public void setLeituras(List<ViewTotalLeitura> leituras) {
		this.leituras = leituras;
	}


	public List<ViewTotalLeituraDet> getLeiturasDet() {
		ViewTotalLeituraDetRN viewTotalLeituraDetRN = new ViewTotalLeituraDetRN();
		
		List<ViewTotalLeituraDet> viewTotalLeituraDet = viewTotalLeituraDetRN.listar(this.equipamento, this.mes);

		return viewTotalLeituraDet;
	}


	public void setLeiturasDet(List<ViewTotalLeituraDet> leiturasDet) {
		this.leiturasDet = leiturasDet;
	}


	public Equipamento getEquipamento() {
		return equipamento;
	}

	
	public void setEquipamento(ValueChangeEvent event){
		
		Integer equipamento = (Integer) event.getNewValue();
		EquipamentoRN equipamentoRN = new EquipamentoRN();
		this.equipamento = equipamentoRN.carregar(equipamento);
		this.leituras = null;
	}
	
	public String getMes() {
		return mes;
	}


	public void setMes(String mes) {
		this.mes = mes;
	}
	
		
}
