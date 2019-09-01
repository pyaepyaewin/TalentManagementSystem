package com.example.talentmanagementsystem.network_response

import com.example.talentmanagementsystem.network_response.Activity.ActivityResponse
import com.example.talentmanagementsystem.network_response.AssignmentResponse.AssignmentResponse
import com.example.talentmanagementsystem.network_response.ChangePasw.ChangePasswordResponse
import com.example.talentmanagementsystem.network_response.FeedBack.GetFeedBack.FeedbackResponse
import com.example.talentmanagementsystem.network_response.FeedBack.PostFeedFack.PostFeedbackResponse
import com.example.talentmanagementsystem.network_response.Login.LoginResponse
import com.example.talentmanagementsystem.network_response.PinCode.PinCodeResponse
import com.example.talentmanagementsystem.network_response.Register.RegisterResponse
import com.example.talentmanagementsystem.network_response.Teacher.TeacherResponse

import io.reactivex.Observable
import retrofit2.http.*

interface ApiService {
    @GET("students/activities/")
    fun loadActivities(@Header("Authorization") token: String): Observable<ActivityResponse>

    @FormUrlEncoded
    @POST("login")
    fun login(@Field("email") email: String, @Field("password") password: String): Observable<LoginResponse>


    @FormUrlEncoded
    @POST("portal")
    fun loadPinCode(@Field("pin") pinCode: Int): Observable<PinCodeResponse>

    @FormUrlEncoded
    @PUT("students/change_password")
    fun changePasw(
        @Field("student_id") id: Int,
        @Field("old_password") oldPasw: String,
        @Field("new_password") newPasw: String,
        @Field("confirm_password") confirmPasw: String
    ): Observable<ChangePasswordResponse>

    @FormUrlEncoded
    @POST("register")
    fun register(
        @Field("email") email: String,
        @Field("name") name: String,
        @Field("password") password: String,
        @Field("confirm_password") confirmPassword: String,
        @Field("date_of_birth") date_of_birth: String,
        @Field("module_id") module_id: Int,
        @Field("phone") phone: String,
        @Field("address") address: String
    ): Observable<RegisterResponse>

    @GET("students/assignments/{student_id}/list")
    fun loadAssignmentData(@Header("Authorization") token: String, @Path("student_id") id: Int): Observable<AssignmentResponse>

    @GET("students/feedback")
    fun loadFeedBackData(@Header("Authorization") token: String): Observable<FeedbackResponse>


    @GET("students/teachers/{student_id}/list")
    fun loadTeacherData(@Header("Authorization") token: String,
                        @Path("student_id") id: Int): Observable<TeacherResponse>

    @FormUrlEncoded
    @POST("students/feedback/store")
    fun sendFeedBackData(@Field("student_id") student_id:Int,
                         @Field("title")title:String,
                         @Field("description")description:String,
                         @Header("Authorization") token: String):Observable<PostFeedbackResponse>

}