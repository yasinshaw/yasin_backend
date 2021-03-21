package com.yasinshaw.common.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.time.LocalDateTime
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import java.time.ZoneId
import java.time.Instant
import java.io.IOException
import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.*


@Configuration
class JacksonConfig {

    @Bean
    fun serializingObjectMapper(): ObjectMapper {
        val objectMapper = ObjectMapper()
        val javaTimeModule = JavaTimeModule()
        javaTimeModule.addSerializer(LocalDateTime::class.java, LocalDateTimeSerializer())
        javaTimeModule.addDeserializer(LocalDateTime::class.java, LocalDateTimeDeserializer())
        objectMapper.registerModule(javaTimeModule)
        return objectMapper
    }

    /**
     * 序列化实现
     */
    private class LocalDateTimeSerializer : JsonSerializer<LocalDateTime?>() {
        @Throws(IOException::class)
        override fun serialize(value: LocalDateTime?, gen: JsonGenerator, serializers: SerializerProvider) {
            if (value != null) {
                val timestamp = value.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli()
                gen.writeNumber(timestamp)
            }
        }
    }

    /**
     * 反序列化实现
     */
    private class LocalDateTimeDeserializer : JsonDeserializer<LocalDateTime?>() {
        @Throws(IOException::class)
        override fun deserialize(p: JsonParser, deserializationContext: DeserializationContext?): LocalDateTime? {
            val timestamp: Long = p.valueAsLong
            return if (timestamp > 0) {
                LocalDateTime.ofInstant(Instant.ofEpochMilli(timestamp), ZoneId.systemDefault())
            } else {
                null
            }
        }
    }
}