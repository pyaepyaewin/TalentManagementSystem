package com.example.talentmanagementsystem.data.models

import android.util.Log
import android.widget.Toast

import com.example.talentmanagementsystem.network_response.AssignmentResponse.AssignmentResponse
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class AssignmentModel : BaseModel() {
private var INSTANCE:AssignmentModel?=null
    var disposable=CompositeDisposable()
    fun getInstance():AssignmentModel
    {
        if(INSTANCE==null)
        {
            INSTANCE= AssignmentModel()
        }
        return INSTANCE!!
    }

    fun loadAssignmentList(onSuccess: (response: AssignmentResponse)->Unit,
                           onError:(error:Throwable)->Unit, token:String, id:Int) {
        disposable.add(mApiService.loadAssignmentData(token, id).subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    onSuccess(it)
                },
                {
                    // onError()
                    //Log.d("Error displayer", it.localizedMessage)
                }
            ))
    }

}