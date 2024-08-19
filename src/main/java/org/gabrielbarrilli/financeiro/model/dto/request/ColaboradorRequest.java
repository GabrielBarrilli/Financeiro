package org.gabrielbarrilli.financeiro.model.dto.request;

public record ColaboradorRequest(
        String colaboradorName,
        Long colaboradorTipoId
) {
}
