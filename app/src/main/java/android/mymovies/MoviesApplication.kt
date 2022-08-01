package android.mymovies

import android.app.Application
import android.mymovies.di.component.DaggerApplicationComponent

class MoviesApplication : Application() {
    
    val component by lazy {
        DaggerApplicationComponent.factory()
            .create(this)
    }
}