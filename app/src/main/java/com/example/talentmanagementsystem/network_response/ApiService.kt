package com.example.talentmanagementsystem.network_response

import com.example.talentmanagementsystem.network_response.Activity.ActivityResponse
import com.example.talentmanagementsystem.network_response.Assignment.AssignmentResponse
import com.example.talentmanagementsystem.network_response.ChangePasw.ChangePaswResponse
import com.example.talentmanagementsystem.network_response.Login.LoginResponse
import com.example.talentmanagementsystem.network_response.PinCode.PinCodeResponse
import com.example.talentmanagementsystem.network_response.Register.RegisterResponse
import com.example.talentmanagementsystem.network_response.Teacher.TeacherResponse

import io.reactivex.Observable
import retrofit2.http.*
import java.sql.Date

interface ApiService {
    @GET("students/activities/")
    fun loadActivities(@Header("Authorization") token : String): Observable<ActivityResponse>

    @FormUrlEncoded
    @POST("login")
    fun login(@Field("email") email: String, @Field("password") password: String): Observable<LoginResponse>

    @FormUrlEncoded
    @POST("students/teachers")
    fun loadTeacherData(@Field("user_id")id:Int):Observable<TeacherResponse>

    @FormUrlEncoded
    @POST("portal")
    fun loadPinCode(@Field("pin")pinCode:Int):Observable<
            PinCodeResponse>

    @PUT("students/change_password")
    fun changePasw(@Field("student_id") id:Int,
                   @Field("old_password")oldPasw:String,
                   @Field("new_password")newPasw:String,
                   @Field("confirm_password")confirmPasw:String):Observable<ChangePaswResponse>

    @FormUrlEncoded
    @POST("register")
    fun register(@Field("email")email:String,
                 @Field("name")name:String,
                 @Field("password")password: String,
                 @Field("confirm_password")confirmPassword: String,
                 @Field("date_of_birth")date_of_birth: String,
                 @Field("module_id")module_id:Int,
                 @Field("phone")phone:String,
                 @Field("address")address:String):Observable<RegisterResponse>

//    @GET("students/assignments/SharedPreference.getUserId/list")
//    fun loadAssignmentData(@Header("Authorization") token : String): Observable<AssignmentResponse>

}