package org.serratec.backend.dto;

import java.time.LocalDate;

public record VendedorEmpresaResponseDTO(Long id, String nome, String email, Double salario, Integer numeroCarteiraTrabalho, LocalDate dataAdmissao) {
}
