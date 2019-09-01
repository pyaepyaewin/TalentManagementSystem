package com.example.talentmanagementsystem.data.models

import com.example.talentmanagementsystem.network_response.Teacher.TeacherResponse
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class TeacherModel:BaseModel() {
    val disposable: CompositeDisposable by lazy {
        CompositeDisposable()
    }

    companion object {
        private var instance: TeacherModel? = null

        fun getInstance(): TeacherModel {
            if (instance == null) {
                instance = TeacherModel()
            }
            return instance!!
        }
    }
    fun loadTeacherData(token:String,
        id:Int,
        onSuccess: (response: TeacherResponse) -> Unit,
        onError: (error: Throwable) -> Unit
    ) {
        disposable.add(
            mApiService.loadTeacherData(token,id).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    onSuccess(it)

                }, {
                    onError(it)
                })
        )
    }
}