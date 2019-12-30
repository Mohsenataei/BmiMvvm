package com.mohsen.caculatebmi_mvvm.data

import android.content.Context
import com.mohsen.caculatebmi_mvvm.App
import com.mohsen.caculatebmi_mvvm.R
import java.util.HashMap

class ExercisesExpandableListDataPump {
    private var context: Context? = null
    private val res = App.instance.resources
    private val expandableListDetail = HashMap<String, List<String>>()

    fun getHeaders() = expandableListDetail.keys as ArrayList<String>
    fun getData(): HashMap<String, List<String>> {


        val walking = ArrayList<String>()
        val running = ArrayList<String>()
        val bicycle = ArrayList<String>()
        val teamSport = ArrayList<String>()
        val solo = ArrayList<String>()
        val swimming = ArrayList<String>()
        val others = ArrayList<String>()
        val means = ArrayList<String>()
        val power = ArrayList<String>()
        val contest = ArrayList<String>()
        val dailyWorks = ArrayList<String>()



        walking.newAdd(R.string.going_up_steirs_fast)
        walking.newAdd(R.string.going_up_steirs_slow)
        walking.newAdd(R.string.going_up_mountains_5_to_10)
        walking.newAdd(R.string.going_up_mountains_4)
        walking.newAdd(R.string.going_up_mountains)
        walking.newAdd(R.string.walking_slow)
        walking.newAdd(R.string.walking_slow_in_water)
        walking.newAdd(R.string.walking_medium_in_water)
        walking.newAdd(R.string.spinning_ex)
        walking.newAdd(R.string.walking_and_running)
        walking.newAdd(R.string.walking_3)
        walking.newAdd(R.string.walking_5_5)
        walking.newAdd(R.string.walking_7)
        walking.newAdd(R.string.walking_on_grass)
        walking.newAdd(R.string.walking_on_sand)
        walking.newAdd(R.string.hill_climbing)
        walking.newAdd(R.string.walking_to_work_medium)
        walking.newAdd(R.string.walking_to_work_fast)
        walking.newAdd(R.string.walking_to_work_slow)
        walking.newAdd(R.string.going_down_steirs_11_22)
        walking.newAdd(R.string.going_down_steirs_23_33)
        walking.newAdd(R.string.going_down_steirs_34_45)
        walking.newAdd(R.string.walking_slow_less_than_11)
        walking.newAdd(R.string.walking_medium_less_than_11)
        walking.newAdd(R.string.walking_fast_fast_than_11)
        walking.newAdd(R.string.walking_wheelchair)
        walking.newAdd(R.string.running_so_fast)
        walking.newAdd(R.string.running_fast)
        walking.newAdd(R.string.running_medium)
        walking.newAdd(R.string.running_slow)
        walking.newAdd(R.string.roping_fast)
        walking.newAdd(R.string.roping_slow)

        //init running
        running.newAdd(R.string.running_slow_6_5)
        running.newAdd(R.string.running_so_fast_14_5)
        running.newAdd(R.string.running_so_fast_16)
        running.newAdd(R.string.running_fast_12)
        running.newAdd(R.string.running_fast_13)
        running.newAdd(R.string.running_fast_14)
        running.newAdd(R.string.running_fast_7)
        running.newAdd(R.string.running_fast_10)
        running.newAdd(R.string.running_fast_8)
        running.newAdd(R.string.running_marathon)

        //init bicycle
        bicycle.newAdd(R.string.RPM)
        bicycle.newAdd(R.string.spinning)
        bicycle.newAdd(R.string.slow_fixed_bike_35_50)
        bicycle.newAdd(R.string.so_so_fast_fixed_bike_201_270)
        bicycle.newAdd(R.string.so_fast_fixed_bike_161_200)
        bicycle.newAdd(R.string.fast_fixed_bike_101_160)
        bicycle.newAdd(R.string.medium_fixed_bike_51_89)
        bicycle.newAdd(R.string.medium_fixed_bike_90_100)
        bicycle.newAdd(R.string.bycycling)
        bicycle.newAdd(R.string.so_slow_bycycling)
        bicycle.newAdd(R.string.so_slow_bycycling_24_to_30)
        bicycle.newAdd(R.string.bycycling_in_mountains)
        bicycle.newAdd(R.string.bycycling_23_25)
        bicycle.newAdd(R.string.bycycling_more_than_32)

        // init teamSport
        teamSport.newAdd(R.string.basketball)
        teamSport.newAdd(R.string.football)
        teamSport.newAdd(R.string.vollyball)
        teamSport.newAdd(R.string.rogbey)
        teamSport.newAdd(R.string.football_pro)
        teamSport.newAdd(R.string.handball)

        //init solo
        solo.newAdd(R.string.squash)
        solo.newAdd(R.string.ski)
        solo.newAdd(R.string.skate)
        solo.newAdd(R.string.body_atack)
        solo.newAdd(R.string.body_pump)
        solo.newAdd(R.string.body_kombat)
        solo.newAdd(R.string.badminton)
        solo.newAdd(R.string.bodybuilding)
        solo.newAdd(R.string.ping_pong)
        solo.newAdd(R.string.tae_bo)
        solo.newAdd(R.string.tae_chi)
        solo.newAdd(R.string.tennis)
        solo.newAdd(R.string.TRX)
        solo.newAdd(R.string.jujitsu)
        solo.newAdd(R.string.judo)
        solo.newAdd(R.string.sit_up)
        solo.newAdd(R.string.persian_dance)
        solo.newAdd(R.string.ballet)
        solo.newAdd(R.string.tango)
        solo.newAdd(R.string.disco)
        solo.newAdd(R.string.salsa)
        solo.newAdd(R.string.arabian_dance)
        solo.newAdd(R.string.gymnastic)
        solo.newAdd(R.string.rock_climbing)
        solo.newAdd(R.string.jump_rope)
        solo.newAdd(R.string.karate)
        solo.newAdd(R.string.wrestling)
        solo.newAdd(R.string.kick_boxing)
        solo.newAdd(R.string.golf)
        solo.newAdd(R.string.muay_thai)
        solo.newAdd(R.string.weight_lifting)
        solo.newAdd(R.string.yoga)


        // init swimming
        swimming.newAdd(R.string.aerobics_in_water)
        swimming.newAdd(R.string.slow_swimming)
        swimming.newAdd(R.string.butterfly_stroke)
        swimming.newAdd(R.string.fast_swimming)
        swimming.newAdd(R.string.Breaststroke)
        swimming.newAdd(R.string.Backstroke)
        swimming.newAdd(R.string.front_crawl)
        swimming.newAdd(R.string.underwater_diving)
        swimming.newAdd(R.string.waterpolo)

        // init others :

        others.newAdd(R.string.alpine_skiing)
        others.newAdd(R.string.riding)
        others.newAdd(R.string.ice_skiing)
        others.newAdd(R.string.space_skiing)
        others.newAdd(R.string.ice_skating)
        others.newAdd(R.string.snow_board)
        others.newAdd(R.string.elliptical)
        others.newAdd(R.string.aerobics)
        others.newAdd(R.string.gardening)
        others.newAdd(R.string.bootcamp)
        others.newAdd(R.string.bowling)
        others.newAdd(R.string.pool)
        others.newAdd(R.string.pilates)


        means.add("دوچرخه ثابت، 100 وات، شدت کم)")
        means.add("دوچرخه ثابت، 150 وات، شدت معمولی)")
        means.add("دوچرخه ثابت، 200 وات، شدت بالا)")
        means.add("دوچرخه ثابت، 250 وات، شدت بسیار بالا)")
        means.add("دوچرخه ثابت، 50 وات، شدت بسیار کم)")
        means.add("قایقرانی ثابت، 100 وات، شدت متوسط")
        means.add("قایقرانی ثابت، 150 وات، شدت بالا")
        means.add("قایقرانی ثابت، 200 وات، شدت بسیار بالا")
        means.add("قایقرانی ثابت، 50 وات، شدت بسیار کم")
        means.add("ماشین اسکی معمولی")

        // init swidish
        power.add("ورزش های سوئدی")
        power.add("وزنه زدن با شدت بالا")
        power.add("وزنه زدن با شدت کم")

        //init contest
        dailyWorks.newAdd(R.string.cleaning)
        dailyWorks.newAdd(R.string.carpentry)
        dailyWorks.newAdd(R.string.welding)
        dailyWorks.newAdd(R.string.Shoemaking)
        dailyWorks.newAdd(R.string.bathing)
        dailyWorks.newAdd(R.string.Bathing)
        dailyWorks.newAdd(R.string.makingup)
        dailyWorks.newAdd(R.string.eating)
        dailyWorks.newAdd(R.string.putting_clothes_on_and_off)
        dailyWorks.newAdd(R.string.typing)
        dailyWorks.newAdd(R.string.Sewing)
        dailyWorks.newAdd(R.string.Sewing_machine)
        dailyWorks.newAdd(R.string.Sewing_hand)
        dailyWorks.newAdd(R.string.Sewing_cutting)
        dailyWorks.newAdd(R.string.standing_and_lifting_more_than_22)
        dailyWorks.newAdd(R.string.car_fixing)
        dailyWorks.newAdd(R.string.fixing_heavy_parts)
        dailyWorks.newAdd(R.string.speaking_and_standing_in_work)
        dailyWorks.newAdd(R.string.sitting)
        dailyWorks.newAdd(R.string.shovelling_5_7)
        dailyWorks.newAdd(R.string.shovelling_4)
        dailyWorks.newAdd(R.string.shovelling_7)
        dailyWorks.newAdd(R.string.shovelling)
        dailyWorks.newAdd(R.string.pulling)
        dailyWorks.newAdd(R.string.massaging)
        dailyWorks.newAdd(R.string.stone_carving)
        dailyWorks.newAdd(R.string.pressing_or_punching)
        dailyWorks.newAdd(R.string.cutting_machine)
        dailyWorks.newAdd(R.string.metal_paper)
        dailyWorks.newAdd(R.string.building_locks)
        dailyWorks.newAdd(R.string.hours_cleaning)
        dailyWorks.newAdd(R.string.keeping_jungle)
        dailyWorks.newAdd(R.string.fireman)
        dailyWorks.newAdd(R.string.farming)
        dailyWorks.newAdd(R.string.plumber)
        dailyWorks.newAdd(R.string.mining_drilling)
        dailyWorks.newAdd(R.string.house_keeping)
        dailyWorks.newAdd(R.string.napping)


        expandableListDetail[res.getString(R.string.walking) + " (" + walking.size + ")"] = walking
        expandableListDetail[res.getString(R.string.running) + " (" + running.size + ")"] = running
        expandableListDetail[res.getString(R.string.bike_riding) + " (" + bicycle.size + ")"] = bicycle
        expandableListDetail[res.getString(R.string.solo) + " (" + solo.size + ")"] = solo
        expandableListDetail[res.getString(R.string.swimming) + " (" + swimming.size + ")"] = swimming
        //expandableListDetail[res.getString(R.string.contests) + " (" + contest.size + ")"] = contest
        expandableListDetail[res.getString(R.string.power) + " (" + power.size + ")"] = power
        expandableListDetail[res.getString(R.string.daily_activities) + " (" + dailyWorks.size + ")"] = dailyWorks
        expandableListDetail[res.getString(R.string.other_activities) + " (" + others.size + ")"] = others
//        expandableListDetail["دویدن"] = running
//        expandableListDetail["دوچرخه سواری"] = bicycle
//        expandableListDetail["تیمی"] = teamSport
//        expandableListDetail["انفرادی"] = solo
//        expandableListDetail["شنا"] = swimming
//        expandableListDetail["مسابقات"] = contest
//        expandableListDetail["ورزش های قدرتی"] = power
//        expandableListDetail["فعالیت های روزانه"] = dailyWorks
//        expandableListDetail["سایر"] = others


        return expandableListDetail
    }

    fun java.util.ArrayList<String>.newAdd(id: Int) {
        add(res.getString(id))
    }
}
