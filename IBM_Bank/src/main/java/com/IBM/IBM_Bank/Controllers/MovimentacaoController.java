package com.IBM.IBM_Bank.Controllers;


import com.IBM.IBM_bank.Models.Movimentacao;
import com.IBM.IBM_bank.Services.MovimentacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movimentacoes")
public class MovimentacaoController {

    @Autowired
    private MovimentacaoService movimentacaoService;

    @PostMapping
    public ResponseEntity<Movimentacao> registrarMovimentacao(@RequestBody Movimentacao movimentacao) {
        return ResponseEntity.ok(movimentacaoService.registrarMovimentacao(movimentacao));
    }

    @GetMapping
    public ResponseEntity<List<Movimentacao>> listarMovimentacoes() {
        return ResponseEntity.ok(movimentacaoService.listarTodasMovimentacoes());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Movimentacao> buscarMovimentacao(@PathVariable Long id) {
        return ResponseEntity.ok(movimentacaoService.buscarMovimentacaoPorId(id));
    }

}
