
package com.projeto.dspesquisaspringboot.repositories;

import com.projeto.dspesquisaspringboot.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;


public interface GameRepository extends JpaRepository<Game,Long> {
    
    
    
}
