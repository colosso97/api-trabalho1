package org.serratec.backend.service;

import org.serratec.backend.dto.LancamentoVendasRequestDTO;
import org.serratec.backend.dto.LancamentoVendasResponseDTO;
import org.serratec.backend.entity.LancamentoVendas;
import org.serratec.backend.entity.Vendedor;
import org.serratec.backend.exception.LancamentoVendasException;
import org.serratec.backend.repository.LancamentoVendasRepository;
import org.serratec.backend.repository.VendedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class LancamentoVendasService {
    @Autowired
    private LancamentoVendasRepository repository;

    @Autowired
    private VendedorRepository vendedorRepository;

    public List<LancamentoVendasResponseDTO> listar(){
        List<LancamentoVendas> vendasEntity = repository.findAll();
        List<LancamentoVendasResponseDTO> vendasDTO = new ArrayList<>();

        for(LancamentoVendas venda : vendasEntity){
            vendasDTO.add(new LancamentoVendasResponseDTO(venda.getDataVenda(), venda.getValorVenda(), venda.getVendedor().getNome()));
        }

        return vendasDTO;
    }

    public LancamentoVendasResponseDTO listarPorId(Long id){
        Optional<LancamentoVendas> v = repository.findById(id);
        if(v.isPresent()){
            LancamentoVendas venda = v.get();
            return new LancamentoVendasResponseDTO(venda.getDataVenda(), venda.getValorVenda(), venda.getVendedor().getNome());
        }
        throw new LancamentoVendasException("O lançamento da venda não foi encontrado baseado na busca por id.");
    }

    public LancamentoVendasResponseDTO adicionar(LancamentoVendasRequestDTO dto) {
        Vendedor vendedor = vendedorRepository.findById(dto.getVendedor().getId())
                .orElseThrow(() -> new RuntimeException("O vendedor não foi encontrado."));

        LancamentoVendas venda = new LancamentoVendas();
        venda.setDataVenda(dto.getDataVenda());
        venda.setValorVenda(dto.getValorVenda());
        venda.setVendedor(vendedor);

        repository.save(venda);

        return new LancamentoVendasResponseDTO(
                venda.getDataVenda(),
                venda.getValorVenda(),
                vendedor.getNome()
        );
    }

    public List<LancamentoVendasResponseDTO> adicionarLista(List<LancamentoVendasRequestDTO> vendasDTO){
        List<LancamentoVendas> vendasEntity = new ArrayList<>();

        for(LancamentoVendasRequestDTO vendaDTO : vendasDTO){
            LancamentoVendas v = new LancamentoVendas();
            v.setDataVenda(vendaDTO.getDataVenda());
            v.setValorVenda(vendaDTO.getValorVenda());
            v.setVendedor(vendaDTO.getVendedor());
            vendasEntity.add(v);
        }

        repository.saveAll(vendasEntity);

        List<LancamentoVendasResponseDTO> responseDTO = new ArrayList<>();
        for(LancamentoVendas venda : vendasEntity){
            Vendedor vendedor = vendedorRepository.findById(venda.getVendedor().getId())
                    .orElseThrow(() -> new RuntimeException("O vendedor não foi encontrado."));

            responseDTO.add(new LancamentoVendasResponseDTO(
                    venda.getDataVenda(),
                    venda.getValorVenda(),
                    vendedor.getNome()
            ));
        }
        return responseDTO;
    }

    public LancamentoVendasResponseDTO atualizar(Long id, LancamentoVendasRequestDTO dto){
        Optional<LancamentoVendas> v = repository.findById(id);
        if(v.isPresent()){
            LancamentoVendas venda = v.get();
            venda.setId(id);
            venda.setDataVenda(dto.getDataVenda());
            venda.setValorVenda(dto.getValorVenda());
            venda.setVendedor(dto.getVendedor());
            repository.save(venda);

            return new LancamentoVendasResponseDTO(venda.getDataVenda(), venda.getValorVenda(), venda.getVendedor().getNome());
        }
        throw new LancamentoVendasException("O lançamento da venda não foi encontrado baseado na busca por id.");
    }

    public Void deletar(Long id){
        Optional<LancamentoVendas> v = repository.findById(id);
        if(v.isPresent()){
            repository.deleteById(id);
        }
        throw new LancamentoVendasException("O lançamento da venda não foi encontrado baseado na busca por id.");
    }
}
