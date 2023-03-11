package br.com.nuone.forum.mapper

import br.com.nuone.forum.model.Topic
import br.com.nuone.forum.model.dto.CreateTopicForm
import br.com.nuone.forum.service.AuthorService
import br.com.nuone.forum.service.CourseService
import org.springframework.stereotype.Component

@Component
class TopicFormMapper(
    private val courseService: CourseService,
    private val authorService: AuthorService,
) : Mapper<CreateTopicForm, Topic> {
    override fun map(form: CreateTopicForm): Topic {
        return Topic(
            title = form.title,
            message = form.message,
            course = courseService.findById(form.courseId),
            author = authorService.findById(form.authorId),
        )
    }

}
