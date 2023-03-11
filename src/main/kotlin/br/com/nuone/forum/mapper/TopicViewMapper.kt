package br.com.nuone.forum.mapper

import br.com.nuone.forum.model.Topic
import br.com.nuone.forum.model.view.TopicView
import org.springframework.stereotype.Component

@Component
class TopicViewMapper : Mapper<Topic, TopicView> {
    override fun map(t: Topic): TopicView {
        return TopicView(
            id = t.id,
            title = t.title,
            message = t.message,
            status = t.status,
            createdAt = t.createdAt,
        )
    }
}