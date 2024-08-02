package org.gabrielbarrilli.financeiro.repository;

import org.gabrielbarrilli.financeiro.model.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> {
}