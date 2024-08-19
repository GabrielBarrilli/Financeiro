package org.gabrielbarrilli.financeiro.service;

import jakarta.persistence.EntityNotFoundException;
import org.gabrielbarrilli.financeiro.mapper.BancoMapper;
import org.gabrielbarrilli.financeiro.model.Banco;
import org.gabrielbarrilli.financeiro.model.dto.request.BancoRequest;
import org.gabrielbarrilli.financeiro.repository.BancoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BancoService {

    private final BancoRepository bancoRepository;

    public BancoService(BancoRepository bancoRepository) {
        this.bancoRepository = bancoRepository;
    }

    public Banco createBanco(BancoRequest bancoRequest) {
        return bancoRepository.save(BancoMapper.toEntity(bancoRequest));
    }

    public Banco getBancoById(Long id) {

        return bancoRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Banco não encontrado pelo id: " + id)
        );
    }

    public List<Banco> getAllBancos() {
        return bancoRepository.findAll();
    }

    public Banco updateBanco(Long id, BancoRequest bancoRequest) {
        return bancoRepository.save(BancoMapper.toEntityUpdate(id, bancoRequest));
    }

    public void deleteBanco(Long id) {
        Banco banco = getBancoById(id);

        bancoRepository.delete(banco);
    }
}
