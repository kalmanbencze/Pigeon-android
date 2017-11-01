package com.android.messaging.data


import android.arch.lifecycle.LiveData
import android.content.SharedPreferences

abstract class PrefLiveData<T>(val sharedPrefs: SharedPreferences,
                               val key: String,
                               val defValue: T) : LiveData<T>() {

    private val preferenceChangeListener = SharedPreferences.OnSharedPreferenceChangeListener { sharedPreferences, key ->
        if (key == this.key) {
            value = getValueFromPreferences(key, defValue)
        }
    }

    abstract fun getValueFromPreferences(key: String, defValue: T): T

    override fun onActive() {
        super.onActive()
        value = getValueFromPreferences(key, defValue)
        sharedPrefs.registerOnSharedPreferenceChangeListener(preferenceChangeListener)
    }

    override fun onInactive() {
        sharedPrefs.unregisterOnSharedPreferenceChangeListener(preferenceChangeListener)
        super.onInactive()
    }
}

class PrefIntLiveData(sharedPrefs: SharedPreferences, key: String, defValue: Int) :
        PrefLiveData<Int>(sharedPrefs, key, defValue) {
    override fun getValueFromPreferences(key: String, defValue: Int): Int = sharedPrefs.getInt(key, defValue)
}

class PrefStringLiveData(sharedPrefs: SharedPreferences, key: String, defValue: String) :
        PrefLiveData<String>(sharedPrefs, key, defValue) {
    override fun getValueFromPreferences(key: String, defValue: String): String = sharedPrefs.getString(key, defValue)
}

class PrefBooleanLiveData(sharedPrefs: SharedPreferences, key: String, defValue: Boolean) :
        PrefLiveData<Boolean>(sharedPrefs, key, defValue) {
    override fun getValueFromPreferences(key: String, defValue: Boolean): Boolean = sharedPrefs.getBoolean(key, defValue)
}

class PrefFloatLiveData(sharedPrefs: SharedPreferences, key: String, defValue: Float) :
        PrefLiveData<Float>(sharedPrefs, key, defValue) {
    override fun getValueFromPreferences(key: String, defValue: Float): Float = sharedPrefs.getFloat(key, defValue)
}

class PrefLongLiveData(sharedPrefs: SharedPreferences, key: String, defValue: Long) :
        PrefLiveData<Long>(sharedPrefs, key, defValue) {
    override fun getValueFromPreferences(key: String, defValue: Long): Long = sharedPrefs.getLong(key, defValue)
}

class PrefStringSetLiveData(sharedPrefs: SharedPreferences, key: String, defValue: Set<String>) :
        PrefLiveData<Set<String>>(sharedPrefs, key, defValue) {
    override fun getValueFromPreferences(key: String, defValue: Set<String>): Set<String> = sharedPrefs.getStringSet(key, defValue)
}

fun SharedPreferences.intLiveData(key: String, defValue: Int): PrefLiveData<Int> {
    return PrefIntLiveData(this, key, defValue)
}
fun SharedPreferences.stringLiveData(key: String, defValue: String): PrefLiveData<String> {
    return PrefStringLiveData(this, key, defValue)
}
fun SharedPreferences.booleanLiveData(key: String, defValue: Boolean): PrefLiveData<Boolean> {
    return PrefBooleanLiveData(this, key, defValue)
}
fun SharedPreferences.floatLiveData(key: String, defValue: Float): PrefLiveData<Float> {
    return PrefFloatLiveData(this, key, defValue)
}
fun SharedPreferences.longLiveData(key: String, defValue: Long): PrefLiveData<Long> {
    return PrefLongLiveData(this, key, defValue)
}
fun SharedPreferences.stringSetLiveData(key: String, defValue: Set<String>): PrefLiveData<Set<String>> {
    return PrefStringSetLiveData(this, key, defValue)
}