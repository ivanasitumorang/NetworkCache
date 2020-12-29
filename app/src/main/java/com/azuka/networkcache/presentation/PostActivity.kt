package com.azuka.networkcache.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.azuka.networkcache.NetworkCacheApp
import com.azuka.networkcache.R
import com.azuka.networkcache.base.ViewModelFactory
import com.azuka.networkcache.presentation.adapter.PostAdapter
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
            val adapter = PostAdapter(it)
            rvPost.adapter = adapter
        })
    }

    private fun setupDI() {
        (applicationContext as NetworkCacheApp).appComponent.inject(this)
    }
}
