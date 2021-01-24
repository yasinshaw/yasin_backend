package com.yasinshaw.application.repository

import com.yasinshaw.domain.Article

interface ArticleRepository {
    fun findArticleById(id: Long): Article;
    fun save(article: Article);
}