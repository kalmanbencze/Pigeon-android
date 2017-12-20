package me.kalmanbncz.pigeon.data

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import java.util.*

/**
 * This class handles preference changes for the app
 * Created by Kalman on 10/7/2015.
 */
class ApplicationPreferences @SuppressLint("CommitPrefEdits")
constructor(context: Context) {

    /**
     * preference name
     */
    private val PREFS_NAME = "osvAppPrefs"

    /**
     * used for modifying values in a SharedPreferences prefs
     */
    private val prefsEditor: SharedPreferences.Editor

    /**
     * reference to preference
     */
    private val prefs: SharedPreferences

    init {
        prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        prefsEditor = prefs.edit()
    }

    fun getIntPreference(key: String): Int {
        return prefs.getInt(key, 0)
    }

    fun getIntPreference(key: String, def: Int): Int {
        return prefs.getInt(key, def)
    }

    fun getStringPreference(key: String): String {
        return prefs.getString(key, "")
    }

    fun getStringPreference(key: String, defValue: String): String? {
        return prefs.getString(key, defValue)
    }

    fun getBooleanPreference(key: String): Boolean {
        return prefs.getBoolean(key, false)
    }

    fun getBooleanPreference(key: String, defaultValue: Boolean): Boolean {
        return prefs.getBoolean(key, defaultValue)
    }

    fun getFloatPreference(key: String): Float {
        return prefs.getFloat(key, 0f)
    }

    fun getFloatPreference(key: String, defaultValue: Float): Float {
        return prefs.getFloat(key, defaultValue)
    }

    fun getStringSetPreference(key: String, defaultValue: Set<String>): Set<String>? {
        return prefs.getStringSet(key, defaultValue)
    }

    fun getStringSetPreference(key: String): Set<String> {
        return prefs.getStringSet(key, HashSet())
    }

    fun saveStringPreference(key: String, value: String) {
        prefsEditor.putString(key, value)
        prefsEditor.commit()
    }

    fun saveBooleanPreference(key: String, value: Boolean) {
        prefsEditor.putBoolean(key, value)
        prefsEditor.commit()
    }

    fun saveFloatPreference(key: String, value: Float) {
        prefsEditor.putFloat(key, value)
        prefsEditor.commit()
    }

    fun saveFloatPreference(key: String, value: Float, later: Boolean) {
        prefsEditor.putFloat(key, value)
        if (later) {
            prefsEditor.apply()
        } else {
            prefsEditor.commit()
        }
    }

    fun saveIntPreference(key: String, value: Int) {
        prefsEditor.putInt(key, value)
        prefsEditor.commit()
    }

    fun saveStringSetPreference(key: String, strings: Set<String>) {
        prefsEditor.putStringSet(key, strings)
        prefsEditor.commit()
    }

    fun getLiveIntPreference(key: String): PrefIntLiveData {
        return PrefIntLiveData(prefs, key, 0)
    }

    fun getLiveIntPreference(key: String, defValue: Int): PrefIntLiveData {
        return PrefIntLiveData(prefs, key, defValue)
    }

    fun getLiveStringPreference(key: String): PrefStringLiveData {
        return PrefStringLiveData(prefs, key, "")
    }

    fun getLiveStringPreference(key: String, defValue: String): PrefStringLiveData {
        return PrefStringLiveData(prefs, key, defValue)
    }

    fun getLiveLongPreference(key: String): PrefLongLiveData {
        return PrefLongLiveData(prefs, key, 0L)
    }

    fun getLiveLongPreference(key: String, defValue: Long): PrefLongLiveData {
        return PrefLongLiveData(prefs, key, defValue)
    }

    fun getLiveStringSetPreference(key: String, defValue: Set<String>): PrefStringSetLiveData {
        return PrefStringSetLiveData(prefs, key, defValue)
    }

    fun getLiveBooleanPreference(key: String): PrefBooleanLiveData {
        return PrefBooleanLiveData(prefs, key, false)
    }

    fun getLiveBooleanPreference(key: String, defValue: Boolean): PrefBooleanLiveData {
        return PrefBooleanLiveData(prefs, key, defValue)
    }

}
