package pl.icompass.kotlin.network.model

/**
 * @author Krzysztof Gradzki
 */
data class Weather(
        var id: Int,
        var main: String,
        var description: String,
        var icon: String
)