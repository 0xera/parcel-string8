package com.example.benchmark

import kotlin.random.Random

fun generateStringsList(count: Int) = (0 until count).map { "привет" } // "hello"
fun generateLongsList(count: Int) = (0 until count).map { Random.nextLong() }