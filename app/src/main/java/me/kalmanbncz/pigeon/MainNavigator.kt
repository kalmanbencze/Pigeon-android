package me.kalmanbncz.pigeon

import me.kalmanbncz.pigeon.data.model.Contact

/**
 * Created by kalman.bencze on 10/11/2017.
 */
interface MainNavigator {
    fun openConversationScreen(contact: Contact)
}
