package com.projeto.dspesquisaspringboot.services;

import com.projeto.dspesquisaspringboot.dto.RecordDTO;
import com.projeto.dspesquisaspringboot.dto.RecordInsertDTO;
import com.projeto.dspesquisaspringboot.entities.Game;
import com.projeto.dspesquisaspringboot.entities.Record;
import com.projeto.dspesquisaspringboot.repositories.GameRepository;
import com.projeto.dspesquisaspringboot.repositories.RecordRepository;
import java.time.Instant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RecordService {

    @Autowired
    private RecordRepository repository;

    @Autowired
    private GameRepository gameRepository;

    @Transactional
    public RecordDTO insert(RecordInsertDTO dto) {

        Record entity = new Record();
        entity.setName(dto.getName());
        entity.setAge(dto.getAge());
        entity.setMoment(Instant.now());//pega o horario atual

        Game game = gameRepository.getOne(dto.getGameId());

        entity.setGame(game);

        entity = repository.save(entity);
        
        return new RecordDTO(entity);

    }

}
