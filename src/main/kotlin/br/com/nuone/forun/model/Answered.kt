package br.com.nuone.forun.model

import jakarta.persistence.*
import java.time.LocalDateTime

@Table(name = "tbl_answered")
@Entity
data class Answered(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val message: String,
    val createdAt: LocalDateTime = LocalDateTime.now(),
    @ManyToOne
    val author: Author,
    @ManyToOne
    val topic: Topic,
    val solution: Boolean
)
