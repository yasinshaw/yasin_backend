package com.yasinshaw.data.entity

import java.time.LocalDateTime
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "article")
data class ArticleDO(
    @Id @GeneratedValue var id: Long? = null,
    var addedTime: LocalDateTime = LocalDateTime.now(),
    var title: String,
    var content: String,
);