package org.gabrielbarrilli.financeiro.mapper;

import jakarta.persistence.EntityNotFoundException;
import org.gabrielbarrilli.financeiro.model.Movimentacao;
import org.gabrielbarrilli.financeiro.model.dto.request.MovimentacaoRequest;
import org.gabrielbarrilli.financeiro.model.dto.response.MovimentacaoResponse;
import org.gabrielbarrilli.financeiro.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

public class MovimentacaoMapper {

    private static MovimentacaoCategoriaRepository movimentacaoCategoriaRepository;
    private static MovimentacaoTipoRepository movimentacaoTipoRepository;
    private static ContaRepository contaRepository;
    private static ColaboradorRepository colaboradorRepository;
    private static MovimentacaoRepository movimentacaoRepository;

    public MovimentacaoMapper(
            MovimentacaoCategoriaRepository movimentacaoCategoriaRepository,
            MovimentacaoTipoRepository movimentacaoTipoRepository,
            ContaRepository contaRepository,
            ColaboradorRepository colaboradorRepository,
            MovimentacaoRepository movimentacaoRepository) {
        MovimentacaoMapper.movimentacaoCategoriaRepository = movimentacaoCategoriaRepository;
        MovimentacaoMapper.movimentacaoTipoRepository = movimentacaoTipoRepository;
        MovimentacaoMapper.contaRepository = contaRepository;
        MovimentacaoMapper.colaboradorRepository = colaboradorRepository;
        MovimentacaoMapper.movimentacaoRepository = movimentacaoRepository;
    }

    public static MovimentacaoResponse toResponse(Movimentacao movimentacao) {

        return new MovimentacaoResponse(
                movimentacao.getId(),
                movimentacao.getMovimentacaoValor(),
                movimentacao.getMovimentacaoCategoriaId().getId(),
                movimentacao.getMovimentacaoTipoId().getId(),
                movimentacao.getMovimentacaoContaId().getId(),
                movimentacao.getMovimentacaoColaboradorId().getId()
        );
    }

    public static Movimentacao toEntity(MovimentacaoRequest movimentacaoRequest) {
        Movimentacao movimentacao = new Movimentacao();

        return getMovimentacao(movimentacaoRequest, movimentacao);
    }

    public static Movimentacao toEntityUpdate(Long id, MovimentacaoRequest movimentacaoRequest) {
        var movimentacao = movimentacaoRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Movimentação não encontrada pelo id: " + id)
        );

        return getMovimentacao(movimentacaoRequest, movimentacao);
    }

    private static Movimentacao getMovimentacao(MovimentacaoRequest movimentacaoRequest, Movimentacao movimentacao) {
        var movimentacaoCategoria = movimentacaoCategoriaRepository.findById(movimentacaoRequest.movimentacaoCategoriaId()).orElseThrow(
                () -> new EntityNotFoundException("Categoria de movimentação não encontrada pelo id: " + movimentacaoRequest.movimentacaoCategoriaId())
        );

        var movimentacaoTipo = movimentacaoTipoRepository.findById(movimentacaoRequest.movimentacaoTipoId()).orElseThrow(
                () -> new EntityNotFoundException("Tipo de movimentação não encontrado pelo id: " + movimentacaoRequest.movimentacaoTipoId())
        );

        var conta = contaRepository.findById(movimentacaoRequest.movimentacaoContaId()).orElseThrow(
                () -> new EntityNotFoundException("Conta não encontrada pelo id: " + movimentacaoRequest.movimentacaoContaId())
        );

        var colaborador = colaboradorRepository.findById(movimentacaoRequest.movimentacaoColaboradorId()).orElseThrow(
                () -> new EntityNotFoundException("Colaborador não encontrado pelo id: " + movimentacaoRequest.movimentacaoColaboradorId())
        );

        movimentacao.setMovimentacaoValor(movimentacaoRequest.movimentacaoValor());
        movimentacao.setMovimentacaoCategoriaId(movimentacaoCategoria);
        movimentacao.setMovimentacaoTipoId(movimentacaoTipo);
        movimentacao.setMovimentacaoContaId(conta);
        movimentacao.setMovimentacaoColaboradorId(colaborador);

        return movimentacao;
    }

    public static List<MovimentacaoResponse> toResponseList(List<Movimentacao> movimentacaoList) {
        return movimentacaoList.stream()
                .map(MovimentacaoMapper::toResponse)
                .collect(Collectors.toList());
    }
}
