package org.gabrielbarrilli.financeiro.repository;

import org.gabrielbarrilli.financeiro.model.Colaborador;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ColaboradorRepository extends JpaRepository<Colaborador, Long> {
}