package br.com.nuone.forun.model.view

import br.com.nuone.forun.model.StatusTopic
import java.time.LocalDateTime

class TopicView (
    val id: Long? = null,
    val title: String,
    val message: String,
    val status: StatusTopic,
    val createdAt: LocalDateTime,
)