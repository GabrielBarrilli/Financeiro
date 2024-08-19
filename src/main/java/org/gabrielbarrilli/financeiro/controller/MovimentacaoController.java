package org.gabrielbarrilli.financeiro.controller;

import org.gabrielbarrilli.financeiro.mapper.MovimentacaoMapper;
import org.gabrielbarrilli.financeiro.model.dto.request.MovimentacaoRequest;
import org.gabrielbarrilli.financeiro.model.dto.response.MovimentacaoResponse;
import org.gabrielbarrilli.financeiro.service.MovimentacaoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/movimentacao")
public class MovimentacaoController {

    private final MovimentacaoService movimentacaoService;

    public MovimentacaoController(MovimentacaoService movimentacaoService) {
        this.movimentacaoService = movimentacaoService;
    }

    @ResponseStatus(CREATED)
    @PostMapping
    public MovimentacaoResponse createMovimentacao (@RequestBody MovimentacaoRequest movimentacaoRequest) {
        return MovimentacaoMapper.toResponse(movimentacaoService.createMovimentacao(movimentacaoRequest));
    }

    @ResponseStatus(OK)
    @GetMapping
    public List<MovimentacaoResponse> getAllMovimentacao () {
        return MovimentacaoMapper.toResponseList(movimentacaoService.findAll());
    }

    @ResponseStatus(OK)
    @GetMapping("{/{id}")
    public MovimentacaoResponse getMovimentacaoById (@PathVariable Long id) {
        return MovimentacaoMapper.toResponse(movimentacaoService.findById(id));
    }

    @ResponseStatus(ACCEPTED)
    @PutMapping("/{id}")
    public MovimentacaoResponse updateMovimentacao (@PathVariable Long id, @RequestBody MovimentacaoRequest movimentacaoRequest) {
        return MovimentacaoMapper.toResponse(movimentacaoService.updateMovimentacao(id, movimentacaoRequest));
    }

    @ResponseStatus(OK)
    @DeleteMapping("/{id}")
    public String deleteMovimentacao (@PathVariable Long id) {
        movimentacaoService.deleteMovimentacao(id);

        return "Movimentação removida com sucesso!";
    }

}
