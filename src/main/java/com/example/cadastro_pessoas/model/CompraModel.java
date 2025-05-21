package com.example.cadastro_pessoas.model;
import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "compras")
public class CompraModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime dataCompra;

    @ManyToOne
    @JoinColumn(name = "pessoa_id", nullable = false)
    private PessoasModel pessoa;

    @OneToMany(mappedBy = "compra", cascade = CascadeType.ALL)
    private List<ItemCompraModel> itens;

    public Long getId() { 
        return id; }

    public void setId(Long id) {
        this.id = id; }

    public LocalDateTime getDataCompra() {
        return dataCompra; }

    public void setDataCompra(LocalDateTime dataCompra) { 
        this.dataCompra = dataCompra; }

    public PessoasModel getPessoa() { 
        return pessoa; }

    public void setPessoa(PessoasModel pessoa) { 
        this.pessoa = pessoa; } 

    public List<ItemCompraModel> getItens() { 
        return itens; }

    public void setItens(List<ItemCompraModel> itens) { 
        this.itens = itens; }

}