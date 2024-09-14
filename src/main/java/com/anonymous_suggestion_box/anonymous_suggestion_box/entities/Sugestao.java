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
    @DateTimeFormat(pattern = "dd-MM-yyyy'T'HH:mm")
    private LocalDateTime dataEnvio;

    @NotNull
    @Column(nullable = false)
    @DateTimeFormat(pattern = "dd-MM-yyyy'T'HH:mm")
    private LocalDateTime dataAtualizacao;
}





