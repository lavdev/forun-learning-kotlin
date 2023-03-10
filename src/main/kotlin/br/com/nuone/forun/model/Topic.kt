package br.com.nuone.forun.model

import java.time.LocalDateTime

data class Topic(
    var id: Long? = null,
    val title: String,
    val message: String,
    val createdAt: LocalDateTime = LocalDateTime.now(),
    val course: Course,
    val author: Author,
    val status: StatusTopic = StatusTopic.NOT_ANSWERED,
    val answerLst: List<Answered> = ArrayList()
)
