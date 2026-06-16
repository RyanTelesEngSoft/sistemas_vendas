package com.ryanteles.sistemas_vendas.controller;

import com.ryanteles.sistemas_vendas.entity.Cliente;
import com.ryanteles.sistemas_vendas.service.ClienteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping
    public List<Cliente> listar(){
        return clienteService.listarTodos();
    }

    @GetMapping("/{id}")
    public Optional<Cliente> buscarPorId (@PathVariable Long id){
        return clienteService.buscarPorId(id);
    }

    @PostMapping
    public String salvar (@RequestBody Cliente cliente){
        clienteService.salvar(cliente);
        return "Cliente Cadastrado!";
    }

    @DeleteMapping("/{id}")
    public String deletar (@PathVariable Long id){
        clienteService.deletar(id);
        return "Cliente Deletado!";
    }

    @PutMapping("/{id}")
    public String atualizar (@PathVariable Long id, @RequestBody Cliente clienteAtualizado){
        clienteService.atualizar(id, clienteAtualizado);
        return "Cliente Atualizado!";
    }

}
