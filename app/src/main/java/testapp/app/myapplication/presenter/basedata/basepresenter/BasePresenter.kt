package testapp.app.myapplication.presenter.basedata.basepresenter

import testapp.app.myapplication.presenter.basedata.router.BaseRouter
import testapp.app.myapplication.presenter.basedata.view.BaseView
import java.lang.ref.WeakReference

abstract class BasePresenter <out View : BaseView, out Router : BaseRouter>(view: View, router: Router) {

    private var mView: WeakReference<View>? = WeakReference(view)
    private var mRouter: WeakReference<Router>? = WeakReference(router)

    abstract fun init()

    abstract fun onStart()

    abstract fun onStop()

    fun getRouter(): Router? {
        return mRouter?.get()
    }

    fun getView(): View? {
        return mView?.get()
    }


}
