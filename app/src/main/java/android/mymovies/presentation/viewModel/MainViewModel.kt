package android.mymovies.presentation.viewModel

import android.mymovies.data.network.models.MoviesResponse
import android.mymovies.domain.MoviesUseCase
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import javax.inject.Inject


class MainViewModel @Inject constructor(
    private val useCase: MoviesUseCase
) : ViewModel() {

    val movies: MutableLiveData<MoviesResponse> = MutableLiveData()

    fun getMovies(type: String) = viewModelScope.launch {
        Log.e("GetMovies", "${useCase.getMoviesUseCase(type)}")
    }
}