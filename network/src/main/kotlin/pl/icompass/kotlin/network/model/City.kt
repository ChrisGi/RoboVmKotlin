package pl.icompass.kotlin.network.model

/**
 * @author Krzysztof Gradzki
 */
data class City(
        var id: Int,
        var name: String,
        var coord: Coord,
        var country: String,
        var population: Int
)