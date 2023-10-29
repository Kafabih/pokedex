package com.svck.mobile.pokedexapp.utils

sealed class ResultProvider<T>(val data: T? = null, val msg: String? = null) {
    class Success<T>(data: T?) : ResultProvider<T>(data)
    class Error<T>(data: T? = null, msg: String) : ResultProvider<T>(data, msg)
    class Loading<T> : ResultProvider<T>()
}


