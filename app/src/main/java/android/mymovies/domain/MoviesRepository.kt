package android.mymovies.domain

import android.mymovies.data.network.models.MoviesResponse

interface MoviesRepository {

    suspend fun getMovies(type: String) : MoviesResponse
}