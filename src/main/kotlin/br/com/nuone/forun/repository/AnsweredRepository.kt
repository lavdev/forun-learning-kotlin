package br.com.nuone.forun.repository;

import br.com.nuone.forun.model.Answered
import org.springframework.data.jpa.repository.JpaRepository

interface AnsweredRepository : JpaRepository<Answered, Long> {
}