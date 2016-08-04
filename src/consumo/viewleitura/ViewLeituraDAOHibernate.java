package consumo.viewleitura;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import consumo.local.Local;

public class ViewLeituraDAOHibernate implements ViewLeituraDAO {
	private Session session;
	
	public void setSession(Session session){
		this.session = session;
	}

	@Override
	public List<ViewLeitura> listar(Local local) {
		Criteria criteria = this.session.createCriteria(ViewLeitura.class);
		
		criteria.add(Restrictions.eq("local", local));
		criteria.addOrder(Order.asc("equipamento"));
		
		List<ViewLeitura> lista = criteria.list();
		
		return lista;
	}
	
	

}
