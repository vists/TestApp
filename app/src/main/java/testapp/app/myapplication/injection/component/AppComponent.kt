package testapp.app.myapplication.injection.component

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import testapp.app.myapplication.App
import testapp.app.myapplication.injection.modules.AppModule
import javax.inject.Singleton

@Singleton
@Component(modules = [(AppModule::class)])
interface AppComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun context(context: Context): Builder

        fun build(): AppComponent
    }

    fun inject(app: App)
}