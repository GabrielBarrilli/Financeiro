package org.gabrielbarrilli.financeiro.service;

import jakarta.persistence.EntityNotFoundException;
import org.gabrielbarrilli.financeiro.mapper.ColaboradorMapper;
import org.gabrielbarrilli.financeiro.model.Colaborador;
import org.gabrielbarrilli.financeiro.model.dto.request.ColaboradorRequest;
import org.gabrielbarrilli.financeiro.repository.ColaboradorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ColaboradorService {

    private final ColaboradorRepository colaboradorRepository;

    public ColaboradorService(ColaboradorRepository colaboradorRepository) {
        this.colaboradorRepository = colaboradorRepository;
    }

    public Colaborador createColaborador(ColaboradorRequest colaboradorRequest) {
        return ColaboradorMapper.toEntity(colaboradorRequest);
    }

    public List<Colaborador> getAllColaborador() {
        return colaboradorRepository.findAll();
    }

    public Colaborador getColaboradorById(Long id) {
        return colaboradorRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Colaborador não encontrado pelo id: " + id)
        );
    }

    public Colaborador updateColaborador(Long id, ColaboradorRequest colaboradorRequest) {
        return ColaboradorMapper.toEntityUpdate(id, colaboradorRequest);
    }

    public void deleteColaborador(Long id) {
        colaboradorRepository.deleteById(id);
    }
}
