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

    @OneToOne
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
    @DateTimeFormat(pattern = "dd-MM-yyyy'T'HH:mm")
    private LocalDateTime dataEnvio;

}
