package com.iamrajendra.featue_one.di.module

import androidx.lifecycle.ViewModel
import com.iamrajendra.featue_one.ui.viewmodel.FeatureOneViewModel
import com.iamrajendra.featue_one.ui.viewmodel.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
@Module
abstract class  ViewModelsModule {
    @Binds
    @IntoMap
    @ViewModelKey(FeatureOneViewModel::class)
    abstract fun bindAdoptedPetsViewModel(adoptedPetsViewModel: FeatureOneViewModel): ViewModel

}