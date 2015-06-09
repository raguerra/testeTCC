package br.com.tcc.mb;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.context.RequestContext;

import br.com.tcc.dao.MotoristaDao;
import br.com.tcc.modelo.Motorista;
import br.com.tcc.util.FacesMessages;

@Named
@RequestScoped
public class MotoristaBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Motorista motorista = new Motorista();

	private List<Motorista> motoristas;

	@Inject
	private MotoristaDao dao;

	@Inject
	private FacesMessages messages;

	private Motorista motoristaSelecionado;

	public Motorista getMotoristaSelecionado() {
		return motoristaSelecionado;
	}

	public void setMotoristaSelecionado(Motorista motoristaSelecionado) {
		this.motoristaSelecionado = motoristaSelecionado;
	}

	public Motorista getMotorista() {
		return motorista;
	}

	public void setMotorista(Motorista motorista) {
		this.motorista = motorista;
	}

	public void preparaNovoCadastro() {
		this.motorista = new Motorista();
	}

	public void grava() {
		dao.adiciona(motorista);
		messages.info("Carro cadastrado com sucesso!");
		RequestContext.getCurrentInstance().update(
				Arrays.asList("frm:msg", "frm:motorista-table"));
		this.motorista = new Motorista();
		this.motoristas = dao.listaTodos();
	}

	public void remove(Motorista motorista) {
		dao.remove(motorista);
		this.motoristas = dao.listaTodos();
	}

	public List<Motorista> getMotoristas() {
		if (motoristas == null) {
			System.out.println("Carregando Motoristas...");
			this.motoristas = dao.listaTodos();
		}
		return motoristas;
	}

	public void consultar() {
		this.motoristas = dao.listaTodos();
	}

}
