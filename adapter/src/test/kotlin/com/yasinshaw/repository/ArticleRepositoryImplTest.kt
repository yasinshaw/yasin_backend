package com.yasinshaw.repository

import com.yasinshaw.BaseIntegrationTest
import com.yasinshaw.data.entity.ArticleDO
import com.yasinshaw.domain.Article
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager
import org.springframework.context.annotation.ComponentScan

@DataJpaTest
internal class ArticleRepositoryImplTest @Autowired constructor(
    val entityManager: TestEntityManager,
    val articleRepositoryImpl: ArticleRepositoryImpl,
) : BaseIntegrationTest() {
    @Test
    internal fun shouldSaveArticleSuccess() {
        articleRepositoryImpl.save(Article(
            id = null,
            title = "title",
            content = "myContent",
        ));
        val articleDO = entityManager.find(ArticleDO::class.java, 1L)
        assertEquals(articleDO.id, 1L)
        assertNotNull(articleDO.addedTime)
        assertEquals(articleDO.title, "title")
        assertEquals(articleDO.content, "myContent")
    }
}