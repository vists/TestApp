package testapp.app.myapplication.presenter

import io.reactivex.annotations.NonNull
import io.reactivex.observers.DisposableSingleObserver
import testapp.app.myapplication.interactor.InteractorUserDataList
import testapp.app.myapplication.modelpojo.DataForRepUser
import testapp.app.myapplication.modelpojo.UserData
import testapp.app.myapplication.presenter.basedata.basepresenter.BasePresenter
import testapp.app.myapplication.presenter.basedata.router.BaseRouter
import testapp.app.myapplication.presenter.basedata.view.BaseView
import javax.inject.Inject

class MainActivityPresenter

@Inject constructor(interactUserDataList: InteractorUserDataList, view: ViewPresenter, router: RouterPresenter) : BasePresenter<MainActivityPresenter.ViewPresenter, MainActivityPresenter.RouterPresenter>(view, router) {

    private var mInteractUserDataList : InteractorUserDataList = interactUserDataList

    override fun init() {
        getDataUserList()
    }

    override fun onStart() {

    }

    override fun onStop() {
        mInteractUserDataList.unsubscribe()
    }

    private fun getDataUserList() {
        mInteractUserDataList.execute(DataForRepUser(), object : DisposableSingleObserver<List<UserData>>() {
            override fun onSuccess(userList: List<UserData>) {
                    if(!userList.isEmpty())
                        getView()?.onSetItems(userList)
            }

            override fun onError(@NonNull throwable: Throwable) {
            }
        })

    }

    interface ViewPresenter : BaseView{
        fun onSetItems(listData:List<UserData>)
    }

    interface RouterPresenter : BaseRouter
}