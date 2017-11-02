package com.android.messaging.di.viewmodel

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.android.messaging.ViewModelFactory
import com.android.messaging.presentation.conversations.ConversationsViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
public abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(ConversationsViewModel::class)
    abstract fun bindConversationsViewModel(vm: ConversationsViewModel): ViewModel


    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}
