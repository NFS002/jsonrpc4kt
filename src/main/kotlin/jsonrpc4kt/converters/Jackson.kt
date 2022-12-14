package jsonrpc4kt.converters

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import jsonrpc4kt.core.Conversion
import jsonrpc4kt.core.Converter

fun Conversion.jackson(init: ObjectMapper.() -> Unit): JacksonConverter {
    val mapper = jacksonObjectMapper()
    mapper.init()
    return JacksonConverter(mapper)
}

class JacksonConverter(val mapper: ObjectMapper) : Converter {
    override fun <T> deserialize(input: String, returnType: Class<T>): T? = mapper.readValue(input, returnType)
    override fun serialize(input: Any): String = mapper.writeValueAsString(input)
}
