package com.azuka.networkcache

import android.app.Application
import com.azuka.networkcache.di.DaggerAppComponent


/**
 * Created by ivanaazuka on 29/12/20.
 * Android Engineer
 */

open class NetworkCacheApp : Application() {

    val appComponent = DaggerAppComponent.factory().create(applicationContext)
}