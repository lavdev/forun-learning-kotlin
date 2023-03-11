package br.com.nuone.forum.model.data

import br.com.nuone.forum.model.Author

@Deprecated(message = "It has been replaced by JPA")
class AuthorData {

    private var authors = listOf(
        Author(
            1, "Laverson Espindola", "laverson@nuone.com.br")
        )
        fun create(author: Author): Author {
            this.authors.plus(author)
            return author
        }

        fun size(): Int {
            return this.authors.size
        }

        fun findAll(): List<Author> {
            return this.authors
        }

}