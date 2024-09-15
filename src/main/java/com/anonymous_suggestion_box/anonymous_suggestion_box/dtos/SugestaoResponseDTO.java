package com.anonymous_suggestion_box.anonymous_suggestion_box.dtos;

import com.anonymous_suggestion_box.anonymous_suggestion_box.entities.Resposta;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class SugestaoResponseDTO {

    private Long id;
    private String tituloSugestao;
    private String descricaoSugestao;

    @JsonFormat(pattern = "dd-MM-yyyy' 'HH:mm")
    private LocalDateTime dataEnvio;

    @JsonFormat(pattern = "dd-MM-yyyy' 'HH:mm")
    private LocalDateTime dataAtualizacao;

//    private List<Resposta> respostas = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

//    public List<Resposta> getRespostas() {
//        return respostas;
//    }
//
//    public void setRespostas(List<Resposta> respostas) {
//        this.respostas = respostas;
//    }
}
