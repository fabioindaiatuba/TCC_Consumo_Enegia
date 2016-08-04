package consumo.web;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import consumo.equipamento.Equipamento;
import consumo.equipamento.EquipamentoRN;
import consumo.local.Local;
import consumo.util.ContextoUtil;

@ManagedBean(name="equipamentoBean")
@ViewScoped
public class EquipamentoBean {
	private List<Equipamento> lista = null;
	private Equipamento editado;
	
	public EquipamentoBean(){
		this.novo();
	}
	
	public void novo(){
		this.editado = new Equipamento();
	}
	
	public void editar(){
		
	}
	
	public void salvar(){
		ContextoBean contextoBean = ContextoUtil.getContextoBean();
		this.editado.setLocal(contextoBean.getLocalAtivo());
		EquipamentoRN equipamentoRN = new EquipamentoRN();
		equipamentoRN.salvar(this.editado);
		this.novo();
		this.lista = null;
		
	}
	public void excluir(){

		EquipamentoRN equipamentoRN = new EquipamentoRN();
		//this.editado = equipamentoRN.carregar(this.editado.getEquipamento());
		equipamentoRN.excluir(this.editado);
		
		this.lista = null;
	}
	public List<Equipamento> getLista(){
		if (this.lista == null) {	
			ContextoBean contextoBean = ContextoUtil.getContextoBean();
			Local local = contextoBean.getLocalAtivo();
			
			EquipamentoRN equipamentoRN = new EquipamentoRN();
			this.lista = equipamentoRN.listar(local);
		}
		return this.lista;
	}

	public Equipamento getEditado() {
		return editado;
	}

	public void setEditado(Equipamento editado) {
		this.editado = editado;
	}

}
