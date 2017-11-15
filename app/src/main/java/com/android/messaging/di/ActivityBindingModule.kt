package com.android.messaging.di

import com.android.messaging.di.scopes.ActivityScoped
import com.android.messaging.presentation.activity.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
internal abstract class ActivityBindingModule {
    @ActivityScoped
    @ContributesAndroidInjector(modules = arrayOf(FragmentBindingModule::class))
    internal abstract fun contributeMainActivity(): MainActivity

}
