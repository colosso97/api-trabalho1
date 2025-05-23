package org.serratec.backend.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Vendedor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Long id;
	protected String nome;
	protected String email;
	protected Double salario;

	@OneToMany(mappedBy = "vendedor")
	protected List<LancamentoVendas> lancamentoDeVendas;
	
}
