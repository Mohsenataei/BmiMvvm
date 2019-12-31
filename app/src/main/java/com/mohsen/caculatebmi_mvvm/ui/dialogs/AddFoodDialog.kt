package com.mohsen.caculatebmi_mvvm.ui.dialogs

import android.app.Dialog
import android.content.Context
import android.content.res.Resources
import android.os.Bundle
import android.os.CountDownTimer
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.core.widget.addTextChangedListener
import com.mohsen.caculatebmi_mvvm.App
import com.mohsen.caculatebmi_mvvm.R
import com.mohsen.caculatebmi_mvvm.database.entity.Food
import com.mohsen.caculatebmi_mvvm.util.*
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.InterstitialAd
import com.google.android.gms.ads.MobileAds
import com.google.android.gms.ads.reward.RewardedVideoAd
import com.google.android.gms.ads.rewarded.RewardItem
import com.google.android.gms.ads.rewarded.RewardedAd
import com.google.android.gms.ads.rewarded.RewardedAdCallback
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback
import kotlinx.android.synthetic.main.add_food_dialog.*

@Suppress("DEPRECATION")
const val AD_UNIT_ID = "ca-app-pub-8616739363688136/3776981726"
const val AD_REWARD_UNIT_ID = "ca-app-pub-8616739363688136/6484419001"

//const val AD_UNIT_ID = "ca-app-pub-3940256099942544/1033173712"


