package android.mymovies.di.component

import android.content.Context
import android.mymovies.di.ApplicationScope
import android.mymovies.di.module.DataModule
import android.mymovies.di.module.DomainModule
import android.mymovies.di.subcomponent.ActivityComponent
import dagger.BindsInstance
import dagger.Component

@ApplicationScope
@Component(modules = [DataModule::class, DomainModule::class])
interface ApplicationComponent {

    fun activityComponentFactory(): ActivityComponent.Factory

    @Component.Factory
    interface ApplicationComponentFactory {

        fun create(
            @BindsInstance context: Context
        ): ApplicationComponent
    }
}