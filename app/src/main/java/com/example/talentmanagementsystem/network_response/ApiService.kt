package com.example.talentmanagementsystem.network_response

import com.example.talentmanagementsystem.network_response.Activity.ActivityResponse
import io.reactivex.Observable
import retrofit2.http.GET
import java.util.*

interface ApiService {
  @GET("students/activities/")
   fun loadActivities(): Observable<ActivityResponse>
}