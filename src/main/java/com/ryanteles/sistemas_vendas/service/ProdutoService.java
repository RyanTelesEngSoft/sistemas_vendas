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
    public void deletarPorId (Long id){
       Optional<Produto> produto = produtoRepository.findById(id);
        if (produto.isPresent()){
            produtoRepository.deleteById(id);
        }
    }

    public Produto atualizar (Long id, Produto produtoAtualizado){
        Optional<Produto> produto = produtoRepository.findById(id);
        if (produto.isPresent()){
            Produto produtoExistente = produto.get();
            produtoExistente.setNome(produtoAtualizado.getNome());
            produtoExistente.setDescricao(produtoAtualizado.getDescricao());
            produtoExistente.setPreco(produtoAtualizado.getPreco());
            produtoExistente.setEstoque(produtoAtualizado.getEstoque());
            return produtoRepository.save(produtoExistente);
        }

        return null;
    }


}
