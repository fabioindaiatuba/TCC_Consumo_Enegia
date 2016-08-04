package consumo.viewtotalleituradet;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import consumo.equipamento.Equipamento;

public class ViewTotalLeituraDetDAOHibernate implements ViewTotalLeituraDetDAO {
	private Session session;
	
	public void setSession(Session session){
		this.session = session;
	}

	@Override
	public List<ViewTotalLeituraDet> listar(Equipamento equipamento, String mes) {
		Criteria criteria = this.session.createCriteria(ViewTotalLeituraDet.class);
		
		criteria.add(Restrictions.eq("equipamento", equipamento));
		criteria.add(Restrictions.eq("mes", mes));
		
		List<ViewTotalLeituraDet> lista = criteria.list();
		
		return lista;
	}
	
	

}
