package com.example.cadastro_pessoas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.cadastro_pessoas.model.ItemCompraModel;

@Repository
public interface ItemCompraRepository extends JpaRepository<ItemCompraModel, Long> {
}
