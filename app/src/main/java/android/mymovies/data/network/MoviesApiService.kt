package android.mymovies.data.network

import android.mymovies.common.Constants.Companion.API_KEY
import android.mymovies.data.network.models.MoviesResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface MoviesApiService {

    @GET("v2/reviews/all.json")
    suspend fun getMovies(
        @Query("type")
        type: String = "all",
        @Query("api-key")
        apiKey: String = API_KEY
    ): MoviesResponse
}