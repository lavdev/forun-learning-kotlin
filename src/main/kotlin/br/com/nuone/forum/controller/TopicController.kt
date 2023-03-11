package br.com.nuone.forum.controller

import br.com.nuone.forum.model.dto.CreateTopicForm
import br.com.nuone.forum.model.dto.TopicByCategoryDto
import br.com.nuone.forum.model.dto.UpdateTopicForm
import br.com.nuone.forum.model.view.TopicView
import br.com.nuone.forum.service.TopicService
import jakarta.transaction.Transactional
import jakarta.validation.Valid
import org.springframework.cache.annotation.CacheEvict
import org.springframework.cache.annotation.Cacheable
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import org.springframework.data.web.PageableDefault
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder

@RestController
@RequestMapping("/topics")
class TopicController(private val topicService: TopicService) {
    // ⚠ this one is not a good candidate to be a cacheable
    // it will be changed a lot. But it is just to learn
    // how the spring boot cache works.  (right level)
    @GetMapping
    @Cacheable("cache_topics")
    fun findAll(
        @RequestParam(name = "course", required = false) course: String?,
        @PageableDefault(
            size = 10,
            sort = ["createdAt"],
            direction = Sort.Direction.DESC
        ) pageable: Pageable
    ): Page<TopicView> {
        return topicService.findAll(course, pageable)
    }

    @GetMapping("/topic/{id}")
    fun findById(@PathVariable id: Long): TopicView {
        return topicService.findById(id);
    }

    @PostMapping()
    @Transactional
    @CacheEvict(value = ["cache_topics"], allEntries = true)
    fun create(
        @RequestBody @Valid form: CreateTopicForm, uriBuilder: UriComponentsBuilder
    ): ResponseEntity<TopicView> {
        val topicView = topicService.create(form);
        val uri = uriBuilder.path("/topics/topic/${topicView.id}")
            .build().toUri()
        return ResponseEntity.created(uri).body(topicView)
    }

    @PutMapping("/topic/{id}")
    @Transactional
    @CacheEvict(value = ["cache_topics"], allEntries = true)
    fun update(
        @RequestBody @Valid form: UpdateTopicForm,
        @PathVariable id: Long
    ): ResponseEntity<TopicView> {
        return ResponseEntity.ok(topicService.update(id, form))
    }

    @DeleteMapping("/topic/{id}")
    @Transactional
    @CacheEvict(value = ["cache_topics"], allEntries = true)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun delete(@PathVariable id: Long) {
        topicService.delete(id);
    }

    @GetMapping("/topic/report")
    fun report() : List<TopicByCategoryDto> {
        return this.topicService.report();
    }
}