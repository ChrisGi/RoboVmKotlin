package pl.icompass.kotlin.network.model

/**
 * @author Krzysztof Gradzki
 */
data class OpenWeather(
        var city: City,
        var cod: String,
        var message: Double,
        var cnt: Int,
        var list: List<Day>
)
