package org.gabrielbarrilli.financeiro.controller;

import org.gabrielbarrilli.financeiro.mapper.BancoMapper;
import org.gabrielbarrilli.financeiro.model.dto.request.BancoRequest;
import org.gabrielbarrilli.financeiro.model.dto.response.BancoResponse;
import org.gabrielbarrilli.financeiro.service.BancoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/banco")
public class BancoController {

    private final BancoService bancoService;

    public BancoController(BancoService bancoService) {
        this.bancoService = bancoService;
    }

    @ResponseStatus(CREATED)
    @PostMapping
    public BancoResponse createBanco(@RequestBody BancoRequest bancoRequest) {
        return BancoMapper.toResponse(bancoService.createBanco(bancoRequest));
    }

    @ResponseStatus(OK)
    @GetMapping("/{id}")
    public BancoResponse getBancoById(@PathVariable("id") Long id) {
        return BancoMapper.toResponse(bancoService.getBancoById(id));
    }

    @ResponseStatus(OK)
    @GetMapping
    public List<BancoResponse> getAllBancos() {
        return BancoMapper.toResponseList(bancoService.getAllBancos());
    }

    @ResponseStatus(ACCEPTED)
    @PutMapping("/{id}")
    public BancoResponse updateBanco(@PathVariable("id") Long id, @RequestBody BancoRequest bancoRequest) {
        return BancoMapper.toResponse(bancoService.updateBanco(id, bancoRequest));
    }

    @ResponseStatus(OK)
    @DeleteMapping("/{id}")
    public String deleteBanco(@PathVariable("id") Long id) {
        bancoService.deleteBanco(id);

        return "Banco deletado com sucesso!";
    }
}
