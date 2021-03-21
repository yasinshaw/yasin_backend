package com.yasinshaw.common.util

import com.fasterxml.jackson.databind.ObjectMapper

class JsonUtil(
) {
    companion object {
        private val OBJECT_MAPPER: ObjectMapper = ObjectMapper()

        fun toJson(value: Any?): String? = OBJECT_MAPPER.writeValueAsString(value)

        fun <T> toObj(json: String?, cls: Class<T>) = OBJECT_MAPPER.readValue(json, cls)
    }
}