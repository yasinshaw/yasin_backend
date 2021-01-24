package com.yasinshaw.data.dao

import com.yasinshaw.data.entity.ArticleDO
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ArticleDao: JpaRepository<ArticleDO, Long> {
}