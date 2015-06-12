package br.com.tcc.dao;

import java.io.Serializable;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class GraficoQuantidadeTipoManutencaoDao implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manager;
	
	public Long totalManutencao(){
		Query consultaTotal = (Query) manager.createQuery("select count(tipoManutencao) from Manutencao");
		Long quantidadeTotal = (Long)consultaTotal.getSingleResult();
		return quantidadeTotal;
	}
	
	public Long preventiva(){
		Query preventiva = (Query) manager.createQuery("select count(tipoManutencao) from Manutencao "
				+ "where tipoManutencao = 'PREVENTIVA' ");
		Long quantidadePrev = (Long) preventiva.getSingleResult();
		return quantidadePrev;
	}
	
	public Long corretiva(){
		Query corretiva = (Query) manager.createQuery("select count(tipoManutencao) from Manutencao"
				+ "where tipoManutencao = 'CORRETIVA' ");
		Long quantidadeCorr = (Long)corretiva.getSingleResult();
		return quantidadeCorr;
	}
	
	public Long preditiva(){
		Query preditiva = (Query) manager.createQuery("select count(tipoManutencao) from Manutencao"
				+ "where tipoManutencao = 'PREDITIVA' ");
		Long quantidadePred = (Long)preditiva.getSingleResult();
		return quantidadePred;
	}

}
