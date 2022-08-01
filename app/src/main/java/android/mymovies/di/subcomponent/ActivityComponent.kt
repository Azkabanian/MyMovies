package android.mymovies.di.subcomponent

import android.mymovies.data.network.MoviesApiService
import android.mymovies.di.module.ViewModelModule
import android.mymovies.presentation.activity.MainActivity
import dagger.BindsInstance
import dagger.Subcomponent

@Subcomponent(modules = [ViewModelModule::class])
interface ActivityComponent {

    fun inject(activity: MainActivity)

    @Subcomponent.Factory
    interface Factory {

        fun create(
            @BindsInstance type: String
        ): ActivityComponent
    }
}