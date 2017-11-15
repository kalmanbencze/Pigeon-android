package com.android.messaging.di.main

import com.android.messaging.MainNavigator
import com.android.messaging.MainNavigatorImpl
import com.android.messaging.di.scopes.ActivityScoped
import com.android.messaging.di.scopes.FragmentScoped
import com.android.messaging.di.viewmodel.ViewModelModule
import com.android.messaging.presentation.fragment.ContactsFragment
import com.android.messaging.presentation.fragment.ConversationFragment
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by kalman.bencze on 07/11/2017.
 */
@Module
abstract class MainModule {

    @ActivityScoped
    @Binds
    internal abstract fun mainNavigator(navigator: MainNavigatorImpl): MainNavigator

    @FragmentScoped
    @ContributesAndroidInjector(modules = arrayOf(ViewModelModule::class))
    internal abstract fun contributeConversationFragment(): ConversationFragment

    @FragmentScoped
    @ContributesAndroidInjector(modules = arrayOf(ViewModelModule::class))
    internal abstract fun contributeContactsFragment(): ContactsFragment

}
