package org.gabrielbarrilli.financeiro.repository;

import org.gabrielbarrilli.financeiro.model.Banco;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BancoRepository extends JpaRepository<Banco, Long> {
}