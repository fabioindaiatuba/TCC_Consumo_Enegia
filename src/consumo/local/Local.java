package consumo.local;

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

import consumo.usuario.Usuario;

@Entity
@Table(name="local")
public class Local implements Serializable {
	
	@Id
	@GeneratedValue
	@Column(name="codigo")
	private Integer local;
	
	@ManyToOne
	@OnDelete(action=OnDeleteAction.CASCADE)
	@JoinColumn(name = "usuario", nullable = false)
	private Usuario usuario;
	
	@Column(name="descricao")
	private String descricao;
	
	@Column(name="favorito")
	private boolean favorito;
	
	@Column(precision = 10, scale = 6)
	private BigDecimal valorKWh;

	public Integer getLocal() {
		return local;
	}

	public void setLocal(Integer local) {
		this.local = local;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public boolean isFavorito() {
		return favorito;
	}

	public void setFavorito(boolean favorito) {
		this.favorito = favorito;
	}

	
	public BigDecimal getValorKWh() {
		return valorKWh;
	}

	public void setValorKWh(BigDecimal valorKWh) {
		this.valorKWh = valorKWh;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + (favorito ? 1231 : 1237);
		result = prime * result + ((local == null) ? 0 : local.hashCode());
		result = prime * result + ((usuario == null) ? 0 : usuario.hashCode());
		result = prime * result
				+ ((valorKWh == null) ? 0 : valorKWh.hashCode());
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
		Local other = (Local) obj;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (favorito != other.favorito)
			return false;
		if (local == null) {
			if (other.local != null)
				return false;
		} else if (!local.equals(other.local))
			return false;
		if (usuario == null) {
			if (other.usuario != null)
				return false;
		} else if (!usuario.equals(other.usuario))
			return false;
		if (valorKWh == null) {
			if (other.valorKWh != null)
				return false;
		} else if (!valorKWh.equals(other.valorKWh))
			return false;
		return true;
	}

}
