package android.mymovies.di.module

import android.mymovies.data.repository.MoviesRepositoryImpl
import android.mymovies.domain.MoviesRepository
import dagger.Binds
import dagger.Module

@Module
interface DomainModule {

    @Binds
    fun bindsRepository(impl: MoviesRepositoryImpl): MoviesRepository
}