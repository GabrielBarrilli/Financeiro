package org.gabrielbarrilli.financeiro.model.dto.request;

public record EmpresaRequest(
        String empresaName,
        String empresaCnpj
) {
}
