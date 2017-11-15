package com.android.messaging.di;

import com.android.messaging.di.scopes.ConversationScope;
import dagger.Component;

/**
 * Created by kalman.bencze on 07/11/2017.
 */
@ConversationScope
@Component(dependencies = AppComponent.class, modules = {ConversationModule.class})
public interface ConversationComponent {
}
