package com.iamrajendra.base.data

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.iamrajendra.base.utils.RxBus
import io.reactivex.functions.Consumer
import io.reactivex.internal.util.NotificationLite.accept
import io.reactivex.subjects.PublishSubject
import java.io.Serializable
import javax.inject.Singleton

@Singleton
class Rout {
    var map: HashMap<String, String> = HashMap()
    private val signal = RxBus<RoutData>()

    companion object{
        val FEATURE_ONE = "featureone"
        val FEATURE_TWO = "featuretwo"
    }
    init {
        initPath()
    }

    private fun initPath() {
        map[FEATURE_ONE] = "com.iamrajendra.featue_one.FeatureOneActivity"
        map["featureone/activityone"] = "com.iamrajendra.featue_one.FeatureOneActivity"
        map["featuretwo/activitytwo"] = "com.iamrajendra.featue_two.FeatureTwoActivity"
        map[FEATURE_TWO] = "com.iamrajendra.featue_two.FeatureTwoActivity"
    }

    fun go(path: String, data: Serializable? = null, finished: Boolean = false) {
        var d = RoutData(map.get(path), data,finished)
        signal.send(d)
    }

    fun route(activity: AppCompatActivity) {
       signal.toObservable() .subscribe( Consumer<RoutData>() {
           val c = Class.forName(it.path)
           var intent = Intent(activity, c)
           if (it.data != null) {
               intent.putExtra("data", it.data)
           }
           activity.startActivity(intent)
           if (it.finished) {
               activity.finish()
           }
        });
    }

    data class RoutData(
        val path: String?,
        val data: Serializable? = null,
        var finished: Boolean = false
    )


}