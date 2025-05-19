package com.example.cadastro_pessoas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.cadastro_pessoas.model.ProdutoModel;
import com.example.cadastro_pessoas.servicer.ProdutoService;





@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

    //injeção de dependência do serviço
    @Autowired
    private ProdutoService service;

    public ProdutoController() {
    }

    //POST: Adicionando um novo produto
    @PostMapping
    public ProdutoModel salvar(@RequestBody ProdutoModel produtoModel) {
        return service.salvar(produtoModel);
    }
    
    //GET: Listando todos os produtos
    @GetMapping
    public List<ProdutoModel> listarTodos(){
        return service.listarTodos();
    }
    
    //GET: Buscar um produto por ID
    @GetMapping("/{id}")
    public ResponseEntity<ProdutoModel> buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id)
                    .map(ResponseEntity::ok)
                    .orElse(ResponseEntity.notFound().build());
    }
    
    //PUT: Atualizar um produto
    @PutMapping("/{id}")
    public ResponseEntity<ProdutoModel> atualizar(@PathVariable Long id, @RequestBody ProdutoModel produtoModel) {
        if (!service.buscarPorId(id).isPresent()){
            return ResponseEntity.notFound().build();
        }
        produtoModel.setId(id);
        return ResponseEntity.ok(service.salvar(produtoModel));
    }

    //DELETE: remover ou excluir um produto
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        if (!service.buscarPorId(id).isPresent()) {
            return  ResponseEntity.notFound().build();
        }
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
