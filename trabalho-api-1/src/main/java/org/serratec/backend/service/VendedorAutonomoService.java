package org.serratec.backend.service;

import org.serratec.backend.dto.VendedorAutonomoRequestDTO;
import org.serratec.backend.dto.VendedorAutonomoResponseDTO;
import org.serratec.backend.entity.VendedorAutonomo;
import org.serratec.backend.exception.VendedorAutonomoException;
import org.serratec.backend.repository.VendedorAutonomoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class VendedorAutonomoService {
    @Autowired
    private VendedorAutonomoRepository vendedorAutonomoRepository;

    public List<VendedorAutonomoResponseDTO> listar(){
        List<VendedorAutonomo> vendedores = vendedorAutonomoRepository.findAll();
        List<VendedorAutonomoResponseDTO> vendedoresDTO = new ArrayList<>();

        for(VendedorAutonomo v : vendedores) {
            vendedoresDTO.add(new VendedorAutonomoResponseDTO(v.getId(), v.getNome(), v.getEmail(), v.getSalario(), v.getComissao()));
        }

        return vendedoresDTO;
    }

    public VendedorAutonomoResponseDTO listarPorId(Long id){
        Optional<VendedorAutonomo> v = vendedorAutonomoRepository.findById(id);
        if(v.isPresent()){
            VendedorAutonomo vendedorAutonomo = v.get();
            return new VendedorAutonomoResponseDTO(vendedorAutonomo.getId(), vendedorAutonomo.getNome(), vendedorAutonomo.getEmail(), vendedorAutonomo.getSalario(), vendedorAutonomo.getComissao());
        }
        throw new VendedorAutonomoException("O vendedor autonomo não foi encontrado baseado na busca por id.");
    }

    public VendedorAutonomoResponseDTO adicionar(VendedorAutonomoRequestDTO dto){
        VendedorAutonomo vendedorAutonomo = new VendedorAutonomo();
        vendedorAutonomo.setNome(dto.getNome());
        vendedorAutonomo.setEmail(dto.getEmail());
        vendedorAutonomo.setSalario(dto.getSalario());
        vendedorAutonomo.setComissao(dto.getComissao());

        vendedorAutonomoRepository.save(vendedorAutonomo);

        return new VendedorAutonomoResponseDTO(vendedorAutonomo.getId(), vendedorAutonomo.getNome(), vendedorAutonomo.getEmail(), vendedorAutonomo.getSalario(), vendedorAutonomo.getComissao());
    }
}
