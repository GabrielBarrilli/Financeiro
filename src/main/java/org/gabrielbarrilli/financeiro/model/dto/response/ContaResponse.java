package org.gabrielbarrilli.financeiro.model.dto.response;

public record ContaResponse(
        Long id,
        String contaName,
        String contaAg,
        String contaNumero,
        Double contaSaldo,
        Long contaEmpresaId,
        Long contaBancoId
) {
}
