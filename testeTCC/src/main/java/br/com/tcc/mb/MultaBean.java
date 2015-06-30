package br.com.tcc.mb;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.context.RequestContext;

import br.com.tcc.dao.MultaDao;
import br.com.tcc.modelo.Multa;
import br.com.tcc.util.FacesMessages;

@Named
@RequestScoped
public class MultaBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private FacesMessages messages;
	
	@Inject
	private MultaDao dao;
	
	private Multa multa = new Multa();
	
	private List<Multa> multas;
	
	/**
	 * @return the multa
	 */
	public Multa getMulta() {
		return multa;
	}

	/**
	 * @param multa the multa to set
	 */
	public void setMulta(Multa multa) {
		this.multa = multa;
	}

	public void preparaNovoCadastro() {
		this.multa = new Multa();
	}
	
	public void grava() {
		dao.adiciona(multa);
		messages.info("Multa cadastrada com sucesso!");
		RequestContext.getCurrentInstance().update(
				Arrays.asList("frm:msgs", "frm:multa-table"));
		this.multa = new Multa();
		this.multas = dao.listaTodos();
	}
	
	public List<Multa> getMultas() {
		if (multas == null) {
			System.out.println("Carregando multass");
			this.multas = dao.listaTodos();
		}
		return multas;
	}
	
	public void consultar(){
		this.multas = dao.listaTodos();
	}

}
