package consumo.web;

import java.math.BigDecimal;
import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import consumo.equipamento.Equipamento;
import consumo.equipamento.EquipamentoRN;
import consumo.leitura.Leitura;
import consumo.leitura.LeituraRN;
import consumo.util.ContextoUtil;

@ManagedBean(name="leituraArduinoBean")
@ViewScoped
public class LeituraArduinoBean {
	private Leitura editado;
	private String leitura_kwh;
	private String tempo;
	private String id;
	private String corrente;
	private Equipamento equipamento;
	
	
	public LeituraArduinoBean(){
		this.novo();
	}
	
	public void novo(){
		this.editado = new Leitura();
	}
	
	public void editar(){
		
	}
	
	public void salvar(){
		ContextoBean contextoBean = ContextoUtil.getContextoBean();
		
		
		EquipamentoRN equipamentoRN = new EquipamentoRN();
		this.equipamento = equipamentoRN.carregarPorID(this.id);
		if(this.equipamento != null){
			this.editado.setEquipamento(this.equipamento);
			this.editado.setLeitura_kwh(new BigDecimal(this.leitura_kwh));
			this.editado.setTempo(new BigDecimal(this.tempo));
			this.editado.setCorrente(new BigDecimal(this.corrente));
			this.editado.setData(new Date(System.currentTimeMillis()));
			
			LeituraRN leituraRN = new LeituraRN();
			leituraRN.salvar(this.editado);
		}
		
		this.novo();
		
	}

	public Leitura getEditado() {
		return editado;
	}

	public void setEditado(Leitura editado) {
		this.editado = editado;
	}

	public String getLeitura_kwh() {
		return leitura_kwh;
	}

	public void setLeitura_kwh(String leitura_kwh) {
		this.leitura_kwh = leitura_kwh;
	}

	public String getTempo() {
		return tempo;
	}

	public void setTempo(String tempo) {
		this.tempo = tempo;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCorrente() {
		return corrente;
	}

	public void setCorrente(String corrente) {
		this.corrente = corrente;
	}
	
}
