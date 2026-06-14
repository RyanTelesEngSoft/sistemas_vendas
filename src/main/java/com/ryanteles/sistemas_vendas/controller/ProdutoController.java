package com.ryanteles.sistemas_vendas.controller;

import com.ryanteles.sistemas_vendas.entity.Produto;
import com.ryanteles.sistemas_vendas.service.ProdutoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @GetMapping
    public List<Produto> listar(){
        return produtoService.listarTodos();
    }

    @PostMapping
    public String salvar(@RequestBody Produto produto){
        produtoService.salvar(produto);
        return "Produto Cadastrado!";
    }

}
