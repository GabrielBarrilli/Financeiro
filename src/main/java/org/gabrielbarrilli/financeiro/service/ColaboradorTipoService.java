package org.gabrielbarrilli.financeiro.service;

import jakarta.persistence.EntityNotFoundException;
import org.gabrielbarrilli.financeiro.mapper.ColaboradorTipoMapper;
import org.gabrielbarrilli.financeiro.model.ColaboradorTipo;
import org.gabrielbarrilli.financeiro.model.dto.request.ColaboradorTipoRequest;
import org.gabrielbarrilli.financeiro.repository.ColaboradorTipoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ColaboradorTipoService {

    private final ColaboradorTipoRepository colaboradorTipoRepository;

    public ColaboradorTipoService(ColaboradorTipoRepository colaboradorTipoRepository) {
        this.colaboradorTipoRepository = colaboradorTipoRepository;
    }

    public ColaboradorTipo createColaboradorTipo(ColaboradorTipoRequest colaboradorTipoRequest) {
        return colaboradorTipoRepository.save(ColaboradorTipoMapper.toEntity(colaboradorTipoRequest));
    }

    public List<ColaboradorTipo> findAllColaboradorTipo() {
        return colaboradorTipoRepository.findAll();
    }

    public ColaboradorTipo findColaboradorTipoById(Long id) {
        return colaboradorTipoRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Tipo de colaborador não encontrado pelo id: " + id)
        );
    }

    public ColaboradorTipo updateColaboradorTipo(Long id, ColaboradorTipoRequest colaboradorTipoRequest) {
        return colaboradorTipoRepository.save(ColaboradorTipoMapper.toEntityUpdate(id, colaboradorTipoRequest));
    }

    public void deleteColaboradorTipo(Long id) {
        colaboradorTipoRepository.deleteById(id);
    }
}
