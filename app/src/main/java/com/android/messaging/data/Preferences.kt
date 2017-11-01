package com.android.messaging.data

import javax.inject.Inject

/**
 * Class for handling preferences easily
 * Created by kalmanb on 9/14/17.
 */
class Preferences @Inject
constructor(private val prefs: ApplicationPreferences) : PreferenceTypes, VersionPreferences, RunPreferences {

    // version related

    override var versionName: String
        get() = prefs.getStringPreference(PreferenceTypes.K_VERSION_NAME)
        set(versionName) = prefs.saveStringPreference(PreferenceTypes.K_VERSION_NAME, versionName)

    override var versionCode: Int
        get() = prefs.getIntPreference(PreferenceTypes.K_VERSION_CODE)
        set(versionCode) = prefs.saveIntPreference(PreferenceTypes.K_VERSION_CODE, versionCode)

    override var versionCodeForSdk: Int
        get() = prefs.getIntPreference(PreferenceTypes.K_SDK_VERSION_CODE)
        set(version) = prefs.saveIntPreference(PreferenceTypes.K_SDK_VERSION_CODE, version)
    /*
   * this value will be true only if it's called for the first time
   **/
    override val isFirstRun: Boolean
        get() {
            val value = prefs.getBooleanPreference(PreferenceTypes.K_FIRST_RUN, true)
            if (value) {
                prefs.saveBooleanPreference(PreferenceTypes.K_FIRST_RUN, false)
            }
            return value
        }

    var ffmpegCrashCounter: Int
        get() = prefs.getIntPreference(PreferenceTypes.K_FFMPEG_CRASH_COUNTER)
        set(value) = prefs.saveIntPreference(PreferenceTypes.K_FFMPEG_CRASH_COUNTER, value)

    override var restartCounter: Int
        get() = prefs.getIntPreference(PreferenceTypes.K_RESTART_COUNTER)
        set(value) = prefs.saveIntPreference(PreferenceTypes.K_RESTART_COUNTER, value)

    override var crashed: Boolean
        get() = prefs.getBooleanPreference(PreferenceTypes.K_CRASHED)
        set(value) = prefs.saveBooleanPreference(PreferenceTypes.K_CRASHED, value)
}
