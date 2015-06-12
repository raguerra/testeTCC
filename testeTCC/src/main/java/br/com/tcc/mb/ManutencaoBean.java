package br.com.tcc.mb;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.tcc.dao.CarroDao;
import br.com.tcc.dao.ManutencaoDao;
import br.com.tcc.enumClasse.TipoManutencao;
import br.com.tcc.modelo.Carro;
import br.com.tcc.modelo.Manutencao;

@Named
@RequestScoped
public class ManutencaoBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Carro carro = new Carro();
	
	@Inject
	private Manutencao manutencao;
	
	private int idCarro;
	
	@Inject
	private CarroDao carroDao;
	
	@Inject
	private ManutencaoDao manutencaoDao;
	
	public void preparaNovoCadastro() {
		this.manutencao = new Manutencao();
	}
	
	public void grava(){
//		Carro carro = carroDao.buscaPorId(idCarro);
//		manutencao.setCarro(carro);
		this.manutencaoDao.adiciona(manutencao);
		this.manutencao = new Manutencao();
	}

	public Carro getCarro() {
		return carro;
	}

	public void setCarro(Carro carro) {
		this.carro = carro;
	}

	public Manutencao getManutencao() {
		return manutencao;
	}

	public void setManutencao(Manutencao manutencao) {
		this.manutencao = manutencao;
	}

	public int getIdCarro() {
		return idCarro;
	}

	public void setIdCarro(int idCarro) {
		this.idCarro = idCarro;
	}

	public CarroDao getCarroDao() {
		return carroDao;
	}

	public void setCarroDao(CarroDao carroDao) {
		this.carroDao = carroDao;
	}

	public ManutencaoDao getManutencaoDao() {
		return manutencaoDao;
	}

	public void setManutencaoDao(ManutencaoDao manutencaoDao) {
		this.manutencaoDao = manutencaoDao;
	}
	
	public TipoManutencao[] getTipoManutencao(){  
        return TipoManutencao.values();  
    }  
	
}
