package com.anonymous_suggestion_box.anonymous_suggestion_box.controllers;

import com.anonymous_suggestion_box.anonymous_suggestion_box.dtos.SugestaoConsultaDTO;
import com.anonymous_suggestion_box.anonymous_suggestion_box.dtos.SugestaoRequestDTO;
import com.anonymous_suggestion_box.anonymous_suggestion_box.dtos.SugestaoResponseDTO;
import com.anonymous_suggestion_box.anonymous_suggestion_box.services.SugestaoService;
import jakarta.validation.Valid;
import org.apache.coyote.BadRequestException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sugestoes")
public class SugestaoController {

    private static final Logger logger = LoggerFactory.getLogger(SugestaoController.class);

    @Autowired
    private SugestaoService sugestaoService;

    @PostMapping
    public ResponseEntity<SugestaoResponseDTO> criaSugestao(@Valid @RequestBody SugestaoRequestDTO sugestaoRequestDTO) throws BadRequestException {
        logger.info("recebendo solicitação para criar nova sugestão: {}, sugestaoRequestDTO");
        SugestaoResponseDTO sugestaoResponseDTO = sugestaoService.criaSugestao(sugestaoRequestDTO);
        logger.info("sugestão criada com sucesso: {}, sugestaoResponseDTO");
        return new ResponseEntity<>(sugestaoResponseDTO, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<SugestaoConsultaDTO>> consultaTodasSugestoes(
            @RequestParam(required = false) String tituloSugestao) {

        List<SugestaoConsultaDTO> sugestoes = sugestaoService.consultaTodasSugestoes();
        return ResponseEntity.ok(sugestoes);
    }

}
