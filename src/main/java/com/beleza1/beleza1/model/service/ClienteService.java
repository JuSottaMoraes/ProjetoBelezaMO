
package com.beleza1.beleza1.model.service;

import com.beleza1.beleza1.model.Entity.ClienteEntity;
import com.beleza1.beleza1.model.repository.ClienteRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {
    @Autowired
    ClienteRepository clienteJPA;
    
    //INSERT =Adicionar registros no banco
    public ClienteEntity inserir(ClienteEntity cliente ){
        clienteJPA.save(cliente);
        return cliente;
    }
    // SELECT * = Listar todos os registros
    // No JPA trabalha-se com List
    public List<ClienteEntity> listarTodos() {
        return clienteJPA.findAll();
    }

    //SELECT = Buscar registro especifico
    public ClienteEntity getPorId(Integer id) {
        return clienteJPA.findById(id).orElse(null);
    }

    //UPDATE = Atualizar um registro existente
    public ClienteEntity atualizar(Integer id, ClienteEntity clienteNovo) {
        ClienteEntity clienteAtual = getPorId(id);

        clienteAtual.setNome(clienteNovo.getNome());
        clienteAtual.setSobrenome(clienteNovo.getSobrenome());
        clienteAtual.setIdade(clienteNovo.getIdade());

        clienteJPA.save(clienteAtual);
        return clienteAtual;

    }
    //DELETE = Remover um registro existente  
    public ClienteEntity remover(Integer id){
        ClienteEntity cliente = getPorId (id);
        clienteJPA.deleteById(cliente.getId());
        return cliente;
    }
      public List<ClienteEntity> listarMaiorIdade() {
        return clienteJPA.findAll();
    }
}
 

