package br.com.tcc.mb;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.context.RequestContext;

import br.com.tcc.dao.CarroDao;
import br.com.tcc.modelo.Carro;
import br.com.tcc.util.FacesMessages;

@Named
@RequestScoped
public class CarroBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private FacesMessages messages;

	private Carro carro = new Carro();

	private List<Carro> carros;

	@Inject
	private CarroDao dao;
	
	private Carro carroSelecionado;
	
	public Carro getCarroSelecionado() {
		return carroSelecionado;
	}

	public void setCarroSelecionado(Carro carroSelecionado) {
		System.out.println("Selecionado...");
		System.out.println(carroSelecionado.getPlaca());
		this.carroSelecionado = carroSelecionado;
	}

	public Carro getCarro() {
		return carro;
	}

	public void setCarro(Carro carro) {
		this.carro = carro;
	}

	public void preparaNovoCadastro() {
		this.carro = new Carro();
	}
	
	//vou ter problema para atualizar
	public void grava() {
		dao.adiciona(carro);
		messages.info("Carro cadastrado com sucesso!");
		RequestContext.getCurrentInstance().update(
				Arrays.asList("frm:msgs", "frm:carro-table"));
		this.carro = new Carro();
		this.carros = dao.listaTodos();
	}

	public void remove(Carro carro) {
		dao.remove(carro);
		messages.info("Carro excluido com sucesso!");
		this.carros = dao.listaTodos();
	}
	
	public void atualiza(Carro carro){
		dao.atualiza(carro);
		this.carros = dao.listaTodos();
	}

	public List<Carro> getCarros() {
		if (carros == null) {
			System.out.println("Carregando carros");
			this.carros = dao.listaTodos();
		}
		return carros;
	}
	
	public void consultar(){
		this.carros = dao.listaTodos();
	}
	
}
