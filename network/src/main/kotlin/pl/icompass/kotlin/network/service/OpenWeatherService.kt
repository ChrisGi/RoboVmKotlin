package pl.icompass.kotlin.network.service

import com.squareup.okhttp.OkHttpClient
import com.squareup.okhttp.logging.HttpLoggingInterceptor
import pl.icompass.kotlin.network.model.OpenWeather
import retrofit.GsonConverterFactory
import retrofit.Retrofit
import retrofit.RxJavaCallAdapterFactory
import retrofit.http.GET
import retrofit.http.Query
import rx.Observable

/**
 * @author Krzysztof Gradzki
 */
interface OpenWeatherService {

    @GET("forecast?")
    fun get5DaysWeatherRx(@Query("q") query: String): Observable<OpenWeather>

    companion object {

        fun create(): OpenWeatherService {

            val logInterceptor = HttpLoggingInterceptor();
            logInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)

            val interceptorList = arrayOf(WeatherRequestInterceptor(), logInterceptor)

            val httpClient: OkHttpClient = OkHttpClient()

            httpClient.interceptors().addAll(interceptorList)

            val retrofit = Retrofit.Builder()
                    .client(httpClient)
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl("http://api.openweathermap.org/data/2.5/").build();

            return retrofit.create(OpenWeatherService::class.java)
        }
    }
}