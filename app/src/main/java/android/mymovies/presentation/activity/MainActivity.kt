package android.mymovies.presentation.activity

import android.mymovies.MoviesApplication
import android.mymovies.R
import android.mymovies.databinding.ActivityMainBinding
import android.mymovies.presentation.viewModel.MainViewModel
import android.mymovies.presentation.viewModel.ViewModelFactory
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    private lateinit var binding: ActivityMainBinding
    private lateinit var mainAdapter: MainAdapter

    private val viewModel by lazy {
        ViewModelProvider(this, viewModelFactory)[MainViewModel::class.java]
    }

    private val component by lazy {
        (application as MoviesApplication).component
            .activityComponentFactory()
            .create("all")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        component.inject(this)
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupRecyclerView()

        fetchPosts()

//        viewModel.movies.observe(this) {
//            mainAdapter.submitData(this.lifecycle, it)
//        }

//        viewModel.movies.observe(this){
//            mainAdapter.differ.submitList(it.results.toList())
//        }
//        viewModel.getMovies("all")
    }

    private fun fetchPosts() {
       lifecycleScope.launch {
           viewModel.fetchPosts().collectLatest { pagingData ->
               mainAdapter.submitData(pagingData)
           }
       }
    }

    private fun setupRecyclerView() {
        mainAdapter = MainAdapter()
        binding.rvMovie.apply {
            setHasFixedSize(true)
            adapter = mainAdapter
            layoutManager = LinearLayoutManager(this@MainActivity)
        }

    }
}