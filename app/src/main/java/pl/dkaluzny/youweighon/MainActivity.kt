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

        showWeightButtonId.setOnClickListener {
//        var result = calculateWeight(weight.toString().toDouble())
//         resultTextViewvId.text = "Yout weight " + result.toString() + " on Mars"
        }
        marsCheckBox.setOnClickListener(this)
        venusCheckBox.setOnClickListener(this)
        jupiterCheckBox.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        v as CheckBox
        var isChecked:Boolean = v.isChecked
        var weight = enterWeightId.text

        when(v.id) {
            R.id.marsCheckBox -> if (isChecked){calculateWeight(weight.toString().toDouble(), v)}
            R.id.venusCheckBox -> if (isChecked){calculateWeight(weight.toString().toDouble(), v)}
            R.id.jupiterCheckBox -> if (isChecked){calculateWeight(weight.toString().toDouble(), v)}
        }
    }

    fun calculateWeight(userWeight: Double, checkBox: CheckBox) {
        var result: Double?
        when(checkBox.id){

            R.id.marsCheckBox -> result =  userWeight * marsGravity
            R.id.venusCheckBox -> result =  userWeight * venusGravity
            R.id.jupiterCheckBox -> result =  userWeight * jupiterGravity
            else -> result = userWeight * marsGravity
        }

        resultTextViewvId.text =  "Weight is" + result
    }
}
