package br.com.nuone.forun.model.data

import br.com.nuone.forun.model.Course

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