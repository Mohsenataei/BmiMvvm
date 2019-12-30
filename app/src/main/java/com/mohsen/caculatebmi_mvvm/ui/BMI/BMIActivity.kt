package com.mohsen.caculatebmi_mvvm.ui.BMI

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mohsen.caculatebmi_mvvm.R
import com.xw.repo.BubbleSeekBar
import kotlinx.android.synthetic.main.activity_bmi.*

class BMIActivity : AppCompatActivity(), BubbleSeekBar.OnProgressChangedListener {
    private val MIN_HEIGHT = 130
    private val MAX_HEIGHT = 220
    private val MIN_WEIGHT = 35
    private val MAX_WEIGHT = 200
    private val DEFAULT_HEIGHT = 175
    private val DEFAULT_WEIGHT = 70

//    internal var bmiProgressV: CircleProgressView
//    internal var hightTV: TextView
//    internal var weightTV: TextView
//    internal var resultDescriptionTV: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_bmi)

//        bmiProgressV = findViewById(R.id.bmi_progress)
//        hightTV = findViewById(R.id.bmi_hight)
//        weightTV = findViewById(R.id.bmi_weight)
////        resultDescriptionTV = findViewById(R.id.bmi_result_description)
//        bmi_result_description.setOnClickListener { view ->
//            startActivity(
//                Intent(
//                    this,
//                    ConsumedCaloriesCalculator::class.java
//                )
//            )
//        }

        bmi_seekbar_hight.setOnProgressChangedListener(this)
        bmi_seekbar_weight.onProgressChangedListener = this
        ///FloatingActionButton fab = findViewById(R.id.add);

//        bmi_result_title.setOnClickListener({ view ->
//            Toast.makeText(this, "clicked", Toast.LENGTH_SHORT).show()
//            startActivity(Intent(this, CaloriesMainPage::class.java))
//        })
       setDefaults()
    }


    override fun onProgressChanged(
        bubbleSeekBar: BubbleSeekBar?,
        progress: Int,
        progressFloat: Float
    ) {

        calculateBMI()
    }

    override fun getProgressOnActionUp(
        bubbleSeekBar: BubbleSeekBar?,
        progress: Int,
        progressFloat: Float
    ) {

    }

    override fun getProgressOnFinally(
        bubbleSeekBar: BubbleSeekBar?,
        progress: Int,
        progressFloat: Float
    ) {

    }

    private fun setDefaults() {
        bmi_seekbar_hight.getConfigBuilder()
            .min(MIN_HEIGHT.toFloat())
            .max(MAX_HEIGHT.toFloat())
            .build()

        bmi_seekbar_weight.configBuilder
            .min(MIN_WEIGHT.toFloat())
            .max(MAX_WEIGHT.toFloat())
            .build()

        bmi_seekbar_hight.setProgress(DEFAULT_HEIGHT.toFloat())
        bmi_seekbar_weight.setProgress(DEFAULT_WEIGHT.toFloat())
    }
    private fun calculateBMI() {
        val hight = bmi_seekbar_hight.getProgress()
        val wight = bmi_seekbar_weight.getProgress()

        val hightMeter = hight.toFloat() / 100

        bmi_hight.text = Integer.toString(hight)
        bmi_weight.text = Integer.toString(wight)
        val bmi = (wight / (hightMeter * hightMeter)).toInt()
        bmi_progress.setValueAnimated(bmi.toFloat())

        //insure its a text and will be shown as english digits on all phones.
        bmi_progress.setText(Integer.toString(bmi))

        var descriptionResource = -1

        if (bmi > 40)
            descriptionResource = R.string.bmi_more_than_40_description
        else if (bmi > 30)
            descriptionResource = R.string.bmi_30_to_40_description
        else if (bmi > 25)
            descriptionResource = R.string.bmi_25_to_30_description
        else if (bmi > 20)
            descriptionResource = R.string.bmi_20_to_25_description
        else if (bmi > 18.5)
            descriptionResource = R.string.bmi_18_5_to_20_description
        else
            descriptionResource = R.string.bmi_below_18_5_description


        bmi_result_description.setText(descriptionResource)

    }
}
