package consumo.equipamento;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import consumo.leitura.Leitura;
import consumo.local.Local;

public class EquipamentoDAOHibernate implements EquipamentoDAO {

	private Session session;
	public void setSession(Session session){
		this.session = session;
	}
	@Override
	public void excluir(Equipamento equipamento) {
		this.session.delete(equipamento);
	}
	@Override
	public void salvar(Equipamento equipamento) {
		this.session.merge(equipamento);
		this.session.flush();
		this.session.clear();
	}
	@Override
	public Equipamento carregar(Integer equipamento) {
		return (Equipamento) this.session.get(Equipamento.class, equipamento);
	}
	
	@Override
	public List<Equipamento> listar(Local local) {
		Criteria criteria = this.session.createCriteria(Equipamento.class);
		criteria.add(Restrictions.eq("local", local));
		return criteria.list();
	}
	
	@Override
	public Equipamento carregarPorID(String id) {
		Criteria criteria = this.session.createCriteria(Equipamento.class);
		criteria.add(Restrictions.eq("id", id));
		return (Equipamento) criteria.uniqueResult();
	}
	
	
}
