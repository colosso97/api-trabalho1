package org.serratec.backend.controller;

import org.serratec.backend.dto.VendedorResponseDTO;
import org.serratec.backend.entity.Vendedor;
import org.serratec.backend.repository.VendedorRepository;
import org.serratec.backend.service.VendedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/vendedores")
public class VendedorController {
    @Autowired
    private VendedorService service;

    @GetMapping
    public ResponseEntity<List<VendedorResponseDTO>> listar() {
        return ResponseEntity.ok().body(service.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<VendedorResponseDTO> listarPorId(@PathVariable Long id) {
        return ResponseEntity.ok().body(service.listarPorId(id));
    }
}
