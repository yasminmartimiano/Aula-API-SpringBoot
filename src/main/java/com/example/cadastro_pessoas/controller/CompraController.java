package com.example.cadastro_pessoas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.cadastro_pessoas.model.CompraModel;
import com.example.cadastro_pessoas.servicer.CompraService;

@RestController
@RequestMapping("/api/compras")
public class CompraController {

    @Autowired
    private CompraService compraService;

    @PostMapping
    public ResponseEntity<CompraModel> registrarCompra(@RequestBody CompraModel compra) {
        CompraModel novaCompra = compraService.registrarCompra(compra);
        return new ResponseEntity<>(novaCompra, HttpStatus.CREATED);
    }

    @GetMapping
    public List<CompraModel> listarCompras() {
        return compraService.listarCompras();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CompraModel> buscarCompraPorId(@PathVariable Long id) {
        return compraService.buscarCompraPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/pessoa/{idPessoa}")
    public List<CompraModel> buscarComprasPorPessoa(@PathVariable Long idPessoa) {
        return compraService.buscarComprasPorPessoa(idPessoa);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> apagarCompra(@PathVariable Long id) {
        compraService.apagarCompra(id);
        return ResponseEntity.noContent().build();
    }
}
