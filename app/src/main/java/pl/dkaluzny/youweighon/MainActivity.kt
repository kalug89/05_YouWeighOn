package pl.dkaluzny.youweighon

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.widget.CheckBox
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {


    val marsGravity = 0.38
    val venusGravity = 0.91
    val jupiterGravity = 2.34


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var weight = enterWeightId.text
        showWeightButtonId.setOnClickListener {
            var result = calculateWeight(weight.toString().toDouble())

            resultTextViewvId.text = "Yout weight " + result.toString() + " on Mars"
        }
        marsCheckBox.setOnClickListener(this)
        venusCheckBox.setOnClickListener(this)
        jupiterCheckBox.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        v as CheckBox
        var isChecked:Boolean = v.isChecked

        when(v.id) {
            R.id.marsCheckBox -> if (isChecked){Log.wtf("Setup Mars", "Mars")}
            R.id.venusCheckBox -> if (isChecked){Log.wtf("Stup Venus", "Venus")}
            R.id.jupiterCheckBox -> if (isChecked){Log.wtf("Stup Jupiter", "Jupiter")}
        }
    }

    fun calculateWeight(userWeight: Double): Double {
        return userWeight * marsGravity
    }
}
