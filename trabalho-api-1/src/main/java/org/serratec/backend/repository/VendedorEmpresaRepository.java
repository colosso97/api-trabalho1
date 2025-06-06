package org.serratec.backend.repository;

import org.serratec.backend.entity.VendedorEmpresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VendedorEmpresaRepository extends JpaRepository<VendedorEmpresa, Long> {

}
