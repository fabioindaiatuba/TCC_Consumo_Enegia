package consumo.viewtotalleitura;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import consumo.equipamento.Equipamento;

public class ViewTotalLeituraDAOHibernate implements ViewTotalLeituraDAO {
	private Session session;
	
	public void setSession(Session session){
		this.session = session;
	}

	@Override
	public List<ViewTotalLeitura> listar(Equipamento equipamento) {
		Criteria criteria = this.session.createCriteria(ViewTotalLeitura.class);
		
		criteria.add(Restrictions.eq("equipamento", equipamento));
		
		List<ViewTotalLeitura> lista = criteria.list();
		
		return lista;
	}
	
	

}
