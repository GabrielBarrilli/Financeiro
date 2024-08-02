package org.gabrielbarrilli.financeiro.repository;

import org.gabrielbarrilli.financeiro.model.MovimentacaoCategoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovimentacaoCategoriaRepository extends JpaRepository<MovimentacaoCategoria, Long> {
}