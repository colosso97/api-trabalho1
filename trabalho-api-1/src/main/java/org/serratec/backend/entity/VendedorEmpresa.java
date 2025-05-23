package org.serratec.backend.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@PrimaryKeyJoinColumn(name = "id")
public class VendedorEmpresa extends Vendedor {
	private Integer numeroCarteiraTrabalho;
	private LocalDate dataAdmissao;
	
	
	public Integer getNumeroCarteiraTrabalho() {
		return numeroCarteiraTrabalho;
	}
	public void setNumeroCarteiraTrabalho(Integer numeroCarteiraTrabalho) {
		this.numeroCarteiraTrabalho = numeroCarteiraTrabalho;
	}
	public LocalDate getDataAdmissao() {
		return dataAdmissao;
	}
	public void setDataAdmissao(LocalDate dataAdmissao) {
		this.dataAdmissao = dataAdmissao;
	}
	
	
}
