package com.mohsen.caculatebmi_mvvm.data

import android.content.Context
import java.util.HashMap

class ExercisesExpandableListDataPump {
    private var context: Context? = null

    fun getData(): HashMap<String, List<String>> {
        val expandableListDetail = HashMap<String, List<String>>()

        val walking = ArrayList<String>()
        val running = ArrayList<String>()
        val bicycle = ArrayList<String>()
        val teamSport = ArrayList<String>()
        val solo = ArrayList<String>()
        val swimming = ArrayList<String>()
        val others = ArrayList<String>()



        walking.add("بالارفتن از پله ها با سرعت بالا")
        walking.add("بالارفتن از پله ها با سرعت پایین")
        walking.add("تپه نوردی با بار ۵ تا ۱۰ کیلو")
        walking.add("تپه نوردی با بار تا ۴ کیلو")
        walking.add("تپه نوردی بدون بار")
        walking.add("راه رفتن آهسته (کمتر از ۳ کیلو متر در ساعت)")
        walking.add("راه رفتن آهسته در آب")

        walking.add("راه رفتن با سرعت متوسط در آب")
        walking.add("راه رفتن روی سطح صاف ( ۳ کیلو متر در ساعت)")
        walking.add("راه رفتن تند روی سطح صاف ( ۵/۵ کیلو متر در ساعت)")
        walking.add("راه رفتن خیلی سریع روی سطح صاف ( ۷ کیلو متر در ساعت)")
        walking.add("راه رفتن روی چمن")
        walking.add("راه رفتن روی شن")
        walking.add("بالارفتن از پله ها با سرعت بالا")
        walking.add("بالارفتن از پله ها با سرعت بالا")
        walking.add("بالارفتن از پله ها با سرعت بالا")
        walking.add("بالارفتن از پله ها با سرعت بالا")
        walking.add("بالارفتن از پله ها با سرعت بالا")
        walking.add("بالارفتن از پله ها با سرعت بالا")
        walking.add("بالارفتن از پله ها با سرعت بالا")
        walking.add("بالارفتن از پله ها با سرعت بالا")

        //init running

        running.add("دویدن آرام (۶٫۵ کیلومتر بر ساعت)")
        running.add("دویدن خیلی سریع (۱۴٫۵ کیلومتر بر ساعت)")
        running.add("دویدن خیلی سریع (۱۶ کیلومتر بر ساعت)")
        running.add("دویدن سریع (۱۲ کیلومتر بر ساعت)")
        running.add("دویدن سریع (۱۳ کیلومتر بر ساعت)")
        running.add("دویدن سریع (۱۴ کیلومتر بر ساعت)")
        running.add("دویدن سریع (۷ کیلومتر بر ساعت)")
        running.add("دویدن ماراتن")
        running.add("دویدن ۸ کیلومتر بر ساعت")
        running.add("دویدن ۱۰ کیلومتر بر ساعت")

        //init bicycle
        bicycle.add("آر پی ام")
        bicycle.add("اسپینینگ")
        bicycle.add("دوچرخه ثابت آهسته‌(۵۰−۳۵ وات)")
        bicycle.add("دوچرخه ثابت خیلی خیلی سریع (۲۰۱−۲۷۰ وات)")
        bicycle.add("دوچرخه ثابت خیلی سریع (۱۶۱−۲۰۰ وات)")
        bicycle.add("دوچرخه ثابت سریع (۱۰۱−۱۶۰ وات)")
        bicycle.add("دوچرخه ثابت معمولی (۵۱−۸۹ وات)")
        bicycle.add("دوچرخه ثابت معمولی (۹۰−۱۰۰ وات)")
        bicycle.add("دوچرخه سواری تفریحی")
        bicycle.add("دوچرخه سواری خیلی آهسته")
        bicycle.add("دوچرخه سواری خیلی سریع (۲۴ تا ۳۰ کیلومتر بر ساعت)")
        bicycle.add("دوچرخه سواری در کوهستان")
        bicycle.add("دوچرخه سواری سریع (سرعت ۲۳−۲۵۰۵ کیلومتر بر ساعت)")
        bicycle.add("دوچرخه سواری مسابقاتی(سرعت بالاتر از ۳۲ کیلومتر بر ساعت)")

        // init teamSport
        teamSport.add("بستکتبال (غیر حرفه ای)")
        teamSport.add("فوتبال (غیر حرفه ای)")
        teamSport.add("والیبال (غیر حرفه ای)")
        teamSport.add("راگبی")
        teamSport.add("فوتبال حرفه ای")
        teamSport.add("هندبال")

        //init solo

        solo.add("اسکواش")
        solo.add("اسکی")
        solo.add("اسکیت")
        solo.add("بادی اتک")
        solo.add("بادی پامپ")
        solo.add("بادی کامبت")
        solo.add("بدمینتون")
        solo.add("بدنسازی")
        solo.add("پینگ پونگ")
        solo.add("تای بو")
        solo.add("تای چی")
        solo.add("تنیس")
        solo.add("تی آر ایکس")
        solo.add("جوجیتسو")
        solo.add(" جوجیتسو")
        solo.add(" جودو")
        solo.add(" دراز و نشست(۲۰ عدد در دقیقه)")
        solo.add("رقص ایرانی")
        solo.add("رقص باله")
        solo.add("رقص تانگو")
        solo.add("رقص دیسکو")
        solo.add("رقص سالسا")
        solo.add("رقص عربی")
        solo.add("ژیمناستیک")
        solo.add("صخره نوردی")
        solo.add("طناب زدن")
        solo.add("کاراته")
        solo.add("کشتی")
        solo.add("کیک بوکس")
        solo.add("گلف")
        solo.add("موآی تای")
        solo.add("وزنه برداری")
        solo.add("یوگا")

        // init swimming

        swimming.add("ایروبیک در آب")
        swimming.add("شنا آهسته")
        swimming.add("شنا پروانه")
        swimming.add("شنا سریع")
        swimming.add("شنا قورباغه")
        swimming.add("شنا کرال پشت")
        swimming.add("شنا کرال سینه")
        swimming.add("غواصی")
        swimming.add("واترپلو")

        // init others :

        others.add("آلپاین")
        others.add("اسب سواری")
        others.add("اسکی")
        others.add("اسکی روی یخ")
        others.add("اسکی فضایی")
        others.add("اسکیت روی یخ")
        others.add("اسنو برد")
        others.add("الیپتیکال")
        others.add("ایروبیک")
        others.add("ایروبیک با استپ بلند")
        others.add("ایروبیک با استپ کوتاه")
        others.add("باغبانی")
        others.add("بوت کمپ")
        others.add("بولینگ")
        others.add("بیلیارد")
        others.add("پیلانس")

        expandableListDetail["پیاده روی"] = walking
        expandableListDetail["دویدن"] = running
        expandableListDetail["دوچرخه سواری"] = bicycle
        expandableListDetail["تیمی"] = teamSport
        expandableListDetail["انفرادی"] = solo
        expandableListDetail["شنا"] = swimming
        expandableListDetail["سایر"] = others

        return expandableListDetail
    }
    }