package consumo.web;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

import consumo.local.Local;
import consumo.local.LocalRN;
import consumo.usuario.Usuario;
import consumo.usuario.UsuarioRN;

@ManagedBean(name="contextoBean")
@SessionScoped
public class ContextoBean {
	private Usuario usuarioLogado = null;
	private Local localAtivo = null;
	
	public Usuario getUsuarioLogado() {
		FacesContext context = FacesContext.getCurrentInstance();
		ExternalContext external = context.getExternalContext();
		String login = external.getRemoteUser();
		if (this.usuarioLogado == null || !login.equals(this.usuarioLogado.getLogin())){
			if(login != null){
				UsuarioRN usuarioRN = new UsuarioRN();
				this.usuarioLogado = usuarioRN.buscaPorLogin(login);
				this.localAtivo = null;
			}
		}
		return usuarioLogado;
	}
	public void setUsuarioLogado(Usuario usuario){
		this.usuarioLogado = usuario;
	}
	
	public Local getLocalAtivo() {
		if(this.localAtivo == null){
			Usuario usuario = this.getUsuarioLogado();
			LocalRN localRN = new LocalRN();
			this.localAtivo = localRN.buscarFavorito(usuario);
			if (this.localAtivo == null){
				List<Local> locais = localRN.listar(usuario);
				if (locais != null){
					for(Local conta : locais){
						this.localAtivo = conta;
						break;
					}
				}
			}
		}
		return this.localAtivo;
	}
	public void setLocalAtivo(ValueChangeEvent event){
		Integer local = (Integer) event.getNewValue();
		LocalRN localRN = new LocalRN();
		this.localAtivo = localRN.carregar(local);
	}
}
