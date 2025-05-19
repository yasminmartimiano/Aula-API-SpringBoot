package com.example.cadastro_pessoas.servicer;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cadastro_pessoas.model.CompraModel;
import com.example.cadastro_pessoas.model.ItemCompraModel;
import com.example.cadastro_pessoas.model.ProdutoModel;
import com.example.cadastro_pessoas.repository.CompraRepository;
import com.example.cadastro_pessoas.repository.ProdutoRepository;

@Service
public class CompraService {

    @Autowired
    private CompraRepository compraRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    //registrar uma nova compra
    public CompraModel registrarCompra(CompraModel compra) {
        for (ItemCompraModel item : compra.getItens()) {
            //buscando o produto no banco por id
            ProdutoModel produto = produtoRepository.findById(item.getProduto().getId())
                    .orElseThrow(() -> new RuntimeException("Produto não encontrado"));

                    //verificando se tem produto suficiente
            if (produto.getQuantidadeEstoque() < item.getQuantidade()) {
                throw new RuntimeException("Estoque insuficiente para o produto " + produto.getNome());
            }

            //atualiza o estoque do produto
            produto.setQuantidadeEstoque(produto.getQuantidadeEstoque() - item.getQuantidade());
            produtoRepository.save(produto);
            //definindo o preco e rgeistrando a compra
            item.setPrecoUnitario(produto.getPreco());
            item.setCompra(compra);
        }

        //salva a data da compra
        compra.setDataCompra(LocalDateTime.now());
        //salva a compra no repositorio
        return compraRepository.save(compra);
    }

    //listar todas as compras
    public List<CompraModel> listarCompras() {
        return compraRepository.findAll();
    }

    //buscar compra por id
    public Optional<CompraModel> buscarCompraPorId(Long id) {
        return compraRepository.findById(id);
    }

    //listar compra por id
    public List<CompraModel> buscarComprasPorPessoa(Long idPessoa) {
        return compraRepository.findByPessoaId(idPessoa);
    }

    //remover ou excluir compra
    public void apagarCompra(Long id) {
        compraRepository.deleteById(id);
    }
}

