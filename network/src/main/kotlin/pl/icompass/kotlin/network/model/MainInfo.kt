package pl.icompass.kotlin.network.model

import com.google.gson.annotations.SerializedName

/**
 * @author Krzysztof Gradzki
 */
class MainInfo(
        var temp: Double,
        @SerializedName("temp_min") var tempMin: Double,
        @SerializedName("temp_max") var tempMax: Double,
        var pressure: Double,
        @SerializedName("sea_level") var seaLevel: Double,
        @SerializedName("grnd_level") var grndLevel: Double,
        var humidity: Int,
        @SerializedName("temp_kf") var tempKf: Double
)