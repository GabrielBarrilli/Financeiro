package org.gabrielbarrilli.financeiro.repository;

import org.gabrielbarrilli.financeiro.model.MovimentacaoTipo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovimentacaoTipoRepository extends JpaRepository<MovimentacaoTipo, Long> {
}