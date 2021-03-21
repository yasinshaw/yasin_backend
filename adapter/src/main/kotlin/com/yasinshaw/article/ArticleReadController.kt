package com.yasinshaw.article

import com.yasinshaw.application.article.ArticleQuery
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RequestMapping("/articles")
@RestController
class ArticleReadController @Autowired constructor(
    private val articleQuery: ArticleQuery,
) {

    @GetMapping("/{id}")
    fun getArticleDetailById(@PathVariable id: Long) = articleQuery.getArticleDetailById(id)

}