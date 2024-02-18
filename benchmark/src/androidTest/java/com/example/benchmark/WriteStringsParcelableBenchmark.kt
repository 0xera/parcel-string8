package com.example.benchmark

import androidx.benchmark.junit4.BenchmarkRule
import androidx.benchmark.junit4.measureRepeated
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import java.io.File

@RunWith(AndroidJUnit4::class)
class WriteStringsParcelableBenchmark {

    private val context = InstrumentationRegistry.getInstrumentation().targetContext

    @get:Rule
    val benchmarkRule = BenchmarkRule()

    @Test
    fun writeStrings5x() = writeStringsBenchmark(5)

    @Test
    fun writeStrings10x() = writeStringsBenchmark(10)

    @Test
    fun writeStrings100x() = writeStringsBenchmark(100)

    @Test
    fun writeStrings1000x() = writeStringsBenchmark(1_000)

    @Test
    fun writeStrings10000x() = writeStringsBenchmark(10_000)

    private fun writeStringsBenchmark(count: Int) {
        benchmarkRule.measureRepeated {
            val data = runWithTimingDisabled { ParcelableStringsData(generateStringsList(count)) }
            data.writeParcelable(context, "strings-parcelable-${count}x")
        }
    }

}