package pl.dkaluzny.youweighon

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.TextUtils
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
        var isChecked: Boolean = v.isChecked
        var weight = enterWeightId.text

        when (v.id) {
            R.id.marsCheckBox -> if (isChecked && !TextUtils.isEmpty(enterWeightId.text.toString())) {
                calculateWeight(weight.toString().toDouble(), v)
                venusCheckBox.isChecked = false
                jupiterCheckBox.isChecked = false

            }

            R.id.venusCheckBox -> if (isChecked && !TextUtils.isEmpty(enterWeightId.text.toString())) {
                calculateWeight(weight.toString().toDouble(), v)
                marsCheckBox.isChecked = false
                jupiterCheckBox.isChecked = false
            }
            R.id.jupiterCheckBox -> if (isChecked && !TextUtils.isEmpty(enterWeightId.text.toString()))
            {
                calculateWeight(weight.toString().toDouble(), v)
                marsCheckBox.isChecked = false
                venusCheckBox.isChecked = false
            }
        }
    }

    fun calculateWeight(userWeight: Double, checkBox: CheckBox) {
        var result: Double?
        when (checkBox.id) {

            R.id.marsCheckBox -> {
                result = userWeight * marsGravity
                resultTextViewvId.text = "Weight is " + result.format(2) + " On Mars"
            }
            R.id.venusCheckBox -> {
                result = userWeight * venusGravity
                resultTextViewvId.text = "Weight is " + result.format(2) + " On Venus"
            }
            R.id.jupiterCheckBox -> {
                result = userWeight * jupiterGravity
                resultTextViewvId.text = "Weight is " + result.format(2) + " On Upiter"
            }
            else -> result = userWeight * marsGravity
        }
    }

    fun Double.format(digits: Int) = java.lang.String.format("%.${digits}f", this)
}
