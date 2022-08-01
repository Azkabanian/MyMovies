package android.mymovies.data.network

import android.mymovies.common.Constants.Companion.STARTING_PAGE_INDEX
import android.mymovies.domain.model.Result
import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import okio.IOException
import retrofit2.HttpException
import javax.inject.Inject


class MainPagingSource @Inject constructor(
    private val moviesApi: MoviesApiService,
    private val type: String
) : PagingSource<Int, Result>() {


    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Result> {

        val position = params.key ?: STARTING_PAGE_INDEX
        Log.e("params", "${position}")

        return try {
            val response = moviesApi.getMovies(type)
            val movies = response.results

            LoadResult.Page(
                data = movies,
                prevKey = if (position == STARTING_PAGE_INDEX) null else position - 1,
                nextKey = position.plus(1)
            )
        } catch (exception: IOException) {
            LoadResult.Error(exception)
        } catch (exception: HttpException) {
            LoadResult.Error(exception)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Result>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }
}