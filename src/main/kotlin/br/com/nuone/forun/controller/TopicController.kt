package br.com.nuone.forun.controller

import br.com.nuone.forun.model.dto.CreateTopicForm
import br.com.nuone.forun.model.dto.UpdateTopicForm
import br.com.nuone.forun.model.view.TopicView
import br.com.nuone.forun.service.TopicService
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder

@RestController
@RequestMapping("/topics")
class TopicController(private val topicService: TopicService) {
    @GetMapping
    fun findAll(): List<TopicView> {
        return topicService.findAll()
    }

    @GetMapping("/topic/{id}")
    fun findById(@PathVariable id: Long): TopicView {
        return topicService.findById(id);
    }

    @PostMapping()
    fun create(
        @RequestBody @Valid form: CreateTopicForm, uriBuilder: UriComponentsBuilder
    ): ResponseEntity<TopicView> {
        val topicView = topicService.create(form);
        val uri = uriBuilder.path("/topics/topic/${topicView.id}")
            .build().toUri()
        return ResponseEntity.created(uri).body(topicView)
    }

    @PutMapping()
    fun update(@RequestBody @Valid form: UpdateTopicForm): ResponseEntity<TopicView> {
        return ResponseEntity.ok(topicService.update(form))
    }

    @DeleteMapping("/topic/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun delete(@PathVariable id: Long){
        topicService.delete(id);
    }

}