package com.cincinnatiai.plugins

import io.ktor.server.application.*
import io.ktor.server.routing.*

internal fun Application.configureRouting() {
    routing {
        petsRouting()
    }
}
