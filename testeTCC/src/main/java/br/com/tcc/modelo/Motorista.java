package br.com.tcc.modelo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.validator.constraints.NotEmpty;

import br.com.tcc.enumClasse.StatusBd;

@Entity
public class Motorista implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotEmpty(message = "em branco.")
	private String nome;

	@NotEmpty(message = ": Campo Vazio.")
	private String rg;

	@NotEmpty(message = ": Campo Vazio.")
	private String tipoSangue;

	@NotEmpty(message = ": Campo Vazio.")
	private String cnh;

	@NotEmpty(message = ": Campo Vazio.")
	private String categoriaCnh;

	@Enumerated(EnumType.STRING)
	private StatusBd statusBd;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getTipoSangue() {
		return tipoSangue;
	}

	public void setTipoSangue(String tipoSangue) {
		this.tipoSangue = tipoSangue;
	}

	public String getCnh() {
		return cnh;
	}

	public void setCnh(String cnh) {
		this.cnh = cnh;
	}

	public String getCategoriaCnh() {
		return categoriaCnh;
	}

	public void setCategoriaCnh(String categoriaCnh) {
		this.categoriaCnh = categoriaCnh;
	}

	public StatusBd getStatusBd() {
		return statusBd;
	}

	public void setStatusBd(StatusBd statusBd) {
		this.statusBd = statusBd;
	}

}
