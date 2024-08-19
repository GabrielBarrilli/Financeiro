package org.gabrielbarrilli.financeiro.service;

import jakarta.persistence.EntityNotFoundException;
import org.gabrielbarrilli.financeiro.mapper.MovimentacaoTipoMapper;
import org.gabrielbarrilli.financeiro.model.MovimentacaoTipo;
import org.gabrielbarrilli.financeiro.model.dto.request.MovimentacaoTipoRequest;
import org.gabrielbarrilli.financeiro.repository.MovimentacaoTipoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovimentacaoTipoService {

    private final MovimentacaoTipoRepository movimentacaoTipoRepository;

    public MovimentacaoTipoService(MovimentacaoTipoRepository movimentacaoTipoRepository) {
        this.movimentacaoTipoRepository = movimentacaoTipoRepository;
    }

    public MovimentacaoTipo createMovimentacaoTipo(MovimentacaoTipoRequest movimentacaoTipoRequest) {
        return movimentacaoTipoRepository.save(MovimentacaoTipoMapper.toEntity(movimentacaoTipoRequest));
    }

    public List<MovimentacaoTipo> getAllMovimentacaoTipo() {
        return movimentacaoTipoRepository.findAll();
    }

    public MovimentacaoTipo getMovimentacaoTipoById(Long id) {
        return movimentacaoTipoRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Tipo de movimentação não encontrado com id: " + id)
        );
    }

    public MovimentacaoTipo updateMovimentacaoTipo(Long id, MovimentacaoTipoRequest movimentacaoTipoRequest) {
        return movimentacaoTipoRepository.save(MovimentacaoTipoMapper.toEntityUpdate(id, movimentacaoTipoRequest));
    }

    public void deleteMovimentacaoTipo(Long id) {
        movimentacaoTipoRepository.deleteById(id);
    }
}
