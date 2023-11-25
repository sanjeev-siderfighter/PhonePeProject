package com.example.phonepeproject.applayers.datasource.remotedatasource.utils

sealed interface ApiResult<out SuccessType> {
    data class Success<out SuccessType>(val response: SuccessType) : ApiResult<SuccessType>
    data class Failure(val exception: Exception) : ApiResult<Nothing>
}