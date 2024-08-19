package org.gabrielbarrilli.financeiro.service;

import jakarta.persistence.EntityNotFoundException;
import org.gabrielbarrilli.financeiro.mapper.MovimentacaoCategoriaMapper;
import org.gabrielbarrilli.financeiro.model.MovimentacaoCategoria;
import org.gabrielbarrilli.financeiro.model.dto.request.MovimentacaoCategoriaRequest;
import org.gabrielbarrilli.financeiro.repository.MovimentacaoCategoriaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovimentacaoCategoriaService {

    private final MovimentacaoCategoriaRepository movimentacaoCategoriaRepository;

    public MovimentacaoCategoriaService(MovimentacaoCategoriaRepository movimentacaoCategoriaRepository) {
        this.movimentacaoCategoriaRepository = movimentacaoCategoriaRepository;
    }

    public MovimentacaoCategoria createMovimentacaoCategoria(MovimentacaoCategoriaRequest movimentacaoCategoriaRequest) {
        return MovimentacaoCategoriaMapper.toEntity(movimentacaoCategoriaRequest);
    }

    public List<MovimentacaoCategoria> findAllMovimentacaoCategoria() {
        return movimentacaoCategoriaRepository.findAll();
    }

    public MovimentacaoCategoria findMovimentacaoCategoriaById(Long id) {
        return movimentacaoCategoriaRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Categoria de movimentação não encontrada pelo id: " + id)
        );
    }

    public MovimentacaoCategoria updateMovimentacaoCategoria(Long id, MovimentacaoCategoriaRequest movimentacaoCategoriaRequest) {
        return movimentacaoCategoriaRepository.save(MovimentacaoCategoriaMapper.toEntityUpdate(id, movimentacaoCategoriaRequest));
    }

    public void deleteMovimentacaoCategoria(Long id) {
        movimentacaoCategoriaRepository.deleteById(id);
    }

}
