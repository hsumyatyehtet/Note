package com.hmyh.note.utils

import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit

@SuppressLint("CheckResult")
fun Completable.subscribeDBWithCompletable() {
    this.subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe ({
            Log.d("Database CRUD", "Operation is successful.")
        },{
            Log.d("Database CRUD", "Operation is a failure")
        })
}


inline fun <T: Any> liveData(liveBlock: MutableLiveData<T>.() -> Unit): LiveData<T> {
    return MutableLiveData<T>().apply{
        liveBlock()
    }
}
fun Disposable.disposeBy(bag: CompositeDisposable) = bag.add(this)

fun onWait(millisec: Long, doOnNext: () -> Unit): Disposable {
   return Observable.timer(millisec, TimeUnit.MILLISECONDS)
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe {

            doOnNext()

        }
}