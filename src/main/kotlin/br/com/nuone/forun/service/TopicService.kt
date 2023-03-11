package br.com.nuone.forun.service

import br.com.nuone.forun.exception.NotFoundException
import br.com.nuone.forun.mapper.TopicFormMapper
import br.com.nuone.forun.mapper.TopicViewMapper
import br.com.nuone.forun.model.Topic
import br.com.nuone.forun.model.dto.CreateTopicForm
import br.com.nuone.forun.model.dto.UpdateTopicForm
import br.com.nuone.forun.model.view.TopicView
import br.com.nuone.forun.repository.TopicRepository
import org.springframework.stereotype.Service

@Service
class TopicService(
    private val topicRepository: TopicRepository,
    private val topicViewMapper: TopicViewMapper,
    private val topicFormMapper: TopicFormMapper
) {
    fun findAll(): List<TopicView> {
        return this.topicRepository
            .findAll().map { t -> topicViewMapper.map(t) }.toList()
    }

    /**
     * Get Topic by ID
     */
    fun findById(id: Long): TopicView {
        val topic = this.topicRepository
            .findById(id)
            .orElseThrow { NotFoundException("The Topic cannot be found!") }
        return topicViewMapper.map(topic)
    }

    /**
     * Create a new Topic
     * @param {@link CreateTopicForm}
     * @return {@link TopicView}
     */
    fun create(form: CreateTopicForm): TopicView {
        val topic = topicFormMapper.map(form);
        return topicViewMapper.map(this.topicRepository.save(topic))
    }

    /***
     * Update a Topic
     * @param {@link UpdateTopicForm}
     * @return {@link TopicView}
     */
    fun update(id: Long, form: UpdateTopicForm): TopicView {

        val topic = this.topicRepository
            .findById(id)
            .orElseThrow { NotFoundException("The Topic cannot be found!") }

        val updated = this.topicRepository.save(
            Topic(
                topic.id,
                form.title,
                form.message,
                topic.createdAt,
                topic.course,
                topic.author,
                topic.status,
                topic.answerLst
            )
        );
        return topicViewMapper.map(updated);
    }

    /***
     * Delete a Topic
     * @param id Topic´s  identification
     */
    fun delete(id: Long) {
        val topic = this.topicRepository
            .findById(id)
            .orElseThrow { NotFoundException("The Topic cannot be found!") }
        this.topicRepository.delete(topic);
    }

}

