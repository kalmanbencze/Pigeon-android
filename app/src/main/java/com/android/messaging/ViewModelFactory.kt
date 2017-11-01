package com.android.messaging

import javax.inject.Inject
import javax.inject.Provider
import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider

/**
 * Responsible for creating the view models while with a lifecycle owner to be used with LiveData
 *
 * This class should be used together with ViewModelProvider.get(LifecycleOwner, Factory) method to instantiate the view models.
 * This way it will respect the scope of the creation and enable the lifecycle library to clean up resources such as observers.
 *
 * Custom scopes can be implemented by implementing the LifecycleRegistryOwner interface,
 * which can be injected later on through this factory class.
 * Created by kalmanb on 9/7/17.
 */
class ViewModelFactory @Inject
internal constructor(private val creators: Map<Class<out ViewModel>, Provider<ViewModel>>) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        var creator: Provider<out ViewModel>? = creators[modelClass]
        if (creator == null) {
            for ((key, value) in creators) {
                if (modelClass.isAssignableFrom(key)) {
                    creator = value
                    break
                }
            }
        }
        if (creator == null) {
            throw IllegalArgumentException("unknown model class " + modelClass)
        }
        try {
            return creator.get() as T
        } catch (e: Exception) {
            throw RuntimeException(e)
        }

    }
}
