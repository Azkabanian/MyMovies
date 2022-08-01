package android.mymovies.domain

import android.mymovies.domain.model.MoviesResponse
import android.mymovies.domain.model.Result
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.paging.Pager
import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow

interface MoviesRepository {

     fun getMovies(type: String): Flow<PagingData<Result>>

//    fun getMovies(type: String) : MoviesResponse
}