class AddFoodDialog(
    context: Context,
    food_title: String,
    type: String,
//    val onConfirmClick: (food: Food) -> Unit = {},
    val onResult: ((Food) -> Unit)? = null
) : Dialog(context) {
    val key: String? = null
    var ateCalory: String? = null
    var calories: Int? = null
    var meal: Int? = null
    var type: Int? = null
    val title = food_title
    var userPrefs:Preferences? = null
    val caloriesData = getCaloriesData()
    val caloryByGram = caloriesData["gram"]
    val caloryByGlass = caloriesData["glass"]
    var flags = arrayOfNulls<Boolean>(4)
    val res: Resources? = App.instance.resources
    private lateinit var mInterstitialAd: InterstitialAd
    private lateinit var mRewardedAd: RewardedAd

    private lateinit var mRewardedVideoAd: RewardedVideoAd


    private var mCoinCount: Int = 0
    private var mCountDownTimer: CountDownTimer? = null
    private var mGameOver = false
    private var mGamePaused = false
    private var mIsLoading = false
    private var mTimeRemaining: Int = 1

    //ca-app-pub-8616739363688136~5362909026

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.add_food_dialog)

        userPrefs = Preferences(context)
        //  MobileAds.initialize(context)
        Log.i("onCreate", "Start")
        MobileAds.initialize(context) {
            Log.i("MobileAds.initialize", "Start")
            it.adapterStatusMap.forEach { (t, u) ->
                Log.i("MobileAds.initialize", "$t: ${u.description} _ ${u.initializationState}")
            }
        }


        mRewardedVideoAd = MobileAds.getRewardedVideoAdInstance(context)
        loadRewardedAd()
        prepareRewardAd()

        window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)

        for (i in 0..flags.size - 1)
            flags[i] = false
        food_name.text = title

        getMeal()
        getType()
        //getCalories()
        add_food_dialog_edit_text.addTextChangedListener {
            object : TextWatcher {
                override fun afterTextChanged(s: Editable?) {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }

                override fun beforeTextChanged(
                    s: CharSequence?,
                    start: Int,
                    count: Int,
                    after: Int
                ) {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

                    val text = add_food_dialog_edit_text.text.toString().toInt()
                    Log.d("onchange", "is it working ?")
                    val unit = caloriesData["gram"]!![title]
                    if (unit != null) {
                        calories = text.times(unit).div(100)
                        Consumed_calories_text_view.text = text.times(unit).div(100).toString()
                            .plus(" :" + res?.getString(R.string.calory))
                        consumedProteinsTextView.text =
                            text.times(unit).div(100).div(genRandomNum(text)).toString()
                                .plus(" :" + res?.getString(R.string.proteins))
                        //  ateCalory = consumedProteinsTextView.text.toString()
                    } else {
                        Log.d("FoodDialog", "unit is empty")
                        Consumed_calories_text_view.text = genRandomNum(100).times(100).toString()
                            .plus(" :" + res?.getString(R.string.calory))
                    }

                    if (type == TYPE_GLASS && !consumedProteinsTextView.text.isNullOrEmpty()) {
                        consumedProteinsTextView.text =
                            add_food_dialog_edit_text.text.toString().toInt().times(5).toString()
                        // ateCalory = consumedProteinsTextView.text.toString()
                    }
                }

            }
        }
        onConfirmClicked()

    }
    private fun loadRewardedVideoAd() {
        mRewardedVideoAd.loadAd(
            "ca-app-pub-3940256099942544/5224354917",
            AdRequest.Builder().build()
        )
    }


    private fun getMeal() {
        add_food_dialog_breakfast.setOnClickListener {
            meal = BREAKFAST
            selectBreakfast()
            setDinnerToNormal()
            setMianVadeToNormal()
            setLaunchToNormal()
            context.toast(res!!.getString(R.string.breakfast_toast))
        }
        add_food_dialog_dinner.setOnClickListener {
            meal = DINNER
            selectDinner()
            setMianVadeToNormal()
            setLaunchToNormal()
            setBreakfastToNormal()
            context.toast(res!!.getString(R.string.dinner_toast))
        }
        add_food_dialog_mianvade.setOnClickListener {
            meal = MIANVADEH
            selectMianvade()
            setLaunchToNormal()
            setBreakfastToNormal()
            setDinnerToNormal()
            context.toast(res!!.getString(R.string.snack_toast))
        }
        add_food_dialog_launch.setOnClickListener {
            meal = LAUNCH
            selectLaunch()
            setBreakfastToNormal()
            setDinnerToNormal()
            setMianVadeToNormal()
            context.toast(res!!.getString(R.string.launch_toast))
        }

    }

    private fun getType() {
        add_food_dialog_glass_text_view.setOnClickListener {
            type = TYPE_GLASS
            context.toast(res!!.getString(R.string.selected_unit_glass))
            getCalories()
            setCaloriesTextView(TYPE_GLASS)
        }
        add_food_dialog_gram_text_view.setOnClickListener {
            type = TYPE_GRAM
            context.toast(res!!.getString(R.string.selected_unit_gram))
            getCalories()
            setCaloriesTextView(TYPE_GRAM)
        }
    }

    private fun setCaloriesTextView(type: Int) {
        if (!add_food_dialog_edit_text.text.isNullOrEmpty()) {
            val text = add_food_dialog_edit_text.text.toString().toInt()
            if (type == TYPE_GLASS) {
                val cal = caloryByGlass!![title]
                consumedProteinsTextView.text = text.times(cal!!).toString()

            } else if (type == TYPE_GRAM) {

                val cal = caloryByGram!![title]
//                calories = text.times(cal!!).div(100)
//                Consumed_calories_text_view.text = text.times(cal).div(100).toString().plus(" کالری ")
//                consumedProteinsTextView.text = text.times(cal).div(100).div(genRandomNum(text)).toString().plus("پروتیین ")
                if (cal != null) {
                    calories = text.times(cal!!).div(100)
                    Consumed_calories_text_view.text = text.times(cal).div(100).toString()
                        .plus(" :" + res?.getString(R.string.calory))
                    consumedProteinsTextView.text =
                        text.times(cal).div(100).div(genRandomNum(text)).toString()
                            .plus(" :" + res?.getString(R.string.proteins))
                    // ateCalory = consumedProteinsTextView.text.toString()
                } else {
                    Log.d("FoodDialog", "unit is empty")
                    Consumed_calories_text_view.text =
                        text.times(genRandomNum(300)).div(100).toString()
                            .plus(" :" + res?.getString(R.string.calory))
                }
            }
        }
    }

    private fun getCalories() {

        ateCalory = add_food_dialog_edit_text.text.toString()
//        }else if (add_food_dialog_edit_text.text.toString().toIntOrNull() == null){
//            context.toast("لطفا مقدار مصرفی را به عدد وارد کنید")
//            ateCalory = add_food_dialog_edit_text.text.toString()
    }

    private fun setValuesByGram() {
        val cal = caloryByGram!![title]
        consumedProteinsTextView.text = ateCalory!!.toInt().times(cal!!).div(100).toString()
    }

    private fun setValuesByGlass() {
        val cal = caloryByGlass!![title]
        consumedProteinsTextView.text = ateCalory!!.toInt().times(cal!!).toString()
    }

    private fun confirmation() {
        Log.d("Type", "type is " + type)
        //onConfirmClick(Food(0,type!!,title,ateCalory!!.toInt(),meal.toString()))

        //  commonList.add(Food(0,type!!,title,ateCalory!!.toInt(),meal.toString()))
        val cat = when (meal) {
            BREAKFAST -> "breakfast"
            LAUNCH -> "launch"
            DINNER -> "dinner"
            MIANVADEH -> "mianvadeh"
            else -> throw NotImplementedError("meal type is wrong")
        }
//        tempList.add(Food(calories!!, type!!, title, ateCalory!!.toInt(), cat!!))
//        Log.d(
//            "extra_food",
//            "item added to common list in addFood dialog and list size now is : ${commonList.size}"
//        )
//        Log.d("testing", "Start Debugging")
//        for (item in commonList) {
//            Log.d("testing", item.name)
//        }
        Log.d("testing", "End Debugging")


        if (first_skip) {
            first_skip = true
//            prepareAd()
            prepareRewardAd()
        }


        onResult?.invoke(Food(calories!!, type!!, title, ateCalory!!.toInt(), cat))
        dismiss()
    }

    private fun getValues() {
        getMeal()
        getType()
        add_food_dialog_glass_text_view.setOnClickListener {
            type = TYPE_GLASS
            if (meal == null) {
                context.toast(res!!.getString(R.string.plz_specify_when))
                getMeal()
            } else if (ateCalory == null) {
                context.toast(res!!.getString(R.string.plz_enter_amount))
                getCalories()
            }
            setValuesByGlass()

        }
        add_food_dialog_gram_text_view.setOnClickListener {
            type = TYPE_GRAM
            if (meal == null) {
                context.toast(res!!.getString(R.string.plz_specify_when))
                getMeal()
            } else if (ateCalory == null) {
                context.toast(res!!.getString(R.string.plz_enter_amount))
                getCalories()
            }
            setValuesByGram()
        }
    }

    private fun onConfirmClicked() {
        add_food_confirm_button.setOnClickListener {
            //context.toast("confirm clicked")
            if (checkValues())
//               showInterstitial()
                showRewardedVideo()
        }
    }


    private fun checkValues(): Boolean {
        if (!checkCalories()) {
            context.toast(res!!.getString(R.string.plz_enter_amount))
            getCalories()
            return false
        } else if (!checkMeal()) {
            context.toast(res!!.getString(R.string.plz_specify_when))
            getMeal()
            return false
        } else if (!checkType()) {
            context.toast(res!!.getString(R.string.plz_select_unit))
            getType()
            return false
        } else return true

    }

    private fun checkType(): Boolean {
        if (type == null) {
            return false
        }
        return true
    }

    private fun checkMeal(): Boolean {
        if (meal == null) {
            return false
        }
        return true
    }

    private fun checkCalories(): Boolean {
        if (ateCalory == null) {
            return false
        }
        return true
    }


    private fun setBreakfastToNormal() {
        add_food_dialog_breakfast.setDrawableTop(R.drawable.ic_breakfast)
        add_food_dialog_breakfast.setTextColor(ContextCompat.getColor(context, R.color.grey))
        add_food_dialog_breakfast.setBackgroundResource(R.drawable.add_food_dialog_items_background)
    }

    private fun setDinnerToNormal() {
        add_food_dialog_dinner.setDrawableTop(R.drawable.ic_dinner)
        add_food_dialog_dinner.setTextColor(ContextCompat.getColor(context, R.color.grey))
        add_food_dialog_dinner.setBackgroundResource(R.drawable.add_food_dialog_items_background)
    }

    private fun setLaunchToNormal() {
        add_food_dialog_launch.setDrawableTop(R.drawable.ic_utensils_alt)
        add_food_dialog_launch.setTextColor(ContextCompat.getColor(context, R.color.grey))
        add_food_dialog_launch.setBackgroundResource(R.drawable.add_food_dialog_items_background)
    }

    private fun setMianVadeToNormal() {
        add_food_dialog_mianvade.setDrawableTop(R.drawable.ic_bread)
        add_food_dialog_mianvade.setTextColor(ContextCompat.getColor(context, R.color.grey))
        add_food_dialog_mianvade.setBackgroundResource(R.drawable.add_food_dialog_items_background)
    }


    private fun selectBreakfast() {
        add_food_dialog_breakfast.setDrawableTop(R.drawable.ic_breakfast_onclicked)
        add_food_dialog_breakfast.setTextColor(ContextCompat.getColor(context, R.color.white))
        add_food_dialog_breakfast.setBackgroundResource(R.drawable.add_food_confirm_background)
    }

    private fun selectDinner() {
        add_food_dialog_dinner.setDrawableTop(R.drawable.ic_dinner_onclick)
        add_food_dialog_dinner.setTextColor(ContextCompat.getColor(context, R.color.white))
        add_food_dialog_dinner.setBackgroundResource(R.drawable.add_food_confirm_background)
    }

    private fun selectLaunch() {
        add_food_dialog_launch.setDrawableTop(R.drawable.ic_utensils_alt_onclick)
        add_food_dialog_launch.setTextColor(ContextCompat.getColor(context, R.color.white))
        add_food_dialog_launch.setBackgroundResource(R.drawable.add_food_confirm_background)
    }

    private fun selectMianvade() {
        add_food_dialog_mianvade.setDrawableTop(R.drawable.ic_bread_onclick)
        add_food_dialog_mianvade.setTextColor(ContextCompat.getColor(context, R.color.white))
        add_food_dialog_mianvade.setBackgroundResource(R.drawable.add_food_confirm_background)
    }

    private fun genRandomNum(bound: Int): Int {
        if (bound < 100)
            return (50..100).random()
        else if ((bound in 100..200)) {
            return (100..200).random()
        } else if ((bound in 200..300)) {
            return (200..300).random()
        } else if ((bound in 300..400)) {
            return (300..400).random()
        } else {
            return (400..600).random()
        }
    }


    private fun showInterstitial() {
        if (first_skip) {
            confirmation()
            if (mInterstitialAd.isLoaded) {
                mInterstitialAd.show()
            } else {
                Toast.makeText(context, "Ad wasn't loaded.", Toast.LENGTH_SHORT).show()
                Log.d("Ad", "Ad wasn't loaded.")
            }
        } else {
            first_skip = true
            confirmation()
        }
    }

    //    private fun prepareAd() {
