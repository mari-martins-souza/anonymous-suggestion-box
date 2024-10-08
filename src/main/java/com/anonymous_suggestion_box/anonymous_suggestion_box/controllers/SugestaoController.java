package com.anonymous_suggestion_box.anonymous_suggestion_box.controllers;

import com.anonymous_suggestion_box.anonymous_suggestion_box.dtos.SugestaoConsultaDTO;
import com.anonymous_suggestion_box.anonymous_suggestion_box.dtos.SugestaoRequestDTO;
import com.anonymous_suggestion_box.anonymous_suggestion_box.dtos.SugestaoResponseDTO;
import com.anonymous_suggestion_box.anonymous_suggestion_box.services.SugestaoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(name= "Sugestões")
public class SugestaoController {

    private static final Logger logger = LoggerFactory.getLogger(SugestaoController.class);

    @Autowired
    private SugestaoService sugestaoService;

    @PostMapping
    @Operation(summary = "Cria sugestão de melhoria", description = "Salva uma nova sugestão de melhoria no banco de " +
            "dados")
    public ResponseEntity<SugestaoResponseDTO> criaSugestao(@Valid @RequestBody SugestaoRequestDTO sugestaoRequestDTO) throws BadRequestException {
        logger.info("recebendo solicitação para criar nova sugestão: {}, sugestaoRequestDTO");
        SugestaoResponseDTO sugestaoResponseDTO = sugestaoService.criaSugestao(sugestaoRequestDTO);
        logger.info("sugestão criada com sucesso: {}, sugestaoResponseDTO");
        return new ResponseEntity<>(sugestaoResponseDTO, HttpStatus.CREATED);
    }

    @GetMapping
    @Operation(summary = "Lista todas as sugestões ou busca específicas pelo título", description = "Exibe todas as " +
            "sugestões cadastradas" +
            " no banco de " +
            "dados ou as sugestões filtradas pelo título")
    public ResponseEntity<List<SugestaoConsultaDTO>> consultaTodasSugestoes(
            @RequestParam(required = false) String tituloSugestao) {

        List<SugestaoConsultaDTO> sugestoes = sugestaoService.consultaTodasSugestoes(tituloSugestao);
        return ResponseEntity.ok(sugestoes);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Busca sugestão pelo id", description = "Busca e exibe uma sugestão específica pelo id")
    public ResponseEntity<SugestaoResponseDTO> consultaSugestaoPorId(@PathVariable Long id) {
        SugestaoResponseDTO sugestao = sugestaoService.consultaSugestaoPorId(id);
        return ResponseEntity.ok(sugestao);
    }

}
