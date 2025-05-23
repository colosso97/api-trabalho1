package org.serratec.backend.repository;

import org.serratec.backend.entity.LancamentoVendas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LancamentoVendasRepository extends JpaRepository<LancamentoVendas, Long> {

}