//        if (!mInterstitialAd.isLoading && !mInterstitialAd.isLoaded) {
//            val adRequest = AdRequest.Builder()
//                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
//                .build()
//            mInterstitialAd.loadAd(adRequest)
//        }
//
//    }
    private fun loadRewardedAd() {
        if (!(::mRewardedAd.isInitialized) || !mRewardedAd.isLoaded) {
            mIsLoading = true
            mRewardedAd = RewardedAd(context, AD_REWARD_UNIT_ID)
            mRewardedAd.loadAd(
                AdRequest.Builder().build(),
                object : RewardedAdLoadCallback() {
                    override fun onRewardedAdLoaded() {
                        mIsLoading = false
                        Toast.makeText(context, "onRewardedAdLoaded", Toast.LENGTH_LONG).show()

                    }

                    override fun onRewardedAdFailedToLoad(errorCode: Int) {
                        mIsLoading = false
                        Toast.makeText(
                            context,
                            "onRewardedAdFailedToLoad error code : $errorCode",
                            Toast.LENGTH_LONG
                        )
                            .show()
                    }

                }
            )
        }
    }

    private fun showRewardedVideo() {
        //show_video_button.visibility = View.INVISIBLE
        if (first_skip) {
            mCoinCount--
            confirmation()
            if (mRewardedAd.isLoaded) {
                mRewardedAd.show(
                    ownerActivity,
                    object : RewardedAdCallback() {
                        override fun onUserEarnedReward(
                            rewardItem: RewardItem
                        ) {
                            Toast.makeText(context, "onUserEarnedReward", Toast.LENGTH_LONG).show()
                            addCoins(rewardItem.amount)
                        }

                        override fun onRewardedAdClosed() {
                            Toast.makeText(context, "onRewardedAdClosed", Toast.LENGTH_LONG).show()
                            loadRewardedAd()
                        }

                        override fun onRewardedAdFailedToShow(errorCode: Int) {
                            Toast.makeText(context, "onRewardedAdFailedToShow", Toast.LENGTH_LONG)
                                .show()
                        }

                        override fun onRewardedAdOpened() {
                            Toast.makeText(context, "onRewardedAdOpened", Toast.LENGTH_LONG).show()
                        }
                    }
                )
            }
        } else {
            first_skip = true
            mCoinCount--
            confirmation()
        }
    }


    private fun addCoins(coins: Int) {
        mCoinCount += coins
        Toast.makeText(context, "you have $mCoinCount tries to add left", Toast.LENGTH_SHORT).show()
        //coin_count_text.text = "Coins: $mCoinCount"
    }


    private fun prepareRewardAd() {
        // Hide the retry button, load the ad, and start the timer.
//        retry_button.visibility = View.INVISIBLE
//        show_video_button.visibility = View.INVISIBLE
        if (!mRewardedAd.isLoaded && !mIsLoading) {
            loadRewardedAd()
        }
        //createTimer(COUNTER_TIME)
        mGamePaused = false
        mGameOver = false
    }


}

