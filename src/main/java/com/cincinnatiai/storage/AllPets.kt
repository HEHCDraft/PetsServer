package com.cincinnatiai.storage

import com.cincinnatiai.models.Pet

internal object AllPets {
    private val pets = mutableListOf<Pet>()

    fun saveNewPet(pet: Pet) {
        if (!pets.contains(pet)) {
            pets.add(pet)
        }
    }

    fun findPetById(id: String): Pet? {
        return pets.find { it.id == id }
    }

    fun getAllPets(): List<Pet> {
        return pets
    }

    fun removePet(id: String): Boolean {
        return pets.removeIf { it.id == id }
    }
}