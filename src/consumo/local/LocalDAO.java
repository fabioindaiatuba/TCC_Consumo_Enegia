package consumo.local;

import java.util.List;

import consumo.usuario.Usuario;

public interface LocalDAO {
	public void salvar(Local local);
	public void excluir(Local local);
	public Local carregar(Integer local);
	public List<Local> listar(Usuario usuario);
	public Local buscarFavorito(Usuario usuario);
}
