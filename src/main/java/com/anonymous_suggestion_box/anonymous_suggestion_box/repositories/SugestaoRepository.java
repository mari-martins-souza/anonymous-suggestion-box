package com.anonymous_suggestion_box.anonymous_suggestion_box.repositories;

import com.anonymous_suggestion_box.anonymous_suggestion_box.entities.Sugestao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SugestaoRepository extends JpaRepository<Sugestao, Long> {

}
