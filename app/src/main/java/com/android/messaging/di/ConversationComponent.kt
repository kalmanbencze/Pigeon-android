package com.android.messaging.di

import com.android.messaging.di.scopes.ConversationScope
import dagger.Component

/**
 * Created by kalman.bencze on 07/11/2017.
 */
@ConversationScope
@Component(dependencies = arrayOf(AppComponent::class), modules = arrayOf(ConversationModule::class))
interface ConversationComponent
