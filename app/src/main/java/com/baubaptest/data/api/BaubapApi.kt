package com.baubaptest.data.api

import com.baubaptest.data.model.BaubapTestModel
import retrofit2.Response
import retrofit2.http.GET

interface BaubapApi {
    @GET("baubapTest")
    suspend fun getSomeStuffs() : Response<List<BaubapTestModel>>
}