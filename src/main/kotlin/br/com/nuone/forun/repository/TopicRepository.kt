package br.com.nuone.forun.repository;

import br.com.nuone.forun.model.Topic
import org.springframework.data.jpa.repository.JpaRepository

interface TopicRepository : JpaRepository<Topic, Long> {
}