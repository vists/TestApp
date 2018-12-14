package testapp.app.myapplication.interactor.baseinteractor

import io.reactivex.Scheduler
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver

abstract class BaseSingleInteractor<ResultType, ParameterType>(protected val jobScheduler: Scheduler, private val uiScheduler: Scheduler) {
    private val disposable = CompositeDisposable()

    val isDisposed: Boolean
        get() = disposable.isDisposed

    protected abstract fun buildSingle(parameter: ParameterType): Single<ResultType>

    fun execute(parameter: ParameterType, observer: DisposableSingleObserver<ResultType>) {
        disposable.add(buildSingle(parameter)
                .subscribeOn(jobScheduler)
                .observeOn(uiScheduler)
                .subscribeWith(observer))
    }

    fun unsubscribe() {
        disposable.dispose()
    }
}
