package android.mymovies.data.repository

import android.mymovies.data.network.MainPagingSource
import android.mymovies.data.network.MoviesApiService
import android.mymovies.domain.MoviesRepository
import androidx.paging.Pager
import androidx.paging.PagingConfig
import javax.inject.Inject

class MoviesRepositoryImpl @Inject constructor(
    private val api: MoviesApiService
) : MoviesRepository {

    override fun getMovies(type: String) =
        Pager(
            PagingConfig(pageSize = 20, enablePlaceholders = false)
        ) {
            MainPagingSource(api, type)
        }.flow
}