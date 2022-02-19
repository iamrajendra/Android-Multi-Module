package com.iamrajendra.multi_module_arti

import android.app.Application
import com.iamrajendra.base.di.BaseComponentProvider
import com.iamrajendra.base.di.compoennt.BaseComponent
import com.iamrajendra.base.di.compoennt.DaggerBaseComponent
import com.iamrajendra.base.di.module.BaseModule

class MyApplication : Application(),BaseComponentProvider{
    lateinit var baseCompoment:BaseComponent

    override fun onCreate() {
        super.onCreate()
        baseCompoment = DaggerBaseComponent
            .builder()
            .baseModule(BaseModule())
            .build()
        baseCompoment.inject(this)
    }

    override fun provideBaseComponent(): BaseComponent {
  return  baseCompoment;
   }


}