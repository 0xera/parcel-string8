package com.example.benchmark

import android.content.Context
import java.io.ObjectInputStream
import java.io.ObjectOutputStream
import java.io.Serializable

fun <T : Serializable> T.writeSerializable(context: Context, fileName: String) =
    context.openFileOutput(fileName, Context.MODE_PRIVATE).use { file ->
        ObjectOutputStream(file).use { oos -> oos.writeObject(this) }
    }

fun <T : Serializable> readSerializable(context: Context, fileName: String) =
    context.openFileInput(fileName).use { file ->
        ObjectInputStream(file).use { oos -> oos.readObject() }
    } as? T
