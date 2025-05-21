package com.example.cadastro_pessoas.model;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "itenscompra")
public class ItemCompraModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "compra_id", nullable = false)
    private CompraModel compra;

    @ManyToOne
    @JoinColumn(name = "produto_id", nullable = false)
    private ProdutoModel produto;

    private Integer quantidade;

    private BigDecimal precoUnitario;

    public Long getId() { 
        return id; }

    public void setId(Long id) { 
        this.id = id; }

    public CompraModel getCompra() { 
        return compra; }

    public void setCompra(CompraModel compra) { 
        this.compra = compra; }

    public ProdutoModel getProduto() { 
        return produto; }

    public void setProduto(ProdutoModel produto) { 
        this.produto = produto; }

    public Integer getQuantidade() { 
        return quantidade; }

    public void setQuantidade(Integer quantidade) { 
        this.quantidade = quantidade; }

    public BigDecimal getPrecoUnitario() { 
        return precoUnitario; }

    public void setPrecoUnitario(BigDecimal precoUnitario) { 
        this.precoUnitario = precoUnitario; }

    public void setPrecoUnitario(Double preco) {
        throw new UnsupportedOperationException("'setPrecoUnitario' ainda não foi implementado");
    }
}
