package com.ryanteles.sistemas_vendas.service;

import com.ryanteles.sistemas_vendas.entity.ItemPedido;
import com.ryanteles.sistemas_vendas.repository.ItemPedidoRepository;
import com.ryanteles.sistemas_vendas.repository.PedidoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemPedidoService {

    private final ItemPedidoRepository itemPedidoRepository;
    private final PedidoRepository pedidoRepository;

    public ItemPedidoService(ItemPedidoRepository itemPedidoRepository, PedidoRepository pedidoRepository) {
        this.itemPedidoRepository = itemPedidoRepository;
        this.pedidoRepository = pedidoRepository;
    }

    public List<ItemPedido> listar(){
        return itemPedidoRepository.findAll();
    }

    public Optional<ItemPedido> buscarPorId (Long id){
        return itemPedidoRepository.findById(id);
    }

    public ItemPedido salvar (ItemPedido itemPedido){
         return itemPedidoRepository.save(itemPedido);
    }

    public void deletar (Long id){
        Optional<ItemPedido> itemPedido = itemPedidoRepository.findById(id);
        if(itemPedido.isPresent()){
            itemPedidoRepository.deleteById(id);
        }
    }

    public ItemPedido atualizar (Long id, ItemPedido itemPedidoAtualizado){
        Optional<ItemPedido> itemPedido = itemPedidoRepository.findById(id);
        if(itemPedido.isPresent()){
            ItemPedido itemExistente = itemPedido.get();
            itemExistente.setQuantidade(itemPedidoAtualizado.getQuantidade());
            itemExistente.setPrecoUnitario(itemPedidoAtualizado.getPrecoUnitario());
            itemExistente.setProduto(itemPedidoAtualizado.getProduto());
            itemExistente.setPedido(itemPedidoAtualizado.getPedido());
            return itemPedidoRepository.save(itemExistente);

        }
        return null;
    }

}
