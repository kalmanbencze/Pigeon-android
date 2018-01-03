package me.kalmanbncz.pigeon.di.viewmodel

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import me.kalmanbncz.pigeon.presentation.viewmodel.ContactsViewModel
import me.kalmanbncz.pigeon.presentation.viewmodel.ConversationViewModel
import me.kalmanbncz.pigeon.presentation.viewmodel.NewMessageViewModel
import me.kalmanbncz.pigeon.presentation.viewmodel.ViewModelFactory

@Module
public abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(ConversationViewModel::class)
    abstract fun bindConversationsViewModel(vm: ConversationViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(ContactsViewModel::class)
    abstract fun bindContactsViewModel(vm: ContactsViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(NewMessageViewModel::class)
    abstract fun bindNewMessageViewModel(vm: NewMessageViewModel): ViewModel


    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}
