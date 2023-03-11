package br.com.nuone.forum.service

import br.com.nuone.forum.exception.NotFoundException
import br.com.nuone.forum.model.Course
import br.com.nuone.forum.model.dto.CourseForm
import br.com.nuone.forum.repository.CourseRepository
import org.springframework.stereotype.Service

@Service
class CourseService(private val courseRepository: CourseRepository) {
    fun create(dto: CourseForm): Course {
        throw TODO("It has to be implemented yet")
    }

    fun findById(id: Long): Course {
        return this.courseRepository
            .findById(id)
            .orElseThrow { NotFoundException("The Course cannot be found!") }
    }
}