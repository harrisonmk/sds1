
package com.projeto.dspesquisaspringboot.repositories;

import com.projeto.dspesquisaspringboot.entities.Record;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecordRepository extends JpaRepository<Record,Long> {
    
}
