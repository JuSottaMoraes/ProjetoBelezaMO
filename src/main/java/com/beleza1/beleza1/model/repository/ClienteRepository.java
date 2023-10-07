
package com.beleza1.beleza1.model.repository;

import com.beleza1.beleza1.model.Entity.ClienteEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ClienteRepository extends JpaRepository<ClienteEntity,Integer>{
    
    @Query(value = "select * from Cliente", nativeQuery = true)

    List<ClienteEntity> findAllMaiorIdade();

}

    

