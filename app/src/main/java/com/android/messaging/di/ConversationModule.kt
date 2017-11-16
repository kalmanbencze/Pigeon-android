package com.android.messaging.di

import com.android.messaging.data.ConversationDep
import com.android.messaging.di.scopes.ConversationScope
import dagger.Module
import dagger.Provides

/**
 * Created by kalman.bencze on 07/11/2017.
 */
@Module
internal class ConversationModule {
    @Provides
    @ConversationScope
    fun provideConversationDep(): ConversationDep {
        return ConversationDep()
    }
}
