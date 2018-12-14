package testapp.app.myapplication.injection.modules

import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import testapp.app.myapplication.injection.annotation.PerActivity
import testapp.app.myapplication.injection.modules.mainactivity.MainActivityModule
import testapp.app.myapplication.ui.MainActivity

@Module(includes = [(AndroidSupportInjectionModule::class)])
abstract class AppActivitiesModule {

    @PerActivity
    @ContributesAndroidInjector(modules = [(MainActivityModule::class)])
    internal abstract fun mainActivityInjector(): MainActivity
}