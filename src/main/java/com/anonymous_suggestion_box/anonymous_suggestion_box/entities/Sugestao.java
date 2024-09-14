package com.anonymous_suggestion_box.anonymous_suggestion_box.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Entity
@Table(name="sugestoes")
public class Sugestao {

    @OneToOne(mappedBy = "sugestao", cascade = CascadeType.ALL)
    private Resposta resposta;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    @Column(unique = true)
    private Long id;

    @NotBlank
    @Size(max = 64)
    @Column(nullable = false, length = 64)
    private String tituloSugestao;

    @NotBlank
    @Size(min = 16, max = 256)
    @Column(nullable = false, length = 256)
    private String descricaoSugestao;

    @NotNull
    @Column(nullable = false)
    @DateTimeFormat(pattern = "dd-MM-yyyy' 'HH:mm")
    private LocalDateTime dataEnvio;

    @NotNull
    @Column(nullable = false)
    @DateTimeFormat(pattern = "dd-MM-yyyy' 'HH:mm")
    private LocalDateTime dataAtualizacao;

    public Resposta getResposta() {
        return resposta;
    }

    public void setResposta(Resposta resposta) {
        this.resposta = resposta;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotBlank @Size(max = 64) String getTituloSugestao() {
        return tituloSugestao;
    }

    public void setTituloSugestao(@NotBlank @Size(max = 64) String tituloSugestao) {
        this.tituloSugestao = tituloSugestao;
    }

    public @NotBlank @Size(min = 16, max = 256) String getDescricaoSugestao() {
        return descricaoSugestao;
    }

    public void setDescricaoSugestao(@NotBlank @Size(min = 16, max = 256) String descricaoSugestao) {
        this.descricaoSugestao = descricaoSugestao;
    }

    public @NotNull LocalDateTime getDataEnvio() {
        return dataEnvio;
    }

    public void setDataEnvio(@NotNull LocalDateTime dataEnvio) {
        this.dataEnvio = dataEnvio;
    }

    public @NotNull LocalDateTime getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(@NotNull LocalDateTime dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }
}





