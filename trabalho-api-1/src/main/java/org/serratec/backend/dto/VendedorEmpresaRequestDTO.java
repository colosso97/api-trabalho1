package org.serratec.backend.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.serratec.backend.entity.VendedorEmpresa;

@NoArgsConstructor
@Getter
@Setter
public class VendedorEmpresaRequestDTO {
    @NotBlank(message = "O nome do vendedor não pode ser nulo ou vazio.")
    private String nome;

    @NotBlank(message = "O email do vendedor não pode ser nulo ou vazio.")
    @Email(message = "O email informado não é valido. Insira um email valido e tente novamente!")
    private String email;

    @NotNull(message = "O salario do vendedor não pode ser nulo ou vazio.")
    @DecimalMin(value = "1518.0", inclusive = true, message = "O salario deve ser igual ou maior ao salario minimo.")
    private Double salario;

    @NotNull(message = "O número da carteira de trabalho do vendedor não pode ser nulo.")
    private Integer numeroCarteiraTrabalho;

    public VendedorEmpresaRequestDTO(VendedorEmpresa vendedorEmpresa) {
        this.nome = vendedorEmpresa.getNome();
        this.email = vendedorEmpresa.getEmail();
        this.salario = vendedorEmpresa.getSalario();
        this.numeroCarteiraTrabalho = vendedorEmpresa.getNumeroCarteiraTrabalho();
    }
}
