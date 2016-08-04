package consumo.viewtotalleituradet;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.primefaces.model.chart.MeterGaugeChartModel;

import consumo.equipamento.Equipamento;
import consumo.local.Local;

@Entity
@Table(name="viewtotal_leitura_det")
public class ViewTotalLeituraDet implements Serializable {

	@Id
	@ManyToOne
	@JoinColumn(name = "equipamento", nullable = false)
	private Equipamento equipamento;
	
	@Id
	@Column(name="data")
	private String data;
	
	@Column(name="tempo")
	private String tempo;
	
	@Column(precision = 10, scale = 6)
	private BigDecimal consumo;
	
	@Column(precision = 10, scale = 2)
	private BigDecimal valor;

	@Column(name="mes")
	private String mes;
	
	


	public Equipamento getEquipamento() {
		return equipamento;
	}


	public void setEquipamento(Equipamento equipamento) {
		this.equipamento = equipamento;
	}


	public String getData() {
		return data;
	}


	public void setData(String data) {
		this.data = data;
	}


	public String getTempo() {
		return tempo;
	}


	public void setTempo(String tempo) {
		this.tempo = tempo;
	}


	public BigDecimal getConsumo() {
		return consumo;
	}


	public void setConsumo(BigDecimal consumo) {
		this.consumo = consumo;
	}


	public BigDecimal getValor() {
		return valor;
	}


	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}


	public String getMes() {
		return mes;
	}


	public void setMes(String mes) {
		this.mes = mes;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((consumo == null) ? 0 : consumo.hashCode());
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		result = prime * result
				+ ((equipamento == null) ? 0 : equipamento.hashCode());
		result = prime * result + ((mes == null) ? 0 : mes.hashCode());
		result = prime * result + ((tempo == null) ? 0 : tempo.hashCode());
		result = prime * result + ((valor == null) ? 0 : valor.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ViewTotalLeituraDet other = (ViewTotalLeituraDet) obj;
		if (consumo == null) {
			if (other.consumo != null)
				return false;
		} else if (!consumo.equals(other.consumo))
			return false;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		if (equipamento == null) {
			if (other.equipamento != null)
				return false;
		} else if (!equipamento.equals(other.equipamento))
			return false;
		if (mes == null) {
			if (other.mes != null)
				return false;
		} else if (!mes.equals(other.mes))
			return false;
		if (tempo == null) {
			if (other.tempo != null)
				return false;
		} else if (!tempo.equals(other.tempo))
			return false;
		if (valor == null) {
			if (other.valor != null)
				return false;
		} else if (!valor.equals(other.valor))
			return false;
		return true;
	}


	
		
}
