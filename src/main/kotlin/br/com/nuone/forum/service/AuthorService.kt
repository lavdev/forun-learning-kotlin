package br.com.nuone.forum.service

import br.com.nuone.forum.exception.NotFoundException
import br.com.nuone.forum.model.Author
import br.com.nuone.forum.model.dto.AuthorForm
import br.com.nuone.forum.repository.AuthorRepository
import org.springframework.stereotype.Service

@Service
class AuthorService(private val authorRepository: AuthorRepository) {
    fun create(dto: AuthorForm): Author {
        throw TODO("It has to be implemented yet")
    }
    fun findById(id: Long): Author {
        return this.authorRepository.findById(id)
            .orElseThrow { NotFoundException("The author cannot be found!") }
    }
}
