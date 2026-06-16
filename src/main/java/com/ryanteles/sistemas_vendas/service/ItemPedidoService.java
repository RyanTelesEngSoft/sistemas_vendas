package com.ryanteles.sistemas_vendas.service;

import com.ryanteles.sistemas_vendas.entity.ItemPedido;
import com.ryanteles.sistemas_vendas.entity.Pedido;
import com.ryanteles.sistemas_vendas.entity.Produto;
import com.ryanteles.sistemas_vendas.repository.ItemPedidoRepository;
import com.ryanteles.sistemas_vendas.repository.PedidoRepository;
import com.ryanteles.sistemas_vendas.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class ItemPedidoService {

    private final ItemPedidoRepository itemPedidoRepository;
    private final PedidoRepository pedidoRepository;
    private final ProdutoRepository produtoRepository;

    public ItemPedidoService(ItemPedidoRepository itemPedidoRepository, PedidoRepository pedidoRepository, ProdutoRepository produtoRepository) {
        this.itemPedidoRepository = itemPedidoRepository;
        this.pedidoRepository = pedidoRepository;
        this.produtoRepository = produtoRepository;
    }

    public List<ItemPedido> listar(){
        return itemPedidoRepository.findAll();
    }

    public Optional<ItemPedido> buscarPorId (Long id){
        return itemPedidoRepository.findById(id);
    }

    public ItemPedido salvar (ItemPedido itemPedido){
        Pedido pedido = itemPedido.getPedido();
        Produto produto = itemPedido.getProduto();

        if (itemPedido.getQuantidade() > produto.getEstoque()) {
            throw new RuntimeException("Estoque insuficiente");
        }

        Integer novoEstoque = produto.getEstoque() - itemPedido.getQuantidade();
        produto.setEstoque(novoEstoque);

        BigDecimal subtotal = itemPedido.getPrecoUnitario().multiply(BigDecimal.valueOf(itemPedido.getQuantidade()));
        BigDecimal novoTotal = pedido.getValorTotal().add(subtotal);
        pedido.setValorTotal(novoTotal);

            produtoRepository.save(produto);
            pedidoRepository.save(pedido);
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
