package org.serratec.backend.controller;

import jakarta.validation.Valid;
import org.serratec.backend.dto.VendedorAutonomoRequestDTO;
import org.serratec.backend.dto.VendedorAutonomoResponseDTO;
import org.serratec.backend.service.VendedorAutonomoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/autonomos")
public class VendedorAutonomoController {
    @Autowired
    private VendedorAutonomoService service;

    @GetMapping
    public ResponseEntity<List<VendedorAutonomoResponseDTO>> listar(){
        return ResponseEntity.ok().body(service.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<VendedorAutonomoResponseDTO> listarPorId(@PathVariable Long id){
        return ResponseEntity.ok().body(service.listarPorId(id));
    }

    @PostMapping
    public ResponseEntity<VendedorAutonomoResponseDTO> adicionar(@Valid @RequestBody VendedorAutonomoRequestDTO dto){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.adicionar(dto));
    }

    @PostMapping("/lista")
    public ResponseEntity<List<VendedorAutonomoResponseDTO>> adicionarLista(@Valid @RequestBody List<VendedorAutonomoRequestDTO> lista){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.adicionarLista(lista));
    }

    @PutMapping("/{id}")
    public ResponseEntity<VendedorAutonomoResponseDTO> atualizar(@PathVariable Long id, @Valid @RequestBody VendedorAutonomoRequestDTO dto){
        return ResponseEntity.ok().body(service.atualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Long id){
        return ResponseEntity.noContent().build();
    }
}
