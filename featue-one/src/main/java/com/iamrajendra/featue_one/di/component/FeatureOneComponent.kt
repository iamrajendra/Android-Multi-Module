package com.iamrajendra.featue_one.di.component

import com.iamrajendra.base.di.compoennt.BaseComponent
import com.iamrajendra.featue_one.FeatureOneActivity
import com.iamrajendra.featue_one.di.module.FeatureOneModule
import com.iamrajendra.featue_one.di.module.ViewModelsModule
import com.iamrajendra.featue_one.di.scopes.FeatureOneScope
import dagger.Component

@FeatureOneScope
@Component(
    dependencies = [BaseComponent::class],
    modules = [FeatureOneModule::class, ViewModelsModule::class]
)
interface FeatureOneComponent {
    fun inject(activity: FeatureOneActivity)

}