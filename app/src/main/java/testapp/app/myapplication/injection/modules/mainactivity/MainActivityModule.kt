package testapp.app.myapplication.injection.modules.mainactivity

import dagger.Binds
import dagger.Module
import testapp.app.myapplication.presenter.MainActivityPresenter
import testapp.app.myapplication.ui.MainActivity

@Module
abstract class MainActivityModule {
    @Binds
    internal abstract fun provideViewMainActivity(mainActivity: MainActivity): MainActivityPresenter.ViewPresenter

    @Binds
    internal abstract fun provideRouterMainActivity(mainActivity: MainActivity): MainActivityPresenter.RouterPresenter

}
