package br.com.nuone.forun.mapper

import br.com.nuone.forun.model.Topic
import br.com.nuone.forun.model.view.TopicView
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