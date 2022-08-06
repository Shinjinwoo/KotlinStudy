package com.example.kotlinstudy.modle

import android.util.Log

class DataModel(var name: String?= null, var profileImage : String? = null) {

    var TAG : String = "로그"

    init{
        Log.d(TAG,"DataModel - () called")
    }
}