package org.serratec.backend.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.serratec.backend.dto.VendedorEmpresaRequestDTO;
import org.serratec.backend.dto.VendedorEmpresaResponseDTO;
import org.serratec.backend.entity.VendedorEmpresa;
import org.serratec.backend.exception.VendedorEmpresaException;
import org.serratec.backend.repository.VendedorEmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VendedorEmpresaService {

	    @Autowired
	    private VendedorEmpresaRepository vendedorEmpresaRepository;

	    public List<VendedorEmpresaResponseDTO> listar(){
	        List<VendedorEmpresa> vendedoresEmpresaRepositories = vendedorEmpresaRepository.findAll();
	        List<VendedorEmpresaResponseDTO> vendedoresDTO = new ArrayList<>();

	        for(VendedorEmpresa v : vendedoresEmpresaRepositories) {
	            vendedoresDTO.add(new VendedorEmpresaResponseDTO(v.getId(), v.getNome(), v.getEmail(), v.getSalario(), v.getNumeroCarteiraTrabalho(), v.getDataAdmissao()));
	        }

	        return vendedoresDTO;
	    }

	    public VendedorEmpresaResponseDTO listarPorId(Long id){
	        Optional<VendedorEmpresa> v = vendedorEmpresaRepository.findById(id);
	        if(v.isPresent()){
	            VendedorEmpresa vendedorEmpresa = v.get();
	            return new VendedorEmpresaResponseDTO(vendedorEmpresa.getId(), vendedorEmpresa.getNome(), vendedorEmpresa.getEmail(), vendedorEmpresa.getSalario(), vendedorEmpresa.getNumeroCarteiraTrabalho(), vendedorEmpresa.getDataAdmissao());
	        }
	        throw new VendedorEmpresaException("O vendedor empresa não foi encontrado baseado na busca por id.");
	    }

	    public VendedorEmpresaResponseDTO adicionar(VendedorEmpresaRequestDTO dto){
	        VendedorEmpresa VendedorEmpresa = new VendedorEmpresa();
	        VendedorEmpresa.setNome(dto.getNome());
	        VendedorEmpresa.setEmail(dto.getEmail());
	        VendedorEmpresa.setSalario(dto.getSalario());
	        VendedorEmpresa.setNumeroCarteiraTrabalho(dto.getNumeroCarteiraTrabalho());
	        VendedorEmpresa.setDataAdmissao(LocalDate.now());
	        
	        vendedorEmpresaRepository.save(VendedorEmpresa);

	        return new VendedorEmpresaResponseDTO(
					VendedorEmpresa.getId(),
					VendedorEmpresa.getNome(),
					VendedorEmpresa.getEmail(),
					VendedorEmpresa.getSalario(),
					VendedorEmpresa.getNumeroCarteiraTrabalho(),
					VendedorEmpresa.getDataAdmissao()
			);
	    }
	    
	    public VendedorEmpresaResponseDTO atualizar(Long id ,VendedorEmpresaRequestDTO dto ) {
	    	Optional<VendedorEmpresa> ve = vendedorEmpresaRepository.findById(id);
	    	if(ve.isPresent()) {
	    		VendedorEmpresa vendedorEmpresa = ve.get();
	    		vendedorEmpresa.setId(id);
	    		vendedorEmpresa.setEmail(dto.getEmail());
	    		vendedorEmpresa.setSalario(dto.getSalario());
	    		vendedorEmpresa.setNumeroCarteiraTrabalho(dto.getNumeroCarteiraTrabalho());
	    		vendedorEmpresa.setDataAdmissao(vendedorEmpresa.getDataAdmissao());
				vendedorEmpresaRepository.save(vendedorEmpresa);

				return new VendedorEmpresaResponseDTO(
						vendedorEmpresa.getId(),
						vendedorEmpresa.getNome(),
						vendedorEmpresa.getEmail(),
						vendedorEmpresa.getSalario(),
						vendedorEmpresa.getNumeroCarteiraTrabalho(),
						vendedorEmpresa.getDataAdmissao()
				);
	    	}
	    	throw new VendedorEmpresaException("O vendedor empresa não foi encontrado baseado na busca por id.");
	    }
	    
	    
	    public Void deletar(Long id){
	        Optional<VendedorEmpresa> v = vendedorEmpresaRepository.findById(id);
	        if(v.isPresent()){
	            vendedorEmpresaRepository.deleteById(id);
	        }
	        throw new VendedorEmpresaException("O vendedor empresa não foi encontrado baseado na busca por id.");
	    }
	    
	    public List<VendedorEmpresaResponseDTO> adicionarLista(List<VendedorEmpresaRequestDTO> vendedoresDTO){
	        List<VendedorEmpresa> vendedoresEntity = new ArrayList<>();
	        for(VendedorEmpresaRequestDTO vendedorDTO : vendedoresDTO){
	        	VendedorEmpresa vendedorEmpresa = new VendedorEmpresa();
	        	
	        	vendedorEmpresa.setNome(vendedorDTO.getNome());
	        	vendedorEmpresa.setEmail(vendedorDTO.getEmail());
	        	vendedorEmpresa.setSalario(vendedorDTO.getSalario());
	        	vendedorEmpresa.setNumeroCarteiraTrabalho(vendedorDTO.getNumeroCarteiraTrabalho());
	        	vendedorEmpresa.setDataAdmissao(LocalDate.now());
	            vendedoresEntity.add(vendedorEmpresa);
	        }

	        vendedorEmpresaRepository.saveAll(vendedoresEntity);

	        List<VendedorEmpresaResponseDTO> vendedoresResponseDTO = new ArrayList<>();
	        for (VendedorEmpresa vendedorSalvo : vendedoresEntity) {
	            VendedorEmpresaResponseDTO responseDto = new VendedorEmpresaResponseDTO(
	                    vendedorSalvo.getId(),
	                    vendedorSalvo.getNome(),
	                    vendedorSalvo.getEmail(),
	                    vendedorSalvo.getSalario(),
	                    vendedorSalvo.getNumeroCarteiraTrabalho(),
	                    vendedorSalvo.getDataAdmissao()
	            );
	            vendedoresResponseDTO.add(responseDto);
	        }
	        return vendedoresResponseDTO;
	    } 

	

}
