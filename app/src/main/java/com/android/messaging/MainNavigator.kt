package com.android.messaging

import com.android.messaging.data.model.Contact

/**
 * Created by kalman.bencze on 10/11/2017.
 */
interface MainNavigator {
    fun openConversationScreen(contact: Contact)
}
