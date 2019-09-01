package com.example.talentmanagementsystem.data.models

import com.example.talentmanagementsystem.network_response.FeedBack.PostFeedFack.PostFeedbackResponse
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class CreateFeedbackModel:BaseModel()
{
    val disposable: CompositeDisposable by lazy {
    CompositeDisposable()
}

companion object {
    private var instance: CreateFeedbackModel? = null

    fun getInstance(): CreateFeedbackModel {
        if (instance == null) {
            instance = CreateFeedbackModel()
        }
        return instance!!
    }
}
fun sendFeedBackData(
    student_id: Int,
    title: String,
    description:String,
    onSuccess: (response: PostFeedbackResponse) -> Unit,
    onError: (error: Throwable) -> Unit,token:String
) {
    disposable.add(
        mApiService.sendFeedBackData(student_id,title,description,token).subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                onSuccess(it)

            }, {
                onError(it)
            })
    )
}
}

