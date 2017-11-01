package com.android.messaging.conversations

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel

/**
 * Created by kalman.bencze on 01/11/2017.
 */
class ConversationsViewModel(
        val message: LiveData<String>,
        val title: LiveData<String>
) : ViewModel() {
}
