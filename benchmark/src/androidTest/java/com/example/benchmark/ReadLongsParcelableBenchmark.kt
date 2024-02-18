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
class ReadLongsParcelableBenchmark {

    private val context = InstrumentationRegistry.getInstrumentation().targetContext

    @get:Rule
    val benchmarkRule = BenchmarkRule()

    @Test
    fun readLongs5x() = readLongsBenchmark(5)

    @Test
    fun readLongs10x() = readLongsBenchmark(10)

    @Test
    fun readLongs100x() = readLongsBenchmark(100)

    @Test
    fun readLongs1000x() = readLongsBenchmark(1_000)

    @Test
    fun readLongs10000x() = readLongsBenchmark(10_000)

    private fun readLongsBenchmark(count: Int) {
        benchmarkRule.measureRepeated {
            runWithTimingDisabled {
                if (File(context.filesDir, "longs-parcelable-${count}x").exists().not()) {
                    val data = ParcelableLongsData(generateLongsList(count))
                    data.writeParcelable(context, "longs-parcelable-${count}x")
                }
            }
            readParcelable<ParcelableLongsData>(context, "longs-parcelable-${count}x")
        }
    }
}