package com.yasinshaw.application.article

import com.yasinshaw.domain.article.Article
import com.yasinshaw.domain.article.CreateArticleCommand
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component


@Component
class ArticleApplicationService @Autowired constructor(
    private val articleRepository: ArticleRepository,
) {

    fun createArticle(createArticleCommand: CreateArticleCommand): Long {
        val article = Article.createArticle(createArticleCommand)
        articleRepository.save(article)
        return article.id!!
    }

}