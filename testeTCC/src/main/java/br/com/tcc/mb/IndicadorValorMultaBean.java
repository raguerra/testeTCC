package br.com.tcc.mb;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.tcc.dao.IndicadorValorMultaDao;
import br.com.tcc.modelo.Multa;

@Named
@RequestScoped
public class IndicadorValorMultaBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private IndicadorValorMultaDao dao;

	private Double soma;
	
	private List<Multa> multas;

	public Double getSoma() {
		return soma;
	}

	public void setSoma(Double soma) {
		this.soma = soma;
	}
	
	public Double somar(){
		this.soma = dao.totalMultas();
		return soma;
	}
	
	public List<Multa> getMultas() {
		if (multas == null) {
			System.out.println("Carregando multas");
			this.multas = dao.topMultas();
		}
		return multas;
	}
}
