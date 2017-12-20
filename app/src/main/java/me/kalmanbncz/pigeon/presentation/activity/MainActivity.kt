package me.kalmanbncz.pigeon.presentation.activity

import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import me.kalmanbncz.pigeon.MainNavigator
import me.kalmanbncz.pigeon.R
import me.kalmanbncz.pigeon.data.Preferences
import me.kalmanbncz.pigeon.data.model.Contact
import me.kalmanbncz.pigeon.presentation.BaseActivity
import me.kalmanbncz.pigeon.presentation.fragment.ContactsFragment
import me.kalmanbncz.pigeon.presentation.fragment.ConversationFragment
import javax.inject.Inject

class MainActivity : BaseActivity(), MainNavigator {
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
