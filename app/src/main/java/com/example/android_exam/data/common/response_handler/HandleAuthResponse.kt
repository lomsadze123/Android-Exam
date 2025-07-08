package com.example.android_exam.data.common.response_handler

import com.example.android_exam.data.common.AppError
import com.example.android_exam.data.common.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class HandleAuthResponse {
    suspend fun <T> safeAuthCall(call: suspend () -> T): Flow<Resource<Unit>> = flow {
        emit(Resource.Loading(true))
        try {
            call()
            emit(Resource.Success(Unit))
        } catch (t: Throwable) {
            emit(Resource.Error(AppError.fromException(t).message, t))
        }
        emit(Resource.Loading(false))
    }
}
