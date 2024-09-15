package com.anonymous_suggestion_box.anonymous_suggestion_box.services;

import com.anonymous_suggestion_box.anonymous_suggestion_box.dtos.SugestaoConsultaDTO;
import com.anonymous_suggestion_box.anonymous_suggestion_box.dtos.SugestaoRequestDTO;
import com.anonymous_suggestion_box.anonymous_suggestion_box.dtos.SugestaoResponseDTO;
import com.anonymous_suggestion_box.anonymous_suggestion_box.entities.Sugestao;
import com.anonymous_suggestion_box.anonymous_suggestion_box.repositories.SugestaoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SugestaoService {

    private static final Logger logger = LoggerFactory.getLogger(SugestaoService.class);

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private SugestaoRepository sugestaoRepository;


    public SugestaoResponseDTO convertToDto(Sugestao sugestao) {
        return modelMapper.map(sugestao, SugestaoResponseDTO.class);
    }

    public Sugestao convertToEntity(SugestaoRequestDTO sugestaoRequestDTO) {
        return modelMapper.map(sugestaoRequestDTO, Sugestao.class);
    }

    public SugestaoConsultaDTO convertConsultaToDto(Sugestao sugestao) {
        return modelMapper.map(sugestao, SugestaoConsultaDTO.class);
    }



    public SugestaoResponseDTO criaSugestao(SugestaoRequestDTO sugestaoRequestDTO) {
        logger.info("iniciando criação de nova sugestão: {}, sugestaoRequestDTO");
        Sugestao sugestao = convertToEntity(sugestaoRequestDTO);

        Sugestao sugestaoSalva = sugestaoRepository.save(sugestao);

        logger.info("sugestão criada e salva no banco de dados: {}, sugestaoResponseDTO");
        return convertToDto(sugestaoSalva);
    }

    public List<SugestaoConsultaDTO> consultaTodasSugestoes(String tituloSugestao) {
        List<Sugestao> sugestoes;
        if (tituloSugestao != null && !tituloSugestao.isEmpty()) {
            sugestoes =
                    sugestaoRepository.findByTituloSugestaoContainingIgnoreCaseOrderByDataAtualizacaoDesc(tituloSugestao);
        } else {
            sugestoes = sugestaoRepository.findAll(Sort.by(Sort.Direction.DESC, "dataAtualizacao"));
        }
        return sugestoes.stream()
                .map(this::convertConsultaToDto)
                .collect(Collectors.toList());
    }

    public SugestaoResponseDTO consultaSugestaoPorId(Long id) {
        Sugestao sugestao = sugestaoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Sugestão não encontrada"));
        return convertToDto((sugestao));
    }
}
