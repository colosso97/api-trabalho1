package org.serratec.backend.controller;

import jakarta.validation.Valid;
import org.serratec.backend.dto.LancamentoVendasRequestDTO;
import org.serratec.backend.dto.LancamentoVendasResponseDTO;
import org.serratec.backend.service.LancamentoVendasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vendas")
public class LancamentoVendasController {
    @Autowired
    private LancamentoVendasService service;

    @GetMapping
    public ResponseEntity<List<LancamentoVendasResponseDTO>> listar(){
        return ResponseEntity.ok().body(service.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<LancamentoVendasResponseDTO> listarPorId(@PathVariable Long id){
        return ResponseEntity.ok().body(service.listarPorId(id));
    }

    @PostMapping
    public ResponseEntity<LancamentoVendasResponseDTO> adicionar(@Valid @RequestBody LancamentoVendasRequestDTO dto){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.adicionar(dto));
    }

    @PostMapping("/lista")
    public ResponseEntity<List<LancamentoVendasResponseDTO>> adicionarLista(@Valid @RequestBody List<LancamentoVendasRequestDTO> vendasDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.adicionarLista(vendasDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<LancamentoVendasResponseDTO> atualizar(@PathVariable Long id, @Valid @RequestBody LancamentoVendasRequestDTO dto){
        return ResponseEntity.ok().body(service.atualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
