package com.projeto.dspesquisaspringboot.controllers;

import com.projeto.dspesquisaspringboot.dto.RecordDTO;
import com.projeto.dspesquisaspringboot.dto.RecordInsertDTO;
import com.projeto.dspesquisaspringboot.services.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/records")
public class RecordController {

    @Autowired
    private RecordService service;

    
    @PostMapping
    public ResponseEntity<RecordDTO> insert(@RequestBody RecordInsertDTO dto) { //@RequestBody converte o json para o tipo RecordInsertDTO

        RecordDTO newDTO = service.insert(dto);

        return ResponseEntity.ok().body(newDTO);
    }

    
    
}
