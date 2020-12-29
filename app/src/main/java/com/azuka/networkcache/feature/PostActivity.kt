package com.azuka.networkcache.feature

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.azuka.networkcache.NetworkCacheApp
import com.azuka.networkcache.R
import com.azuka.networkcache.base.ViewModelFactory
import kotlinx.android.synthetic.main.activity_post.*
import javax.inject.Inject

class PostActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private val viewModel: PostViewModel by lazy {
        ViewModelProvider(this, viewModelFactory).get(PostViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        setupDI()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_post)

        viewModel.getPosts()

        viewModel.postList.observe(this, {
            Log.i("Hasil", it.toString())
            tvData.text = it.toString()
        })
    }

    private fun setupDI() {
        (applicationContext as NetworkCacheApp).appComponent.inject(this)
    }
}
