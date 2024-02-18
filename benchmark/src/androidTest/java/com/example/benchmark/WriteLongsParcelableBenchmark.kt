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
class WriteLongsParcelableBenchmark {

    private val context = InstrumentationRegistry.getInstrumentation().targetContext

    @get:Rule
    val benchmarkRule = BenchmarkRule()

    @Test
    fun writeLongs5x() = writeLongsBenchmark(5)

    @Test
    fun writeLongs10x() = writeLongsBenchmark(10)

    @Test
    fun writeLongs100x() = writeLongsBenchmark(100)

    @Test
    fun writeLongs1000x() = writeLongsBenchmark(1_000)

    @Test
    fun writeLongs10000x() = writeLongsBenchmark(10_000)

    private fun writeLongsBenchmark(count: Int) {
        benchmarkRule.measureRepeated {
            val data = runWithTimingDisabled { ParcelableLongsData(generateLongsList(count)) }
            data.writeParcelable(context, "longs-parcelable-${count}x")
        }
    }
}