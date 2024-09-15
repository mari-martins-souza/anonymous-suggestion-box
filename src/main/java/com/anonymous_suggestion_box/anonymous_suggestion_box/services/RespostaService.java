package com.anonymous_suggestion_box.anonymous_suggestion_box.services;

import com.anonymous_suggestion_box.anonymous_suggestion_box.dtos.RespostaRequestDTO;
import com.anonymous_suggestion_box.anonymous_suggestion_box.dtos.RespostaResponseDTO;
import com.anonymous_suggestion_box.anonymous_suggestion_box.entities.Resposta;
import com.anonymous_suggestion_box.anonymous_suggestion_box.repositories.RespostaRepository;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RespostaService {

    private static final Logger logger = LoggerFactory.getLogger(RespostaService.class);

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private RespostaRepository respostaRepository;

    public RespostaResponseDTO convertToDto(Resposta resposta) {
        return modelMapper.map(resposta, RespostaResponseDTO.class);
    }

    public Resposta convertToEntity(RespostaRequestDTO respostaRequestDTO) {
        return modelMapper.map(respostaRequestDTO, Resposta.class);
    }

    public RespostaResponseDTO criaResposta(RespostaRequestDTO respostaRequestDTO) {
        logger.info("iniciando criação de nova resposta: {}, respostaRequestDTO");
        Resposta resposta = convertToEntity(respostaRequestDTO);

        Resposta respostaSalva = respostaRepository.save(resposta);

        logger.info("resposta criada e salva no banco de dados: {}, respostaResponseDTO");
        return convertToDto(respostaSalva);
    }
}
