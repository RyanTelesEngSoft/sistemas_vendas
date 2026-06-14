package com.ryanteles.sistemas_vendas.service;

import com.ryanteles.sistemas_vendas.entity.Produto;
import com.ryanteles.sistemas_vendas.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository) {

        this.produtoRepository = produtoRepository;
    }

    public List<Produto> listarTodos(){
        return produtoRepository.findAll();
    }

    public Produto salvar(Produto produto){
        return produtoRepository.save(produto);
    }

    public Optional<Produto> buscarPorId(Long id){
      return produtoRepository.findById(id);

    }
}
