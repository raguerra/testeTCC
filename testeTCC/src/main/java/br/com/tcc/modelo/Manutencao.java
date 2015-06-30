package br.com.tcc.modelo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import br.com.tcc.enumClasse.TipoManutencao;

@Entity
public class Manutencao implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

//	@ManyToOne
//	@JoinColumn(name = "carro_id")
//	private Carro carro;
	@NotEmpty(message="Carro")
	private String placaCarro;

	@Enumerated(EnumType.STRING)
	private TipoManutencao tipoManutencao;
	@NotEmpty
	private String descServicos;
	@NotNull
	@Temporal(TemporalType.DATE)
	private Date dataInicioManutencao;
	@NotNull
	@Temporal(TemporalType.DATE)
	private Date dataFimManutencao;

	public Manutencao() {

	}

	public Manutencao(TipoManutencao tipoManutencao, String descServicos,
			Date dataInicioManutencao, Date dataFimManutencao) {
		this.tipoManutencao = tipoManutencao;
		this.descServicos = descServicos;
		this.dataInicioManutencao = dataInicioManutencao;
		this.dataFimManutencao = dataFimManutencao;
//		this.carro = carro;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

//	public Carro getCarro() {
//		return carro;
//	}
//
//	public void setCarro(Carro carro) {
//		this.carro = carro;
//	}
	
	
	
	public TipoManutencao getTipoManutencao() {
		return tipoManutencao;
	}

	public String getPlacaCarro() {
		return placaCarro;
	}

	public void setPlacaCarro(String placaCarro) {
		this.placaCarro = placaCarro;
	}

	public void setTipoManutencao(TipoManutencao tipoManutencao) {
		this.tipoManutencao = tipoManutencao;
	}

	public String getDescServicos() {
		return descServicos;
	}

	public void setDescServicos(String descServicos) {
		this.descServicos = descServicos;
	}

	public Date getDataInicioManutencao() {
		return dataInicioManutencao;
	}

	public void setDataInicioManutencao(Date dataInicioManutencao) {
		this.dataInicioManutencao = dataInicioManutencao;
	}

	public Date getDataFimManutencao() {
		return dataFimManutencao;
	}

	public void setDataFimManutencao(Date dataFimManutencao) {
		this.dataFimManutencao = dataFimManutencao;
	}
	
	@Override
	public int hashCode() {
		return getId();
	}
	
	@Override
	public boolean equals(Object obj){
		if(obj instanceof Manutencao){
			Manutencao manutencao = (Manutencao) obj;
			return manutencao.getId() == getId();
		}
		return false;
	}

}
