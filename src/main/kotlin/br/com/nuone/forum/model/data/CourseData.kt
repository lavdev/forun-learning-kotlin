package br.com.nuone.forum.model.data

import br.com.nuone.forum.model.Course

@Deprecated(message = "It has been replaced by JPA")
class CourseData() {

    private val courses = listOf(
        Course(1,"Kotlin","Programação"),
        Course(2,"Java","Programação"),
        Course(3,"Spring Boot","Programação"),
    )

    /**
     * Return a Topic list
     */
    fun findAll(): List<Course> {
        return courses
    }

    fun create(course: Course): Course {
        this.courses.plus(course);
        return course;
    }

    fun nextId(): Long {
        return this.courses.size.toLong() + 1
    }
}