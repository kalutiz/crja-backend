package com.crja.backend.controllers;

import com.crja.backend.dto.PessoaDTO;
import com.crja.backend.repositories.PessoaRepository;
import com.crja.backend.services.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.time.LocalDate;

@RestController
@RequestMapping(value = "/pessoas")
public class PessoaController {

    @Autowired
    private PessoaService service;

    @GetMapping
    public ResponseEntity<Page<PessoaDTO>> findAll(Pageable pageable) {
        Page<PessoaDTO> page = service.findAll(pageable);
        return ResponseEntity.ok().body(page);
    }

    @PostMapping
    public ResponseEntity<PessoaDTO> insert(@RequestBody PessoaDTO dto) {
        dto = service.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<PessoaDTO> update(@PathVariable Long id, @RequestBody PessoaDTO dto) {
        dto = service.update(id, dto);
        return ResponseEntity.ok().body(dto);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "/gastos")
    public ResponseEntity<Double> findByNameAndPeriod(@RequestParam("nome") String nome,
                                                        @RequestParam("inicio") String inicio,
                                                        @RequestParam("fim") String fim,
                                                        Pageable pageable) {
        Double mediaDuracao = service.findbyNameAndPeriod(nome, LocalDate.parse(inicio).atTime(0,0,0), LocalDate.parse(fim).atTime(0,0,0), pageable);
        return ResponseEntity.ok().body(mediaDuracao);
    }
}
