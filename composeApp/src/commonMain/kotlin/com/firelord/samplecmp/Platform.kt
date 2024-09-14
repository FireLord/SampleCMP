package com.firelord.samplecmp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform