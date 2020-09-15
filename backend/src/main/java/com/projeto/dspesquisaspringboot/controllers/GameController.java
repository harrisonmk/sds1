
package com.projeto.dspesquisaspringboot.controllers;

import com.projeto.dspesquisaspringboot.dto.GameDTO;
import com.projeto.dspesquisaspringboot.entities.Game;
import com.projeto.dspesquisaspringboot.repositories.GameRepository;
import com.projeto.dspesquisaspringboot.services.GameService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/games")
public class GameController {
    
  @Autowired  
  private GameRepository gameRepository;  
  
   @Autowired
  private GameService service;
  
  @GetMapping
  public ResponseEntity<List<GameDTO>> findAll(){
    
   List<GameDTO> list =  service.findAll();
      
   return ResponseEntity.ok().body(list);
      
  }
  
  
  
    
    
}
