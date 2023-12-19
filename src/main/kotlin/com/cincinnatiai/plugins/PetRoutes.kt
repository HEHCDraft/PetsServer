package com.cincinnatiai.plugins

import com.cincinnatiai.models.Pet
import com.cincinnatiai.storage.AllPets
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.plugins.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import io.ktor.util.*

@OptIn(InternalAPI::class)
internal fun Route.petsRouting() {
    route("/pet") {
        get {
            val pets = AllPets.getAllPets()
            if (pets.isNotEmpty()) {
                call.respond(pets)
            } else {
                call.respondText(
                    text = "No pets found",
                    status = HttpStatusCode.OK
                )
            }
        }
        get("{id?}") {
            val id = call.parameters["id"] ?: return@get call.respondText(
                text = "Missing id",
                status = HttpStatusCode.BadRequest
            )
            val pet = AllPets.findPetById(id) ?: return@get call.respondText(
                text = "No pet with id $id",
                status = HttpStatusCode.NotFound
            )
            call.respond(pet)
        }
        post {
            val pet = try {
                call.receive<Pet>()
            } catch (e: BadRequestException) {
                call.respondText(
                    text = e.rootCause!!.localizedMessage,
                    status = HttpStatusCode.BadRequest
                )
                return@post
            }
            AllPets.findPetById(pet.id)?.let {
                call.respondText(
                    text = "Pet Id already registered",
                    status = HttpStatusCode.Conflict
                )
                return@post
            }
            AllPets.saveNewPet(pet)
            call.respondText(
                text = "Pet information stored correctly",
                status = HttpStatusCode.Created
            )
        }
        delete("{id?}") {
            val id = call.parameters["id"] ?: return@delete call.respondText(
                text = "Missing id",
                status = HttpStatusCode.BadRequest
            )
            if (AllPets.removePet(id)) {
                call.respondText(
                    text = "Pet removed correctly",
                    status = HttpStatusCode.Accepted
                )
            } else {
                call.respondText(
                    text = "Pet ID Not Found",
                    status = HttpStatusCode.NotFound
                )
            }
        }
    }
}