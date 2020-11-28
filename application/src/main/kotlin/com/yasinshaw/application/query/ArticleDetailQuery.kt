package com.yasinshaw.application.query

import com.yasinshaw.application.vo.ArticleDetailVO
import org.springframework.stereotype.Service

@Service
class ArticleDetailQuery {
    fun getArticleDetailById(id: Long) =
            ArticleDetailVO(id, "title", "detail")
}