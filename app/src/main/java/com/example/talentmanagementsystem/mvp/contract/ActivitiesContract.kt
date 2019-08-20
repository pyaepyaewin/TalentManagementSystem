package com.example.talentmanagementsystem.mvp.contract

import com.example.talentmanagementsystem.network_response.Activity.Data

interface ActivitiesContract {
   interface ActivitiesView
  {
 fun showActivityList(activityList:List<Data>)
      fun showError(error:String)
  }
  interface ActivitiesPresenter
   {
       fun attachView(view:ActivitiesView)
       fun loadActivityList()

 }
}