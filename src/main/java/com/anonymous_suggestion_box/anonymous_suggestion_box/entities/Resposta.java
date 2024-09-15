package com.anonymous_suggestion_box.anonymous_suggestion_box.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Entity
@Table(name="respostas")
public class Resposta {

    @ManyToOne
    @JoinColumn(name="sugestao_id", nullable = false)
    private Sugestao sugestao;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    @Column(unique = true)
    private Long id;

    @NotBlank
    @Size(min = 16, max = 256)
    @Column(nullable = false, length = 256)
    private String textoResposta;

    @NotNull
    @Column(nullable = false)
    @DateTimeFormat(pattern = "dd-MM-yyyy' 'HH:mm")
    private LocalDateTime dataEnvio;

    public Sugestao getSugestao() {
        return sugestao;
    }

    public void setSugestao(Sugestao sugestao) {
        this.sugestao = sugestao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotBlank @Size(min = 16, max = 256) String getTextoResposta() {
        return textoResposta;
    }

    public void setTextoResposta(@NotBlank @Size(min = 16, max = 256) String textoResposta) {
        this.textoResposta = textoResposta;
    }

    public @NotNull LocalDateTime getDataEnvio() {
        return dataEnvio;
    }

    public void setDataEnvio(@NotNull LocalDateTime dataEnvio) {
        this.dataEnvio = dataEnvio;
    }
}
