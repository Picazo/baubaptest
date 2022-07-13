package com.baubaptest.data.repository

import android.content.Context
import com.baubaptest.data.services.BaubapService
import com.baubaptest.data.utils.NetworkHelper.isNetworkAvailable
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class BaubapRepository @Inject constructor(
    private val service:BaubapService,
    @ApplicationContext private val context:Context
) {
    suspend fun getSomeStuffs(): Boolean {
        return if (isNetworkAvailable(context))
            service.getSomeStuffs()
        else
            service.getSomeStuffs()
    }
}