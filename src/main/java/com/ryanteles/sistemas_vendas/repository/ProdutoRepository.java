package com.ryanteles.sistemas_vendas.repository;

import com.ryanteles.sistemas_vendas.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto,Long> {
}
