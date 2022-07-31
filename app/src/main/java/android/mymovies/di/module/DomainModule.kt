package android.mymovies.di.module

import android.mymovies.data.network.MoviesApiService
import android.mymovies.data.repository.MoviesRepositoryImpl
import android.mymovies.domain.MoviesRepository
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
class DomainModule {

//    @Binds
//    fun bindsRepository(impl: MoviesRepositoryImpl): MoviesRepository

    @Provides
    fun provideMoviesRepository(api : MoviesApiService) : MoviesRepository = MoviesRepositoryImpl(api)
}