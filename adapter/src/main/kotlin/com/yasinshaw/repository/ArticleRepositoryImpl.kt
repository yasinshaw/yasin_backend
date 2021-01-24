package com.yasinshaw.repository

import com.yasinshaw.application.repository.ArticleRepository
import com.yasinshaw.data.dao.ArticleDao
import com.yasinshaw.data.entity.ArticleDO
import com.yasinshaw.domain.Article
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class ArticleRepositoryImpl @Autowired constructor(
    private val articleDao: ArticleDao,
) : ArticleRepository {
    override fun findArticleById(id: Long): Article {
        return articleDao.findById(id).map { articleDO ->
            Article(
                articleDO.id,
                articleDO.title,
                articleDO.content
            )
        }.orElseThrow();
    }

    override fun save(article: Article) {
        articleDao.save(ArticleDO(
            id = article.id,
            title = article.title,
            content = article.content,
        ));
    }
}