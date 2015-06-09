package br.com.tcc.modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import br.com.tcc.enumClasse.StatusBd;

@Entity
public class Carro implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@NotEmpty
	private String placa;
	@NotEmpty
	private String modelo;
	@NotEmpty
	private String marca;

	private String versao;

	private String chassi;

	@NotNull
	@Temporal(TemporalType.DATE)
	private Date dataAquisicao;
	
	private double hodometroInicial;

	private double hodometroAtual;

	@Enumerated(EnumType.STRING)
	private StatusBd statusBd;

	@OneToMany(mappedBy = "carro", cascade = CascadeType.PERSIST, targetEntity = Manutencao.class, fetch = FetchType.LAZY)
	private List<Manutencao> manutencoes;

	public Date getDataAquisicao() {
		return dataAquisicao;
	}

	public void setDataAquisicao(Date dataAquisicao) {
		this.dataAquisicao = dataAquisicao;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getVersao() {
		return versao;
	}

	public void setVersao(String versao) {
		this.versao = versao;
	}

	public String getChassi() {
		return chassi;
	}

	public void setChassi(String chassi) {
		this.chassi = chassi;
	}

	public double getHodometroInicial() {
		return hodometroInicial;
	}

	public void setHodometroInicial(double hodometroInicial) {
		this.hodometroInicial = hodometroInicial;
	}

	public double getHodometroAtual() {
		return hodometroAtual;
	}

	public void setHodometroAtual(double hodometroAtual) {
		this.hodometroAtual = hodometroAtual;
	}

	public StatusBd getStatusBd() {
		return statusBd;
	}

	public void setStatusBd(StatusBd statusBd) {
		this.statusBd = statusBd;
	}

	public List<Manutencao> getManutencoes() {
		return manutencoes;
	}

	public void setManutencoes(List<Manutencao> manutencoes) {
		this.manutencoes = manutencoes;
	}

	@Override
	public int hashCode() {
		return getId();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Carro) {
			Carro carro = (Carro) obj;
			return carro.getId() == getId();
		}
		return false;
	}

}
