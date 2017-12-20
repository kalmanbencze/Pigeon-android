package me.kalmanbncz.pigeon.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import me.kalmanbncz.pigeon.di.main.MainModule
import me.kalmanbncz.pigeon.di.scopes.ActivityScoped
import me.kalmanbncz.pigeon.presentation.activity.MainActivity

@Module
internal abstract class ActivityBindingModule {
    @ActivityScoped
    @ContributesAndroidInjector(modules = arrayOf(MainModule::class))
    internal abstract fun contributeMainActivity(): MainActivity

}
