package consumo.leitura;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import consumo.equipamento.Equipamento;
import consumo.viewleitura.ViewLeitura;

public class LeituraDAOHibernate implements LeituraDAO {
	private Session session;
	
	public void setSession(Session session){
		this.session = session;
	}
	
	@Override
	public void salvar(Leitura leitura) {
		//this.session.saveOrUpdate(lancamento);
		this.session.merge(leitura);
		this.session.flush();
		this.session.clear();
	}

	@Override
	public void excluir(Leitura leitura) {
		this.session.delete(leitura);
	}

	@Override
	public Leitura carregar(Integer leitura) {
		return (Leitura) this.session.get(Leitura.class, leitura);
	}

	@Override
	public List<Leitura> listar(Equipamento equipamento, Date dataInicio, Date dataFim) {
		Criteria criteria = this.session.createCriteria(ViewLeitura.class);
		
		if(dataInicio != null && dataFim != null){
			criteria.add(Restrictions.between("data", dataInicio, dataFim));
		} else if (dataInicio != null) {
			criteria.add(Restrictions.ge("data", dataInicio));
		} else if (dataFim != null) {
			criteria.add(Restrictions.le("data", dataFim));
		}
		
		criteria.add(Restrictions.eq("equipamento", equipamento));
		criteria.addOrder(Order.asc("data"));
		return criteria.list();
	}

}
