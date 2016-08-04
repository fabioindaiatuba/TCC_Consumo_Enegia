package consumo.web;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import org.springframework.util.DigestUtils;

import consumo.local.Local;
import consumo.local.LocalRN;
import consumo.usuario.Usuario;
import consumo.usuario.UsuarioRN;

@ManagedBean(name="usuarioBean")
@RequestScoped
public class UsuarioBean {
	private Usuario usuario = new Usuario();
	private String confirmarSenha;
	private List<Usuario> lista;
	private String destinoSalvar;
	private String senhaCriptografada;
	private Local local = new Local();
	
	public String novo(){
		this.destinoSalvar = "/admin/principal";
		this.usuario = new Usuario();
		this.usuario.setAtivo(true);
		return "/admin/usuario_novo";
	}
	public String editar(){
		//this.confirmarSenha = this.usuario.getSenha();
		this.senhaCriptografada = this.usuario.getSenha();
	    return "/admin/usuario_edicao";
	}
	
	public String salvar(){
		FacesContext context = FacesContext.getCurrentInstance();

		String senha = this.usuario.getSenha();
		if (senha != null &&
	            senha.trim().length() > 0  &&
	            !senha.equals(this.confirmarSenha)) {
			FacesMessage facesMessage = new FacesMessage("A senha não foi confirmada corretamente");
			context.addMessage(null, facesMessage);
			return null;
		}
		
		if (senha != null && senha.trim().length() == 0) {
			this.usuario.setSenha(this.senhaCriptografada);
		} else {
			String senhaCripto = DigestUtils.md5DigestAsHex(senha.getBytes());
			this.usuario.setSenha(senhaCripto);
		}
		
		UsuarioRN usuarioRN = new UsuarioRN();
		usuarioRN.salvar(this.usuario);
		
		if(this.local.getDescricao() != null){
			this.local.setUsuario(this.usuario);
			this.local.setFavorito(true);
			LocalRN localRN = new LocalRN();
			localRN.salvar(local);
		}
		return this.destinoSalvar;
	}
	
	public String excluir(){
		UsuarioRN usuarioRN = new UsuarioRN();
		usuarioRN.excluir(this.usuario);
		this.lista = null;
		return null;
	}
	
	public String ativar(){
		if(this.usuario.isAtivo()){
			this.usuario.setAtivo(false);
		} else {
			this.usuario.setAtivo(true);
		}
		
		UsuarioRN usuarioRN = new UsuarioRN();
		usuarioRN.salvar(this.usuario);
		return null;
	}
	
	public String atribuiPermissao(Usuario usuario, String permissao){
		this.usuario = usuario;
		java.util.Set<String> permissoes = this.usuario.getPermissao();
		if(permissoes.contains(permissao)){
			permissoes.remove(permissao);
		} else {
			permissoes.add(permissao);
		}
		return null;
	}
	
	public Local getLocal() {
		return local;
	}
	public void setLocal(Local local) {
		this.local = local;
	}
	public List<Usuario> getLista(){
		if(this.lista == null){
			UsuarioRN usuarioRN = new UsuarioRN();
			this.lista = usuarioRN.listar();
		}
		return this.lista;
	}
	
	public String getDestinoSalvar() {
		return destinoSalvar;
	}
	public void setDestinoSalvar(String destinoSalvar) {
		this.destinoSalvar = destinoSalvar;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public String getConfirmarSenha() {
		return confirmarSenha;
	}
	public void setConfirmarSenha(String confirmarSenha) {
		this.confirmarSenha = confirmarSenha;
	}
	public String getSenhaCriptografada() {
		return senhaCriptografada;
	}
	public void setSenhaCriptografada(String senhaCriptografada) {
		this.senhaCriptografada = senhaCriptografada;
	}
	
	
}
