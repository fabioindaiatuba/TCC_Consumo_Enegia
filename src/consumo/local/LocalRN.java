package consumo.local;

import java.util.List;

import consumo.usuario.Usuario;
import consumo.util.DAOFactory;

public class LocalRN {
	private LocalDAO localDAO;
	
	public LocalRN() {
		this.localDAO = DAOFactory.criarLocalDAO();
	}
	
	public List<Local> listar(Usuario usuario){
		return this.localDAO.listar(usuario);
	}
	
	public Local carregar(Integer local){
		return this.localDAO.carregar(local);
	}
	public void salvar(Local local){
		this.localDAO.salvar(local);
	}
	public void excluir(Local local){
		this.localDAO.excluir(local);
	}
	public void tornarFavorito(Local localFavorito){
		Local local = this.buscarFavorito(localFavorito.getUsuario());
		if(local != null){
			local.setFavorito(false);
			this.localDAO.salvar(local);
		}
		localFavorito.setFavorito(true);
		this.localDAO.salvar(localFavorito);
	}
	
	public Local buscarFavorito(Usuario usuario){
		return this.localDAO.buscarFavorito(usuario);
	}
}
