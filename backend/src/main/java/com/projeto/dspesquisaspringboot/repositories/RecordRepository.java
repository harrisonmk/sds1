
package com.projeto.dspesquisaspringboot.repositories;

import com.projeto.dspesquisaspringboot.entities.Record;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RecordRepository extends JpaRepository<Record,Long> {
    
}
