package consumo.equipamento;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import consumo.local.Local;

@Entity
@Table(name="equipamento")
public class Equipamento implements Serializable {
	
	@Id
	@GeneratedValue
	@Column(name="codigo")
	private Integer equipamento;
	
	@ManyToOne
	@OnDelete(action=OnDeleteAction.CASCADE)
	@JoinColumn(name = "local", nullable = false)
	private Local local;
	
	@Column(name="descricao")
	private String descricao;
	
	@Column(precision = 10, scale = 2)
	private BigDecimal tensao;
	
	@Column(precision = 10, scale = 2)
	private BigDecimal potencia_max;
	
	@Column(name="id")
	@org.hibernate.annotations.NaturalId
	private String id;
	
	public Integer getEquipamento() {
		return equipamento;
	}

	public void setEquipamento(Integer equipamento) {
		this.equipamento = equipamento;
	}

	public Local getLocal() {
		return local;
	}

	public void setLocal(Local local) {
		this.local = local;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public BigDecimal getTensao() {
		return tensao;
	}

	public void setTensao(BigDecimal tensao) {
		this.tensao = tensao;
	}

	public BigDecimal getPotencia_max() {
		return potencia_max;
	}

	public void setPotencia_max(BigDecimal potencia_max) {
		this.potencia_max = potencia_max;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result
				+ ((equipamento == null) ? 0 : equipamento.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((local == null) ? 0 : local.hashCode());
		result = prime * result
				+ ((potencia_max == null) ? 0 : potencia_max.hashCode());
		result = prime * result + ((tensao == null) ? 0 : tensao.hashCode());
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
		Equipamento other = (Equipamento) obj;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (equipamento == null) {
			if (other.equipamento != null)
				return false;
		} else if (!equipamento.equals(other.equipamento))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (local == null) {
			if (other.local != null)
				return false;
		} else if (!local.equals(other.local))
			return false;
		if (potencia_max == null) {
			if (other.potencia_max != null)
				return false;
		} else if (!potencia_max.equals(other.potencia_max))
			return false;
		if (tensao == null) {
			if (other.tensao != null)
				return false;
		} else if (!tensao.equals(other.tensao))
			return false;
		return true;
	}
	
	
	
	
}
