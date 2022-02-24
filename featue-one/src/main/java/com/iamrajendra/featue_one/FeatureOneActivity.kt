package com.iamrajendra.featue_one

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.GeneratedAdapter
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.iamrajendra.base.data.*
import com.iamrajendra.base.pojo.Post
import com.iamrajendra.base.utils.InjectUtils
import com.iamrajendra.featue_one.databinding.ActivityFeatureOneBinding
import com.iamrajendra.featue_one.di.component.DaggerFeatureOneComponent
import com.iamrajendra.featue_one.ui.GenericAdapter
import com.iamrajendra.featue_one.ui.viewmodel.FeatureOneViewModel
import com.iamrajendra.featue_one.ui.viewmodel.ViewModelFactory
import com.iamrajendra.room.dao.PostDao
import javax.inject.Inject

class FeatureOneActivity : AppCompatActivity(){

    @Inject
    lateinit var  rout: Rout
    @Inject
    lateinit var  viewModelFactory: ViewModelFactory
   var binding:ActivityFeatureOneBinding ?= null
    private val viewModel: FeatureOneViewModel by viewModels { viewModelFactory }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding  = ActivityFeatureOneBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        DaggerFeatureOneComponent
            .builder()
            .baseComponent(InjectUtils.provideBaseComponent(applicationContext))
            .build()
            .inject(this)

        binding?.list?.layoutManager = LinearLayoutManager(applicationContext)
        var adapter  = GenericAdapter(type=GenericAdapter.POST)
        binding?.list?.adapter = adapter
        viewModel.live.observe(this, Observer {
            if (it is Response.Loading){
                print("Loadingg")
                binding?.pro?.visibility = View.VISIBLE
            }
            if (it is Response.Successful){
                var list = it.data as List<Post>
                print("Success"+list.size)
                adapter.update(list)
                binding?.pro?.visibility = View.GONE

            }
        })
        viewModel.fetchPost()
        }


}