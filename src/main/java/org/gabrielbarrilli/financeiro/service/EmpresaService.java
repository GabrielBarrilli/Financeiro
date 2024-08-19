package org.gabrielbarrilli.financeiro.service;

import jakarta.persistence.EntityNotFoundException;
import org.gabrielbarrilli.financeiro.mapper.EmpresaMapper;
import org.gabrielbarrilli.financeiro.model.Empresa;
import org.gabrielbarrilli.financeiro.model.dto.request.EmpresaRequest;
import org.gabrielbarrilli.financeiro.repository.EmpresaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpresaService {

    private final EmpresaRepository empresaRepository;

    public EmpresaService(EmpresaRepository empresaRepository) {
        this.empresaRepository = empresaRepository;
    }

    public Empresa createEmpresa(EmpresaRequest empresaRequest) {
        return EmpresaMapper.toEntity(empresaRequest);
    }

    public List<Empresa> getAllEmpresa() {
        return empresaRepository.findAll();
    }

    public Empresa getEmpresaById(Long id) {
        return empresaRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Empresa nao encontrada com id: " + id)
        );
    }

    public Empresa updateEmpresa(Long id, EmpresaRequest empresaRequest) {
        return empresaRepository.save(EmpresaMapper.toEntityUpdate(id, empresaRequest));
    }

    public void deleteEmpresa(Long id) {
        empresaRepository.deleteById(id);
    }
}
