package com.flixmobility.challenge.data.remote

import com.flixmobility.challenge.data.model.TimetableResponse
import retrofit2.http.GET

interface ApiService {
    @GET("station/1/timetable.json")
    suspend fun getTimeTable() : TimetableResponse
}