package com.ryanteles.sistemas_vendas.repository;

import com.ryanteles.sistemas_vendas.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente,Long> {
}
