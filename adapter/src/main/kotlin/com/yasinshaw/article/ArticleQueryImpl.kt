package com.yasinshaw.article

import com.yasinshaw.application.article.ArticleQuery
import com.yasinshaw.application.article.ArticleDetailVO
import org.springframework.stereotype.Component

@Component
class ArticleQueryImpl constructor(
    private val articleDao: ArticleDao,
) : ArticleQuery {
    override fun getArticleDetailById(id: Long): ArticleDetailVO =
        articleDao.findById(id).map { convertArticleDO2ArticleDetailVO(it) }.orElse(null)

    private fun convertArticleDO2ArticleDetailVO(articleDO: ArticleDO): ArticleDetailVO {
        return ArticleDetailVO(
            id = articleDO.id!!,
            title = articleDO.title,
            content = articleDO.content
        )
    }
}