package com.yasinshaw.article

import com.yasinshaw.application.article.ArticleDetailVO
import com.yasinshaw.application.article.ArticleQuery
import com.yasinshaw.common.handler.MyException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import kotlin.jvm.Throws

@RequestMapping("/articles")
@RestController
class ArticleReadController @Autowired constructor(
    private val articleQuery: ArticleQuery,
) {

    @GetMapping("/{id}")
    @Throws(MyException::class)
    fun getArticleDetailById(@PathVariable id: Long) = articleQuery.getArticleDetailById(id) ?: throw MyException(-1, "找不到文章")

}