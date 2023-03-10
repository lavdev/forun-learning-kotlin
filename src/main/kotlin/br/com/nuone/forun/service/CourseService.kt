package br.com.nuone.forun.service

import br.com.nuone.forun.model.Course
import br.com.nuone.forun.model.data.CourseData
import br.com.nuone.forun.model.dto.CourseForm
import org.springframework.stereotype.Service

@Service
class CourseService {

    fun create(dto: CourseForm): Course {
        val course = Course(
            id = CourseData().nextId(),
            name = dto.name,
            catetory = dto.category
        )
        return CourseData().create(course)
    }

    /***
     *
     */
    fun findById(id: Long): Course {
        return CourseData()
            .findAll()
            .stream()
            .filter { t ->
                t.id == id
            }.findFirst().get()
    }
}