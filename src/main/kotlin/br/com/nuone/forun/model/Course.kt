package br.com.nuone.forun.model

import jakarta.persistence.*

@Table(name = "tbl_course")
@Entity
data class Course(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val name: String,
    val catetory: String
)

