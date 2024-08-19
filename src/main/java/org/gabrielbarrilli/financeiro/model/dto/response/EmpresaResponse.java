package org.gabrielbarrilli.financeiro.model.dto.response;

public record EmpresaResponse(
        Long id,
        String empresaName,
        String empresaCnpj
) {
}
