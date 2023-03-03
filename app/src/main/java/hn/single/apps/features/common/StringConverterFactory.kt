package hn.single.apps.features.common

import okhttp3.ResponseBody
import retrofit2.Converter
import retrofit2.Retrofit
import java.lang.reflect.Type

class StringConverterFactory : Converter.Factory() {

    override fun responseBodyConverter(
        type: Type,
        annotations: Array<out Annotation>,
        retrofit: Retrofit
    ): Converter<ResponseBody, *>? {
        annotations.forEach { annotation ->
            if (annotation is RawString) return StringConverter()
        }
        return null
    }

    class StringConverter : Converter<ResponseBody, String> {
        override fun convert(value: ResponseBody): String {
            return value.byteString().utf8()
        }
    }
}

annotation class RawString