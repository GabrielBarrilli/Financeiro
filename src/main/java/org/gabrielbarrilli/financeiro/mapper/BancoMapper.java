package org.gabrielbarrilli.financeiro.mapper;

import jakarta.persistence.EntityNotFoundException;
import org.gabrielbarrilli.financeiro.model.Banco;
import org.gabrielbarrilli.financeiro.model.dto.request.BancoRequest;
import org.gabrielbarrilli.financeiro.model.dto.response.BancoResponse;
import org.gabrielbarrilli.financeiro.repository.BancoRepository;

import java.util.List;
import java.util.stream.Collectors;

public class BancoMapper {

    private static BancoRepository bancoRepository;

    public BancoMapper(
            BancoRepository bancoRepository
    ) {
        BancoMapper.bancoRepository = bancoRepository;
    }

    public static BancoResponse toResponse(Banco banco) {

        return new BancoResponse(
                banco.getId(),
                banco.getBancoName()
        );
    }

    public static Banco toEntity(BancoRequest bancoRequest) {
        Banco banco = new Banco();

        banco.setBancoName(bancoRequest.bancoName());

        return banco;
    }

    public static Banco toEntityUpdate(Long id, BancoRequest bancoRequest) {
        var banco = bancoRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Banco não encontrado pelo id: " + id)
        );

        banco.setBancoName(bancoRequest.bancoName());

        return banco;
    }

    public static List<BancoResponse> toResponseList(List<Banco> bancoList) {
        return bancoList.stream()
                .map(BancoMapper::toResponse)
                .collect(Collectors.toList());
    }
}
