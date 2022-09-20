package jsonrpc4kt.converters


import com.google.gson.Gson
import jsonrpc4kt.core.Conversion
import jsonrpc4kt.core.Converter

fun Conversion.gson(init: Gson.() -> Unit): JsonConverter {
    val gson = Gson()
    gson.init()
    return JsonConverter(gson)
}

class JsonConverter(val gson: Gson) : Converter {
    override fun <T> deserialize(input: String, returnType: Class<T>): T? = gson.fromJson(input, returnType)
    override fun serialize(input: Any): String = gson.toJson(input)
}
