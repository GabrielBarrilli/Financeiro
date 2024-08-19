package org.gabrielbarrilli.financeiro.model.dto.request;

public record MovimentacaoRequest(
        Double movimentacaoValor,
        Long movimentacaoCategoriaId,
        Long movimentacaoTipoId,
        Long movimentacaoContaId,
        Long movimentacaoColaboradorId
) {
}
