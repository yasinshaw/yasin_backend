package com.yasinshaw.application.article

import com.yasinshaw.domain.article.Article

interface ArticleRepository {
    fun findArticleById(id: Long): Article;
    fun save(article: Article): Long;
}