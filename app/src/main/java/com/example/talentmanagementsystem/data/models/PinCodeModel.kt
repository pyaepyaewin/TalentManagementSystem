package com.example.talentmanagementsystem.data.models

import com.example.talentmanagementsystem.network_response.PinCode.PinCodeResponse
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class PinCodeModel:BaseModel() {
    val disposable: CompositeDisposable by lazy {
        CompositeDisposable()
    }

    companion object {
        private var instance: PinCodeModel? = null

        fun getInstance(): PinCodeModel {
            if (instance == null) {
                instance = PinCodeModel()
            }
            return instance!!
        }
    }
    fun sendPinCode(
        pin: Int,
        onSuccess: (response: PinCodeResponse) -> Unit,
        onError: (error: Throwable) -> Unit
    ) {
        disposable.add(
            mApiService.loadPinCode(pin).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    onSuccess(it)

                }, {
                    onError(it)
                })
        )
    }
}


