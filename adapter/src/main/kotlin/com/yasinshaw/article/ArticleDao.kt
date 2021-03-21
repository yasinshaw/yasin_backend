package com.yasinshaw.article

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ArticleDao: JpaRepository<ArticleDO, Long> {
}