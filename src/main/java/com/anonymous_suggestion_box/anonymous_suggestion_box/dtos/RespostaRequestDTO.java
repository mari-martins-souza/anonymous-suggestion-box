package com.anonymous_suggestion_box.anonymous_suggestion_box.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public class RespostaRequestDTO {

    private String textoResposta;

    @JsonFormat(pattern = "dd-MM-yyyy' 'HH:mm")
    private LocalDateTime dataEnvio;

    private Long sugestaoId;

    public String getTextoResposta() {
        return textoResposta;
    }

    public void setTextoResposta(String textoResposta) {
        this.textoResposta = textoResposta;
    }

    public LocalDateTime getDataEnvio() {
        return dataEnvio;
    }

    public void setDataEnvio(LocalDateTime dataEnvio) {
        this.dataEnvio = dataEnvio;
    }

    public Long getSugestaoId() {
        return sugestaoId;
    }

    public void setSugestaoId(Long sugestaoId) {
        this.sugestaoId = sugestaoId;
    }
}
