package com.anonymous_suggestion_box.anonymous_suggestion_box.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.anonymous_suggestion_box.anonymous_suggestion_box.entities.Resposta;

@Repository
public interface RespostaRepository extends JpaRepository<Resposta, Long> {

}
