package br.com.tcc.modelo;

import java.io.Serializable;

public class GraficoQuantidadeMotorista implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Long catA;
	
	private Long catAB;
	
	private Long catB;
	
	private Long catC;
	
	private Long catD;
	
	private Long catE;
	
	private Long totalMotorista;
	
	public Long getCatA() {
		return catA;
	}

	public void setCatA(Long catA) {
		this.catA = catA;
	}

	public Long getCatAB() {
		return catAB;
	}

	public void setCatAB(Long catAB) {
		this.catAB = catAB;
	}

	public Long getCatB() {
		return catB;
	}

	public void setCatB(Long catB) {
		this.catB = catB;
	}

	public Long getCatC() {
		return catC;
	}

	public void setCatC(Long catC) {
		this.catC = catC;
	}

	public Long getCatD() {
		return catD;
	}

	public void setCatD(Long catD) {
		this.catD = catD;
	}

	public Long getCatE() {
		return catE;
	}

	public void setCatE(Long catE) {
		this.catE = catE;
	}

	public Long getTotalMotorista() {
		return totalMotorista;
	}

	public void setTotalMotorista(Long totalMotorista) {
		this.totalMotorista = totalMotorista;
	}

}
