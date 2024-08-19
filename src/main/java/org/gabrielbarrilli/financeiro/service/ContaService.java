package org.gabrielbarrilli.financeiro.service;

import jakarta.persistence.EntityNotFoundException;
import org.gabrielbarrilli.financeiro.mapper.ContaMapper;
import org.gabrielbarrilli.financeiro.model.Conta;
import org.gabrielbarrilli.financeiro.model.dto.request.ContaRequest;
import org.gabrielbarrilli.financeiro.repository.ContaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContaService {

    private final ContaRepository contaRepository;

    public ContaService(ContaRepository contaRepository) {
        this.contaRepository = contaRepository;
    }

    public Conta createConta(ContaRequest contaRequest) {
        return ContaMapper.toEntity(contaRequest);
    }

    public List<Conta> getAllConta() {
        return contaRepository.findAll();
    }
    public Conta getContaById(Long id) {
        return contaRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Conta não encontrada pelo id: " + id)
        );
    }

    public Conta updateConta(Long id, ContaRequest contaRequest) {
        return ContaMapper.toEntityUpdate(id, contaRequest);
    }

    public void deleteConta(Long id) {
        contaRepository.deleteById(id);
    }
}
