package com.iamrajendra.featue_one.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject
import javax.inject.Provider

class ViewModelFactory
@Inject constructor(
    private val providers: Map<Class<out ViewModel>, @JvmSuppressWildcards Provider<ViewModel>>
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        var provider = providers[modelClass]
        if (provider == null) {
            for (entry in providers.entries) {
                if (modelClass.isAssignableFrom(entry.key)) {
                    provider = entry.value
                    break
                }
            }
        }
        return provider!!.get() as T
    }
}