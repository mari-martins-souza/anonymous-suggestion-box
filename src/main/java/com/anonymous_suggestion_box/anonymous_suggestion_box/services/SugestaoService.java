package com.anonymous_suggestion_box.anonymous_suggestion_box.services;

import com.anonymous_suggestion_box.anonymous_suggestion_box.dtos.SugestaoRequestDTO;
import com.anonymous_suggestion_box.anonymous_suggestion_box.dtos.SugestaoResponseDTO;
import com.anonymous_suggestion_box.anonymous_suggestion_box.entities.Sugestao;
import com.anonymous_suggestion_box.anonymous_suggestion_box.repositories.SugestaoRepository;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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



    public SugestaoResponseDTO criaSugestao(SugestaoRequestDTO sugestaoRequestDTO) {
        logger.info("iniciando criação de nova sugestão: {}, sugestaoRequestDTO");
        Sugestao sugestao = convertToEntity(sugestaoRequestDTO);

        Sugestao sugestaoSalva = sugestaoRepository.save(sugestao);

        logger.info("sugestão criada e salva no banco de dados: {}, sugestaoResponseDTO");
        return convertToDto(sugestaoSalva);
    }
}
