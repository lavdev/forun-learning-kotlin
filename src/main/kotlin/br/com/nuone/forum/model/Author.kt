package br.com.nuone.forum.model

import jakarta.persistence.*

@Table(name = "tbl_author")
@Entity
data class Author(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val name: String,
    val email: String
)