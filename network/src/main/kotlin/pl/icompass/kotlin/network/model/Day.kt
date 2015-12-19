package pl.icompass.kotlin.network.model

import com.google.gson.annotations.SerializedName

/**
 * @author Krzysztof Gradzki
 */
data class Day(
        var dt: Int,
        var main: MainInfo,
        var weather: List<Weather>,
        var clouds: Clouds,
        var wind: Wind,
        @SerializedName("dt_txt") var dtText: String
)