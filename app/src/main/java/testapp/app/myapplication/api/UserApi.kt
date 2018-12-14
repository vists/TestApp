package testapp.app.myapplication.api

import io.reactivex.Single
import retrofit2.http.GET
import testapp.app.myapplication.modelpojo.UserData


interface UserApi {
    @GET("comments")
    fun userDataList() : Single<List<UserData>>
}