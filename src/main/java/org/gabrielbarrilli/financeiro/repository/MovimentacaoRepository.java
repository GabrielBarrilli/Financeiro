package org.gabrielbarrilli.financeiro.repository;

import org.gabrielbarrilli.financeiro.model.Movimentacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovimentacaoRepository extends JpaRepository<Movimentacao, Long> {
}