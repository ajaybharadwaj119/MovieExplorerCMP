package org.ajay.movieexplorer

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform