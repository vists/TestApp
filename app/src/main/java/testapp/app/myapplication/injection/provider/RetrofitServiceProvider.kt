package testapp.app.myapplication.injection.provider

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject

class RetrofitServiceProvider{

private var service: Retrofit.Builder
private var defaultHttpClient: OkHttpClient

@Inject
constructor() {
    val httpBuilder = OkHttpClient.Builder()
    defaultHttpClient = httpBuilder.build()
    service = Retrofit.Builder()
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .client(defaultHttpClient)
            .baseUrl("https://jsonplaceholder.typicode.com/")


}
fun <T> getServiceRetrofit(clazz: Class<T>): T {
    return service.build().create(clazz)
}
}
