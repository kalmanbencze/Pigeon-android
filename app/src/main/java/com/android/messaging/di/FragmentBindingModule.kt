package com.android.messaging.di

import com.android.messaging.conversations.ConversationsFragment
import com.android.messaging.di.viewmodel.ViewModelModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Utility class for generating subcomponents for binding the fragments' fields
 * Created by kalmanb on 9/22/17.
 */
@Module
abstract class FragmentBindingModule {

    @ContributesAndroidInjector(modules = arrayOf(ViewModelModule::class))
    internal abstract fun contributeConversationsFragment(): ConversationsFragment
}
