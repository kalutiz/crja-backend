package com.crja.backend.controllers;

import com.crja.backend.dto.TarefaDTO;
import com.crja.backend.repositories.TarefaRepository;
import com.crja.backend.services.TarefaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/tarefas")
public class TarefaController {

    @Autowired
    private TarefaRepository repository;
    @Autowired
    private TarefaService service;

    @GetMapping(value = "/pendentes")
    public ResponseEntity<Page<TarefaDTO>> findAllPendentes(Pageable pageable) {
        Page<TarefaDTO> page = service.findAllPendentes(pageable);
        return ResponseEntity.ok().body(page);
    }

    @GetMapping
    public ResponseEntity<Page<TarefaDTO>> findAll(Pageable pageable) {
        Page<TarefaDTO> page = service.findAll(pageable);
        return ResponseEntity.ok().body(page);
    }

    @PostMapping
    public ResponseEntity<TarefaDTO> insert(@RequestBody TarefaDTO dto) {
        dto = service.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @PutMapping(value = "/alocar/{id}")
    public ResponseEntity<TarefaDTO> updatePessoa(@PathVariable Long id, @RequestBody TarefaDTO dto) {
        dto = service.updatePessoa(id, dto);
        return ResponseEntity.ok().body(dto);
    }

    @PutMapping(value = "/finalizar/{id}")
    public ResponseEntity<TarefaDTO> finalizarTarefa(@PathVariable Long id) {
        TarefaDTO dto = new TarefaDTO();
        dto = service.finalizarTarefa(id);
        return ResponseEntity.ok().body(dto);
    }
}
