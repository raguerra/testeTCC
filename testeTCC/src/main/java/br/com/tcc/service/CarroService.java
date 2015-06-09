package br.com.tcc.service;

import java.io.Serializable;

import javax.inject.Inject;

import br.com.tcc.dao.CarroDao;
import br.com.tcc.modelo.Carro;
import br.com.tcc.tx.Transacional;

public class CarroService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private CarroDao dao;

	@Transacional
	public void salvar(Carro carro) {
		dao.atualiza(carro);
	}

	@Transacional
	public void excluir(Carro carro) {
		dao.remove(carro);
	}

}