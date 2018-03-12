package com.algaworks.money.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.algaworks.money.api.model.Lancamento;
import com.algaworks.money.api.repository.LancamentoRepository;

@Service
public class LancamentoService {
	
	@Autowired
	private LancamentoRepository lancamentoRepository;
	

	public List<Lancamento> listarTodos(){
		return lancamentoRepository.findAll();
	}
	
	public Lancamento buscarPeloCodigo(Long codigo) {
		Lancamento lancamento = lancamentoRepository.findOne(codigo); 
		if(lancamento == null) {
			throw new EmptyResultDataAccessException(1);
		}
		return lancamento;
	}
}
