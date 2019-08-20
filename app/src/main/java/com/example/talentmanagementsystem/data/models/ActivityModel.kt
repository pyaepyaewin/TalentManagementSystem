package com.example.talentmanagementsystem.data.models

import com.example.talentmanagementsystem.network_response.Activity.ActivityResponse
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.internal.operators.single.SingleDoOnSuccess
import rx.Scheduler
import rx.schedulers.Schedulers

class ActivityModel :BaseModel(){
    private var INSTANCE:ActivityModel?=null
    var disposable = CompositeDisposable()


    fun getInstance():ActivityModel
    {
        if(INSTANCE==null)
        {
            INSTANCE= ActivityModel()
        }
        return INSTANCE!!
    }
    fun loadActivityData(onSuccess:(response:ActivityResponse)->Unit,onError:(error:Throwable)->Unit)
    {
        disposable.add(mApiService.loadActivities()
            .subscribeOn(io.reactivex.schedulers.Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    onSuccess(it)
                },
                {
                    onError(it)
                }
            ))
    }
}