package android.mymovies.data.network

import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApiService {

    @GET("reviews/{type}.json")
    suspend fun getMovies(
        @Query("type")
        type: String = "all",
        @Query("offset")
        offset: Int,
        @Query("order")
        order: String = "by-publication-date"
    )
}