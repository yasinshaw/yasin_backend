package com.yasinshaw.application.query

import com.yasinshaw.application.vo.ArticleDetailVO
import org.springframework.stereotype.Service

interface ArticleQuery {
    fun getArticleDetailById(id: Long): ArticleDetailVO;
}