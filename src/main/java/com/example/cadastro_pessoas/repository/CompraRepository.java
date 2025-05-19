package com.example.cadastro_pessoas.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.cadastro_pessoas.model.CompraModel;

@Repository
public interface CompraRepository extends JpaRepository<CompraModel, Long> {
    List<CompraModel> findByPessoaId(Long idPessoa);
}

