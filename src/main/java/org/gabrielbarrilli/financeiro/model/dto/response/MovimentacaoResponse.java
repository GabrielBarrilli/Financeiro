package org.gabrielbarrilli.financeiro.model.dto.response;

public record MovimentacaoResponse(
        Long id,
        Double movimentacaoValor,
        Long movimentacaoCategoriaId,
        Long movimentacaoTipoId,
        Long movimentacaoContaId,
        Long movimentacaoColaboradorId
) {
}
