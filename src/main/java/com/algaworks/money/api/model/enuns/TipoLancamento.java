package com.algaworks.money.api.model.enuns;

public enum TipoLancamento {
	
	RECEITA("Receita"),
	DESPESA("Depesa");
	
	private String descricao;

	private TipoLancamento(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
	
	
}
