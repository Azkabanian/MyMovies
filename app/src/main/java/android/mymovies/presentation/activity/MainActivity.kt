package android.mymovies.presentation.activity

import android.mymovies.MoviesApplication
import android.mymovies.R
import android.mymovies.presentation.viewModel.MainViewModel
import android.mymovies.presentation.viewModel.ViewModelFactory
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private val viewModel by lazy {
        ViewModelProvider(this, viewModelFactory)[MainViewModel::class.java]
    }

    private val component by lazy {
        (application as MoviesApplication).component
            .activityComponentFactory()
            .create()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        component.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel.getMovies("all")

        Log.e("qwertyuiop", viewModel.toString())
    }
}