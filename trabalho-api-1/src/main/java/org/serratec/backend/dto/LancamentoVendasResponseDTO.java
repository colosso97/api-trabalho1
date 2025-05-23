package org.serratec.backend.dto;

import java.time.LocalDate;

public record LancamentoVendasResponseDTO(LocalDate dataVenda, Double valorVenda, String nomeVendedor) {
}
