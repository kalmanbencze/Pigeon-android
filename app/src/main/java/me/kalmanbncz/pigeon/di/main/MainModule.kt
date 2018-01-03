package me.kalmanbncz.pigeon.di.main

import android.arch.lifecycle.LifecycleOwner
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import me.kalmanbncz.pigeon.MainNavigator
import me.kalmanbncz.pigeon.di.scopes.ActivityScoped
import me.kalmanbncz.pigeon.di.scopes.FragmentScoped
import me.kalmanbncz.pigeon.di.viewmodel.ViewModelModule
import me.kalmanbncz.pigeon.presentation.activity.MainActivity
import me.kalmanbncz.pigeon.presentation.fragment.ContactsFragment
import me.kalmanbncz.pigeon.presentation.fragment.ConversationFragment
import me.kalmanbncz.pigeon.presentation.fragment.NewMessageFragment

/**
 * Created by kalman.bencze on 07/11/2017.
 */
@Module
abstract class MainModule {

    @ActivityScoped
    @Binds
    internal abstract fun mainNavigator(activity: MainActivity): MainNavigator

    @ActivityScoped
    @Binds
    internal abstract fun lifecycleOwnerActivity(activity: MainActivity): LifecycleOwner

//    @FragmentScoped
//    @Binds
//    internal abstract fun lifecycleOwnerFragment(fragment: Fragment): LifecycleOwner

    @FragmentScoped
    @ContributesAndroidInjector(modules = arrayOf(ViewModelModule::class))
    internal abstract fun contributeConversationFragment(): ConversationFragment

    @FragmentScoped
    @ContributesAndroidInjector(modules = arrayOf(ViewModelModule::class))
    internal abstract fun contributeContactsFragment(): ContactsFragment

    @FragmentScoped
    @ContributesAndroidInjector(modules = arrayOf(ViewModelModule::class))
    internal abstract fun contributeNewMessageFragment(): NewMessageFragment

}
