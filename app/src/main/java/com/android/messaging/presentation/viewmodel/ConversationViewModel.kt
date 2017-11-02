package com.android.messaging.presentation.viewmodel

import android.arch.lifecycle.ViewModel
import com.android.messaging.data.Preferences
import javax.inject.Inject

/**
 * Created by kalman.bencze on 01/11/2017.
 */
class ConversationViewModel @Inject
internal constructor(
        val prefs: Preferences
) : ViewModel() {
}
