package br.com.tcc.enumClasse;

public enum TipoUsuario {
	
	Administrador("Administrador"), 
	Colaborador("Colaborador"), 
	Motorista("Motorista");

	private String descricao;

	TipoUsuario(String descicao) {
		this.descricao = descicao;
	}

	public String getDescricao() {
		return descricao;
	}

}
