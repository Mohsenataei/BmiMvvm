package com.mohsen.caculatebmi_mvvm.util

import android.content.Context
import android.content.SharedPreferences
import com.google.gson.GsonBuilder

class SavedSharedPrerefrences(c: Context) {
    private val SKIP_FIRST = "skip_first"
    private val preferences = c.getSharedPreferences("MODEL_PREFERENCES", Context.MODE_PRIVATE)
    private val editor = preferences.edit()

    private val gson = GsonBuilder().create()
    private var PRIVATE_MODE = 0
    private val PREF_NAME = "mindorks-welcome"
    val sharedPref: SharedPreferences = c.getSharedPreferences(PREF_NAME, PRIVATE_MODE)

    /**
     * Saves object into the Preferences.
     * Only the fields are stored. Methods, Inner classes, Nested classes and inner interfaces are not stored.
     **/
    fun <T> putObject(key: String, y: T) {        //Convert object to JSON String.
        val inString = gson.toJson(y)        //Save that String in SharedPreferences
        editor.putString(key, inString).commit()
    }

    fun setFisrtAdd(b: Boolean){
        editor.putBoolean(SKIP_FIRST,b)
        editor.apply()
    }

    fun getFirstAdd(): Boolean{
        return preferences.getBoolean(SKIP_FIRST,false)
    }

    /**
     * Saves collection of objects into the Preferences.
     * Only the fields are stored. Methods, Inner classes, Nested classes and inner interfaces are not stored.
     **/

    fun <T> getObject(key: String, c: Class<T>): T? {        //We read JSON String which was saved.
        val value = preferences.getString(key, null)
        if (value != null) {
            //JSON String was found which means object can be read.
            // We convert this JSON String to model object. Parameter "c" (of type Class<T>" is used to cast.
            return gson.fromJson(value, c)
        } else {
            //No JSON String with this key was found which means key is invalid or object was not saved.
            throw IllegalArgumentException("No object with key: $key was saved")
        }
    }
}