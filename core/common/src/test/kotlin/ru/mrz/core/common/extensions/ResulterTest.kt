package ru.mrz.core.common.extensions

import app.cash.turbine.test
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.test.runTest
import org.junit.Test
import ru.mrz.core.common.states.Resulter
import ru.mrz.core.common.states.asResult
import ru.mrz.core.common.states.onLoading
import kotlin.test.assertTrue

class ResulterTest {
    @Test
    fun `should return loading and then success`() = runTest {
        flow { emit(Unit) }.asResult().test {
            assertTrue(awaitItem() is Resulter.Loading)
            assertTrue(awaitItem() is Resulter.Success)
            awaitComplete()
        }
    }

    @Test
    fun `should work when loading`() = runTest {
        flow { emit(Unit) }.asResult().onLoading {
            assert(true)
        }
    }
}