package org.serratec.backend.dto;

import org.serratec.backend.entity.LancamentoVendas;

import java.util.List;

public record VendedorResponseDTO(Long id, String nome, String email, Double salario, List<LancamentoVendas> lancamentoDeVendas) {
}
