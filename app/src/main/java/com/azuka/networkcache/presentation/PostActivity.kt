package com.azuka.networkcache.presentation

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
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
            it?.let {
                val adapter = PostAdapter(it)
                rvPost.adapter = adapter
            }

        })
    }

    private val onQueryTextListener = object : SearchView.OnQueryTextListener {
        override fun onQueryTextSubmit(p0: String?): Boolean = false

        override fun onQueryTextChange(p0: String?): Boolean {
            if (!p0.isNullOrEmpty()) {
                viewModel.getPosts(query = p0)
            }
            return true
        }
    }

    private val onActionExpandListener = object : MenuItem.OnActionExpandListener {
        override fun onMenuItemActionExpand(p0: MenuItem?): Boolean = true

        override fun onMenuItemActionCollapse(p0: MenuItem?): Boolean {
            viewModel.getPosts()
            return true
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_home, menu)

        val searchItem: MenuItem? = menu?.findItem(R.id.action_search)
        val searchView: SearchView = searchItem?.actionView as SearchView
        searchView.setOnQueryTextListener(onQueryTextListener)
        searchItem.setOnActionExpandListener(onActionExpandListener)

        return true
    }

    private fun setupDI() {
        (applicationContext as NetworkCacheApp).appComponent.inject(this)
    }
}
