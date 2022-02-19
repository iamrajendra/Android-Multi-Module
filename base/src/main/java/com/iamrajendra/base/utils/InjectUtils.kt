package com.iamrajendra.base.utils

import android.content.Context
import com.iamrajendra.base.di.BaseComponentProvider
import com.iamrajendra.base.di.compoennt.BaseComponent

object InjectUtils {

    fun provideBaseComponent(applicationContext: Context): BaseComponent {
        return if (applicationContext is BaseComponentProvider) {
            (applicationContext as BaseComponentProvider).provideBaseComponent()
        } else {
            throw IllegalStateException("Provide the application context which implement BaseComponentProvider")
        }
    }

}