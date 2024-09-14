package com.anonymous_suggestion_box.anonymous_suggestion_box.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public class SugestaoRequestDTO {

    private String tituloSugestao;
    private String descricaoSugestao;

    @JsonFormat(pattern = "dd-MM-yyyy' 'HH:mm")
    private LocalDateTime dataEnvio;

    @JsonFormat(pattern = "dd-MM-yyyy' 'HH:mm")
    private LocalDateTime dataAtualizacao;

    public String getTituloSugestao() {
        return tituloSugestao;
    }

    public void setTituloSugestao(String tituloSugestao) {
        this.tituloSugestao = tituloSugestao;
    }

    public String getDescricaoSugestao() {
        return descricaoSugestao;
    }

    public void setDescricaoSugestao(String descricaoSugestao) {
        this.descricaoSugestao = descricaoSugestao;
    }

    public LocalDateTime getDataEnvio() {
        return dataEnvio;
    }

    public void setDataEnvio(LocalDateTime dataEnvio) {
        this.dataEnvio = dataEnvio;
    }

    public LocalDateTime getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(LocalDateTime dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }
}

