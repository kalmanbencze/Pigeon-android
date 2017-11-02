package com.android.messaging.presentation.activity

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.android.messaging.R
import com.android.messaging.data.Preferences
import com.android.messaging.di.Injectable
import com.android.messaging.presentation.fragment.ConversationFragment
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject

class MainActivity : AppCompatActivity(), Injectable, HasSupportFragmentInjector {
    @Inject
    lateinit var fragmentInjector: DispatchingAndroidInjector<Fragment>

    override fun supportFragmentInjector(): DispatchingAndroidInjector<Fragment> {
        return fragmentInjector
    }

    @Inject
    internal lateinit var prefs: Preferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction().replace(R.id.content_holder, ConversationFragment()).addToBackStack(ConversationFragment.TAG).commit()
        Log.d("MainActivity", "onCreate:" + prefs)

    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
    }

}
