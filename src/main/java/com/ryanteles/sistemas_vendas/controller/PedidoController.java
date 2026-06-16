package com.ryanteles.sistemas_vendas.controller;


import com.ryanteles.sistemas_vendas.entity.Pedido;
import com.ryanteles.sistemas_vendas.service.PedidoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    private final PedidoService pedidoService;

    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @GetMapping
    public List<Pedido> listar(){
        return pedidoService.listarTodos();
    }

    @GetMapping("/{id}")
    public Optional<Pedido> buscarPorId(@PathVariable Long id){
        return pedidoService.buscarPorId(id);
    }

    @PostMapping
    public String salvar (@RequestBody Pedido pedido){
        pedidoService.salvar(pedido);
        return "Pedido Cadastrado!";
    }

    @DeleteMapping("/{id}")
    public String deletar (@PathVariable Long id){
        pedidoService.deletar(id);
        return "Pedido Deletado!";
    }

    @PutMapping("/{id}")
    public String atualizar (@PathVariable Long id, @RequestBody Pedido pedidoAtualizado){
        pedidoService.atualizar(id, pedidoAtualizado);
        return "Pedido Atualizado!";
    }
}
