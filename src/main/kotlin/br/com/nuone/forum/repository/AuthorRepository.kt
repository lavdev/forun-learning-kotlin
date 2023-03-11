package br.com.nuone.forum.repository;

import br.com.nuone.forum.model.Author
import org.springframework.data.jpa.repository.JpaRepository

interface AuthorRepository : JpaRepository<Author, Long> {
}