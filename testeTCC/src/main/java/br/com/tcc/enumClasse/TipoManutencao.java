package br.com.tcc.enumClasse;

public enum TipoManutencao {

	PREVENTIVA("Manutenção prevista no Manual"), 
	CORRETIVA("Manutenção para correção de falha"), 
	PREDITIVA("Modificação de parâmetro de Condição ou Desempenho");

	private String descricao;

	TipoManutencao(String descicao) {
		this.descricao = descicao;
	}

	public String getDescricao() {
		return descricao;
	}

}
