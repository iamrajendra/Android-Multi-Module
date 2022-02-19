package com.iamrajendra.featue_two

import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.iamrajendra.base.data.DatabaseService
import com.iamrajendra.base.data.NetworkService
import com.iamrajendra.base.utils.InjectUtils
import com.iamrajendra.featue_two.di.compoenent.DaggerFeaturetwoComponent
import javax.inject.Inject

class FeatureTwoActivity :AppCompatActivity() {
    @Inject
    lateinit var databaseService: DatabaseService

    @Inject
    lateinit var networkService: NetworkService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_feature_two)
        DaggerFeaturetwoComponent
            .builder()
            .baseComponent(InjectUtils.provideBaseComponent(applicationContext))
            .build()
            .inject(this)
        Log.d("DaggerSample_FeatureTwo", databaseService.toString())
    }
}