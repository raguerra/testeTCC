package br.com.tcc.dao;

import java.io.Serializable;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class GraficoPizzaGravidadeMultaDao implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;

	public Long totalGravidade() {
		Query consultaGravidade = (Query) manager
				.createQuery("select count(gravidade) from Multa");
		Long quantidadeGrav = (Long) consultaGravidade.getSingleResult();
		return quantidadeGrav;
	}

	public Long gravissima() {
		Query gravissima = (Query) manager
				.createQuery("select count(gravidade) from Multa where gravidade = 'GRAVISSIMA'");
		Long quantidade = (Long) gravissima.getSingleResult();
		return quantidade;
	}

	public Long grave() {
		Query grave = (Query) manager
				.createQuery("select count(gravidade) from Multa where gravidade = 'GRAVE' ");
		Long quantidade = (Long) grave.getSingleResult();
		return quantidade;
	}

	public Long media() {
		Query media = (Query) manager
				.createQuery("select count(gravidade) from Multa where gravidade = 'MEDIA'");
		Long quantidade = (Long) media.getSingleResult();
		return quantidade;
	}

	public Long leve() {
		Query leve = (Query) manager
				.createQuery("select count(gravidade) from Multa where gravidade = 'LEVE'");
		Long quantidade = (Long) leve.getSingleResult();
		return quantidade;
	}

}
