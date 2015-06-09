package br.com.tcc.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaQuery;

import br.com.tcc.enumClasse.StatusBd;
import br.com.tcc.modelo.Motorista;

public class MotoristaDao implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;

	public void adiciona(Motorista motorista) {
		manager.getTransaction().begin();
		motorista.setStatusBd(StatusBd.ATIVO);
		manager.persist(motorista);
		manager.getTransaction().commit();
	}

	public void remove(Motorista motorista) {
		manager.getTransaction().begin();
		motorista.setStatusBd(StatusBd.INATIVO);
		manager.merge(motorista);
		manager.getTransaction().commit();
	}

	public void altera(Motorista motorista) {
		manager.getTransaction().begin();
		manager.merge(motorista);
		manager.getTransaction().commit();
	}

	public List<Motorista> listaTodos() {

		CriteriaQuery<Motorista> query = manager.getCriteriaBuilder()
				.createQuery(Motorista.class);
		query.select(query.from(Motorista.class));
		List<Motorista> lista = manager.createQuery(query).getResultList();
		return lista;
	}

	public Motorista buscaPorId(Long id) {
		Motorista motorista = manager.find(Motorista.class, id);
		return motorista;
	}

}
