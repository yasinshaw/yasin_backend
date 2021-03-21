package com.yasinshaw.article

import com.yasinshaw.application.article.ArticleApplicationService
import com.yasinshaw.domain.article.CreateArticleCommand
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RequestMapping("/articles")
@RestController
class ArticleWriteController @Autowired constructor(
    private val articleApplicationService: ArticleApplicationService,
) {

    @PostMapping
    fun create(@RequestBody createArticleCommand: CreateArticleCommand) =
        articleApplicationService.createArticle(createArticleCommand)

}