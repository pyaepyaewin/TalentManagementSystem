package com.example.talentmanagementsystem.data.models

import android.util.Log
import com.example.talentmanagementsystem.network_response.FeedBack.GetFeedBack.FeedbackResponse
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class FeedBackModel:BaseModel(){
    val disposable:CompositeDisposable by lazy {
        CompositeDisposable()
    }
    companion object
    {
        private var INSTANCE:FeedBackModel?=null


        fun getInstance():FeedBackModel
        {
            if(INSTANCE==null)
            {
                INSTANCE= FeedBackModel()
            }
            return INSTANCE!!
        }
    }

    fun loadFeedBack(onSuccess:(response:FeedbackResponse)->Unit,onError:(error:Throwable)->Unit, token:String)
    {
        Log.d("Api","Api@@@@@@@@")
        disposable.add(mApiService.loadFeedBackData(token)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    onSuccess(it)
                    Log.d("suc","@@@@@@@@")

                },
                {
                    onError(it)
                    Log.d("error",it.localizedMessage)
                }
            ))
    }
}