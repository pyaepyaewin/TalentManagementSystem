package com.example.talentmanagementsystem.data.models

import android.util.Log
import com.example.talentmanagementsystem.network_response.ChangePasw.ChangePasswordResponse
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class ChangePasswordModel :BaseModel(){
    val disposable: CompositeDisposable by lazy {
        CompositeDisposable()
    }

    companion object {
        private var instance: ChangePasswordModel? = null

        fun getInstance(): ChangePasswordModel {
            if (instance == null) {
                instance = ChangePasswordModel()
            }
            return instance!!
        }
    }
    fun changePassword(
        student_id:Int,
        old_password:String,
        new_password:String,
        confirm_password:String,
        onSuccess: (response: ChangePasswordResponse) -> Unit,
        onError: (error: Throwable) -> Unit
    ) {
        disposable.add(
            mApiService.changePasw(student_id,old_password,new_password,confirm_password).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    onSuccess(it)

                    Log.d("Success!!!!!!!!!","567890")
                }, {
                    onError(it)
                    Log.d("Error#####", it.localizedMessage)
                })
        )
    }
}

