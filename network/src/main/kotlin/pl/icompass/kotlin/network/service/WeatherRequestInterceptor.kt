package pl.icompass.kotlin.network.service

import com.squareup.okhttp.Interceptor
import com.squareup.okhttp.Response


/**
 * @author Krzysztof Gradzki
 */
class WeatherRequestInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {

        val request = chain.request()
        val httpUrl = request.httpUrl().newBuilder()
                .addQueryParameter("mode", "json")
                .addQueryParameter("appid", "913c3c97ee113d15c4d9e1cdd07cb25a")
                .addQueryParameter("units", "metric")
                .build()

        return chain.proceed(request.newBuilder().url(httpUrl).build())
    }
}