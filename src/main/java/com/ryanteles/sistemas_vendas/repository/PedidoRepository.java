package com.ryanteles.sistemas_vendas.repository;

import com.ryanteles.sistemas_vendas.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}
