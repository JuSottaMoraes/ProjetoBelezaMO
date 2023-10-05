package com.beleza1.beleza1.Controller;

import com.beleza1.beleza1.model.Entity.ClienteEntity;
import com.beleza1.beleza1.model.service.ClienteService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/clientes")
public class ClienteAPI {
    
    @Autowired
    ClienteService jpa;

    @GetMapping
    public List<ClienteEntity> buscarTudo() {
      return jpa.listarTodos();
    }
    
    @GetMapping("/{id}")
    public ClienteEntity bucarPorId(@PathVariable int id) {
        return jpa.getPorId(id);
    }
    

    @PostMapping
    public ClienteEntity adicionar(@RequestBody ClienteEntity cliente) {
        jpa.inserir(cliente);
        return cliente;
    }

    @PutMapping("/{id}")
    public ClienteEntity atualizar(@PathVariable int id, @RequestBody ClienteEntity clienteAtualizado) {
     return  jpa.atualizar(id, clienteAtualizado);
    }


    @DeleteMapping("/{id}")
    public ClienteEntity remover (@PathVariable int id) {
        return jpa.remover(id);
    }
}

