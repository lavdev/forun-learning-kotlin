package br.com.nuone.forun.service

import br.com.nuone.forun.exception.NotFoundException
import br.com.nuone.forun.model.Course
import br.com.nuone.forun.model.data.CourseData
import br.com.nuone.forun.model.dto.CourseForm
import br.com.nuone.forun.repository.CourseRepository
import org.springframework.stereotype.Service

@Service
class CourseService(private val courseRepository: CourseRepository) {
    fun create(dto: CourseForm): Course {
        val course = Course(
            id = CourseData().nextId(),
            name = dto.name,
            catetory = dto.category
        )
        return this.courseRepository.save(course);
    }
    fun findById(id: Long): Course {
        return this.courseRepository
            .findById(id)
            .orElseThrow { NotFoundException("The Course cannot be found!") }
    }
}