package pl.dkaluzny.youweighon

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val marsGravity = 0.38

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var weight = enterWeightId.text
        showWeightButtonId.setOnClickListener {
            var result = calculateWeight(weight.toString().toDouble())

            resultTextViewvId.text = "Yout weight " + result.toString() + " on Mars"
        }
    }

    fun calculateWeight(userWeight: Double): Double {
        return userWeight * marsGravity
    }
}
