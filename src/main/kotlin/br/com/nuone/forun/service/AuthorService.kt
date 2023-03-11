package br.com.nuone.forun.service

import br.com.nuone.forun.exception.NotFoundException
import br.com.nuone.forun.model.Author
import br.com.nuone.forun.model.data.AuthorData
import br.com.nuone.forun.model.dto.AuthorForm
import br.com.nuone.forun.repository.AuthorRepository
import org.springframework.stereotype.Service

@Service
class AuthorService(private val authorRepository: AuthorRepository) {
    fun create(dto: AuthorForm): Author {
        val author = Author(
            name = dto.name,
            id = AuthorData().size().toLong() + 1,
            email = dto.email
        )
        return this.authorRepository.save(author)
    }
    fun findById(id: Long): Author {
        return this.authorRepository.findById(id)
            .orElseThrow { NotFoundException("The author cannot be found!") }
    }
}
