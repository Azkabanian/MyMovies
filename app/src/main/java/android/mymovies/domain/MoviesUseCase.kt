package android.mymovies.domain

import javax.inject.Inject

class MoviesUseCase @Inject constructor(
    private val repository: MoviesRepository
) {

     operator fun invoke(type: String) =
        repository.getMovies(type)

//    suspend fun operator fun invoke(type: String) =
//        repository.getMovies(type)

}