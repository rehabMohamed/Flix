package com.flixmobility.challenge.di

import com.flixmobility.challenge.data.remote.ApiService
import com.flixmobility.challenge.data.repoimpl.TimetableRepoImpl
import com.flixmobility.challenge.domain.repo.TimetableRepo
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module(includes = [NetworkModule::class])
class ApiModule{

    @Provides
    @Singleton
    fun bindApiService(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }

    @Provides
    fun bindDeparturesRepo(timetableRepoImpl: TimetableRepoImpl): TimetableRepo {
        return timetableRepoImpl
    }
}