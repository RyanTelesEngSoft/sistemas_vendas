package com.ryanteles.sistemas_vendas.controller;

import com.ryanteles.sistemas_vendas.entity.ItemPedido;
import com.ryanteles.sistemas_vendas.service.ItemPedidoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/itempedido")
public class ItemPedidoController {

    private final ItemPedidoService itemPedidoService;

    public ItemPedidoController(ItemPedidoService itemPedidoService) {
        this.itemPedidoService = itemPedidoService;
    }

    @GetMapping
    public List<ItemPedido> listar (){
        return itemPedidoService.listar();
    }

    @GetMapping("/{id}")
    public Optional<ItemPedido> buscarPorId(@PathVariable Long id){
        return itemPedidoService.buscarPorId(id);
    }

    @PostMapping
    public String salvar(@RequestBody ItemPedido itemPedido){
        itemPedidoService.salvar(itemPedido);
        return "Item Cadastrado!";
    }

    @DeleteMapping("/{id}")
    public String deletar (@PathVariable Long id){
        itemPedidoService.deletar(id);
        return "Item Deletado!";
    }

    @PutMapping("/{id}")
    public String atualizar (@PathVariable Long id, @RequestBody ItemPedido itemPedidoAtualizado){
        itemPedidoService.atualizar(id, itemPedidoAtualizado);
        return "Item Atualizado!";
    }
}
