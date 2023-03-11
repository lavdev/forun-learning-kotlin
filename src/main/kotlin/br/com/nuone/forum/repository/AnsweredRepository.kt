package br.com.nuone.forum.repository;

import br.com.nuone.forum.model.Answered
import org.springframework.data.jpa.repository.JpaRepository

interface AnsweredRepository : JpaRepository<Answered, Long> {
}