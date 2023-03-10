package br.com.nuone.forun.model.data

import br.com.nuone.forun.model.Author

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