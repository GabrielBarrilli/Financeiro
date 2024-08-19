package org.gabrielbarrilli.financeiro.controller;

import org.gabrielbarrilli.financeiro.mapper.MovimentacaoTipoMapper;
import org.gabrielbarrilli.financeiro.model.dto.request.MovimentacaoTipoRequest;
import org.gabrielbarrilli.financeiro.model.dto.response.MovimentacaoTipoResponse;
import org.gabrielbarrilli.financeiro.service.MovimentacaoTipoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/movimentacaoTipo")
public class MovimentacaoTipoController {

    private final MovimentacaoTipoService movimentacaoTipoService;

    public MovimentacaoTipoController(MovimentacaoTipoService movimentacaoTipoService) {
        this.movimentacaoTipoService = movimentacaoTipoService;
    }

    @ResponseStatus(CREATED)
    @PostMapping
    public MovimentacaoTipoResponse createMovimentacaoTipo(@RequestBody MovimentacaoTipoRequest movimentacaoTipoRequest) {
        return MovimentacaoTipoMapper.toResponse(movimentacaoTipoService.createMovimentacaoTipo(movimentacaoTipoRequest));
    }

    @ResponseStatus(OK)
    @GetMapping
    public List<MovimentacaoTipoResponse> getAllMovimentacaoTipo() {
        return MovimentacaoTipoMapper.toResponseList(movimentacaoTipoService.getAllMovimentacaoTipo());
    }

    @ResponseStatus(OK)
    @GetMapping("/{id}")
    public MovimentacaoTipoResponse getMovimentacaoTipo(@PathVariable Long id) {
        return MovimentacaoTipoMapper.toResponse(movimentacaoTipoService.getMovimentacaoTipoById(id));
    }

    @ResponseStatus(ACCEPTED)
    @PutMapping("/{id}")
    public MovimentacaoTipoResponse updateMovimentacaoTipo(@PathVariable Long id, @RequestBody MovimentacaoTipoRequest request) {
        return MovimentacaoTipoMapper.toResponse(movimentacaoTipoService.updateMovimentacaoTipo(id, request));
    }

    @ResponseStatus(OK)
    @DeleteMapping("/{id}")
    public String deleteMovimentacaoTipo(@PathVariable Long id) {
        movimentacaoTipoService.deleteMovimentacaoTipo(id);

        return "Movimentacao Tipo deletado com sucesso!";
    }


}
