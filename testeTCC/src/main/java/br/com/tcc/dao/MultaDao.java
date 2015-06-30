package br.com.tcc.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaQuery;

import br.com.tcc.modelo.Multa;

public class MultaDao implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manager;
	
	public void adiciona(Multa multa){
		manager.getTransaction().begin();
		manager.persist(multa);
		manager.getTransaction().commit();
	}
	
	public List<Multa> listaTodos(){
		
		CriteriaQuery<Multa> query = manager.getCriteriaBuilder().createQuery(Multa.class);
		query.select(query.from(Multa.class));
		
		List<Multa> lista = manager.createQuery(query).getResultList();
		
		return lista;
	}
	
	public int contaTodos() {
		long result = (Long) manager.createQuery("select count(n) from Multa n").getSingleResult();
		
		return (int) result;
	}
	

}
