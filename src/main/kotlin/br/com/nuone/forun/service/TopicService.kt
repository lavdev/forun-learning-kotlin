package br.com.nuone.forun.service

import br.com.nuone.forun.exception.NotFoundException
import br.com.nuone.forun.mapper.TopicFormMapper
import br.com.nuone.forun.mapper.TopicViewMapper
import br.com.nuone.forun.model.Topic
import br.com.nuone.forun.model.dto.CreateTopicForm
import br.com.nuone.forun.model.dto.UpdateTopicForm
import br.com.nuone.forun.model.view.TopicView
import org.springframework.stereotype.Service

@Service
class TopicService(
    private var topics: List<Topic> = ArrayList(),
    private val topicViewMapper: TopicViewMapper,
    private val topicFormMapper: TopicFormMapper
) {

    fun findAll(): List<TopicView> {
        return topics.stream().map { t -> topicViewMapper.map(t) }.toList()
    }

    /**
     * Get Topic by ID
     */
    fun findById(id: Long): TopicView {
        val topic = topics
            .stream()
            .filter { t ->
                t.id == id
            }.findFirst().get()
        return topicViewMapper.map(topic);
    }

    /**
     * Create a new Topic
     * @param {@link CreateTopicForm}
     * @return {@link TopicView}
     */
    fun create(form: CreateTopicForm): TopicView {
        val topic = topicFormMapper.map(form);
        topic.id = topics.size.toLong() + 1;
        this.topics = topics.plus(topicFormMapper.map(form))
        return topicViewMapper.map(topic);
    }

    /***
     * Update a Topic
     * @param {@link UpdateTopicForm}
     * @return {@link TopicView}
     */
    fun update(form: UpdateTopicForm): TopicView {

        val topic = topics
            .stream()
            .filter { t ->
                t.id == form.id
            }.findFirst()
            .orElseThrow { NotFoundException("The Topic cannot be found!") }

        val updated = Topic(
            topic.id,
            form.title,
            form.message,
            topic.createdAt,
            topic.course,
            topic.author,
            topic.status,
            topic.answerLst
        )

        this.topics = this.topics
            .minus(topic)
            .plus(updated)

        return topicViewMapper.map(updated);
    }

    /***
     * Delete a Topic
     * @param id Topic´s  identification
     */
    fun delete(id: Long) {
        val topic = topics
            .stream()
            .filter { t ->
                t.id == id
            }.findFirst()
            .orElseThrow { NotFoundException("The Topic cannot be found!") }

        this.topics = this.topics
            .minus(topic)
    }

}

