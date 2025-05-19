package com.example.cadastro_pessoas.servicer;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.cadastro_pessoas.model.ProdutoModel;
import com.example.cadastro_pessoas.repository.ProdutoRepository;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository repository;

    public List<ProdutoModel> listaProdutoModels(){
        return repository.findAll();
    }

        /**
         * @return
         */
        public ProdutoModel salvar(ProdutoModel produtoModel){
            return repository.save(produtoModel);
        }

        public void remover(Long id){
            repository.deleteById(id);
        }

        public Optional<ProdutoModel> buscarPorId(Long id){
            return repository.findById(id);
        }

        public ProdutoModel atualizar(ProdutoModel produtoModel) {
            throw new UnsupportedOperationException("Método 'atualizar' ainda não foi implementado !");
        }

        public List<ProdutoModel> listarTodos() {
            throw new UnsupportedOperationException("Método 'listarTodos' ainda não foi implementado !");
        }

        public void deletar(Long id) {
            throw new UnsupportedOperationException("Método 'deletar' ainda não foi implementado !");
        }


}
