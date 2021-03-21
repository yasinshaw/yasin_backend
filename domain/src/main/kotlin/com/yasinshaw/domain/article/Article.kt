package com.yasinshaw.domain.article

class Article constructor(
    val id: Long?,
    var title: String,
    var content: String,
) {
    companion object {
        fun createArticle(createArticleCommand: CreateArticleCommand) =
            Article(null, createArticleCommand.title, createArticleCommand.content)
    }

}