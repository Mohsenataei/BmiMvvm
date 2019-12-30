package com.mohsen.caculatebmi_mvvm.ui.dialogs

import android.app.Dialog
import android.content.Context
import android.content.res.Resources
import android.os.Bundle
import android.util.Log
import android.view.ViewGroup
import com.google.android.gms.ads.AdListener
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.InterstitialAd
import com.google.android.gms.ads.MobileAds
import com.mohsen.caculatebmi_mvvm.App
import com.mohsen.caculatebmi_mvvm.R
import com.mohsen.caculatebmi_mvvm.model.Exercise
import com.mohsen.caculatebmi_mvvm.util.exerciseList
import com.mohsen.caculatebmi_mvvm.util.first_skip
import com.mohsen.caculatebmi_mvvm.util.getExerciseCalories
import kotlinx.android.synthetic.main.add_exercise_dialog.*


const val AD_UNIT_IDD = "ca-app-pub-3940256099942544/1033173712"

class AddExerciseDialog(
    context: Context,
    title: String,
    val onConfirmClick: (food: Exercise) -> Unit = {}
) : Dialog(context) {

    private val title = title
    val calories = getExerciseCalories()[title]
    var flag: Boolean? = false
    var duration = 1
    var cal = 0
    val res: Resources? = App.instance.resources
    private lateinit var interstitialAd: InterstitialAd

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.add_exercise_dialog)

        Log.i("onCreate", "Start")
        MobileAds.initialize(context) {
            Log.i("MobileAds.initialize", "Start")
            it.adapterStatusMap.forEach { (t, u) ->
                Log.i("MobileAds.initialize", "$t: ${u.description} _ ${u.initializationState}")
            }
        }


        interstitialAd = InterstitialAd(context).apply {
            adUnitId = AD_UNIT_IDD
            adListener = (object : AdListener() {
                override fun onAdLoaded() {
                    // Toast.makeText(context, "onAdLoaded()", Toast.LENGTH_SHORT).show()
                    Log.d("AddExAd", "onAdLoaded()")
                }

                override fun onAdFailedToLoad(errorCode: Int) {
//                    Toast.makeText(
//                        context,
//                        "onAdFailedToLoad() with error code: $errorCode",
//                        Toast.LENGTH_LONG
//                    ).show()
                    Log.d("AddExAd", "onAdFailedToLoad() with error code: $errorCode")
                }

                override fun onAdClosed() {
                    prepareAd()
                }
            })
        }
        prepareAd()


        window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        addExercisedialogTitle.text = title
        add_exercise_burned_calories_text_view.text =
            calories!!.div(30).toString().plus(" " + res?.getString(R.string.calory))
        number_picker.setOnValueChangedListener { picker, oldVal, newVal ->
            duration = newVal
            setCaloriesValue(newVal)
        }
        addExerciseConfirm.setOnClickListener {
            exerciseList.add(Exercise(title, duration, cal))
            onConfirmClick(Exercise(title, duration, cal))

            showInterstitial()
            dismiss()
        }


    }


    private fun setCaloriesValue(newval: Int) {
        cal = newval.times(calories!!).div(30)
        add_exercise_burned_calories_text_view.text =
            cal.toString().plus(" " + res?.getString(R.string.calory))
    }

    private fun prepareAd() {
        if (!interstitialAd.isLoading && !interstitialAd.isLoaded) {
            val adRequest = AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build()
            interstitialAd.loadAd(adRequest)
        }

    }

    private fun showInterstitial() {
        if (first_skip) {
            if (interstitialAd.isLoaded) {
                interstitialAd.show()
            } else {
                // Toast.makeText(context, "Ad wasn't loaded.", Toast.LENGTH_SHORT).show()
                Log.d("AddExAd", "Ad wasn't loaded.")
            }
        } else {
            first_skip = true
        }
    }


}