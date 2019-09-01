package com.example.talentmanagementsystem.data.models

import com.example.talentmanagementsystem.network_response.Register.RegisterResponse
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class RegisterModel:BaseModel() {
    val disposable: CompositeDisposable by lazy {
        CompositeDisposable()
    }

    companion object {
        private var instance: RegisterModel? = null

        fun getInstance(): RegisterModel {
            if (instance == null) {
                instance = RegisterModel()
            }
            return instance!!
        }
    }

    fun register(
        name: String,
        email: String,
        password: String,
        confirm_password: String,
        phone: String,
        date_of_birth: String,
        module_id: Int,
        address: String,
        onSuccess: (response: RegisterResponse) -> Unit,
        onError: (error: Throwable) -> Unit
    ) {
        disposable.add(
            mApiService.register(
                email,name,password,confirm_password,date_of_birth,module_id,phone,address
            ).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    onSuccess(it)

                }, {
                    onError(it)

                })
        )
    }
}

