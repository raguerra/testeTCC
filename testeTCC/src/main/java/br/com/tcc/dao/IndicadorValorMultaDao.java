package br.com.tcc.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.tcc.modelo.Multa;

public class IndicadorValorMultaDao implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;

	public double totalMultas() {
		Query query = (Query) manager
				.createQuery("select SUM(valor) from Multa");
		return (Double) query.getSingleResult();
	}

	public ArrayList<Multa> topMultas() {
		Query query = (Query) manager
				.createQuery("SELECT motorista, SUM(valor) FROM Multa GROUP BY motorista ORDER BY SUM(valor) ");
		
		
		List<Multa> lista = (query).getResultList();
		

		return (ArrayList<Multa>) lista;
	}

}
