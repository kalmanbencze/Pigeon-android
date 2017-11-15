package com.android.messaging.presentation.activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import com.android.messaging.R
import com.android.messaging.data.Preferences
import com.android.messaging.presentation.fragment.ContactsFragment
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity() {

    @Inject
    internal lateinit var prefs: Preferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction().replace(R.id.content_holder, ContactsFragment()).addToBackStack(ContactsFragment.TAG).commit()
        Log.d("MainActivity", "onCreate:" + prefs)

    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
    }

    override fun onBackPressed() {
        if (supportFragmentManager.backStackEntryCount <= 1) {
            finish()
        } else {
            super.onBackPressed()
        }
    }
}
