package com.algaworks.money.api.repository.lancamento;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.algaworks.money.api.dto.LancamentoDTO;
import com.algaworks.money.api.model.Lancamento;
import com.algaworks.money.api.repository.filter.LancamentoFilter;

public interface LancamentoRepositoryQuery {
	
	public Page<Lancamento> filtrar(LancamentoFilter lancamentoFilter, Pageable pageable);
	public Page<LancamentoDTO> resumir(LancamentoFilter lancamentoFilter, Pageable pageable);

}
