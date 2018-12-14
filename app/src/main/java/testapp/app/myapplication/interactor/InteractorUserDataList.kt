package testapp.app.myapplication.interactor

import io.reactivex.Scheduler
import io.reactivex.Single
import testapp.app.myapplication.injection.annotation.Job
import testapp.app.myapplication.injection.annotation.Main
import testapp.app.myapplication.injection.provider.UserProvider
import testapp.app.myapplication.interactor.baseinteractor.BaseSingleInteractor
import testapp.app.myapplication.modelpojo.DataForRepUser
import testapp.app.myapplication.modelpojo.UserData
import javax.inject.Inject

class InteractorUserDataList
    @Inject
constructor(@Job jobScheduler: Scheduler,
            @Main uiScheduler: Scheduler,
            private val userProvider: UserProvider) : BaseSingleInteractor<List<UserData>, DataForRepUser>(jobScheduler, uiScheduler) {

    override fun buildSingle(parameter: DataForRepUser): Single<List<UserData>> {
        return userProvider.getDataUserList()
    }

}