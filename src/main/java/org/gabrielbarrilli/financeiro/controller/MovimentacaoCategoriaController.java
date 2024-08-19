package org.gabrielbarrilli.financeiro.controller;

import org.gabrielbarrilli.financeiro.mapper.MovimentacaoCategoriaMapper;
import org.gabrielbarrilli.financeiro.model.dto.request.MovimentacaoCategoriaRequest;
import org.gabrielbarrilli.financeiro.model.dto.response.MovimentacaoCategoriaResponse;
import org.gabrielbarrilli.financeiro.service.MovimentacaoCategoriaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/movimentacaoCategoria")
public class MovimentacaoCategoriaController {

    private final MovimentacaoCategoriaService movimentacaoCategoriaService;

    public MovimentacaoCategoriaController(MovimentacaoCategoriaService movimentacaoCategoriaService) {
        this.movimentacaoCategoriaService = movimentacaoCategoriaService;
    }

    @ResponseStatus(CREATED)
    @PostMapping
    public MovimentacaoCategoriaResponse createMovimentacaoCategoria(@RequestBody MovimentacaoCategoriaRequest movimentacaoCategoriaRequest) {
        return MovimentacaoCategoriaMapper.toResponse(movimentacaoCategoriaService.createMovimentacaoCategoria(movimentacaoCategoriaRequest));
    }

    @ResponseStatus(OK)
    @GetMapping
    public List<MovimentacaoCategoriaResponse> getAllMovimentacaoCategoria() {
        return MovimentacaoCategoriaMapper.toResponseList(movimentacaoCategoriaService.findAllMovimentacaoCategoria());
    }

    @ResponseStatus(OK)
    @GetMapping("/{id}")
    public MovimentacaoCategoriaResponse getMovimentacaoCategoria(@PathVariable Long id) {
        return MovimentacaoCategoriaMapper.toResponse(movimentacaoCategoriaService.findMovimentacaoCategoriaById(id));
    }

    @ResponseStatus(ACCEPTED)
    @PutMapping("/{id}")
    public MovimentacaoCategoriaResponse updateMovimentacaoCategoria(@PathVariable Long id, @RequestBody MovimentacaoCategoriaRequest movimentacaoCategoriaRequest) {
        return MovimentacaoCategoriaMapper.toResponse(movimentacaoCategoriaService.updateMovimentacaoCategoria(id, movimentacaoCategoriaRequest));
    }

    @ResponseStatus(OK)
    @DeleteMapping("/{id}")
    public String deleteMovimentacaoCategoria(@PathVariable Long id) {
        movimentacaoCategoriaService.deleteMovimentacaoCategoria(id);

        return "Categoria de movimentação deletada com sucesso!";
    }
}
