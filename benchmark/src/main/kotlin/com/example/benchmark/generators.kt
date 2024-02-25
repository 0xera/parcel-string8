package com.example.benchmark

import kotlin.random.Random

fun generateStringsList(count: Int) = (0 until count).map { "hello" } // "hello", "hello$it", "привет", "привет$it", "你好", "你好$it"
fun generateLongsList(count: Int) = (0 until count).map { Random.nextLong() }