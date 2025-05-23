package org.serratec.backend.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.serratec.backend.entity.Vendedor;

import java.time.LocalDate;

@AllArgsConstructor
@Setter
@Getter
public class LancamentoVendasRequestDTO {
    @NotNull(message = "A data da venda não pode ser nula.")
    private LocalDate dataVenda;

    @NotNull(message = "O valor da venda não pode ser nulo.")
    private Double valorVenda;

    @NotNull(message = "O vendedor vinculado a venda não pode ser nulo.")
    private Vendedor vendedor;
}
