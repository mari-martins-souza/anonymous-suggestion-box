package com.anonymous_suggestion_box.anonymous_suggestion_box.controllers;

import com.anonymous_suggestion_box.anonymous_suggestion_box.dtos.RespostaRequestDTO;
import com.anonymous_suggestion_box.anonymous_suggestion_box.dtos.RespostaResponseDTO;
import com.anonymous_suggestion_box.anonymous_suggestion_box.services.RespostaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.apache.coyote.BadRequestException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sugestoes/{id}/respostas")
@Tag(name= "Comentários/Respostas")
public class RespostaController {

    private static final Logger logger = LoggerFactory.getLogger(RespostaController.class);

    @Autowired
    private RespostaService respostaService;

    @PostMapping
    @Operation(summary = "Responde/comenta sugestão existente", description = "Registra uma resposta/comentário " +
            "para uma sugestão existente, identificando a sugestão pelo id")
    public ResponseEntity<RespostaResponseDTO> criaResposta(@Valid @RequestBody RespostaRequestDTO respostaRequestDTO) throws BadRequestException {
        logger.info("recebendo solicitação para criar nova resposta: {}, respostaRequestDTO");
        RespostaResponseDTO respostaResponseDTO = respostaService.criaResposta(respostaRequestDTO);
        logger.info("resposta criada com sucesso: {}, respostaResponseDTO");
        return new ResponseEntity<>(respostaResponseDTO, HttpStatus.CREATED);
    }

}
