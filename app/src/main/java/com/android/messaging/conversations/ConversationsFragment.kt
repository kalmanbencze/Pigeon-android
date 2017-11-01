package com.android.messaging.conversations

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.android.messaging.ViewModelFactory
import com.android.messaging.di.Injectable
import javax.inject.Inject

/**
 * Created by kalman.bencze on 01/11/2017.
 */

class ConversationsFragment : Fragment(), Injectable {

    @Inject
    internal lateinit var viewModelFactory: ViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModelFactory.create(ConversationsViewModel::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return super.onCreateView(inflater, container, savedInstanceState)
    }
}