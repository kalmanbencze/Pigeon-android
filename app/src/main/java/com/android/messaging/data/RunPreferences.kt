package com.android.messaging.data

/**
 * Class for handling preferences easily
 * Created by kalmanb on 9/14/17.
 */
interface RunPreferences {

    val isFirstRun: Boolean

    var restartCounter: Int

    var crashed: Boolean
}
