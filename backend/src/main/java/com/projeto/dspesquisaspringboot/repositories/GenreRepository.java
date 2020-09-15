
package com.projeto.dspesquisaspringboot.repositories;

import com.projeto.dspesquisaspringboot.entities.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenreRepository extends JpaRepository<Genre,Long> {
    
}
