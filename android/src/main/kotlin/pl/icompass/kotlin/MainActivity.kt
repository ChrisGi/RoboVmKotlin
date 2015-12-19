package pl.icompass.kotlin

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Button
import android.widget.TextView
import pl.icompass.kotlin.network.service.OpenWeatherService
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers
import kotlin.properties.Delegates

class MainActivity : AppCompatActivity() {

    private val TAG = "MainActivity";

    private val counterStore = CounterStore()

    private var weatherService: OpenWeatherService by Delegates.notNull()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my)

        weatherService = OpenWeatherService.create();

        val counterTextView = findViewById(R.id.counterTextView) as TextView
        val counterButton = findViewById(R.id.counterButton) as Button

        counterButton.setOnClickListener { view ->
            counterStore.add(1)
            counterTextView.text = "Click Nr. " + counterStore.get()

            weatherService.get5DaysWeatherRx("Warsaw,PL")
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe({ u -> Log.i(TAG, u.toString()) },
                            { e -> Log.e(TAG, e.message) })
        }
    }
}
