package br.com.nuone.forum.repository;

import br.com.nuone.forum.model.Topic
import br.com.nuone.forum.model.dto.TopicByCategoryDto
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface TopicRepository : JpaRepository<Topic, Long> {
    fun findByCourseName(courseName: String, pageable: Pageable): Page<Topic>

    @Query("select new br.com.nuone.forum.model.dto.TopicByCategoryDto(course.category, count(t)) from Topic t join t.course course group by course.category")
    fun report() : List<TopicByCategoryDto>
}