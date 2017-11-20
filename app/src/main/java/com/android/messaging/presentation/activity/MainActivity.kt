package com.android.messaging.presentation.activity

import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import com.android.messaging.MainNavigator
import com.android.messaging.R
import com.android.messaging.data.Preferences
import com.android.messaging.data.model.Contact
import com.android.messaging.presentation.fragment.ContactsFragment
import com.android.messaging.presentation.fragment.ConversationFragment
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity(), MainNavigator {
    override fun openConversationScreen(contact: Contact) {
        openFragment(ConversationFragment.get(contact), ConversationFragment.TAG)
    }

    private fun openFragment(fragment: Fragment, tag: String) {
        supportFragmentManager.beginTransaction().replace(R.id.content_holder, fragment).addToBackStack(tag).commit()
    }

    @Inject
    internal lateinit var prefs: Preferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        openFragment(ContactsFragment(), ContactsFragment.TAG)
        Log.d("MainActivity", "onCreate:" + prefs)

    }

    override fun onBackPressed() {
        if (supportFragmentManager.backStackEntryCount <= 1) {
            finish()
        } else {
            super.onBackPressed()
        }
    }
}
