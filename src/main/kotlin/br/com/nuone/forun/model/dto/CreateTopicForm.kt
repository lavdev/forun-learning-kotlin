package br.com.nuone.forun.model.dto

import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size

data class CreateTopicForm(
    @field:NotEmpty
    @field:Size(min = 5, max = 100, message = "The Title must be between 5 and 100 character")
    val title: String,
    @field:NotEmpty
    val message: String,
    @field:NotNull
    val courseId: Long,
    @field:NotNull
    val authorId: Long
)