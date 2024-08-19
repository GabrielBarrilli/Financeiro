package org.gabrielbarrilli.financeiro.service;

import jakarta.persistence.EntityNotFoundException;
import org.gabrielbarrilli.financeiro.mapper.MovimentacaoMapper;
import org.gabrielbarrilli.financeiro.model.Movimentacao;
import org.gabrielbarrilli.financeiro.model.dto.request.MovimentacaoRequest;
import org.gabrielbarrilli.financeiro.repository.MovimentacaoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovimentacaoService {

    private final MovimentacaoRepository movimentacaoRepository;

    public MovimentacaoService(MovimentacaoRepository movimentacaoRepository) {
        this.movimentacaoRepository = movimentacaoRepository;
    }

    public Movimentacao createMovimentacao(MovimentacaoRequest movimentacaoRequest) {
        return movimentacaoRepository.save(MovimentacaoMapper.toEntity(movimentacaoRequest));
    }

    public List<Movimentacao> findAll() {
        return movimentacaoRepository.findAll();
    }

    public Movimentacao findById(Long id) {
        return movimentacaoRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Movimentação não encontrado pelo id: " + id)
        );
    }

    public Movimentacao updateMovimentacao(Long id, MovimentacaoRequest movimentacaoRequest) {
        return movimentacaoRepository.save(MovimentacaoMapper.toEntityUpdate(id, movimentacaoRequest));
    }

    public void deleteMovimentacao(Long id) {
        movimentacaoRepository.deleteById(id);
    }
}
