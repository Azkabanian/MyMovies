package android.mymovies.data.network.models

data class MovieResponse(
    val copyright: String,
    val has_more: Boolean,
    val num_results: Int,
    val results: List<Result>,
    val status: String
)