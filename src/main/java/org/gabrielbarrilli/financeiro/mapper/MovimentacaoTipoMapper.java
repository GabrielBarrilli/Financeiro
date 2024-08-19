package org.gabrielbarrilli.financeiro.mapper;

import jakarta.persistence.EntityNotFoundException;
import org.gabrielbarrilli.financeiro.model.MovimentacaoTipo;
import org.gabrielbarrilli.financeiro.model.dto.request.MovimentacaoTipoRequest;
import org.gabrielbarrilli.financeiro.model.dto.response.MovimentacaoTipoResponse;
import org.gabrielbarrilli.financeiro.repository.MovimentacaoTipoRepository;

import java.util.List;
import java.util.stream.Collectors;

public class MovimentacaoTipoMapper {

    private static MovimentacaoTipoRepository movimentacaoTipoRepository;

    public MovimentacaoTipoMapper(
            MovimentacaoTipoRepository movimentacaoTipoRepository
    ) {
        MovimentacaoTipoMapper.movimentacaoTipoRepository = movimentacaoTipoRepository;
    }

    public static MovimentacaoTipoResponse toResponse(MovimentacaoTipo movimentacaoTipo) {

        return new MovimentacaoTipoResponse(
                movimentacaoTipo.getId(),
                movimentacaoTipo.getMovimentacaoTipoName()
        );
    }

    public static MovimentacaoTipo toEntity(MovimentacaoTipoRequest movimentacaoTipoRequest) {
        MovimentacaoTipo movimentacaoTipo = new MovimentacaoTipo();

        movimentacaoTipo.setMovimentacaoTipoName(movimentacaoTipoRequest.movimentacaoTipoName());

        return movimentacaoTipo;
    }

    public static MovimentacaoTipo toEntityUpdate(Long id, MovimentacaoTipoRequest movimentacaoTipoRequest) {
        var movimentacaoTipo = movimentacaoTipoRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Tipo de movimentação não encontrada pelo id: " + id)
        );

        movimentacaoTipo.setMovimentacaoTipoName(movimentacaoTipoRequest.movimentacaoTipoName());

        return movimentacaoTipo;
    }

    public static List<MovimentacaoTipoResponse> toResponseList(List<MovimentacaoTipo> movimentacaoTipoList) {
        return movimentacaoTipoList.stream()
                .map(MovimentacaoTipoMapper::toResponse)
                .collect(Collectors.toList());
    }
}
