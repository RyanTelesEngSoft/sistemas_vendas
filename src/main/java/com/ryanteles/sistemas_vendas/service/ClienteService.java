package com.ryanteles.sistemas_vendas.service;


import com.ryanteles.sistemas_vendas.entity.Cliente;
import com.ryanteles.sistemas_vendas.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public List<Cliente> listarTodos(){
        return clienteRepository.findAll();
    }

    public Optional<Cliente> buscarPorId (Long id){
        return clienteRepository.findById(id);
    }

    public Cliente salvar(Cliente cliente){
        return clienteRepository.save(cliente);
    }

    public void deletar(Long id){
        Optional<Cliente> cliente = clienteRepository.findById(id);
        if (cliente.isPresent()){
            clienteRepository.deleteById(id);
        }
    }

    public Cliente atualizar (Long id, Cliente clienteAtualizado){
        Optional<Cliente> cliente = clienteRepository.findById(id);
        if(cliente.isPresent()){
            Cliente clienteExistente = cliente.get();
            clienteExistente.setNome(clienteAtualizado.getNome());
            clienteExistente.setEmail(clienteAtualizado.getEmail());
            clienteExistente.setTelefone(clienteAtualizado.getTelefone());
            return clienteRepository.save(clienteExistente);
        }
        return null;
    }
}
