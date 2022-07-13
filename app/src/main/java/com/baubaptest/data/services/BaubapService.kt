package com.baubaptest.data.services

import com.baubaptest.data.api.BaubapApi
import javax.inject.Inject

class BaubapService @Inject constructor(
        private val api:BaubapApi
){


    suspend fun getSomeStuffs(): Boolean{
        //This only example for consume service to clean architecture

        /*return withContext(Dispatchers.IO){
            val response = api.getSomeStuffs()
            response.body().let { stuffs->
                if (stuffs != null )
                    return stuffs
            }
        }*/

        return false
    }

}