package br.com.tcc.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaQuery;

import br.com.tcc.modelo.Manutencao;

public class ManutencaoDao implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;

	public void adiciona(Manutencao manutencao) {
		manager.getTransaction().begin();
		manager.persist(manutencao);
		manager.getTransaction().commit();
	}

	public List<Manutencao> listaTodos() {
		CriteriaQuery<Manutencao> query = manager.getCriteriaBuilder()
				.createQuery(Manutencao.class);
		query.select(query.from(Manutencao.class));

		List<Manutencao> lista = manager.createQuery(query).getResultList();

		return lista;
	}

	public int contaTodos() {
		long result = (Long) manager.createQuery(
				"select count(n) from Manutencao n").getSingleResult();

		return (int) result;
	}

	public List<Manutencao> listaTodosPaginada(int firstResult, int maxResults) {
		CriteriaQuery<Manutencao> query = manager.getCriteriaBuilder()
				.createQuery(Manutencao.class);
		query.select(query.from(Manutencao.class));

		List<Manutencao> lista = manager.createQuery(query)
				.setFirstResult(firstResult).setMaxResults(maxResults)
				.getResultList();

		return lista;
	}

}
