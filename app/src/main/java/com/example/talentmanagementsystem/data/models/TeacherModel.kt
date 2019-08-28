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
    fun loadTeacherData(
        id:Int,
        onSuccess: (response: TeacherResponse) -> Unit,
        onError: (error: Throwable) -> Unit,token:String
    ) {
        disposable.add(
            mApiService.loadTeacherData(id).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    onSuccess(it)

                }, {
                    onError(it)
                })
        )
    }
}