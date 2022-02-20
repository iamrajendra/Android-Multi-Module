package com.iamrajendra.multi_module_arti.main

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.iamrajendra.base.data.DatabaseService
import com.iamrajendra.base.data.NetworkService
import com.iamrajendra.base.data.Rout
import com.iamrajendra.base.utils.InjectUtils
import com.iamrajendra.multi_module_arti.R
import com.iamrajendra.multi_module_arti.di.component.DaggerMainActivityComponent
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
@Inject
lateinit var databaseService: DatabaseService
@Inject
lateinit var  networkService: NetworkService
@Inject
lateinit var  rout: Rout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        DaggerMainActivityComponent
            .builder()
            .baseComponent(InjectUtils.provideBaseComponent(applicationContext))
            .build()
            .inject(this)
        Log.d("DaggerSample_Main", databaseService.toString())
        rout.route(this)

        rout.go(Rout.FEATURE_ONE)

    }

    override fun onStart() {
        super.onStart()
    }

}