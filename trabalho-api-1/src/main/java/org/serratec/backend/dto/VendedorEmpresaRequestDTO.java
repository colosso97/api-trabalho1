package org.serratec.backend.dto;

import org.serratec.backend.entity.VendedorEmpresa;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

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
  
  public VendedorEmpresaRequestDTO(){
  }

    public VendedorEmpresaRequestDTO(VendedorEmpresa vendedorEmpresa) {
        this.nome = vendedorEmpresa.getNome();
        this.email = vendedorEmpresa.getEmail();
        this.salario = vendedorEmpresa.getSalario();
        this.numeroCarteiraTrabalho = vendedorEmpresa.getNumeroCarteiraTrabalho();
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

	public Integer getNumeroCarteiraTrabalho() {
		return numeroCarteiraTrabalho;
	}

	public void setNumeroCarteiraTrabalho(Integer numeroCarteiraTrabalho) {
		this.numeroCarteiraTrabalho = numeroCarteiraTrabalho;
	}
}