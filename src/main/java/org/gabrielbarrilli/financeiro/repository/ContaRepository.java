package org.gabrielbarrilli.financeiro.repository;

import org.gabrielbarrilli.financeiro.model.Conta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContaRepository extends JpaRepository<Conta, Long> {
}