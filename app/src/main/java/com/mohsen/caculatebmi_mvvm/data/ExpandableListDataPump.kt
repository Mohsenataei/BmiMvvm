package com.mohsen.caculatebmi_mvvm.data

import android.content.Context
import java.util.ArrayList
import java.util.HashMap

class ExpandableListDataPump  {
    private val context: Context? = null
//    private val database = AppDatabase.Companion.getDatabase(context)
//    private val foodDao: FoodDao? = null

//    fun ExpandableListDataPump(context: Context): ??? {
//        this.context = context
//    }

    //public HashMap<String, >
    fun getData(): HashMap<String, List<String>> {
        val expandableListDetail = HashMap<String, List<String>>()

        //val foods = ArrayList<Food>()
        //AppDatabase database = AppDatabase.Companion.getDatabase(context);


        val cricket = ArrayList<String>()
        cricket.add("سویا")
        cricket.add("آجیل مخلوط")
        cricket.add("آجیل مغز")
        cricket.add("آدامس")
        cricket.add("بادام درختی")
        cricket.add("بادام زمینی")
        cricket.add("بادام هندی")
        cricket.add("برگه زرد آلو")
        cricket.add("برگه هلو")
        cricket.add("پسته")
        cricket.add("ذرت بوداده")
        cricket.add("تخمه آفتاب گردان")
        cricket.add("پفک")
        cricket.add("چیپس")
        cricket.add("سنجد")

        val football = ArrayList<String>()
        football.add("باقالی پلو")
        football.add("لوبیا پلو")
        football.add("استانبولی پلو")
        football.add("آلبالو پلو")
        football.add("پلو کته با روغن")
        football.add("ته چین گوشت")
        football.add("ته چین مرغ")
        football.add("ته دیگ برنج")
        football.add("ته سیب زمینی")
        football.add("دمپخت گوجه")
        football.add("رشته پلو")
        football.add("عدس پلو")
        football.add("سبزی پلو")
        football.add("کلم پلو")

        val basketball = ArrayList<String>()
        basketball.add("آدامس")
        basketball.add("ارده")
        basketball.add("باقلوا")
        basketball.add("بامیه (شیرینی)")
        basketball.add("براونی")
        basketball.add("ساقه طلایی")
        basketball.add("ساقه طلایی شکلاتی")
        basketball.add("پای سیب")
        basketball.add("پشمک")
        basketball.add("پن کیک")
        basketball.add("پولکی")
        basketball.add("پیراشکی شیرین")
        basketball.add("تیرامیسو")
        basketball.add("حلوا ارده")
        basketball.add("خمیر کنجد")
        basketball.add("دونات")
        basketball.add("زولبیا")


        val khoresht = ArrayList<String>()
        khoresht.add("باقلا قاتوق")
        khoresht.add("تاس کباب")
        khoresht.add("ترشی تره")
        khoresht.add("خورش تره")
        khoresht.add("خورش لوبیا سبز")
        khoresht.add("خورش آلو")
        khoresht.add("خورش آلو")

        expandableListDetail["تنقلات" + "  (" + cricket.size + ")"] = cricket
        expandableListDetail["پلو ها"] = football
        expandableListDetail["شیرینی"] = basketball
        expandableListDetail["خورشت" + "  (" + khoresht.size + ")"] = khoresht
        expandableListDetail["سبزیجات"] = basketball
        expandableListDetail["میوه ها"] = basketball
        expandableListDetail["نوشیدنی"] = basketball
        expandableListDetail["متفرقه"] = basketball
        expandableListDetail["حبوبات و غلات"] = basketball
        expandableListDetail["گوشت و لبنیات"] = basketball
        expandableListDetail["سالاد"] = basketball
        expandableListDetail["فست فود"] = basketball
        expandableListDetail["غذای رژیمی"] = basketball


        return expandableListDetail
    }
}