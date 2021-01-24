package com.yasinshaw.controller.query

import com.yasinshaw.application.query.ArticleQuery
import com.yasinshaw.application.repository.ArticleRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RequestMapping("/articles")
@RestController
class ArticleQueryController @Autowired constructor(
        val articleQuery: ArticleQuery,
        val articleRepository: ArticleRepository
) {

    @GetMapping("/{id}")
    fun getArticleDetailById(@PathVariable id: Long) = articleQuery.getArticleDetailById(id)

    @GetMapping("/test")
    fun test() = "test"
}