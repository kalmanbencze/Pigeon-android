package com.android.messaging.di

import android.arch.lifecycle.LiveData
import com.android.messaging.data.model.Contact
import com.android.messaging.data.repository.ContactRepository
import com.android.messaging.di.scopes.FragmentScoped
import com.android.messaging.presentation.fragment.ConversationFragment
import dagger.Module
import dagger.Provides

/**
 * Created by kalman.bencze on 07/11/2017.
 */
@Module
internal class ConversationModule {
    @FragmentScoped
    @Provides
    fun provideContact(repo: ContactRepository, fragment: ConversationFragment): LiveData<Contact> =
            repo.getContact(fragment.arguments?.getInt(ConversationFragment.EXTRA_CONTACT_ID)!!)
}
