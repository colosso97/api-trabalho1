package org.serratec.backend.dto;

import org.serratec.backend.entity.VendedorAutonomo;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import org.serratec.backend.entity.VendedorAutonomo;

public class VendedorAutonomoRequestDTO {
    @NotBlank(message = "O nome do vendedor não pode ser nulo ou vazio.")
    private String nome;

    @NotBlank(message = "O email do vendedor não pode ser nulo ou vazio.")
    @Email(message = "O email informado não é valido. Insira um email valido e tente novamente!")
    private String email;

    @NotNull(message = "O salario do vendedor não pode ser nulo ou vazio.")
    @DecimalMin(value = "1518.0", inclusive = true, message = "O salario deve ser igual ou maior ao salario minimo.")
    private Double salario;

    @NotNull(message = "A comissão do vendedor não pode ser nula.")
    private Double comissao;
  
  public VendedorAutonomoRequestDTO(){
  }

    public VendedorAutonomoRequestDTO(VendedorAutonomo vendedorAutonomo) {
        this.nome = vendedorAutonomo.getNome();
        this.email = vendedorAutonomo.getEmail();
        this.salario = vendedorAutonomo.getSalario();
        this.comissao = vendedorAutonomo.getComissao();
    }

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Double getSalario() {
		return salario;
	}

	public void setSalario(Double salario) {
		this.salario = salario;
	}

	public Double getComissao() {
		return comissao;
	}

	public void setComissao(Double comissao) {
		this.comissao = comissao;
	}
}