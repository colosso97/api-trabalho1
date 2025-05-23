package org.serratec.backend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
@Entity
@PrimaryKeyJoinColumn(name = "id")
public class VendedorAutonomo extends Vendedor{
	private Double comissao;
}
