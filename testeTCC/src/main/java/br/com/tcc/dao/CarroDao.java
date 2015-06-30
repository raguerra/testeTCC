package br.com.tcc.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
//import javax.persistence.Query;
//import javax.persistence.TypedQuery;
//import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
//import javax.persistence.criteria.Root;



import br.com.tcc.enumClasse.StatusBd;
import br.com.tcc.modelo.Carro;

public class CarroDao implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manager;
	
	public void adiciona(Carro carro){
		manager.getTransaction().begin();
		carro.setHodometroAtual(carro.getHodometroInicial());
		carro.setStatusBd(StatusBd.ATIVO);
		manager.persist(carro);
		manager.getTransaction().commit();
	}
	
	public void remove(Carro carro){
		manager.getTransaction().begin();
		carro.setStatusBd(StatusBd.INATIVO);
		manager.merge(carro);
		manager.getTransaction().commit();
	}
	
	public void atualiza(Carro carro){
		manager.getTransaction().begin();
		manager.merge(carro);
		manager.getTransaction().commit();
	}
	
	public List<Carro> listaTodos(){
		
//		CriteriaQuery<Carro> query = manager.getCriteriaBuilder().createQuery(Carro.class);
//		query.select(query.from(Carro.class));
		
		Query query = manager.createQuery("select c from Carro c where c.statusBd=:pStatus");
		query.setParameter("pStatus", StatusBd.ATIVO);
		
		
//		List<Carro> lista = manager.createQuery(query).getResultList();
		@SuppressWarnings("unchecked")
		List<Carro> lista = query.getResultList();
		
		return lista;
	}
	
	public Carro buscaPorId(int id){
		
		Carro carro = manager.find(Carro.class, id);
		return carro;
	}
	
	public int contaTodos() {
		long result = (Long) manager.createQuery("select count(n) from Carro n").getSingleResult();
		
		return (int) result;
	}
	
	public List<Carro> listaTodosPaginada(int firstResult, int maxResults) {
		CriteriaQuery<Carro> query = manager.getCriteriaBuilder().createQuery(Carro.class);
		query.select(query.from(Carro.class));

		List<Carro> lista = manager.createQuery(query).setFirstResult(firstResult)
				.setMaxResults(maxResults).getResultList();

		return lista;
	}
	
}
