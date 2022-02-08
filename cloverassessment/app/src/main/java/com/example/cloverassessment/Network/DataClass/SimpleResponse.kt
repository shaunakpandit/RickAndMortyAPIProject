package com.example.cloverassessment.Network.DataClass

import retrofit2.Response
import java.lang.Exception

/*
Utilized to verify API call success. Bad calls, whether failed or for hitting the wrong
terminal will be caught and error message will be stored
 */

data class SimpleResponse<T>(
    val status: Status,
    val data: Response<T>?,
    val exception: Exception?
){
    companion object {
        fun <T> success(data: Response<T>): SimpleResponse<T> {
            return SimpleResponse(
                status = Status.Success,
                data = data,
                exception = null

            )
        }

        fun <T> failure(exception: Exception): SimpleResponse<T> {
            return SimpleResponse(
                status = Status.Failure,
                data = null,
                exception = exception

            )
        }
    }


    sealed class Status{
        object Success: Status()
        object Failure: Status()
    }

    val failed: Boolean
        get() = this.status == Status.Failure

    val isSuccessful: Boolean
        get() = !failed && this.data?.isSuccessful == true

    val body: T
        get() = this.data!!.body()!!
}
