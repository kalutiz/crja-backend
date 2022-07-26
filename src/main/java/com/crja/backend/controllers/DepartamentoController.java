package com.crja.backend.controllers;

import com.crja.backend.dto.DepartamentoDTO;
import com.crja.backend.services.DepartamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/departamentos")
public class DepartamentoController {

    @Autowired
    private DepartamentoService service;

    @GetMapping
    public ResponseEntity<Page<DepartamentoDTO>> findAll(Pageable pageable) {
        Page<DepartamentoDTO> list = service.findAllPaged(pageable);
        return ResponseEntity.ok().body(list);
    }

}
