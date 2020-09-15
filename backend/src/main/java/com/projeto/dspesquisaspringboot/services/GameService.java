package com.projeto.dspesquisaspringboot.services;

import com.projeto.dspesquisaspringboot.dto.GameDTO;
import com.projeto.dspesquisaspringboot.entities.Game;
import com.projeto.dspesquisaspringboot.repositories.GameRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class GameService {

    @Autowired
    private GameRepository repository;

    
    //Metodo para buscar todos os games
    @Transactional(readOnly = true) //operacao de leitura é true
    public List<GameDTO> findAll() {
        List<Game> list = repository.findAll();
        return list.stream().map(x-> new GameDTO(x)).collect(Collectors.toList());
    }

    
    
    
    
}
