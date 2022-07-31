package android.mymovies.presentation.viewModel

import android.mymovies.data.network.MoviesApiService
import android.mymovies.domain.MoviesUseCase
import android.mymovies.domain.model.Result
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


class MainViewModel @Inject constructor(
    private val useCase: MoviesUseCase,
    val type: String
) : ViewModel() {

     fun fetchPosts(): Flow<PagingData<Result>> = useCase.invoke(type).cachedIn(viewModelScope)



//    val movies: StateFlow<PagingData<Result>> = Pager<Int, Result>(
//        config = PagingConfig(
//            pageSize = 20,
//            maxSize = 100,
//            enablePlaceholders = false
//        ),
//        pagingSourceFactory = { MainPagingSource(api, type) }
//    ).flow.stateIn(viewModelScope, SharingStarted.Lazily, PagingData.empty())

//    private val _movies = MutableLiveData(type)
//    val movies = _movies.switchMap { typeString ->
//        useCase.invoke(typeString).cachedIn(viewModelScope)
//    }
//
//    fun getMovies(type: String) = viewModelScope.launch { Log.e("GetMovies", "${movies}") }


//    val _movies: MutableLiveData<MoviesResponse> = MutableLiveData()
//    val movies: LiveData<MoviesResponse> = _movies
//
//    fun getMovies(type: String) = viewModelScope.launch {
//
//
//
//        val response = useCase.invoke(type)
//        _movies.postValue(response)
//
//        Log.e("GetMovies", "${useCase.invoke(type)}")
//    }

}