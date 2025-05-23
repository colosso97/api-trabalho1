package org.serratec.backend.controller;

import java.util.List;

import org.serratec.backend.dto.VendedorEmpresaRequestDTO;
import org.serratec.backend.dto.VendedorEmpresaResponseDTO;
import org.serratec.backend.service.VendedorEmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/empresas")
public class VendedorEmpresaController {


	@Autowired
	private VendedorEmpresaService service;
	
	@GetMapping
	public ResponseEntity<List<VendedorEmpresaResponseDTO>> listar(){
		return ResponseEntity.ok(service.listar());
	}
	
	@PostMapping
	public ResponseEntity<VendedorEmpresaResponseDTO> inserir(@RequestBody VendedorEmpresaRequestDTO dto) {
		return ResponseEntity.status(HttpStatus.CREATED).body(service.adicionar(dto));	
	}
	
	
	@GetMapping("{id}")
	public ResponseEntity<VendedorEmpresaResponseDTO> listarPorId(@PathVariable Long id){
		return ResponseEntity.ok().body(service.listarPorId(id));
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<Void> deleteById(@PathVariable Long id){
		service.deletar(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping("{id}")
	public ResponseEntity<VendedorEmpresaResponseDTO> atualizar(@PathVariable Long id, @Valid @RequestBody VendedorEmpresaRequestDTO dto){
		return ResponseEntity.ok().body(service.atualizar(id,dto));
	}
	
	@PostMapping("/lista")
	public ResponseEntity<List<VendedorEmpresaResponseDTO>> adicionarLista(@Valid @RequestBody List<VendedorEmpresaRequestDTO> vendedoresDTO){
		return ResponseEntity.status(HttpStatus.CREATED).body(service.adicionarLista(vendedoresDTO));
	}
	
	
	
	
	
	
}
