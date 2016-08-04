package consumo.leitura;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import consumo.equipamento.Equipamento;

@Entity
@Table(name="leitura")
public class Leitura implements Serializable {
	
	@Id
	@GeneratedValue
	@Column(name="codigo")
	private Integer leitura;
	
	@ManyToOne
	@JoinColumn(name = "equipamento", nullable = false)
	private Equipamento equipamento;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date data;
	
	@Column(precision = 10, scale = 6)
	private BigDecimal leitura_kwh;
	
	@Column(precision = 10, scale = 2)
	private BigDecimal tempo;

	@Column(precision = 10, scale = 6)
	private BigDecimal corrente;
	
	public Integer getLeitura() {
		return leitura;
	}

	public void setLeitura(Integer leitura) {
		this.leitura = leitura;
	}

	public Equipamento getEquipamento() {
		return equipamento;
	}

	public void setEquipamento(Equipamento equipamento) {
		this.equipamento = equipamento;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public BigDecimal getLeitura_kwh() {
		return leitura_kwh;
	}

	public void setLeitura_kwh(BigDecimal leitura_kwh) {
		this.leitura_kwh = leitura_kwh;
	}

	public BigDecimal getTempo() {
		return tempo;
	}

	public void setTempo(BigDecimal tempo) {
		this.tempo = tempo;
	}

	public BigDecimal getCorrente() {
		return corrente;
	}

	public void setCorrente(BigDecimal corrente) {
		this.corrente = corrente;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((corrente == null) ? 0 : corrente.hashCode());
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		result = prime * result
				+ ((equipamento == null) ? 0 : equipamento.hashCode());
		result = prime * result + ((leitura == null) ? 0 : leitura.hashCode());
		result = prime * result
				+ ((leitura_kwh == null) ? 0 : leitura_kwh.hashCode());
		result = prime * result + ((tempo == null) ? 0 : tempo.hashCode());
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
		Leitura other = (Leitura) obj;
		if (corrente == null) {
			if (other.corrente != null)
				return false;
		} else if (!corrente.equals(other.corrente))
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
		if (leitura == null) {
			if (other.leitura != null)
				return false;
		} else if (!leitura.equals(other.leitura))
			return false;
		if (leitura_kwh == null) {
			if (other.leitura_kwh != null)
				return false;
		} else if (!leitura_kwh.equals(other.leitura_kwh))
			return false;
		if (tempo == null) {
			if (other.tempo != null)
				return false;
		} else if (!tempo.equals(other.tempo))
			return false;
		return true;
	}

	

	
	
}
