package br.com.tcc.dao;

import java.io.Serializable;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class GraficoQuantidadeMotoristaDao implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manager;
	
	public Long totalMotorista(){
		Query consultaTotal = (Query) manager.createQuery("select count(categoriaCnh) from Motorista");
		Long quantidadeTotal = (Long)consultaTotal.getSingleResult();
		return quantidadeTotal;
	}
	
	public Long catA(){
		Query consultaA = (Query) manager.createQuery("select count(categoriaCnh) from Motorista where categoriaCnh = 'A'");
		Long quantidadeA = (Long)consultaA.getSingleResult();
		return quantidadeA;
	}
	
	public Long catB(){
		Query consultaB = (Query) manager.createQuery("select count(categoriaCnh) from Motorista where categoriaCnh = 'B'");
		Long quantidadeB = (Long)consultaB.getSingleResult();
		return quantidadeB;
	}
	
	public Long catAB(){
		Query consultaAB = (Query) manager.createQuery("select count(categoriaCnh) from Motorista where categoriaCnh = 'AB'");
		Long quantidadeAB = (Long)consultaAB.getSingleResult();
		return quantidadeAB;
	}
	
	public Long catC(){
		Query consultaC = (Query) manager.createQuery("select count(categoriaCnh) from Motorista where categoriaCnh = 'C'");
		Long quantidadeC = (Long)consultaC.getSingleResult();
		return quantidadeC;
	}
	
	public Long catD(){
		Query consultaD = (Query) manager.createQuery("select count(categoriaCnh) from Motorista where categoriaCnh = 'D'");
		Long quantidadeD = (Long)consultaD.getSingleResult();
		return quantidadeD;
	}
	
	public Long catE(){
		Query consultaE = (Query) manager.createQuery("select count(categoriaCnh) from Motorista where categoriaCnh = 'E'");
		Long quantidadeE = (Long)consultaE.getSingleResult();
		return quantidadeE;
	}

}
