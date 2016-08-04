package consumo.local;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import consumo.usuario.Usuario;

public class LocalDAOHibernate implements LocalDAO {

	private Session session;
	public void setSession(Session session){
		this.session = session;
	}
	@Override
	public void excluir(Local local) {
		this.session.delete(local);
	}
	@Override
	public void salvar(Local local) {
		//this.session.saveOrUpdate(local);
		this.session.merge(local);
		this.session.flush();
		this.session.clear();
	}
	@Override
	public Local carregar(Integer local) {
		return (Local) this.session.get(Local.class, local);
	}
	
	@Override
	public List<Local> listar(Usuario usuario) {
		Criteria criteria = this.session.createCriteria(Local.class);
		criteria.add(Restrictions.eq("usuario", usuario));
		return criteria.list();
	}
	
	@Override
	public Local buscarFavorito(Usuario usuario) {
		Criteria criteria = this.session.createCriteria(Local.class);
		criteria.add(Restrictions.eq("usuario", usuario));
		criteria.add(Restrictions.eq("favorito", true));
		return (Local) criteria.uniqueResult();
	}

}
