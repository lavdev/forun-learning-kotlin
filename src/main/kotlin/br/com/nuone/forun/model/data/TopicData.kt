package br.com.nuone.forun.model.data

import br.com.nuone.forun.model.Topic

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