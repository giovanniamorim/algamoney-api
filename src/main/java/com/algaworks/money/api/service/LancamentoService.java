package com.algaworks.money.api.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.algaworks.money.api.dto.LancamentoDTO;
import com.algaworks.money.api.exception.PessoaInexistenteOuInativaException;
import com.algaworks.money.api.model.Lancamento;
import com.algaworks.money.api.model.Pessoa;
import com.algaworks.money.api.repository.LancamentoRepository;
import com.algaworks.money.api.repository.PessoaRepository;
import com.algaworks.money.api.repository.filter.LancamentoFilter;

@Service
public class LancamentoService {
	
	@Autowired
	private LancamentoRepository lancamentoRepository;
	
	@Autowired
	private PessoaRepository pessoaRepository;
	

	public List<Lancamento> pesquisar(LancamentoFilter lancamentoFilter ){
		return lancamentoRepository.findAll();
	}
	
	public Lancamento buscarPeloCodigo(Long codigo) {
		Lancamento lancamento = lancamentoRepository.findOne(codigo); 
		if(lancamento == null) {
			throw new EmptyResultDataAccessException(1);
		}
		return lancamento;
	}

	public void remover(Long codigo) {
		lancamentoRepository.delete(codigo);
	}

	public Lancamento salvar(Lancamento lancamento) {
		Pessoa pessoa = pessoaRepository.findOne(lancamento.getPessoa().getCodigo());
		if(pessoa == null || pessoa.isInativo()) {
			throw new PessoaInexistenteOuInativaException();
		}
		
		return lancamentoRepository.save(lancamento);
	}

	public Lancamento atualizar(Long codigo, Lancamento lancamento) {
		Lancamento lancamentoSalvo = buscarPeloCodigo(codigo);
		BeanUtils.copyProperties(lancamento, lancamentoSalvo, "codigo");
		return lancamentoRepository.save(lancamentoSalvo);
	}
	
	
	public Page<Lancamento> filtrar(LancamentoFilter lancamentoFilter, Pageable pageable) {
		return lancamentoRepository.filtrar(lancamentoFilter, pageable);
	}

	public Page<LancamentoDTO> resumir(LancamentoFilter lancamentoFilter, Pageable pageable) {
		return lancamentoRepository.resumir(lancamentoFilter, pageable);
	}

}
