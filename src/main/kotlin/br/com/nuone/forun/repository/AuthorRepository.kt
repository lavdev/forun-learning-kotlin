package br.com.nuone.forun.repository;

import br.com.nuone.forun.model.Author
import org.springframework.data.jpa.repository.JpaRepository

interface AuthorRepository : JpaRepository<Author, Long> {
}