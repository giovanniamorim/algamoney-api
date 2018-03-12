package com.algaworks.money.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.algaworks.money.api.model.Lancamento;

public interface LancamentoRepository extends JpaRepository<Lancamento, Long>{

}
