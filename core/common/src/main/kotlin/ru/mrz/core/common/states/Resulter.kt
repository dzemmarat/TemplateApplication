package ru.mrz.core.common.states

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onStart

sealed interface Resulter<out T> {
    data class Failure(
        val error: Throwable,
    ) : Resulter<Nothing>

    data class Success<out T>(
        val value: T,
    ) : Resulter<T>

    object Loading : Resulter<Nothing>
}

fun <T> Flow<T>.asResult(): Flow<Resulter<T>> {
    return this
        .map<T, Resulter<T>> {
            Resulter.Success(it)
        }
        .onStart { emit(Resulter.Loading) }
}

fun <T> Flow<Resulter<T>>.onLoading(
    action: suspend () -> Unit,
): Flow<Resulter<T>> = flow {
    collect { value ->
        if (value is Resulter.Loading) action()
        emit(value)
    }
}

fun <T> Flow<Resulter<T>>.onSuccess(
    action: suspend (value: T) -> Unit,
): Flow<Resulter<T>> = flow {
    collect { value ->
        if (value is Resulter.Success) action(value.value)
        emit(value)
    }
}

fun <T> Flow<Resulter<T>>.onError(
    action: suspend (value: Throwable?) -> Unit,
): Flow<Resulter<T>> =
    catch { value ->
        action(value)
    }
