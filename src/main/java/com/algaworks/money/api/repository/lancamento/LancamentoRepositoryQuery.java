package com.algaworks.money.api.repository.lancamento;

import java.util.List;

import com.algaworks.money.api.model.Lancamento;
import com.algaworks.money.api.repository.filter.LancamentoFilter;

public interface LancamentoRepositoryQuery {
	
	public List<Lancamento> filtrar(LancamentoFilter lancamentoFilter);

}
