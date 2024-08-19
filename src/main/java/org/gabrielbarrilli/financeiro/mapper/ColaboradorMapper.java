package org.gabrielbarrilli.financeiro.mapper;

import jakarta.persistence.EntityNotFoundException;
import org.gabrielbarrilli.financeiro.model.Colaborador;
import org.gabrielbarrilli.financeiro.model.dto.request.ColaboradorRequest;
import org.gabrielbarrilli.financeiro.model.dto.response.ColaboradorResponse;
import org.gabrielbarrilli.financeiro.repository.ColaboradorRepository;
import org.gabrielbarrilli.financeiro.repository.ColaboradorTipoRepository;

import java.util.List;
import java.util.stream.Collectors;

public class ColaboradorMapper {

    private static ColaboradorRepository colaboradorRepository;
    private static ColaboradorTipoRepository colaboradorTipoRepository;

    public ColaboradorMapper(
            ColaboradorRepository colaboradorRepository,
            ColaboradorTipoRepository colaboradorTipoRepository
    ) {
        ColaboradorMapper.colaboradorRepository = colaboradorRepository;
        ColaboradorMapper.colaboradorTipoRepository = colaboradorTipoRepository;
    }

    public static ColaboradorResponse toResponse(Colaborador colaborador) {

        return new ColaboradorResponse(
                colaborador.getId(),
                colaborador.getColaboradorName(),
                colaborador.getColaboradorTipoId().getId()
        );
    }

    public static Colaborador toEntity(ColaboradorRequest colaboradorRequest) {
        Colaborador colaborador = new Colaborador();

        return getColaborador(colaboradorRequest, colaborador);
    }

    public static Colaborador toEntityUpdate(Long id, ColaboradorRequest colaboradorRequest) {
        var colaborador = colaboradorRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Colaborador não encontrado pelo id: " + id)
        );

        return getColaborador(colaboradorRequest, colaborador);
    }

    private static Colaborador getColaborador(ColaboradorRequest colaboradorRequest, Colaborador colaborador) {
        var colaboradorTipo = colaboradorTipoRepository.findById(colaboradorRequest.colaboradorTipoId()).orElseThrow(
                () -> new EntityNotFoundException("Tipo de colaborador não encontrado pelo id: " + colaboradorRequest.colaboradorTipoId())
        );

        colaborador.setColaboradorName(colaboradorRequest.colaboradorName());
        colaborador.setColaboradorTipoId(colaboradorTipo);

        return colaborador;
    }

    public static List<ColaboradorResponse> toResponseList(List<Colaborador> colaboradorList) {
        return colaboradorList.stream()
                .map(ColaboradorMapper::toResponse)
                .collect(Collectors.toList());
    }
}
