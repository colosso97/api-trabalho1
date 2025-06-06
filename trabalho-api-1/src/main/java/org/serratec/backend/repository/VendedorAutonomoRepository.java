package org.serratec.backend.repository;

import org.serratec.backend.entity.VendedorAutonomo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VendedorAutonomoRepository extends JpaRepository<VendedorAutonomo, Long>{

}
