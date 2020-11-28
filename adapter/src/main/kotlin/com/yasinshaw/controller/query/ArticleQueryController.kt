package com.yasinshaw.controller.query

import com.yasinshaw.application.query.ArticleDetailQuery
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*

@RequestMapping("/articles")
@RestController
class ArticleQueryController(
        val articleDetailQuery: ArticleDetailQuery) {

    @GetMapping("/{id}")
    fun getArticleDetailById(@PathVariable id: Long) = articleDetailQuery.getArticleDetailById(id)

    @GetMapping("/test")
    fun test() = "test"
}