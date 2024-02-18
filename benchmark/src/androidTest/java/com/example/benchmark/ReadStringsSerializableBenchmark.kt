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
class ReadStringsSerializableBenchmark {

    private val context = InstrumentationRegistry.getInstrumentation().targetContext

    @get:Rule
    val benchmarkRule = BenchmarkRule()

    @Test
    fun readStrings5x() = readStringsBenchmark(5)

    @Test
    fun readStrings10x() = readStringsBenchmark(10)

    @Test
    fun readStrings100x() = readStringsBenchmark(100)

    @Test
    fun readStrings1000x() = readStringsBenchmark(1_000)

    @Test
    fun readStrings10000x() = readStringsBenchmark(10_000)

    private fun readStringsBenchmark(count: Int) {
        benchmarkRule.measureRepeated {
            runWithTimingDisabled {
                if (File(context.filesDir, "strings-serializable-${count}x").exists().not()) {
                    val data = SerializableStringsData(generateStringsList(count))
                    data.writeSerializable(context, "strings-serializable-${count}x")
                }
            }
            readSerializable<SerializableStringsData>(context, "strings-serializable-${count}x")
        }
    }
}