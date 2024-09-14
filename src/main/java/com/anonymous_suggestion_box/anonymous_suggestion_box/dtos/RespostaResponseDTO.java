package com.anonymous_suggestion_box.anonymous_suggestion_box.dtos;

import java.time.LocalDateTime;

public class RespostaResponseDTO {

    private Long id;
    private String textoResposta;
    private LocalDateTime dataEnvio;
    private Long sugestaoId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSugestaoId() {
        return sugestaoId;
    }

    public void setSugestaoId(Long sugestaoId) {
        this.sugestaoId = sugestaoId;
    }

    public LocalDateTime getDataEnvio() {
        return dataEnvio;
    }

    public void setDataEnvio(LocalDateTime dataEnvio) {
        this.dataEnvio = dataEnvio;
    }

    public String getTextoResposta() {
        return textoResposta;
    }

    public void setTextoResposta(String textoResposta) {
        this.textoResposta = textoResposta;
    }
}
