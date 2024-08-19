package org.gabrielbarrilli.financeiro.mapper;

import jakarta.persistence.EntityNotFoundException;
import org.gabrielbarrilli.financeiro.model.MovimentacaoCategoria;
import org.gabrielbarrilli.financeiro.model.dto.request.MovimentacaoCategoriaRequest;
import org.gabrielbarrilli.financeiro.model.dto.response.MovimentacaoCategoriaResponse;
import org.gabrielbarrilli.financeiro.repository.MovimentacaoCategoriaRepository;

import java.util.List;
import java.util.stream.Collectors;

public class MovimentacaoCategoriaMapper {

    private static MovimentacaoCategoriaRepository movimentacaoCategoriaRepository;

    public MovimentacaoCategoriaMapper(
            MovimentacaoCategoriaRepository movimentacaoCategoriaRepository
    ) {
        MovimentacaoCategoriaMapper.movimentacaoCategoriaRepository = movimentacaoCategoriaRepository;
    }

    public static MovimentacaoCategoriaResponse toResponse(MovimentacaoCategoria movimentacaoCategoria) {

        return new MovimentacaoCategoriaResponse(
                movimentacaoCategoria.getId(),
                movimentacaoCategoria.getMovimentacaoCategoriaName()
        );
    }

    public static MovimentacaoCategoria toEntity(MovimentacaoCategoriaRequest movimentacaoCategoriaRequest) {
        MovimentacaoCategoria categoria = new MovimentacaoCategoria();

        categoria.setMovimentacaoCategoriaName(movimentacaoCategoriaRequest.movimentacaoCategoriaName());

        return categoria;
    }

    public static MovimentacaoCategoria toEntityUpdate(Long id, MovimentacaoCategoriaRequest movimentacaoCategoriaRequest) {
        var categoria = movimentacaoCategoriaRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Categoria de movimentação não encontrada pelo id: " + id)
        );

        categoria.setMovimentacaoCategoriaName(movimentacaoCategoriaRequest.movimentacaoCategoriaName());

        return categoria;
    }

    public static List<MovimentacaoCategoriaResponse> toResponseList(List<MovimentacaoCategoria> categorias) {
        return categorias.stream()
                .map(MovimentacaoCategoriaMapper::toResponse)
                .collect(Collectors.toList());
    }
}
