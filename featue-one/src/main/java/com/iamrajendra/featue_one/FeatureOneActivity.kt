package com.iamrajendra.featue_one

import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.iamrajendra.base.data.DatabaseService
import com.iamrajendra.base.data.NetworkService
import com.iamrajendra.base.data.Rout
import com.iamrajendra.base.utils.InjectUtils
import com.iamrajendra.featue_one.di.component.DaggerFeatureOneComponent
import javax.inject.Inject

class FeatureOneActivity : AppCompatActivity(){
    @Inject
    lateinit var databaseService: DatabaseService

    @Inject
    lateinit var networkService: NetworkService
    @Inject
    lateinit var  rout: Rout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_feature_one)
        DaggerFeatureOneComponent
            .builder()
            .baseComponent(InjectUtils.provideBaseComponent(applicationContext))
            .build()
            .inject(this)
        Log.d("DaggerSample_FeatureOne", databaseService.toString())
        var button:Button  = findViewById<Button>(R.id.button)
             button.setOnClickListener( {
           rout.go("featuretwo")

        });
    }

}