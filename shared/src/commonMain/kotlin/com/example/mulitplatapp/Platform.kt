package com.example.mulitplatapp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform