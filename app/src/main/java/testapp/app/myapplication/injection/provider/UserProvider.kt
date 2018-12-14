package testapp.app.myapplication.injection.provider

import io.reactivex.Single
import testapp.app.myapplication.api.UserApi
import testapp.app.myapplication.modelpojo.UserData
import javax.inject.Inject

    class UserProvider @Inject
    constructor(retrofitServiceProvider: RetrofitServiceProvider) {
        private val mUserApi: UserApi = retrofitServiceProvider.getServiceRetrofit(UserApi::class.java)

        fun getDataUserList(): Single<List<UserData>> {
            return mUserApi.userDataList()
        }
    }