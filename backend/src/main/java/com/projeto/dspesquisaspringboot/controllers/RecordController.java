package com.projeto.dspesquisaspringboot.controllers;

import com.projeto.dspesquisaspringboot.dto.RecordDTO;
import com.projeto.dspesquisaspringboot.dto.RecordInsertDTO;
import com.projeto.dspesquisaspringboot.services.RecordService;
import java.time.Instant;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    
    
    @GetMapping
    public ResponseEntity<Page<RecordDTO>> findAll(
            @RequestParam(value = "min", defaultValue = "") String min,
            @RequestParam(value = "max", defaultValue = "momen") String max,
            @RequestParam(value = "page", defaultValue = "0") Integer page, //atributo usado no parametro da uri , pagina padrao, variavel
            @RequestParam(value = "linesPerPage", defaultValue = "0") Integer linesPerPage,
            @RequestParam(value = "orderBy", defaultValue = "moment") String orderBy,
            @RequestParam(value = "direction", defaultValue = "DESC") String direction) {

        Instant minDate = ("".equals(min)) ? null : Instant.parse(min);
        Instant maxDate = ("".equals(max)) ? null : Instant.parse(max);

        if (linesPerPage == 0) { // se o valor for 0 ele busca todos os registros da busca
            linesPerPage = Integer.MAX_VALUE;
        }

        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);

        Page<RecordDTO> list = service.findByMoments(minDate, maxDate, pageRequest);

        return ResponseEntity.ok().body(list);

    }

    
    
    
}
