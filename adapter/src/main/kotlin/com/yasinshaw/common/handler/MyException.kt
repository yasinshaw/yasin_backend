package com.yasinshaw.common.handler

data class MyException(
    val code: Int,
    override val message: String?,
): Exception(message)
