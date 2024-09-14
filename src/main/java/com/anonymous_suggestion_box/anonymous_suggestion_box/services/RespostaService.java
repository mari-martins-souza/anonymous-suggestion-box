package com.anonymous_suggestion_box.anonymous_suggestion_box.services;

import com.anonymous_suggestion_box.anonymous_suggestion_box.dtos.RespostaRequestDTO;
import com.anonymous_suggestion_box.anonymous_suggestion_box.dtos.RespostaResponseDTO;
import com.anonymous_suggestion_box.anonymous_suggestion_box.entities.Resposta;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RespostaService {

    @Autowired
    private ModelMapper modelMapper;

    public RespostaResponseDTO convertToDto(Resposta resposta) {
        return modelMapper.map(resposta, RespostaResponseDTO.class);
    }

    public Resposta convertToEntity(RespostaRequestDTO respostaRequestDTO) {
        return modelMapper.map(respostaRequestDTO, Resposta.class);
    }
}
