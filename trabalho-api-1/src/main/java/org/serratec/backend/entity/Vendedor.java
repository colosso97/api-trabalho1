package org.serratec.backend.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.OneToMany;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Vendedor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Long id;
	protected String nome;
	protected String email;
	protected Double salario;

	@JsonManagedReference
	@OneToMany(mappedBy = "vendedor")
	protected List<LancamentoVendas> lancamentoDeVendas;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public List<LancamentoVendas> getLancamentoDeVendas() {
		return lancamentoDeVendas;
	}

	public void setLancamentoDeVendas(List<LancamentoVendas> lancamentoDeVendas) {
		this.lancamentoDeVendas = lancamentoDeVendas;
	}
	
	
}
