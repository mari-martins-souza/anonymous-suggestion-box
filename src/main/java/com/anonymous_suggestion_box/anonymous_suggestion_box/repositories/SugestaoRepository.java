package com.anonymous_suggestion_box.anonymous_suggestion_box.repositories;

import com.anonymous_suggestion_box.anonymous_suggestion_box.entities.Sugestao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SugestaoRepository extends JpaRepository<Sugestao, Long> {

    List<Sugestao> findByTituloSugestaoContainingIgnoreCaseOrderByDataAtualizacaoDesc(String tituloSugestao);

    Optional<Sugestao> findById (Long id);
}
