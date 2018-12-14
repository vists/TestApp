package testapp.app.myapplication.injection.modules

import dagger.Module
import dagger.Provides
import io.reactivex.schedulers.Schedulers
import io.reactivex.android.schedulers.AndroidSchedulers
import testapp.app.myapplication.injection.annotation.Job
import testapp.app.myapplication.injection.annotation.Main
import testapp.app.myapplication.injection.provider.RetrofitServiceProvider
import javax.inject.Singleton

@Module(includes = [(AppActivitiesModule::class)])
    class AppModule {

        @Provides
        @Job
        fun provideJobScheduler() = Schedulers.computation()

        @Provides
        @Main
        fun provideMainScheduler() = AndroidSchedulers.mainThread()

        @Singleton
        @Provides
        fun provideRetrofit() = RetrofitServiceProvider()
}