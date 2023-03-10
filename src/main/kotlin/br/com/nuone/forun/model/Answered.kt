package br.com.nuone.forun.model

import java.time.LocalDateTime

data class Answered(
    val id: Long? = null,
    val message: String,
    val createdAt: LocalDateTime = LocalDateTime.now(),
    val author: Author,
    val topic: Topic,
    val solution: Boolean
)
