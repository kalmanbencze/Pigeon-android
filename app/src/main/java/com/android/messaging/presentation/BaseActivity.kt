package com.android.messaging.presentation

import dagger.android.support.DaggerAppCompatActivity

/**
 * This activity contains generic functionality present in all activities. New activities should extend this activity.
 * Created by kalman.bencze on 20/12/2017.
 */
abstract class BaseActivity : DaggerAppCompatActivity() {

    override fun onBackPressed() {
        if (supportFragmentManager.backStackEntryCount > 1) {
            supportFragmentManager.popBackStack()
        } else {
            finish()
        }
    }
}
