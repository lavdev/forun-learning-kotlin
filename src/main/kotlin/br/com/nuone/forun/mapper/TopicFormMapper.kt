package br.com.nuone.forun.mapper

import br.com.nuone.forun.model.Topic
import br.com.nuone.forun.model.data.TopicData
import br.com.nuone.forun.model.dto.CreateTopicForm
import br.com.nuone.forun.service.AuthorService
import br.com.nuone.forun.service.CourseService
import org.springframework.stereotype.Component

@Component
class TopicFormMapper(
    private val courseService: CourseService,
    private val authorService: AuthorService,
) : Mapper<CreateTopicForm, Topic> {
    override fun map(form: CreateTopicForm): Topic {
        return Topic(
            id = TopicData().size().toLong() + 1,
            title = form.title,
            message = form.message,
            course = courseService.findById(form.courseId),
            author = authorService.findById(form.authorId),
        )
    }

}
