package org.serratec.backend.service;

import org.serratec.backend.dto.VendedorResponseDTO;
import org.serratec.backend.entity.Vendedor;
import org.serratec.backend.exception.VendedorException;
import org.serratec.backend.repository.VendedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class VendedorService {
    @Autowired
    private VendedorRepository repository;

    public List<VendedorResponseDTO> listar(){
        List<Vendedor> vendedores = repository.findAll();
        List<VendedorResponseDTO> vendedoresDTO = new ArrayList<>();

        for(Vendedor v : vendedores) {
            vendedoresDTO.add(new VendedorResponseDTO(
                    v.getId(),
                    v.getNome(),
                    v.getEmail(),
                    v.getSalario(),
                    v.getLancamentoDeVendas()
            ));
        }
        return vendedoresDTO;
    }

    public VendedorResponseDTO listarPorId(Long id){
        Optional<Vendedor> v = repository.findById(id);
        if(v.isPresent()){
            Vendedor vendedor = v.get();

            return new VendedorResponseDTO(
                    vendedor.getId(),
                    vendedor.getNome(),
                    vendedor.getEmail(),
                    vendedor.getSalario(),
                    vendedor.getLancamentoDeVendas()
            );
        }
        throw new VendedorException("O vendedor não foi encontrado baseado na busca por id.");
    }
}
