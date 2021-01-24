package com.yasinshaw.query

import com.yasinshaw.application.query.ArticleQuery
import com.yasinshaw.application.vo.ArticleDetailVO
import org.springframework.stereotype.Component

@Component
class ArticleQueryImpl : ArticleQuery {
    override fun getArticleDetailById(id: Long) =
        ArticleDetailVO(id, "title", "detail")
}