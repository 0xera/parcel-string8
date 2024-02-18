package com.example.benchmark

import java.io.File

val File.sizeInKb get() = length() / 1024
