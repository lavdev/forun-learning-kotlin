package br.com.nuone.forun.service

import br.com.nuone.forun.model.Author
import br.com.nuone.forun.model.data.AuthorData
import br.com.nuone.forun.model.dto.AuthorForm
import org.springframework.stereotype.Service

@Service
class AuthorService {
    fun create(dto: AuthorForm): Author {
        val author = Author(
            name = dto.name,
            id = AuthorData().size().toLong() + 1,
            email = dto.email
        )
        return AuthorData().create(author)
    }

    /***
     *
     */
    fun findById(id: Long): Author {
        return AuthorData().findAll()
            .stream()
            .filter({ e ->
                e.id == id
            })
            .findFirst()
            .get()
    }
}
