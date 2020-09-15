
package com.projeto.dspesquisaspringboot.repositories;

import com.projeto.dspesquisaspringboot.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameRepository extends JpaRepository<Game,Long> {
    
    
    
}
