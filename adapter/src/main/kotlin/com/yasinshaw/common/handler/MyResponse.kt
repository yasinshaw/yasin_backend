package com.yasinshaw.common.handler

import lombok.NoArgsConstructor
import java.io.Serializable
import java.time.LocalDateTime

data class MyResponse<T> constructor(
    val success: Boolean = false,
    val msg: String = "",
    val data: T? = null,
    val code: Int = 0,
    val time: LocalDateTime = LocalDateTime.now(),
){
    companion object {
        fun <T> ofSuccess(content: T?): MyResponse<T?> = MyResponse(
            success = true,
            msg = "OK",
            data = content,
            code = 0,
            LocalDateTime.now(),
        )

        fun ofFailure(e: MyException) = MyResponse(
            success = false,
            msg = e.message ?: "",
            data = null,
            code = e.code,
            time = LocalDateTime.now(),
        )
    }
}