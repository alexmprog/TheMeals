package com.alexmprog.themeals.core.common.model

// extends Resource with Loading state on demand
sealed class Resource<T> {
    data class Success<T>(val data: T) : Resource<T>()
    data class Error<T>(val error: ErrorType) : Resource<T>()
}

// extends ErrorType with custom types on demand
sealed class ErrorType {
    data object Network : ErrorType()
    data object Unknown : ErrorType()
}