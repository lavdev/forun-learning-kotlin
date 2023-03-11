package br.com.nuone.forun.repository;

import br.com.nuone.forun.model.Course
import org.springframework.data.jpa.repository.JpaRepository

interface CourseRepository : JpaRepository<Course, Long> {
}