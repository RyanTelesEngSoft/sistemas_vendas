package com.ryanteles.sistemas_vendas.service;

import com.ryanteles.sistemas_vendas.entity.Pedido;
import com.ryanteles.sistemas_vendas.repository.PedidoRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {

    private final PedidoRepository pedidoRepository;

    public PedidoService(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    public List<Pedido> listarTodos (){
        return pedidoRepository.findAll();
    }

    public Optional<Pedido> buscarPorId (Long id){
        return pedidoRepository.findById(id);
    }

    public Pedido salvar (Pedido pedido){
        pedido.setValorTotal(BigDecimal.ZERO);
        return pedidoRepository.save(pedido);
    }

    public void deletar (Long id){
        Optional<Pedido> pedido = pedidoRepository.findById(id);
        if(pedido.isPresent()){
            pedidoRepository.deleteById(id);
        }
    }

    public Pedido atualizar(Long id, Pedido pedidoAtualizado){
        Optional<Pedido> pedido = pedidoRepository.findById(id);
        if(pedido.isPresent()){
            Pedido pedidoExistente = pedido.get();
            pedidoExistente.setDataPedido(pedidoAtualizado.getDataPedido());
            pedidoExistente.setCliente(pedidoAtualizado.getCliente());
            return pedidoRepository.save(pedidoExistente);
        }
        return null;
    }
}
