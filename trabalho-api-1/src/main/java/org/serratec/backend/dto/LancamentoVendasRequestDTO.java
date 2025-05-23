package org.serratec.backend.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.serratec.backend.entity.LancamentoVendas;
import org.serratec.backend.entity.Vendedor;

import java.time.LocalDate;

@NoArgsConstructor
@Setter
@Getter
public class LancamentoVendasRequestDTO {
    @NotNull(message = "A data da venda não pode ser nula.")
    private LocalDate dataVenda;

    @NotNull(message = "O valor da venda não pode ser nulo.")
    private Double valorVenda;

    @NotNull(message = "O vendedor vinculado a venda não pode ser nulo.")
    private Vendedor vendedor;

    public LancamentoVendasRequestDTO(LancamentoVendas lancamentoVendas) {
        this.dataVenda = lancamentoVendas.getDataVenda();
        this.valorVenda = lancamentoVendas.getValorVenda();
        this.vendedor = lancamentoVendas.getVendedor();
    }
}
