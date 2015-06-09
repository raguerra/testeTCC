package br.com.tcc.dao;

import java.io.Serializable;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class Grafico1Dao implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manager;

	private Long quantidadeI;

	private Long quantidadeA;
	
	private Long quantidadeTotal;
	
	
	public Long getQuantidadeTotal() {
		return quantidadeTotal;
	}

	public void setQuantidadeTotal(Long quantidadeTotal) {
		this.quantidadeTotal = quantidadeTotal;
	}

	public Long getQuantidadeI() {
		return quantidadeI;
	}

	public void setQuantidadeI(Long quantidadeI) {
		this.quantidadeI = quantidadeI;
	}

	public Long getQuantidadeA() {
		return quantidadeA;
	}

	public void setQuantidadeA(Long quantidadeA) {
		this.quantidadeA = quantidadeA;
	}

	public Long quantidadeA() {
		Query consultaAtivo = (Query) manager.createQuery("select count(statusBd) from Carro where statusBd = 'ATIVO' ");
		Long quantidadeAtivo = (Long)consultaAtivo.getSingleResult();
		return quantidadeAtivo;
	}
	
	public Long quantidadeI() {
		Query consultaInativo = (Query) manager.createQuery("select count(statusBd) from Carro where statusBd = 'INATIVO' ");
		Long quantidadeInativo = (Long)consultaInativo.getSingleResult();
		return quantidadeInativo;
	}
	
	public Long quantidadeT() {
		Query consultaTotal = (Query) manager.createQuery("select count(statusBd) from Carro");
		Long quantidadeTotal = (Long)consultaTotal.getSingleResult();
		return quantidadeTotal;
	}
	
}
