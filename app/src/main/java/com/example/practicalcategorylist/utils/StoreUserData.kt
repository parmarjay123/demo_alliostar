package com.church.utils

import android.content.Context
import android.content.SharedPreferences

/**
 * Created by keval pandya on 15-08-2016.
 */
class StoreUserData(private val parentActivity: Context) {
    private var pref: SharedPreferences? = null
    var APP_KEY = parentActivity.packageName.replace("\\.".toRegex(), "_").toLowerCase()


    fun setString(key: String, value: String) {
        pref = parentActivity.getSharedPreferences(
            APP_KEY,
            Context.MODE_PRIVATE
        )
        val editor = pref!!.edit()
        editor.putString(key, value)
        editor.apply()
    }

    fun getString(key: String): String {
        pref = parentActivity.getSharedPreferences(
            APP_KEY,
            Context.MODE_PRIVATE
        )
        return when {
            key.equals(Constants.USER_LANGUAGE, true) -> {
                pref!!.getString(key, "en")!!
            }
            key.equals(Constants.USER_TOKEN, true) -> {
                if (pref!!.getString(key, "")!!.isNullOrEmpty())
                {
                    pref!!.getString(key, "")!!
                }
                else
                {
                    "Bearer "+pref!!.getString(key, "")!!
                }

            }
            else -> {
                pref!!.getString(key, "")!!
            }
        }



    }

    fun setDouble(key: String, value: Double) {
        pref = parentActivity.getSharedPreferences(
            APP_KEY,
            Context.MODE_PRIVATE
        )
        val editor = pref!!.edit()
        editor.putString(key, value.toString() + "")
        editor.apply()
    }

    fun getDouble(key: String): Double? {
        pref = parentActivity.getSharedPreferences(
            APP_KEY,
            Context.MODE_PRIVATE
        )
        return if (pref!!.getString(key, "")!!.isNotEmpty()) {
            java.lang.Double.parseDouble(pref!!.getString(key, "")!!)
        } else {
            null
        }
    }

    fun setBoolean(key: String, value: Boolean) {
        pref = parentActivity.getSharedPreferences(
            APP_KEY,
            Context.MODE_PRIVATE
        )
        val editor = pref!!.edit()
        editor.putBoolean(key, value)
        editor.apply()
    }

    fun getBoolean(key: String): Boolean {
        pref = parentActivity.getSharedPreferences(
            APP_KEY,
            Context.MODE_PRIVATE
        )
        return pref!!.getBoolean(key, false)
    }


    fun setInt(key: String, value: Int) {
        pref = parentActivity.getSharedPreferences(
            APP_KEY,
            Context.MODE_PRIVATE
        )
        val editor = pref!!.edit()
        editor.putInt(key, value)
        editor.apply()
    }

    fun getInt(key: String): Int {
        pref = parentActivity.getSharedPreferences(
            APP_KEY,
            Context.MODE_PRIVATE
        )
        return pref!!.getInt(key, -1)
    }

    fun setLong(key: String, value: Long) {
        pref = parentActivity.getSharedPreferences(
            APP_KEY,
            Context.MODE_PRIVATE
        )
        val editor = pref!!.edit()
        editor.putLong(key, value)
        editor.commit()
    }

    fun getLong(key: String): Long {
        pref = parentActivity.getSharedPreferences(
            APP_KEY,
            Context.MODE_PRIVATE
        )
        return pref!!.getLong(key, -1)
    }

    fun is_exist(key: String): Boolean {
        pref = parentActivity.getSharedPreferences(
            APP_KEY,
            Context.MODE_PRIVATE
        )
        return pref!!.contains(key)
    }

    fun clearData() {
        var token =getString(Constants.USER_FCM)
        val settings = parentActivity.getSharedPreferences(APP_KEY, Context.MODE_PRIVATE)
        settings.edit().clear().apply()
        setString(Constants.USER_FCM,token)
    }

}
