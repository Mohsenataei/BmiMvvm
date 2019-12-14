package com.avalinejad.sport.data
import com.avalinejad.sport.App
import com.avalinejad.sport.R
import java.util.HashMap
class CaloriesPerGram {
    private val res = App.instance.resources
    fun getData() : HashMap<String, HashMap<String, Int>> {
        val data = HashMap<String, HashMap<String, Int>>()
        val perGramCalories = HashMap<String, Int>()
        val perUnitCalories = HashMap<String, Int>()
        val perGlassCalories = HashMap<String, Int>()



        perGramCalories[res.getString(R.string.gam)] = 100
        perGramCalories[res.getString(R.string.wheat_flour)] = 360
        perGramCalories[res.getString(R.string.cornmeal)] = 370
        perGramCalories[res.getString(R.string.high_fat_soy_flour)] = 420
        perGramCalories[res.getString(R.string.low_fat_soy_flour)] = 460
        perGramCalories[res.getString(R.string.sour_cherry)] = 180
        perGramCalories[res.getString(R.string.armenian_plum)] = 75
        perGramCalories[res.getString(R.string.pineapple)] = 45
        perGramCalories[res.getString(R.string.mango)] = 60
        perGramCalories[res.getString(R.string.steak)] = 200
        //perGramCalories[res.getString(R.string.high_fat_steak)] = 400
        perGramCalories[res.getString(R.string.Pomegranate)] = 60
        perGramCalories[res.getString(R.string.fig_fresh)] = 60
        perGramCalories[res.getString(R.string.fig_dried)] = 270
        perGramCalories[res.getString(R.string.grape)] = 80
        perGramCalories[res.getString(R.string.mixed_nuts)] = 80
        perGramCalories[res.getString(R.string.almond)] = 660
        perGramCalories[res.getString(R.string.almond_crop)] = 30
        perGramCalories[res.getString(R.string.peanut)] = 560
        //perGramCalories[res.getString(R.string.eggplant)] = 17
        perGramCalories[res.getString(R.string.icecream)] = 190
        perGramCalories[res.getString(R.string.biscuit_with_cream)] = 500
        perGramCalories[res.getString(R.string.raw_rice)] = 360
        perGramCalories[res.getString(R.string.brown_cooked_rice)] = 120
        perGramCalories[res.getString(R.string.Baklava)] = 540
        perGramCalories[res.getString(R.string.dried_broad_bean)] = 360
        perGramCalories[res.getString(R.string.broad_bean)] = 103
        perGramCalories[res.getString(R.string.Okra)] = 40
        perGramCalories[res.getString(R.string.quince)] = 30
        perGramCalories[res.getString(R.string.Common_beet_leaf)] = 30
        perGramCalories[res.getString(R.string.grapes_leaf)] = 60
        perGramCalories[res.getString(R.string.orange)] = 35
       // perGramCalories[res.getString(R.string.pistachio_with_skin)] = 340
//        perGramCalories[res.getString(R.string.cheese)] = 210
        perGramCalories[res.getString(R.string.pizza_cheese)] = 450
        perGramCalories[res.getString(R.string.cream_cheese)] = 380
        perGramCalories[res.getString(R.string.onion)] = 38
        perGramCalories[res.getString(R.string.cheese_puffs)] = 100
        perGramCalories[res.getString(R.string.garden_radish)] = 30
        //perGramCalories[res.getString(R.string.tarragon)] = 45
        //perGramCalories[res.getString(R.string.sunflower_seed)] = 580
        perGramCalories[res.getString(R.string.pumpkin_seeds)] = 600
        perGramCalories[res.getString(R.string.watermelo_seeds)] = 590
        perGramCalories[res.getString(R.string.japanese_seeds)] = 570
        perGramCalories[res.getString(R.string.dried_mulberry)] = 570
        perGramCalories[res.getString(R.string.dried_mulberry)] = 25
        perGramCalories[res.getString(R.string.Tamarind)] = 240
        perGramCalories[res.getString(R.string.black_mulberry)] = 80
       //perGramCalories[res.getString(R.string.)] = 80
        perGramCalories[res.getString(R.string.tuna_fish)] = 315
        perGramCalories[res.getString(R.string.halva)] = 400
        perGramCalories[res.getString(R.string.parsley)] = 25
        perGramCalories[res.getString(R.string.parsley)] = 25
        perGramCalories[res.getString(R.string.Wheatgrass)] = 50
        perGramCalories[res.getString(R.string.Liver)] = 160
        perGramCalories[res.getString(R.string.Oat)] = 360
        perGramCalories[res.getString(R.string.potato_chip)] = 500
        perGramCalories[res.getString(R.string.Caviar)] = 300
        perGramCalories[res.getString(R.string.cream)] = 350
        perGramCalories[res.getString(R.string.cucumber)] = 15
        perGramCalories[res.getString(R.string.pickled_cucumber)] = 12
        perGramCalories[res.getString(R.string.persian_melon)] = 23
        perGramCalories[res.getString(R.string.date_palm)] = 310
        perGramCalories[res.getString(R.string.sheep_heart)] = 260
        perGramCalories[res.getString(R.string.popcorn)] = 357
        perGramCalories[res.getString(R.string.basil)] = 40
        perGramCalories[res.getString(R.string.Rhubarb)] = 15
        perGramCalories[res.getString(R.string.Hawthorn)] = 70
        perGramCalories[res.getString(R.string.sheep_Tongue)] = 260
        perGramCalories[res.getString(R.string.Apricot)] = 270
        perGramCalories[res.getString(R.string.Barberry)] = 50
        perGramCalories[res.getString(R.string.Gizzard)] = 140
        perGramCalories[res.getString(R.string.green_Olive)] = 140
        perGramCalories[res.getString(R.string.black_Olive)] = 200
        perGramCalories[res.getString(R.string.Gelatin)] = 60
        perGramCalories[res.getString(R.string.shirazi_alad)] = 60
        perGramCalories[res.getString(R.string.shirazi_alad)] = 130
        perGramCalories[res.getString(R.string.suger)] = 400
        perGramCalories[res.getString(R.string.white_chocolate)] = 400
        perGramCalories[res.getString(R.string.honeydew)] = 23
        perGramCalories[res.getString(R.string.Lentil)] = 340
        perGramCalories[res.getString(R.string.turnip)] = 25
        perGramCalories[res.getString(R.string.danish_pastry)] = 420
        perGramCalories[res.getString(R.string.cream_cookie)] = 500
        perGramCalories[res.getString(R.string.infant_formula)] = 500
        perGramCalories[res.getString(R.string.fenugreek)] = 30
        perGramCalories[res.getString(R.string.Tripe)] = 130
        perGramCalories[res.getString(R.string.garden_cress)] = 25
        perGramCalories[res.getString(R.string.bell_pepper)] = 22
        perGramCalories[res.getString(R.string.Sausage)] = 300
        perGramCalories[res.getString(R.string.Sausage)] = 100
        perGramCalories[res.getString(R.string.raw_mushroom)] = 27
        perGramCalories[res.getString(R.string.grape)] = 30
        perGramCalories[res.getString(R.string.sheep_kidney)] = 105
        perGramCalories[res.getString(R.string.sugar_cube)] = 400
        perGramCalories[res.getString(R.string.sugar_cube)] = 630
        perGramCalories[res.getString(R.string.honey)] = 300
        perGramCalories[res.getString(R.string.tomato)] = 300
        perGramCalories[res.getString(R.string.apple)] = 55
        perGramCalories[res.getString(R.string.Crème_caramel)] = 400
        perGramCalories[res.getString(R.string.mixed_meat)] = 160
        perGramCalories[res.getString(R.string.jujube)] = 100
        perGramCalories[res.getString(R.string.Crème_caramel)] = 400
        perGramCalories[res.getString(R.string.Lettuce)] = 17
        perGramCalories[res.getString(R.string.celery)] = 13
        perGramCalories[res.getString(R.string.raisin)] = 60
        perGramCalories[res.getString(R.string.lunch_meat)] = 300
        perGramCalories[res.getString(R.string.Kashk)] = 380
        perGramCalories[res.getString(R.string.Pear)] = 57
        perGramCalories[res.getString(R.string.gaz)] = 500
        perGramCalories[res.getString(R.string.common_beet)] = 44
        perGramCalories[res.getString(R.string.red_bean)] = 340
        perGramCalories[res.getString(R.string.reine_vlaude_verte)] = 33
        perGramCalories[res.getString(R.string.burger_without_bread)] = 200
        perGramCalories[res.getString(R.string.high_fat_sheep_meat)] = 320
        perGramCalories[res.getString(R.string.low_fat_sheep_meat)] = 280
        perGramCalories[res.getString(R.string.Calf_meat)] = 200
        perGramCalories[res.getString(R.string.chicken_meat)] = 200
        perGramCalories[res.getString(R.string.fish)] = 100
        perGramCalories[res.getString(R.string.tomato)] = 15
        perGramCalories[res.getString(R.string.Wheat)] = 360
        perGramCalories[res.getString(R.string.grapefruit)] = 30
        perGramCalories[res.getString(R.string.Pear)] = 57
        perGramCalories[res.getString(R.string.walnut)] = 625
        perGramCalories[res.getString(R.string.Cauliflower)] = 10
        perGramCalories[res.getString(R.string.corn_flakes)] = 380
        perGramCalories[res.getString(R.string.Khash_ear)] = 350
        perGramCalories[res.getString(R.string.Khash_toungue)] = 350
        perGramCalories[res.getString(R.string.Khash_brain)] = 450
        perGramCalories[res.getString(R.string.simple_cake)] = 240
        perGramCalories[res.getString(R.string.raisin_cake)] = 240
        perGramCalories[res.getString(R.string.yazd_cake)] = 210
        perGramCalories[res.getString(R.string.carrot_cake)] = 180
        perGramCalories[res.getString(R.string.Walnut_cake)] = 260
        perGramCalories[res.getString(R.string.chocolate_cake)] = 280
        perGramCalories[res.getString(R.string.red_velvet_cake)] = 250
        perGramCalories[res.getString(R.string.sesame)] = 500
        perGramCalories[res.getString(R.string.Yogurt5)] = 70
        perGramCalories[res.getString(R.string.Yogurt7)] = 85
        perGramCalories[res.getString(R.string.iceland_Yogurt)] = 60
        perGramCalories[res.getString(R.string.low_fat_Yogurt)] = 50
        perGramCalories[res.getString(R.string.boorani_yogurt)] = 55
        perGramCalories[res.getString(R.string.greek_yogurt)] = 80
        perGramCalories[res.getString(R.string.soy_yogurt)] = 115
        perGramCalories[res.getString(R.string.allium_stipitatum_yogurt)] = 105
        perGramCalories[res.getString(R.string.fruit_yogurt)] = 65
        perGramCalories[res.getString(R.string.eggplant_yogurt)] = 78
        perGramCalories[res.getString(R.string.cucumber_yogurt)] = 60
        perGramCalories[res.getString(R.string.greece_sheep_yogurt)] = 60
        perGramCalories[res.getString(R.string.greece_cow_yogurt)] = 74
        perGramCalories[res.getString(R.string.sweet_lemon)] = 25
        perGramCalories[res.getString(R.string.split_pea)] = 359
        perGramCalories[res.getString(R.string.boiled_Macaroni)] = 330
        perGramCalories[res.getString(R.string.macaroni_with_soy)] = 380
        perGramCalories[res.getString(R.string.raw_macaroni)] = 280

        perGramCalories[res.getString(R.string.barbari)] = 272
        perGramCalories[res.getString(R.string.Pita)] = 275
        perGramCalories[res.getString(R.string.Taftan)] = 279
        perGramCalories[res.getString(R.string.jam)] = 300


        perGramCalories.put("مربا",300)
        perGramCalories.put("نارگیل تازه",156)
        perGramCalories.put("نارگیل ( مغز )",345)
        perGramCalories.put("نارنج",20)
        perGramCalories.put("نارنگی",34)
        perGramCalories.put("ماکارونی",150)
        perGramCalories.put("مارچوبه",20)
        perGramCalories.put("مغز گردو",650)
        perGramCalories.put("مایونز",720)
        perGramCalories.put("ماست کیسه ای",155)
        perGramCalories.put("لیمو شیرین",40)
        perGramCalories.put("لیمو ترش ( آب لیمو )",26)
        perGramCalories.put("لیمو ترش",30)
        perGramCalories.put("لپه پخته 115",500)
        perGramCalories.put("لوبیا قرمز پخته",110)
        perGramCalories.put("لوبیا چشم بلبلی خام",130)
        perGramCalories.put("لوبیا چشم بلبلی پخته",80)
        perGramCalories.put("لوبیا سفید",340)
        perGramCalories.put("کیکی اسفنجی",300)
        perGramCalories.put("کیک شکلاتی",400)
        perGramCalories.put("کلم پیچ خام",20)
        perGramCalories.put("کلم قرمز",28)
        perGramCalories.put("کلم پیشخوان",22)
        perGramCalories.put("کلم فندقی",24)
        perGramCalories.put("کره حیوانی",750)
        perGramCalories.put("کدو حلوایی",35)
        perGramCalories.put("کدو خورشتی",28)
        perGramCalories.put("کاکائو ( پودر )",220)
        
        // karafs refrence

        perGramCalories.put("آجیل سویا",471)
        perGramCalories.put("آجیل مخلوط",594)
        perGramCalories.put("آجیل مغز",600)
        perGramCalories.put("آدامس",150)
        perGramCalories.put("اوتمیل",68)
        perGramCalories.put("بادام درختی",576)
        perGramCalories.put("بادام زمینی",585)
        perGramCalories.put("بادام هندی",553)
        perGramCalories.put("برگه زرد آلو",240)
        perGramCalories.put("برگه هلو",240)
        perGramCalories.put("بیسکوییت ویفر",534)
        perGramCalories.put("پاپ کورن",390)
        perGramCalories.put("پسته",560)
        perGramCalories.put("پودر نارگیل",500)
        perGramCalories.put("تخمه آفتابگردان",582)
        perGramCalories.put("پفک",500)
        perGramCalories.put("چیپس",500)
        perGramCalories.put("چیپس و پنیر",380)
        perGramCalories.put("سنجد",130)
        perGramCalories.put("ذرت مکزیکی با پنیر",300)
        perGramCalories.put("ذرت مکزیکی بدون پنیر",150)
        perGramCalories.put("تخمه ژاپنی",560)
        perGramCalories.put("تخمه کدو",574)
        perGramCalories.put("تخمه هندوانه",560)
//        perGramCalories.put("بادام زمینی بدون پوست")
        perGramCalories.put("سمبوسه سیب زمینی",150)
        perGramCalories.put("سمبوسه گوشت",140)
        perGramCalories.put("سمنو",100)
        perGramCalories.put("سنجد",130)
        perGramCalories.put("شاهدانه",553)
        perGramCalories.put("شربت افرا",261)
        perGramCalories.put("شکلات سفید",539)
        perGramCalories.put("شکلات شیری",535)
        perGramCalories.put("عناب",80)
        perGramCalories.put("فندق",628)
        perGramCalories.put("قیصی",320)
        perGramCalories.put("کشک خشک",98)
        perGramCalories.put("کشک مایع",49)
        perGramCalories.put("کشمش",300)
        perGramCalories.put("کنجد",570)
        perGramCalories.put("کوکی کشمشی",435)
        perGramCalories.put("گردو",654)
        perGramCalories.put("لواشک",180)
        perGramCalories.put("مویز",283)
        perGramCalories.put("نارگیل خشک",660)

        perGramCalories.put("آلبالو پلو",155)
        perGramCalories.put("استانبولی پلو",137)
        perGramCalories.put("برنج سفید پخته",155)
        perGramCalories.put("برنج قهوه ای پخته",130)
        perGramCalories.put("برنج قهوه ای",112)
        perGramCalories.put("پلو ساده با روغن",170)
        perGramCalories.put("پلو ساده بدون روغن",130)
        perGramCalories.put("کته با روغن",137)
        perGramCalories.put("کته بدون روغن",97)
        perGramCalories.put("ته چین بادمجان",137)
        perGramCalories.put("ته چین گوشت",145)
        perGramCalories.put("ته چین مرغ",137)
        perGramCalories.put("ته دیگ برنج",300)
        perGramCalories.put("ته دیگ سیب زمینی",350)
        perGramCalories.put("ته دیگ نان",500)
        perGramCalories.put("دمپخت گوجه",120)
        perGramCalories.put("دمپختک",155)
        perGramCalories.put("رشته پلو",155)
        perGramCalories.put("زرشک پلو",137)
        perGramCalories.put("سبزی پلو",137)
        perGramCalories.put("سیرین پلو",155)
        perGramCalories.put("عدس پلو",137)
        perGramCalories.put("کلم پلو",137)
        perGramCalories.put("کوفته شوید باقالی",150)
        perGramCalories.put("باقالی پلو",155)
        perGramCalories.put("لوبیا پلو",137)
        perGramCalories.put("ماش پلو",130)
        perGramCalories.put("مرصع پلو",155)
        perGramCalories.put("میگو پلو",137)
        perGramCalories.put("نخود پلو",130)
        perGramCalories.put("هویج پلو",130)

        perGramCalories.put("باقلا قاتوق",140)
        perGramCalories.put("تاس کباب",150)
        perGramCalories.put("ترشی تره",135)
        perGramCalories.put("خورشت تره",140)
        perGramCalories.put("خورشت لوبیا سبز",180)
        perGramCalories.put("خورشت آلو",140)
        perGramCalories.put("خورشت آلو اسفناج",140)
        perGramCalories.put("خورشت بادمجان",125)
        perGramCalories.put("خورشت بامیه",140)
        perGramCalories.put("خورشت به",150)
        perGramCalories.put("خورشت خلال بادام",120)
        perGramCalories.put("خورشت سیب",150)
        perGramCalories.put("خورشت فسنجان",180)
        perGramCalories.put("خورشت قورمه سبزی",140)
        perGramCalories.put("خورشت قیمه بادمجان",150)
        perGramCalories.put("خورشت قیمه سیب زمینی",150)
        perGramCalories.put("خورشت کدو",140)
        perGramCalories.put("خورشت کرفس",140)
        perGramCalories.put("خورشت کنگر",140)
        perGramCalories.put("خورشت نخود سبز",140)
        perGramCalories.put("خورشت هویج",100)
        perGramCalories.put("قلیه ماهی",135)
        perGramCalories.put("قلیه میگو",145)
        perGramCalories.put("مرغ ترش",135)
        perGramCalories.put("واویشکا",300)


        perGramCalories[res.getString(R.string.caesar_alad)] = 170
        perGramCalories[res.getString(R.string.chicken_caesar_alad)] = 185
        perGramCalories[res.getString(R.string.potato_alad)] = 155
        perGramCalories[res.getString(R.string.shirazi_alad)] = 14
        perGramCalories[res.getString(R.string.salad_with_Sauce)] = 80
        perGramCalories[res.getString(R.string.salad_without_Sauce)] = 17
        perGramCalories[res.getString(R.string.pasta_salad)] = 221
        perGramCalories[res.getString(R.string.greed_salad)] = 101
        perGramCalories.put("سالاد سزار",170)
        perGramCalories.put("سالاد سزار با مرغ",185)
        perGramCalories.put("سالاد سیب زمینی",155)
        perGramCalories.put("سالاد شیرازی",14)
        perGramCalories.put("سالاد فصل با سس",80)
        perGramCalories.put("سالاد فصل بدون سس",17)
        perGramCalories.put("سالاد ماکارونی",221)
        perGramCalories.put("سالاد یونانی",101)

        perGramCalories.put("اسنک ژامبون و پنیر",200)
        perGramCalories.put("بوریتو گوشت کوچک",300)
        perGramCalories.put("بوریتو گوشت معمولی",300)
        perGramCalories.put("بوریتو مرغ کوچک",200)
        perGramCalories.put("بوریتو مرغ معمولی",200)
        perGramCalories.put("پیاز حلقه ای",330)
        perGramCalories.put("پیتزا استیک",257)
        perGramCalories.put("پیتزا پپرونی",284)
        perGramCalories.put("پنیر پیتزا",264)
        perGramCalories.put("پیتزا سبزیجات کوچک",250)
        perGramCalories.put("پیتزا سبزیجات متوسط",250)
        perGramCalories.put("پیتزا کوچک",250)
        perGramCalories.put("پیتزا گوشت و قارچ",276)
        perGramCalories.put("پیتزا متوسط (تک نفره)",300)
        perGramCalories.put("پیتزا مرغ و قارچ",255)
        perGramCalories.put("تاکو مرغ",180)
        perGramCalories.put("تاکو گوشت",280)
        perGramCalories.put("توستادا گوشت",280)
        perGramCalories.put("توستادا مرغ",180)
        perGramCalories.put("چیز برگر بزرگ",350)
        perGramCalories.put("چیز برگر کوچک",350)
        perGramCalories.put("چیز برگر متوسط",350)
        perGramCalories.put("ساندویج رست بیف",250)
        perGramCalories.put("ساندویج ژامبون",151)
        perGramCalories.put("ساندویج کلاب",220)
        perGramCalories.put("ساندویج هات داگ",200)
        perGramCalories.put("ساندویج همبرگر بزرگ",300)
        perGramCalories.put("ساندویج همبرگر کوچک",300)
        perGramCalories.put("ساندویج همبرگر متوسط",300)
        perGramCalories.put("سیب زمینی سرخ کرده",320)
        perGramCalories.put("فاهیتا گوشت",170)
        perGramCalories.put("فاهیتا مرغ",160)
        perGramCalories.put("فلافل",230)
        perGramCalories.put("لازانیا",300)
        perGramCalories.put("همبرگر ذغالی",222)

        perGramCalories.put("باقالا",100)
        perGramCalories.put("بامیه",40)
        perGramCalories.put("برگ چغندر",19)
        perGramCalories.put("برگ مو",70)
        perGramCalories.put("پیاز",40)
        perGramCalories.put("پیاز کوهی",30)
        perGramCalories.put("پیازچه",23)
        perGramCalories.put("تربچه",12)
        perGramCalories.put("ترخون خشک",295)
        perGramCalories.put("تره",20)
        perGramCalories.put("تره فرنگی",61)
        perGramCalories.put("جعفری",25)
        perGramCalories.put("خوراک لوبیا سبز",31)
        perGramCalories.put("خیار شور",5)
        perGramCalories.put("ذرت بلال",80)
        perGramCalories.put("ذرت (کنسرو)",95)
        perGramCalories.put("رازیانه",337)
        perGramCalories.put("رزماری تازه",131)
        perGramCalories.put("ریحان",25)
        perGramCalories.put("زنجبیل تازه",80)
        perGramCalories.put("زیتون سبز",150)
        perGramCalories.put("زیتون سیاه",200)
        perGramCalories.put("سبزی آش تازه",40)
        perGramCalories.put("سبزی پلویی تازه",40)
        perGramCalories.put("سبزی خوردن",30)
        perGramCalories.put("سبزی دلمه تازه",40)
        perGramCalories.put("سبزی قرمه تازه",40)
        perGramCalories.put("سبزی کوکو تازه",40)
        perGramCalories.put("سبزیجات بخار پز",71)
        perGramCalories.put("سبزیجات گریل",50)
        perGramCalories.put("سیب زمینی",75)
        perGramCalories.put("سیب زمینی آب پز",87)
        perGramCalories.put("سیب زمینی پخته در فر",93)
        perGramCalories.put("سیب زمینی پخته در مایکروفر",105)
        perGramCalories.put("سیب زمینی شیرین",86)
        perGramCalories.put("سیر",40)
        perGramCalories.put("شاهی",20)
        perGramCalories.put("شلغم",28)
        perGramCalories.put("شنبلیله",23)
        perGramCalories.put("شوید تازه",43)
        perGramCalories.put("شوید خشک",305)
        perGramCalories.put("فلفل دلمه کبابی",33)
        perGramCalories.put("فلفل دلمه ای",20)
        perGramCalories.put("فلفل سبز تند",40)
        perGramCalories.put("قارچ پخته",28)
        perGramCalories.put("قارچ خام",22)
        perGramCalories.put("قارچ سوخاری",60)
        perGramCalories.put("کاپری",23)
        perGramCalories.put("کاسنی",23)
        perGramCalories.put("کاهو",20)
        perGramCalories.put("کدو حلوایی",35)
        perGramCalories.put("کدو گریل",41)
        perGramCalories.put("کرفس",15)
        perGramCalories.put("کلم بروکسل",25)
        perGramCalories.put("کلم بروکلی",25)
        perGramCalories.put("کلم پیچ",25)
        perGramCalories.put("کلم چینی خام",12)
        perGramCalories.put("کلم سفید",25)
        perGramCalories.put("کلم قرمز",25)
        perGramCalories.put("کیل",50)
        perGramCalories.put("گشنیز",23)
        perGramCalories.put("گل کلم",25)
        perGramCalories.put("گوجه فرنگی",20)
        perGramCalories.put("گوجه فرنگی خشک شده",258)
        perGramCalories.put("لبو",40)
        perGramCalories.put("لوبیا سبز",30)
        perGramCalories.put("مارچوبه",20)
        perGramCalories.put("مرزه",272)
        perGramCalories.put("موسیر",72)
        perGramCalories.put("نخود سبز",50)
        perGramCalories.put("نعنا خشک",200)
        perGramCalories.put("نعناع",40)
        perGramCalories.put("هویج",35)

        perGramCalories.put("آرد برنج",366)
        perGramCalories.put("آرد برنج سفید",366)
        perGramCalories.put("آرد جو",360)
        perGramCalories.put("آرد جو دو سر",400)
        perGramCalories.put("آرد ذرت",381)
        perGramCalories.put("آرد سویا پر چرب",447)
        perGramCalories.put("آرد سویا کم چرب",352)
        perGramCalories.put("آرد گندم",360)
        perGramCalories.put("آرد گندم قهوه ای",323)
        perGramCalories.put("باقلا خشک",350)
        perGramCalories.put("برنج خام",380)
        perGramCalories.put("بلغور جو",331)
        perGramCalories.put("بلغور گندم",342)
        perGramCalories.put("بلغور گندم پخته",83)
        perGramCalories.put("جو",350)
        perGramCalories.put("جو پرک",360)
        perGramCalories.put("جو دو سر",355)
        perGramCalories.put("جوانه گندم",50)
        perGramCalories.put("جوانه ماش",45)
        perGramCalories.put("خوراک عدس",75)
        perGramCalories.put("خوراک لوبیا",80)
        perGramCalories.put("خوراک نخود",85)
        perGramCalories.put("دال عدس",90)
        perGramCalories.put("سبوس برنج خام",360)
        perGramCalories.put("سبوس جو دو سر پخته",80)
        perGramCalories.put("سبوس جو دو سر خام",246)
        perGramCalories.put("سبوس گندم",206)
        perGramCalories.put("سرلاک",380)
        perGramCalories.put("سویا",380)
        perGramCalories.put("سویا لوبیا",445)
        perGramCalories.put("عدس",340)
        perGramCalories.put("عدس پخته",116)
        perGramCalories.put("عدس خام",353)
        perGramCalories.put("عدسی",108)
        perGramCalories.put("کینوآ پخته",120)
        perGramCalories.put("کینوآ خام",368)
        perGramCalories.put("گندم",350)
        perGramCalories.put("گندم سیاه",343)
        perGramCalories.put("لپه",360)
        perGramCalories.put("لوبیا چشم بلبلی",130)
        perGramCalories.put("لوبیا چشم بلبلی خفته",116)
        perGramCalories.put("لوبیا چیتی",340)
        perGramCalories.put("لوبیا چیتی پخته",100)
        perGramCalories.put("لوبیا قرمز",300)
        perGramCalories.put("لوبیا قرمز پخته",110)
        perGramCalories.put("ماکارونی آب پز",158)
        perGramCalories.put("ماکارونی با سویا",150)
        perGramCalories.put("ماکارونی خام",350)
        perGramCalories[res.getString(R.string.raw_macaroni_with_bran)] = 348
        perGramCalories[res.getString(R.string.cooked_macaroni_with_bran)] = 124
        perGramCalories[res.getString(R.string.oat_bread)] = 244
        perGramCalories[res.getString(R.string.Taftan)] = 279
        perGramCalories[res.getString(R.string.white_toast_bread)] = 290
        perGramCalories[res.getString(R.string.rye_bread)] = 259
        perGramCalories[res.getString(R.string.dried_bread)] = 350
        perGramCalories[res.getString(R.string.roggen_bread)] = 270
        perGramCalories[res.getString(R.string.branny_bread)] = 252
        perGramCalories[res.getString(R.string.Sangak)] = 259
        perGramCalories[res.getString(R.string.Rusk)] = 350
        perGramCalories[res.getString(R.string.Sheermal)] = 296
        perGramCalories[res.getString(R.string.wheat_bread)] = 274
        perGramCalories[res.getString(R.string.Lavash)] = 291
        perGramCalories[res.getString(R.string.Baguette)] = 235
        perGramCalories[res.getString(R.string.Noodle)] = 486
        perGramCalories[res.getString(R.string.green_Chickpea)] = 125



        perGramCalories[res.getString(R.string.sour_cherry)] = 60
        perGramCalories[res.getString(R.string.armenian_plum)] = 75
        perGramCalories[res.getString(R.string.damson)] = 45
        perGramCalories[res.getString(R.string.aloe_vera)] = 60
        perGramCalories[res.getString(R.string.pineapple)] = 50
        perGramCalories[res.getString(R.string.avocado)] = 190
        perGramCalories[res.getString(R.string.common_medlar)] = 90
        perGramCalories[res.getString(R.string.Pomegranate)] = 83
        perGramCalories[res.getString(R.string.mango)] = 65
        perGramCalories[res.getString(R.string.grapes)] = 70
        perGramCalories[res.getString(R.string.dried_mango)] = 275
        perGramCalories[res.getString(R.string.common_fig)] = 70
        perGramCalories[res.getString(R.string.raspberry)] = 57
        perGramCalories[res.getString(R.string.quince)] = 65
        perGramCalories[res.getString(R.string.orange)] = 47
        perGramCalories[res.getString(R.string.passion_fruit)] = 97
        perGramCalories[res.getString(R.string.passion_fruit)] = 240
        perGramCalories[res.getString(R.string.passion_fruit)] = 360
        perGramCalories[res.getString(R.string.almond_crop)] = 30
        perGramCalories[res.getString(R.string.persian_melon)] = 25
        perGramCalories[res.getString(R.string.date_palm)] = 280
        perGramCalories[res.getString(R.string.cucumber)] = 12
        perGramCalories[res.getString(R.string.Pomelo)] = 38
        perGramCalories[res.getString(R.string.Rhubarb)] = 20
        perGramCalories[res.getString(R.string.Hawthorn)] = 60
        perGramCalories[res.getString(R.string.dried_armenian_plum)] = 241
        perGramCalories[res.getString(R.string.fresh_apple)] = 241


        perGramCalories[res.getString(R.string.fresh_apple)] = 73
        perGramCalories[res.getString(R.string.black_mulberry)] = 50
        perGramCalories[res.getString(R.string.black_mulberry)] = 50
        perGramCalories[res.getString(R.string.kumquat)] = 71
        perGramCalories[res.getString(R.string.cranberry)] = 46
        perGramCalories[res.getString(R.string.kiwifruit)] = 50
        perGramCalories[res.getString(R.string.candtaloupe)] = 24
        perGramCalories[res.getString(R.string.sweet_lemon)] = 30
        perGramCalories[res.getString(R.string.banana)] = 70
        perGramCalories[res.getString(R.string.coconut)] = 350
        perGramCalories[res.getString(R.string.bitter_orange)] = 45
        perGramCalories[res.getString(R.string.tangerine)] = 45
        perGramCalories[res.getString(R.string.peach)] = 40
        perGramCalories[res.getString(R.string.saturn_peach)] = 40
        perGramCalories[res.getString(R.string.Watermelo)] = 30


        //perGramCalories


        perGramCalories.put("آبنبات ساده",200)
        perGramCalories.put("آدامس",120)
        perGramCalories.put("ارده",450)
        perGramCalories.put("باقلوا",500)
        perGramCalories.put("بامیه (شیرینی)",400)
        perGramCalories.put("براونی",380)
        perGramCalories.put("ساقه طلایی",440)
        perGramCalories.put("ساقه طلایی شکلاتی",474)
        perGramCalories.put("بیسکوییت کرم دار",480)
        perGramCalories.put("پای سیب",450)
        perGramCalories.put("پاستیل",300)
        perGramCalories.put("پشمک",380)
        perGramCalories.put("پن کیک",230)
        perGramCalories.put("پولکی",400)
        perGramCalories.put("پیراشکی شیرین",250)
        perGramCalories.put("تیرامیسو",450)
        perGramCalories.put("تخم کتان",534)
        perGramCalories.put("چیز کیک",321)
        perGramCalories.put("حلوا",400)
        perGramCalories.put("حلوا ارده",500)
        perGramCalories.put("خمیر کنجد",595)
        perGramCalories.put("دونات",425)
        perGramCalories.put("زولبیا",400)
        perGramCalories.put("ژله",60)
        perGramCalories.put("سوهان",500)
        perGramCalories.put("شکر",400)
        perGramCalories.put("شکر قهوه ای",380)
        perGramCalories.put("شکلات اسنیکرز",488)
        perGramCalories.put("شکلات تلخ ۷۵٪",533)
        perGramCalories.put("شکلات تلخ ۸۰٪",533)
        perGramCalories.put("شکلات تلخ ۸۵٪",566)
        perGramCalories.put("شکلات تلخ ۹۰٪",600)
        perGramCalories.put("شکلات تلخ ۹۹٪",550)
        perGramCalories.put("شکلات ساده",350)
        perGramCalories.put("شکلات صبحانه",500)
        perGramCalories.put("شکلات نارگیلی",488)
        perGramCalories.put("شله زرد",100)
        perGramCalories.put("شیر برنج",100)
        perGramCalories.put("شیره انگور",250)
        perGramCalories.put("شیره خرما",250)
        perGramCalories.put("شیرینی خامه ای",500)
        perGramCalories.put("شیرینی خشک",450)
        perGramCalories.put("شیرینی دانمارکی",400)
        perGramCalories.put("شیرینی زبان",310)
        perGramCalories.put("شیرینی کشمشی",404)
        perGramCalories.put("شیرینی لطیفه",297)
        perGramCalories.put("شیرینی ناپلعونی",440)
        perGramCalories.put("شیرینی نارگیلی",374)
        perGramCalories.put("عسل",300)
        perGramCalories.put("فالوده",150)
        perGramCalories.put("فرنی",100)
        perGramCalories.put("قطاب",470)
        perGramCalories.put("قند",400)
        perGramCalories.put("کاپ کیک",369)
        perGramCalories.put("کاچی",400)
        perGramCalories.put("کاکاعو",228)
        perGramCalories.put("کراسان",406)
        perGramCalories.put("کراسان پنیری",414)
        perGramCalories.put("کراسان سیب",254)
        perGramCalories.put("کرم کارامل",360)
        perGramCalories.put("کلوچه",500)
        perGramCalories.put("کورن فلکس",370)
        perGramCalories.put("کوکی",486)
        perGramCalories.put("کیک خامه ای",370)
        perGramCalories.put("کیک ردولوت",422)
        perGramCalories.put("کیک ساده",300)
        perGramCalories.put("کیک شکلاتی",410)
        perGramCalories.put("کیک گردویی",397)
        perGramCalories.put("کیک هویج",410)
        perGramCalories.put("کیک یزدی",300)
        perGramCalories.put("گز",500)
        perGramCalories.put("مربا",280)
        perGramCalories.put("مربا آلبالو",260)
        perGramCalories.put("مربا بالنگ",280)
        perGramCalories.put("مربا به",290)
        perGramCalories.put("مربا توت فرنگی",270)
        perGramCalories.put("مربا هویج",250)
        perGramCalories.put("مسقطی",135)
        perGramCalories.put("نان برنجی",243)
        perGramCalories.put("نان پنجره ای",357)
        perGramCalories.put("نان خامه ای",500)
        perGramCalories.put("نان نخودچی",508)
        perGramCalories.put("نبات",400)
        perGramCalories.put("نقل",412)
        perGramCalories.put("نوتلا",526)
        perGramCalories.put("وانیل",288)



        perGramCalories[res.getString(R.string.raw_chicken_breast)] = 172
        perGramCalories[res.getString(R.string.Turkey)] = 220
        perGramCalories[res.getString(R.string.chiken_soup)] = 78
        perGramCalories[res.getString(R.string.abgoosht)] = 100
        perGramCalories[res.getString(R.string.duck)] = 337
        perGramCalories[res.getString(R.string.raw_duck)] = 404
        perGramCalories[res.getString(R.string.steak)] = 404
        perGramCalories[res.getString(R.string.turkey_steak)] = 282
        perGramCalories[res.getString(R.string.fat_steak)] = 400
        perGramCalories[res.getString(R.string.pork_steak)] = 259
        perGramCalories[res.getString(R.string.chicken_steak)] = 119
        perGramCalories[res.getString(R.string.chicken_scallop)] = 305
        perGramCalories[res.getString(R.string.fried_chiken_wings)] = 350
        perGramCalories[res.getString(R.string.roasted_chicken_wing)] = 350
        perGramCalories[res.getString(R.string.Quail)] = 227
        perGramCalories[res.getString(R.string.blue_cheese)] = 350
        perGramCalories[res.getString(R.string.chicken_feet)] = 215
        perGramCalories[res.getString(R.string.rarmigiano_reggiano)] = 420
        perGramCalories[res.getString(R.string.pizza_cheese)] = 400
        perGramCalories[res.getString(R.string.tofu)] = 76
        perGramCalories[res.getString(R.string.cheddar_cheese)] = 400
        perGramCalories[res.getString(R.string.cream_cheese)] = 350
        perGramCalories[res.getString(R.string.low_fat_cottage_cheese)] = 201
        perGramCalories[res.getString(R.string.low_fat_cheese)] = 130
        perGramCalories[res.getString(R.string.cottage_cheese)] = 86
        perGramCalories[res.getString(R.string.camembert)] = 86
        perGramCalories[res.getString(R.string.kibi)] = 298
        perGramCalories[res.getString(R.string.gouda_cheese)] = 350
        perGramCalories[res.getString(R.string.Gorgonzola_cheese)] = 350
        perGramCalories[res.getString(R.string.cheese)] = 350
        perGramCalories[res.getString(R.string.lighvan_cheese)] = 280
        perGramCalories[res.getString(R.string.low_fat_Mozzarella)] = 243
        perGramCalories[res.getString(R.string.high_fat_Mozzarella)] = 320
        perGramCalories[res.getString(R.string.medium_fat_Mozzarella)] = 280
        perGramCalories[res.getString(R.string.Mozzarella)] = 254
        perGramCalories[res.getString(R.string.halomi_cheese)] = 364
        perGramCalories[res.getString(R.string.Quail_eggs)] = 364
        perGramCalories[res.getString(R.string.raw_Quail_eggs)] = 154
        perGramCalories[res.getString(R.string.boiled_eggs)] = 160
        perGramCalories[res.getString(R.string.raw_Yolk)] = 339
        perGramCalories[res.getString(R.string.Egg_white)] = 36
        perGramCalories[res.getString(R.string.fried_egg)] = 300
        perGramCalories[res.getString(R.string.tuna_fish)] = 128
        perGramCalories[res.getString(R.string.salted_tuna)] = 173
        perGramCalories[res.getString(R.string.oiled_tuna)] = 300
        perGramCalories[res.getString(R.string.Liver)] = 140
        perGramCalories[res.getString(R.string.chicken_liver)] = 120
        perGramCalories[res.getString(R.string.jujeh_kabab)] = 200
        perGramCalories[res.getString(R.string.chicken_stroganoff)] = 130
        perGramCalories[res.getString(R.string.cream)] = 300
        perGramCalories[res.getString(R.string.chocolate_cream)] = 410
        perGramCalories[res.getString(R.string.honey_cream)] = 390
        perGramCalories[res.getString(R.string.Caviar)] = 252
        perGramCalories[res.getString(R.string.Chicken_Thighs)] = 232
        perGramCalories[res.getString(R.string.fried_Chicken_Thighs)] = 184
        perGramCalories[res.getString(R.string.Chicken_and_pumpkin)] = 95
        perGramCalories[res.getString(R.string.sheep_heart)] = 260
        perGramCalories[res.getString(R.string.tail_fat)] = 902
        perGramCalories[res.getString(R.string.dizi)] = 160
        perGramCalories[res.getString(R.string.Chicken_Thighs_with_skin)] = 216
        perGramCalories[res.getString(R.string.Chicken_Thighs_without_skin)] = 177
        perGramCalories[res.getString(R.string.cooked_Chicken_Thighs_with_skin)] = 232
        perGramCalories[res.getString(R.string.cooked_Chicken_Thighs_without_skin)] = 232
        perGramCalories[res.getString(R.string.rested_in_oven_Chicken_Thighs_with_skin)] = 229
        perGramCalories[res.getString(R.string.fried_Chicken_Thighs)] = 254
        perGramCalories[res.getString(R.string.too_fried_Chicken_Thighs)] = 277
        perGramCalories[res.getString(R.string.Calf_Tongue)] = 192
        perGramCalories[res.getString(R.string.sheep_Tongue)] = 192
        perGramCalories[res.getString(R.string.meat_shawarma_sandwich)] = 241
        perGramCalories[res.getString(R.string.chicken_shawarma_sandwich)] = 133
        perGramCalories[res.getString(R.string.qaimaq)] = 400
        perGramCalories[res.getString(R.string.Gizzard)] = 154
        perGramCalories[res.getString(R.string.Sausage)] = 340
        perGramCalories[res.getString(R.string.Salami)] = 428
        perGramCalories[res.getString(R.string.garlic)] = 248
        perGramCalories[res.getString(R.string.Frankfurter_Wurstchen)] = 287
        perGramCalories[res.getString(R.string.chicken_Lunch_meat)] = 290
        perGramCalories[res.getString(R.string.Sushi)] = 145
        perGramCalories[res.getString(R.string.Tripe)] = 140
        perGramCalories[res.getString(R.string.raw_chicken_breast_with_skin)] = 120
        perGramCalories[res.getString(R.string.chicken_breast_without_skin)] = 150
        perGramCalories[res.getString(R.string.cooked_chicken_breast_without_skin)] = 150
        perGramCalories[res.getString(R.string.cooked_chicken_breast_with_skin)] = 184
        perGramCalories[res.getString(R.string.rested_in_oven_Chicken_breast_with_skin)] = 197
        perGramCalories[res.getString(R.string.fried_chicken_brast)] = 230
        perGramCalories[res.getString(R.string.complete_chicken_breast)] = 165
        perGramCalories[res.getString(R.string.greal_chicken)] = 165
        perGramCalories[res.getString(R.string.Schnitzel_chicken)] = 300
        perGramCalories[res.getString(R.string.Shashlik_whit_fried_fat)] = 326
        perGramCalories[res.getString(R.string.Shashlik_whitout_fried_fat)] = 288
        perGramCalories[res.getString(R.string.raw_shashlik)] = 223
        perGramCalories[res.getString(R.string.Schnitzel_fish)] = 219
        perGramCalories[res.getString(R.string.milk0)] = 35
        perGramCalories[res.getString(R.string.milk1)] = 42
        perGramCalories[res.getString(R.string.human_milk)] = 70
        perGramCalories[res.getString(R.string.infant_formula)] = 496
        perGramCalories[res.getString(R.string.chocolate_milk)] = 83
        perGramCalories[res.getString(R.string.low_fat_chocolate_milk)] = 76
        perGramCalories[res.getString(R.string.boiled_chicken_filet)] = 195
        perGramCalories[res.getString(R.string.sheep_kidney)] = 100
        perGramCalories[res.getString(R.string.turkey_lunch_meat)] = 209
        perGramCalories[res.getString(R.string.large_kebab)] = 200
        perGramCalories[res.getString(R.string.pan_kebab)] = 450
        perGramCalories[res.getString(R.string.sour_kebab)] = 280
        perGramCalories[res.getString(R.string.meat_turkey_kebab)] = 173
        perGramCalories[res.getString(R.string.chicken_turkey_kebab)] = 217
        perGramCalories[res.getString(R.string.filet_kebab)] = 250
        perGramCalories[res.getString(R.string.kabab_koobideh)] = 270
        perGramCalories[res.getString(R.string.roasted_partridge_without_bones)] = 211
        perGramCalories[res.getString(R.string.butter)] = 700
        perGramCalories[res.getString(R.string.Ghee)] = 770
        perGramCalories[res.getString(R.string.Margarine)] = 714
        perGramCalories[res.getString(R.string.sheep_neck_with_fat)] = 307
        perGramCalories[res.getString(R.string.raw_sheep_neck_with_fat)] = 151
        perGramCalories[res.getString(R.string.sheep_neck_without_fat)] = 264
        perGramCalories[res.getString(R.string.raw_sheep_neck_without_fat)] = 231
        perGramCalories[res.getString(R.string.chicken_neck)] = 254
        perGramCalories[res.getString(R.string.mixed_ground_meat)] = 300
        perGramCalories[res.getString(R.string.camel_meat)] = 98
        perGramCalories[res.getString(R.string.common_ostrich)] = 220
        perGramCalories[res.getString(R.string.Calf_meat)] = 250
        perGramCalories[res.getString(R.string.high_fat_sheep_meat)] = 350
        perGramCalories[res.getString(R.string.low_fat_sheep_meat)] = 280
        perGramCalories[res.getString(R.string.fish)] = 120
        perGramCalories[res.getString(R.string.chicken_meat)] = 200
        perGramCalories[res.getString(R.string.steamed_lobster)] = 100
        perGramCalories[res.getString(R.string.fried_lobster)] = 120
        perGramCalories[res.getString(R.string.Yogurt5)] = 79
        perGramCalories[res.getString(R.string.Yogurt7)] = 96

        perGramCalories[res.getString(R.string.iceland_Yogurt)] = 60
        perGramCalories[res.getString(R.string.low_fat_Yogurt)] = 56
        perGramCalories[res.getString(R.string.boorani_yogurt)] = 80
        perGramCalories[res.getString(R.string.greek_yogurt)] = 160
        perGramCalories[res.getString(R.string.soy_yogurt)] = 72
        perGramCalories[res.getString(R.string.allium_stipitatum_yogurt)] = 60
        perGramCalories[res.getString(R.string.fruit_yogurt)] = 180
        perGramCalories[res.getString(R.string.eggplant_yogurt)] = 80
        perGramCalories[res.getString(R.string.cucumber_yogurt)] = 80
        perGramCalories[res.getString(R.string.greece_sheep_yogurt)] = 115
        perGramCalories[res.getString(R.string.greece_cow_yogurt)] = 106
        perGramCalories[res.getString(R.string.vegetable_yogurt)] = 80
        perGramCalories[res.getString(R.string.fried_fish)] = 135
        perGramCalories[res.getString(R.string.grilled_fish)] = 110
        perGramCalories[res.getString(R.string.cooked_fish)] = 110
        perGramCalories[res.getString(R.string.friedd_Shrimp)] = 144
        perGramCalories[res.getString(R.string.cooked_Shrimp)] = 99
        perGramCalories[res.getString(R.string.raw_Shrimp)] = 76
        perGramCalories[res.getString(R.string.small_dried_Shrimp)] = 245
        perGramCalories[res.getString(R.string.fried_lobster)] = 120
        perGramCalories[res.getString(R.string.steamed_lobster)] = 100
        perGramCalories[res.getString(R.string.raw_Shrimp)] = 100
        perGramCalories[res.getString(R.string.milk15)] = 47
        perGramCalories[res.getString(R.string.milk325)] = 61
        perGramCalories[res.getString(R.string.milk37)] = 64


        perGramCalories.newPut(R.string.chicken_nougat,230)
        perGramCalories.newPut(R.string.roasted_Shrimp,100)
        perGramCalories.newPut(R.string.fried_Shrimp,200)
        perGramCalories.newPut(R.string.small_friezed_Shrimp,73)
        perGramCalories.newPut(R.string.small_Shrimp,245)
        perGramCalories.newPut(R.string.large_Shrimp,245)
        perGramCalories.newPut(R.string.burger_without_bread,222)





        //per glass init
        perGlassCalories.put("آجیل یک لیوان ",750)
        perGlassCalories.put("برنج ( یک لیوان )",660)
        perGlassCalories.put("پرتقال ( آب پرتقال )",110)
        perGlassCalories.put("پوره سیب زمینی",180)
        perGlassCalories.put("شکوفه ذرت",25)
        perGlassCalories.put("دسر ( ژلاتین )",180)
        perGlassCalories.put("زردآلو ( کمپوت )",250)
        perGlassCalories.put("عدس",650)
        perGlassCalories.put("فرنی",200)
        perGlassCalories.put("ماست پر چربی",150)
        perGlassCalories.put("ماست کم چرب",110)
        perGlassCalories.put("لوبیا قرمز پخته ( با کمی چربی )",200)
        perGlassCalories.put("کمپوت گیلاس",190)
        perGlassCalories.put("عدس پخته ( با کمی روغن )",185)
        perGlassCalories.put("کره یک لیوان",1600)







        //per unit init

        perUnitCalories.put("بادام ( درشت )",10)
        perUnitCalories.put("پیتزا یک عدد",700)
        perUnitCalories.put("کباب برگ یک سیخ",200)
        perUnitCalories.put("باقلا",5)
        perUnitCalories.put("تربچه",2)
        perUnitCalories.put("تخم مرغ متوسط",70)
        perUnitCalories.put("تخم مرغ ( زرده خالی )",50)
        perUnitCalories.put("تخم مرغ ( سفیده خالی )",20)
        perUnitCalories.put("تخم مرغ آب پز",70)
        perUnitCalories.put("تخم مرغ نیمرو",130)
        perUnitCalories.put("تن ماهی",560)
        perUnitCalories.put("حلیم ( بدون روغن )",180)
        perUnitCalories.put("چای شیرین",4)
        perUnitCalories.put("خرمالو",80)
        perUnitCalories.put("دلمه (متوسط)",150)









        data.put("gram",perGramCalories)
        data.put("glass", perGlassCalories)
        data.put("unit",perUnitCalories)
        return data
    }
    fun getPerGramCalories(): HashMap<String,Int> {
        val perGramCalories = HashMap<String, Int>()

        perGramCalories.put("آدامس",100)
        perGramCalories.put("آرد گندم",360)
        perGramCalories.put("آرد ذرت",370)
        perGramCalories.put("آرد سویا",420)
        perGramCalories.put("آلبالو ( کمپوت )",90)
        perGramCalories.put("آب جو ( ماء الشعیر ) ",40)
        perGramCalories.put("آلوی زرد",75)
        perGramCalories.put("آلبالو تازه ( با هسته )",60)
        perGramCalories.put("آلوی قرمز",45)
        perGramCalories.put("آناناس",45)
        perGramCalories.put("آناناس ( کمپوت )",75)
        perGramCalories.put("آناناس ( کمپوت )",75)
        perGramCalories.put("انبه هندی",60)
        perGramCalories.put("اسفناج خامی",25)
        perGramCalories.put("استیک ( کم چربی )",200)
        perGramCalories.put("استیک ( پر چربی )",400)
        perGramCalories.put("انار تازه ( دانه )",60)
        perGramCalories.put("انار کامل با پوست",35)
        perGramCalories.put("انجیر (تازه ) ",60)
        perGramCalories.put("انجیر ( خشک )",270)
        perGramCalories.put("انگور",80)
        perGramCalories.put("انگور عسکری",90)
        perGramCalories.put("انگور یاقوتی",100)

        return  perGramCalories
    }
    fun HashMap<String, Int>.newPut(id:Int,value:Int){
        put(res.getString(id),value)
    }
}