package consumo.web;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import consumo.local.Local;
import consumo.local.LocalRN;
import consumo.util.ContextoUtil;

@ManagedBean(name="localBean")
@RequestScoped
public class LocalBean {
	private Local selecionado = new Local();
	private List<Local> lista = null;
	
	public LocalBean(){
		this.novo();
	}
	
	public void novo(){
		this.selecionado = new Local();
	}
	
	public void editar(){
		
	}
	
	public String salvar() {
		ContextoBean contextoBean = ContextoUtil.getContextoBean();
		this.selecionado.setUsuario(contextoBean.getUsuarioLogado());

		LocalRN localRN = new LocalRN();
		localRN.salvar(this.selecionado);
		this.selecionado = new Local();
		this.lista = null;
		return null;
	}
	
	
	public String excluir(){
		LocalRN localRN = new LocalRN();
		localRN.excluir(this.selecionado);
		this.selecionado = new Local();
		this.lista = null;
		return null;
	}
	
	public List<Local> getLista() {
		if(this.lista == null){
			ContextoBean contextoBean = ContextoUtil.getContextoBean();
			LocalRN localRN = new LocalRN();
			this.lista = localRN.listar(contextoBean.getUsuarioLogado());
		}
		return this.lista;
		
	}

	
	public String tornarFavorito(){
		LocalRN localRN = new LocalRN();
		localRN.tornarFavorito(this.selecionado);
		this.selecionado = new Local();
		return null;
	}

	public Local getSelecionado() {
		return selecionado;
	}

	public void setSelecionado(Local selecionado) {
		this.selecionado = selecionado;
	}

		
}
