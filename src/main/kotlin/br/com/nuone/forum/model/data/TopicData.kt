package br.com.nuone.forum.model.data

import br.com.nuone.forum.model.Topic

@Deprecated(message = "It has been replaced by JPA")
class TopicData() {

    private val topics = listOf<Topic>()

    /**
     * Return a Topic list
     */
    fun findAll(): List<Topic> {
        return topics
    }

    fun create(topic: Topic): Topic {
        this.topics.plus(topic);
        return topic;
    }

    fun size(): Int {
        return this.topics.size
    }
}