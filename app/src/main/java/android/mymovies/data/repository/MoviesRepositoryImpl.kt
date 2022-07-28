package android.mymovies.data.repository

import android.mymovies.data.network.MoviesApiService
import android.mymovies.domain.MoviesRepository
import javax.inject.Inject

class MoviesRepositoryImpl @Inject constructor(
    private val api: MoviesApiService
): MoviesRepository {

    override suspend fun getMovies(type: String) =
        api.getMovies(type)
}