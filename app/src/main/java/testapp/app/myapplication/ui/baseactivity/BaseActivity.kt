package testapp.app.myapplication.ui.baseactivity

import android.app.Activity
import android.support.v7.app.AppCompatActivity
import dagger.android.AndroidInjection
import dagger.android.support.HasSupportFragmentInjector
import android.support.v4.app.Fragment
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import javax.inject.Inject

abstract class BaseActivity : AppCompatActivity(), HasSupportFragmentInjector {

    @Inject
    lateinit var  mFragmentInjector: DispatchingAndroidInjector<Fragment>

    protected fun inject(childActivity: Activity) {
        AndroidInjection.inject(childActivity)
    }

    override fun supportFragmentInjector(): AndroidInjector<Fragment> {
        return mFragmentInjector
    }

}