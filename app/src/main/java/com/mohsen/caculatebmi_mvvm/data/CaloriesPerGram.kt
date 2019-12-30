package com.mohsen.caculatebmi_mvvm.data
import com.mohsen.caculatebmi_mvvm.App
import com.mohsen.caculatebmi_mvvm.R
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
        perGramCalories[res.getString(R.string.sunflower_seed)] = 580
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
        perGramCalories[res.getString(R.string.garden_asparagus)] = 20
        perGramCalories[res.getString(R.string.Cowpea)] = 80
        perGramCalories[res.getString(R.string.red_bean)] = 110
        perGramCalories[res.getString(R.string.cabbage)] = 20
        perGramCalories[res.getString(R.string.red_cabbage)] = 28
        perGramCalories[res.getString(R.string.Pumpkin)] = 35
        perGramCalories[res.getString(R.string.cocoa)] = 200

        
        // karafs refrence

        perGramCalories[res.getString(R.string.soy_nuts)] = 471
        perGramCalories[res.getString(R.string.mixed_nuts)] = 594
        perGramCalories[res.getString(R.string.mixed_brains)] = 600
        perGramCalories[res.getString(R.string.wafers)] = 534
        perGramCalories[res.getString(R.string.popcorn)] = 390
        perGramCalories[res.getString(R.string.pistachio_with_skin)] = 560
        perGramCalories[res.getString(R.string.pistachio_without_skin)] = 650
        perGramCalories[res.getString(R.string.russian_olive)] = 130
        perGramCalories[res.getString(R.string.esquites_with_cheese)] = 300
        perGramCalories[res.getString(R.string.esquites_without_cheese)] = 150
        perGramCalories[res.getString(R.string.japanese_seeds)] = 560
        perGramCalories[res.getString(R.string.pumpkin_seeds)] = 574
        perGramCalories[res.getString(R.string.watermelo_seeds)] = 560
        perGramCalories[res.getString(R.string.peanut_without_skin)] = 540
        perGramCalories[res.getString(R.string.potato_samosa)] = 150
        perGramCalories[res.getString(R.string.beaf_samosa)] = 140
        perGramCalories[res.getString(R.string.samanu)] = 100
        perGramCalories[res.getString(R.string.russian_olive)] = 130
        perGramCalories[res.getString(R.string.hemp)] = 553
        perGramCalories[res.getString(R.string.maple_juice)] = 261
        perGramCalories[res.getString(R.string.white_chocolate)] = 539
        perGramCalories[res.getString(R.string.milk_chocolate)] = 535
        perGramCalories[res.getString(R.string.gheysi)] = 320
        perGramCalories[res.getString(R.string.dried_curd)] = 98
        perGramCalories[res.getString(R.string.liquid_curd)] = 49
        perGramCalories[res.getString(R.string.raisin)] = 300
        perGramCalories[res.getString(R.string.fruit_leather)] = 180
        perGramCalories[res.getString(R.string.walnut)] = 654
        perGramCalories[res.getString(R.string.zante_currant)] = 283
        perGramCalories[res.getString(R.string.dried_coconut)] = 660
        perGramCalories[res.getString(R.string.cherry_pilaw)] = 155
        perGramCalories[res.getString(R.string.spanish_rice)] = 137
        perGramCalories[res.getString(R.string.white_cooked_rice)] = 155
        perGramCalories[res.getString(R.string.brown_cooked_rice)] = 130
        perGramCalories[res.getString(R.string.pilaf_with_oil)] = 170
        perGramCalories[res.getString(R.string.pilaf_without_oil)] = 130
        perGramCalories[res.getString(R.string.kateh_with_oil)] = 137
        perGramCalories[res.getString(R.string.kateh_without_oil)] = 97
        perGramCalories[res.getString(R.string.eggplant_tahchin)] = 137
        perGramCalories[res.getString(R.string.meat_tahchin)] = 145
        perGramCalories[res.getString(R.string.chiken_tahchin)] = 137
        perGramCalories[res.getString(R.string.rice_tahchin)] = 300
        perGramCalories[res.getString(R.string.potato_tahchin)] = 350
        perGramCalories[res.getString(R.string.bread_tahchin)] = 500
        perGramCalories[res.getString(R.string.dum_pukht)] = 120
        perGramCalories[res.getString(R.string.reshte_pilaf)] = 155
        perGramCalories[res.getString(R.string.barberry_pilaf)] = 137
        perGramCalories[res.getString(R.string.vegtables_pilaf)] = 137
        perGramCalories[res.getString(R.string.sweet_pilaf)] = 155
        perGramCalories[res.getString(R.string.sweet_pilaf)] = 137
        perGramCalories[res.getString(R.string.cabbage_pilaf)] = 137
        perGramCalories[res.getString(R.string.broad_bean_pilaf)] = 155
        perGramCalories[res.getString(R.string.bean_pilaf)] = 137
        perGramCalories[res.getString(R.string.bean_pilaf)] = 130
        perGramCalories[res.getString(R.string.marsa_pilaf)] = 155
        perGramCalories[res.getString(R.string.shrimp_pilaf)] = 137
        perGramCalories[res.getString(R.string.chickpea_pilaf)] = 130
        perGramCalories[res.getString(R.string.carrot_pilaf)] = 130
        perGramCalories[res.getString(R.string.baghala_ghatogh)] = 140
        perGramCalories[res.getString(R.string.tas_kebab)] = 150
        perGramCalories[res.getString(R.string.torshi_tare)] = 135
        perGramCalories[res.getString(R.string.khoresh_tare)] = 140
        perGramCalories[res.getString(R.string.green_bean_Khoresh)] = 180
        perGramCalories[res.getString(R.string.aloo_Khoresh)] = 140
        perGramCalories[res.getString(R.string.Spinach_Khoresh)] = 140
        perGramCalories[res.getString(R.string.eggplant_Khoresh)] = 125
        perGramCalories[res.getString(R.string.Okra_Khoresh)] = 140
        perGramCalories[res.getString(R.string.Quince_Khoresh)] = 150
        perGramCalories[res.getString(R.string.apple_Khoresh)] = 150
        perGramCalories[res.getString(R.string.Almond_cuts_Khoresh)] = 120
        perGramCalories[res.getString(R.string.Ghormeh_sabzi)] = 140
        perGramCalories[res.getString(R.string.Gheimeh)] = 150
        perGramCalories[res.getString(R.string.Fesenjān)] = 180
        perGramCalories[res.getString(R.string.eggplant_Gheimeh)] = 150
        perGramCalories[res.getString(R.string.pumpkin_khoresh)] = 140
        perGramCalories[res.getString(R.string.Celery_khoresh)] = 140
        perGramCalories[res.getString(R.string.spear_thistle_khoresh)] = 140
        perGramCalories[res.getString(R.string.carrot_khoresh)] = 100
        perGramCalories[res.getString(R.string.ghalie_mahi_khoresh)] = 135
        perGramCalories[res.getString(R.string.ghalie_meigoo_khoresh)] = 145
        perGramCalories[res.getString(R.string.morghe_torsh)] = 135
        perGramCalories[res.getString(R.string.vavishka)] = 300


        perGramCalories[res.getString(R.string.caesar_alad)] = 170
        perGramCalories[res.getString(R.string.chicken_caesar_alad)] = 185
        perGramCalories[res.getString(R.string.potato_alad)] = 155
        perGramCalories[res.getString(R.string.shirazi_alad)] = 14
        perGramCalories[res.getString(R.string.salad_with_Sauce)] = 80
        perGramCalories[res.getString(R.string.salad_without_Sauce)] = 17
        perGramCalories[res.getString(R.string.pasta_salad)] = 221
        perGramCalories[res.getString(R.string.greed_salad)] = 101




        perGramCalories[res.getString(R.string.snack_with_cheese)] = 200
        perGramCalories[res.getString(R.string.small_burrito)] = 300
        perGramCalories[res.getString(R.string.medium_burrito_with_meat)] = 300
        perGramCalories[res.getString(R.string.small_burrito_with_chicken)] = 200
        perGramCalories[res.getString(R.string.medium_burrito_with_chicken)] = 200
        perGramCalories[res.getString(R.string.onnion)] = 330
        perGramCalories[res.getString(R.string.steak_pizza)] = 257
        perGramCalories[res.getString(R.string.Pepperoni)] = 284
        perGramCalories[res.getString(R.string.small_vegetable_pizza)] = 250
        perGramCalories[res.getString(R.string.medium_vegetable_pizza)] = 250
        perGramCalories[res.getString(R.string.small_pizza)] = 250
        perGramCalories[res.getString(R.string.medium_pizza)] = 250
        perGramCalories[res.getString(R.string.meat_mushroom_pizza)] = 276
        perGramCalories[res.getString(R.string.chicken_mushroom_pizza)] = 289
        perGramCalories[res.getString(R.string.chicken_tacos)] = 289
        perGramCalories[res.getString(R.string.meat_tacos)] = 280
        perGramCalories[res.getString(R.string.chicken_tostada)] = 180
        perGramCalories[res.getString(R.string.large_cheese_burger)] = 350
        perGramCalories[res.getString(R.string.medium_cheese_burger)] = 350
        perGramCalories[res.getString(R.string.small_cheese_burger)] = 350
        perGramCalories[res.getString(R.string.rest_beef_sandwich)] = 250
        perGramCalories[res.getString(R.string.ham_sandwich)] = 151
        perGramCalories[res.getString(R.string.club_sandwich)] = 220
        perGramCalories[res.getString(R.string.hot_dog_sandwich)] = 200
        perGramCalories[res.getString(R.string.burger_sandwich)] = 300
        perGramCalories[res.getString(R.string.fried_potato)] = 320
        perGramCalories[res.getString(R.string.meat_fahito)] = 170
        perGramCalories[res.getString(R.string.chicken_fahito)] = 160
        perGramCalories[res.getString(R.string.falafel)] = 230
        perGramCalories[res.getString(R.string.lasagne)] = 300
        perGramCalories[res.getString(R.string.roasted_burger)] = 222
        perGramCalories[res.getString(R.string.medium_pizza)] = 300







        perGramCalories[res.getString(R.string.onion_from_mountains)] = 30
        perGramCalories[res.getString(R.string.medium_pizza)] = 300
        perGramCalories[res.getString(R.string.Scallion)] = 23
        perGramCalories[res.getString(R.string.garden_radish)] = 12
        perGramCalories[res.getString(R.string.dried_tarragon)] = 295
        perGramCalories[res.getString(R.string.chives)] = 20
        perGramCalories[res.getString(R.string.garden_leek)] = 61
        perGramCalories[res.getString(R.string.parsley)] = 25
        perGramCalories[res.getString(R.string.roasted_Maize)] = 80
        perGramCalories[res.getString(R.string.Can_Maize)] = 95
        perGramCalories[res.getString(R.string.fennel)] = 337
        perGramCalories[res.getString(R.string.rosemary)] = 131
        perGramCalories[res.getString(R.string.basil)] = 25
        perGramCalories[res.getString(R.string.ginger)] = 80
        perGramCalories[res.getString(R.string.Aush_veg)] = 40
        perGramCalories[res.getString(R.string.Aush_veg)] = 40
        perGramCalories[res.getString(R.string.vegetables)] = 30
        perGramCalories[res.getString(R.string.Dolma_veg)] = 40
        perGramCalories[res.getString(R.string.ghorme_veg)] = 40
        perGramCalories[res.getString(R.string.Kuku_veg)] = 40
        perGramCalories[res.getString(R.string.steamed_veg)] = 71
        perGramCalories[res.getString(R.string.grilled_veg)] = 50
        perGramCalories[res.getString(R.string.potato)] = 75
        perGramCalories[res.getString(R.string.potato)] = 87
        perGramCalories[res.getString(R.string.steamed_potato)] = 87
        perGramCalories[res.getString(R.string.sweet_potato)] = 86
        perGramCalories[res.getString(R.string.garden_cress)] = 20
        perGramCalories[res.getString(R.string.turnip)] = 28
        perGramCalories[res.getString(R.string.fenugreek)] = 23
        perGramCalories[res.getString(R.string.fresh_Dill)] = 43
        perGramCalories[res.getString(R.string.dried_Dill)] = 305
        perGramCalories[res.getString(R.string.roasted_bell_pepper)] = 33
        perGramCalories[res.getString(R.string.bell_pepper)] = 20
        perGramCalories[res.getString(R.string.cooked_mushroom)] = 28
        perGramCalories[res.getString(R.string.raw_mushroom)] = 22
        perGramCalories[res.getString(R.string.roasted_mushroom)] = 60
        perGramCalories[res.getString(R.string.Lettuce)] = 20
        perGramCalories[res.getString(R.string.Pumpkin)] = 35
        perGramCalories[res.getString(R.string.celery)] = 15
        perGramCalories[res.getString(R.string.brussels_sprout)] = 25
        perGramCalories[res.getString(R.string.sprouting_broccoli)] = 25
        perGramCalories[res.getString(R.string.cabbage)] = 25
        perGramCalories[res.getString(R.string.white_cabbage)] = 25
        perGramCalories[res.getString(R.string.red_cabbage)] = 25
        perGramCalories[res.getString(R.string.chinese_cabbage)] = 12
        perGramCalories[res.getString(R.string.kale)] = 50
        perGramCalories[res.getString(R.string.Coriander)] = 23
        perGramCalories[res.getString(R.string.Cauliflower)] = 25
        perGramCalories[res.getString(R.string.tomato)] = 20
        perGramCalories[res.getString(R.string.dried_tomato)] = 20
        perGramCalories[res.getString(R.string.common_beet)] = 40
        perGramCalories[res.getString(R.string.garden_asparagus)] = 20
        perGramCalories[res.getString(R.string.Savory)] = 272
        perGramCalories[res.getString(R.string.allium_stipitatum)] = 72
        perGramCalories[res.getString(R.string.green_Chickpea)] = 30
        perGramCalories[res.getString(R.string.dried_Mint)] = 200
        perGramCalories[res.getString(R.string.Mint)] = 40
        perGramCalories[res.getString(R.string.carrot)] = 35




        perGramCalories[res.getString(R.string.rice_flour)] = 366
        perGramCalories[res.getString(R.string.white_rice_flour)] = 366
        perGramCalories[res.getString(R.string.barley_flour)] = 360
        perGramCalories[res.getString(R.string.Oat_flour)] = 400
        perGramCalories[res.getString(R.string.cornmeal)] = 381
        perGramCalories[res.getString(R.string.high_fat_soy_flour)] = 447
        perGramCalories[res.getString(R.string.low_fat_soy_flour)] = 352
        perGramCalories[res.getString(R.string.wheat_flour)] = 360
        perGramCalories[res.getString(R.string.brown_wheat_flour)] = 323
        perGramCalories[res.getString(R.string.dried_broad_bean)] = 350
        perGramCalories[res.getString(R.string.raw_rice)] = 380
        perGramCalories[res.getString(R.string.oatmeal)] = 331
        perGramCalories[res.getString(R.string.Wheatmeal)] = 342
        perGramCalories[res.getString(R.string.cooked_Wheatmeal)] = 83
        perGramCalories[res.getString(R.string.barley)] = 350
        perGramCalories[res.getString(R.string.rolled_oats)] = 360
        perGramCalories[res.getString(R.string.Oat)] = 355
        perGramCalories[res.getString(R.string.Wheatgrass)] = 50
        perGramCalories[res.getString(R.string.munggrass)] = 45
        perGramCalories[res.getString(R.string.Lentil)] = 90
        perGramCalories[res.getString(R.string.raw_Lentil)] = 110
        perGramCalories[res.getString(R.string.cooked_Lentil)] = 80
        perGramCalories[res.getString(R.string.bean)] = 80
        perGramCalories[res.getString(R.string.Chickpea)] = 85
        perGramCalories[res.getString(R.string.raw_flour_Bran)] = 85
        perGramCalories[res.getString(R.string.flour_Bran)] = 206
        perGramCalories[res.getString(R.string.cooked_oat_bran)] = 80
        perGramCalories[res.getString(R.string.raw_oat_bran)] = 246
        perGramCalories[res.getString(R.string.cerelac)] = 380
        perGramCalories[res.getString(R.string.Quinoa)] = 120
        perGramCalories[res.getString(R.string.raw_quinoa)] = 368
        perGramCalories[res.getString(R.string.Wheat)] = 350
        perGramCalories[res.getString(R.string.black_Wheat)] = 343
        perGramCalories[res.getString(R.string.split_pea)] = 360
        perGramCalories[res.getString(R.string.Cowpea)] = 130
        perGramCalories[res.getString(R.string.Pinto_bean)] = 340
        perGramCalories[res.getString(R.string.cooked_Pinto_bean)] = 100
        perGramCalories[res.getString(R.string.red_bean)] = 300
        perGramCalories[res.getString(R.string.cooked_red_bean)] = 110
        perGramCalories[res.getString(R.string.boiled_Macaroni)] = 158
        perGramCalories[res.getString(R.string.macaroni_with_soy)] = 150
        perGramCalories[res.getString(R.string.raw_macaroni)] = 350


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


        perGramCalories.newPut(R.string.candy,200)
        perGramCalories.newPut(R.string.tahini,450)
        perGramCalories.newPut(R.string.Chocolate_brownie,380)
        perGramCalories.newPut(R.string.saghe_talaee_biscuite,440)
        perGramCalories.newPut(R.string.saghe_talaee_biscuite_chocolate,474)
        perGramCalories.newPut(R.string.biscuit_with_cream,480)
        perGramCalories.newPut(R.string.apple_pie,450)
        perGramCalories.newPut(R.string.Gummy_candy,300)
        perGramCalories.newPut(R.string.Cotton_candy,380)
        perGramCalories.newPut(R.string.pancake,230)
        perGramCalories.newPut(R.string.Poolaki,400)
        perGramCalories.newPut(R.string.Pirozhki,250)
        perGramCalories.newPut(R.string.Tiramisu,450)
        perGramCalories.newPut(R.string.flax,534)
        perGramCalories.newPut(R.string.cheese_cake,321)
        perGramCalories.newPut(R.string.halva,400)
        perGramCalories.newPut(R.string.Sesame_Dough,595)
        perGramCalories.newPut(R.string.Doughnut,425)
        perGramCalories.newPut(R.string.Jalebi,400)
        perGramCalories.newPut(R.string.Gelatin,60)
        perGramCalories.newPut(R.string.Sohan,500)
        perGramCalories.newPut(R.string.suger,400)
        perGramCalories.newPut(R.string.brown_suger,380)
        perGramCalories.newPut(R.string.snickers,488)
        perGramCalories.newPut(R.string.Dark_chocolate_75,533)
        perGramCalories.newPut(R.string.Dark_chocolate_80,533)
        perGramCalories.newPut(R.string.Dark_chocolate_85,566)
        perGramCalories.newPut(R.string.Dark_chocolate_90,600)
        perGramCalories.newPut(R.string.Dark_chocolate_99,660)
        perGramCalories.newPut(R.string.simple_chocolate,350)
        perGramCalories.newPut(R.string.coconut_chocolate,488)
        perGramCalories.newPut(R.string.breakfast_chocolate,500)
        perGramCalories.newPut(R.string.Sholezard,100)
        perGramCalories.newPut(R.string.rice_pudding,100)
        perGramCalories.newPut(R.string.grape_syrup,250)
        perGramCalories.newPut(R.string.Date_palm_syrup,250)
        perGramCalories.newPut(R.string.puff_pastry,310)
        perGramCalories.newPut(R.string.latife_pastry,297)
        perGramCalories.newPut(R.string.Mille_feuille,440)
        perGramCalories.newPut(R.string.coconut_pastry,374)
        perGramCalories.newPut(R.string.honey,300)
        perGramCalories.newPut(R.string.faloodeh,150)
        perGramCalories.newPut(R.string.kheer,100)
        perGramCalories.newPut(R.string.qottab,470)
        perGramCalories.newPut(R.string.sugar_cube,400)
        perGramCalories.newPut(R.string.Cupcake,369)
        perGramCalories.newPut(R.string.Kuymak,400)
        perGramCalories.newPut(R.string.cocoa,228)
        perGramCalories.newPut(R.string.Croissant,406)
        perGramCalories.newPut(R.string.Croissant_with_cheese,414)
        perGramCalories.newPut(R.string.Croissant_with_cheese,414)
        perGramCalories.newPut(R.string.potato_Croissant,254)
        perGramCalories.newPut(R.string.Crème_caramel,360)
        perGramCalories.newPut(R.string.cookie,500)
        perGramCalories.newPut(R.string.Citron_jam,280)
        perGramCalories.newPut(R.string.Quince_jam,290)
        perGramCalories.newPut(R.string.Strawberry_jam,270)
        perGramCalories.newPut(R.string.carrot_jam,250)
        perGramCalories.newPut(R.string.Masghati,250)
        perGramCalories.newPut(R.string.rice_bread,243)
        perGramCalories.newPut(R.string.Rosette,357)
        perGramCalories.newPut(R.string.cream_bread,500)
        perGramCalories.newPut(R.string.Leblebi_bread,508)
        perGramCalories.newPut(R.string.rock_candy,400)
        perGramCalories.newPut(R.string.noghl,412)
        perGramCalories.newPut(R.string.Nutella,526)
        perGramCalories.newPut(R.string.Vanilla,288)

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