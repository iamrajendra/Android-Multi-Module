package com.iamrajendra.featue_two.di.compoenent

import androidx.appcompat.app.AppCompatActivity
import com.iamrajendra.base.di.compoennt.BaseComponent
import com.iamrajendra.featue_two.FeatureTwoActivity
import com.iamrajendra.featue_two.di.module.FeatureTwoModule
import com.iamrajendra.featue_two.di.module.FeatureTwoScope
import dagger.Component

@FeatureTwoScope
@Component(
    dependencies = [BaseComponent::class],
    modules = [FeatureTwoModule::class]
)
interface FeaturetwoComponent {
fun  inject(activity: FeatureTwoActivity)
}