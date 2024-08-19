package org.gabrielbarrilli.financeiro.mapper;

import org.gabrielbarrilli.financeiro.model.ColaboradorTipo;
import org.gabrielbarrilli.financeiro.model.dto.request.ColaboradorTipoRequest;
import org.gabrielbarrilli.financeiro.model.dto.response.ColaboradorTipoResponse;
import org.gabrielbarrilli.financeiro.repository.ColaboradorTipoRepository;

import java.util.List;
import java.util.stream.Collectors;

public class ColaboradorTipoMapper {

    private static ColaboradorTipoRepository colaboradorTipoRepository;

    public ColaboradorTipoMapper(
            ColaboradorTipoRepository colaboradorTipoRepository
    ) {
        ColaboradorTipoMapper.colaboradorTipoRepository = colaboradorTipoRepository;
    }

    public static ColaboradorTipoResponse toResponse(ColaboradorTipo colaboradorTipo) {

        return new ColaboradorTipoResponse(
                colaboradorTipo.getId(),
                colaboradorTipo.getColaboradorTipoName()
        );
    }

    public static ColaboradorTipo toEntity(ColaboradorTipoRequest colaboradorTipoRequest) {
        ColaboradorTipo colaboradorTipo = new ColaboradorTipo();

        colaboradorTipo.setColaboradorTipoName(colaboradorTipoRequest.colaboradorTipoName());

        return colaboradorTipo;
    }

    public static ColaboradorTipo toEntityUpdate(Long id, ColaboradorTipoRequest colaboradorTipoRequest) {
        var colaboradorTipo = colaboradorTipoRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Tipo de colaborador não encontrado pelo id: " + id)
        );

        colaboradorTipo.setColaboradorTipoName(colaboradorTipoRequest.colaboradorTipoName());

        return colaboradorTipo;
    }

    public static List<ColaboradorTipoResponse> toResponseList(List<ColaboradorTipo> colaboradorTipoList) {
        return colaboradorTipoList.stream()
                .map(ColaboradorTipoMapper::toResponse)
                .collect(Collectors.toList());
    }
}
