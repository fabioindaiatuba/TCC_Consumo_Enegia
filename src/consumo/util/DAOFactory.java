package consumo.util;

import consumo.equipamento.EquipamentoDAO;
import consumo.equipamento.EquipamentoDAOHibernate;
import consumo.leitura.LeituraDAO;
import consumo.leitura.LeituraDAOHibernate;
import consumo.local.LocalDAO;
import consumo.local.LocalDAOHibernate;
import consumo.usuario.UsuarioDAO;
import consumo.usuario.UsuarioDAOHibernate;
import consumo.viewleitura.ViewLeituraDAO;
import consumo.viewleitura.ViewLeituraDAOHibernate;
import consumo.viewtotalleitura.ViewTotalLeituraDAO;
import consumo.viewtotalleitura.ViewTotalLeituraDAOHibernate;
import consumo.viewtotalleituradet.ViewTotalLeituraDetDAO;
import consumo.viewtotalleituradet.ViewTotalLeituraDetDAOHibernate;


public class DAOFactory {
	public static UsuarioDAO criarUsuarioDAO() {
		UsuarioDAOHibernate usuarioDAO = new UsuarioDAOHibernate();
		usuarioDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		return usuarioDAO;
	}
	public static LocalDAO criarLocalDAO() {
		LocalDAOHibernate localDAO = new LocalDAOHibernate();
		localDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		return localDAO;
	}
	public static EquipamentoDAO criarEquipamentoDAO() {
		EquipamentoDAOHibernate equipamentoDAO = new EquipamentoDAOHibernate();
		equipamentoDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		return equipamentoDAO;
	}
	public static LeituraDAO criarLeituraDAO() {
		LeituraDAOHibernate leituraDAO = new LeituraDAOHibernate();
		leituraDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		return leituraDAO;
	}
	public static ViewLeituraDAO criarViewLeituraDAO() {
		ViewLeituraDAOHibernate viewLeituraDAO = new ViewLeituraDAOHibernate();
		viewLeituraDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		return viewLeituraDAO;
	}
	public static ViewTotalLeituraDAO criarViewTotalLeituraDAO() {
		ViewTotalLeituraDAOHibernate viewTotalLeituraDAO = new ViewTotalLeituraDAOHibernate();
		viewTotalLeituraDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		return viewTotalLeituraDAO;
	}
	public static ViewTotalLeituraDetDAO criarViewTotalLeituraDetDAO() {
		ViewTotalLeituraDetDAOHibernate viewTotalLeituraDetDAO = new ViewTotalLeituraDetDAOHibernate();
		viewTotalLeituraDetDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		return viewTotalLeituraDetDAO;
	}
}
