package org.serratec.backend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@PrimaryKeyJoinColumn(name = "id")
public class VendedorAutonomo extends Vendedor{
	private Double comissao;
}
