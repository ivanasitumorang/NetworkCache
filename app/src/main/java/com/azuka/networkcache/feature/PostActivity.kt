package com.azuka.networkcache.feature

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.azuka.networkcache.NetworkCacheApp
import com.azuka.networkcache.R

class PostActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        setupDI()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_post)
    }

    private fun setupDI() {
        (applicationContext as NetworkCacheApp).appComponent.inject(this)
    }
}
