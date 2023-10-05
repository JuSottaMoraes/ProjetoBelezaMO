
package com.beleza1.beleza1.model.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import org.springframework.stereotype.Component;


@Data
@Entity
@Table(name="Cliente")


@Component
public class ClienteEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    
    private int id;
    private String nome;
    private String sobrenome;
    private int idade;
    
    public ClienteEntity(){
        
    }

    public ClienteEntity(int id, String nome, String sobrenome, int idade) {
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.idade = idade;
    }
    
}
