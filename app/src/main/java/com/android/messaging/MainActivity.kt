package com.android.messaging

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.android.messaging.conversations.ConversationsFragment
import com.android.messaging.di.Injectable
import java.util.prefs.Preferences
import javax.inject.Inject

class MainActivity : AppCompatActivity(), Injectable {

    @Inject
    internal lateinit var prefs: Preferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction().replace(R.id.content_holder, ConversationsFragment()).commit()
        Log.d("MainActivity", "onCreate:" + prefs)
    }
}
