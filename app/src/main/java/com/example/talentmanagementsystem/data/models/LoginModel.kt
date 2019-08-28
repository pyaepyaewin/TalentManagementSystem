package com.example.talentmanagementsystem.data.models

import android.content.Context
import android.provider.ContactsContract
import com.example.talentmanagementsystem.database.LoginDataClass
import com.example.talentmanagementsystem.network_response.Activity.ActivityResponse
import com.example.talentmanagementsystem.network_response.Login.LoginResponse
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import okhttp3.internal.Internal.instance

class LoginModel : BaseModel() {

    val disposable: CompositeDisposable by lazy {
        CompositeDisposable()
    }

    companion object {
        private var instance: LoginModel? = null

        fun getInstance(): LoginModel {
            if (instance == null) {
                instance = LoginModel()
            }
            return instance!!
        }
    }
        fun login(
            email: String,
            password: String,
            onSuccess: (response: LoginResponse) -> Unit,
            onError: (error: Throwable) -> Unit
        ) {
            disposable.add(
                mApiService.login(email, password).subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe({
                        onSuccess(it)

                    }, {
                        onError(it)
                    })
            )
        }
    }



