package com.android.messaging.di

import com.android.messaging.di.scopes.FragmentScoped
import com.android.messaging.di.viewmodel.ViewModelModule
import com.android.messaging.presentation.fragment.ContactsFragment
import com.android.messaging.presentation.fragment.ConversationFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Utility class for generating subcomponents for binding the fragments' fields
 * Created by kalmanb on 9/22/17.
 */
@Module
abstract class FragmentBindingModule {

    @FragmentScoped
    @ContributesAndroidInjector(modules = arrayOf(ViewModelModule::class))
    internal abstract fun contributeConversationsFragment(): ConversationFragment

    @FragmentScoped
    @ContributesAndroidInjector(modules = arrayOf(ViewModelModule::class))
    internal abstract fun contributeContactsFragment(): ContactsFragment
}
