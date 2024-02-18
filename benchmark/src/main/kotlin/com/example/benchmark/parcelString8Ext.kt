package com.example.benchmark

import android.os.Parcel

// adb shell settings put global hidden_api_policy  1
// adb shell settings delete global hidden_api_policy

// list

fun Parcel.writeString8List(list: List<String>?) {
    if (list == null) {
        writeInt(-1)
        return
    }
    writeInt(list.size)
    for (i in 0..list.lastIndex) {
        writeString8(list[i])
    }
}

fun Parcel.readString8List(list: MutableList<String>) {
    val M = list.size
    val N = readInt()
    var i = 0
    while (i < M && i < N) {
        list[i] = readString8()
        i++
    }
    while (i < N) {
        list.add(readString8())
        i++
    }
    while (i < M) {
        list.removeAt(N)
        i++
    }
}

fun Parcel.createString8List(): List<String>? {
    val size = readInt()
    if (size < 0) return null

    return List(size) { readString8() }
}

// array
fun Parcel.writeString8Array(array: Array<String>?) {
    if (array != null) {
        writeInt(array.size)
        for (i in 0..array.lastIndex) {
            writeString8(array[i])
        }
    } else {
        writeInt(-1)
    }
}

fun Parcel.readString8Array(array: Array<String>) {
    val size = readInt()
    if (size == array.size) {
        for (i in 0..array.lastIndex) {
            array[i] = readString8()
        }
    } else {
        throw RuntimeException("bad array lengths")
    }
}

fun Parcel.createString8Array(): Array<String>? {
    val size = readInt()
    if (size < 0) return null
    return Array(size) { readString8() }
}