package android.mymovies.domain

import javax.inject.Inject

class MoviesUseCase @Inject constructor(
    private val repository: MoviesRepository
) {

    suspend fun getMoviesUseCase(
        type: String
    ) {
        repository.getMovies(type)
    }
}