package com.yasinshaw.article

import com.yasinshaw.application.article.ArticleRepository
import com.yasinshaw.domain.article.Article
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