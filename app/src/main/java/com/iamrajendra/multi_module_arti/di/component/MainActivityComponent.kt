package com.iamrajendra.multi_module_arti.di.component

import android.app.Activity
import com.iamrajendra.base.di.compoennt.BaseComponent
import com.iamrajendra.multi_module_arti.di.module.MainActivityModule
import com.iamrajendra.multi_module_arti.di.scopes.MainActivityScope
import com.iamrajendra.multi_module_arti.main.MainActivity
import dagger.Component

@MainActivityScope
@Component(
    dependencies = [BaseComponent::class],
modules = [MainActivityModule::class]
    )
interface MainActivityComponent {
fun inject(activity: MainActivity)
}