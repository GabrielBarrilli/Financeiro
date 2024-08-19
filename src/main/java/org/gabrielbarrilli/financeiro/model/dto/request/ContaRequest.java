package org.gabrielbarrilli.financeiro.model.dto.request;

public record ContaRequest(
        String contaName,
        String contaAg,
        String contaNumero,
        Double contaSaldo,
        Long contaEmpresaId,
        Long contaBancoId
) {
}
