package com.yasinshaw.application.article

interface ArticleQuery {
    fun getArticleDetailById(id: Long): ArticleDetailVO?;
}