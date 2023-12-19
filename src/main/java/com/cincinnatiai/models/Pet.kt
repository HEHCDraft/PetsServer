package com.cincinnatiai.models

import kotlinx.serialization.Serializable

@Serializable
data class Pet(
    val id: String,
    val name: String,
    val gender: Gender,
    val color: String,
    val age: String,
    val weightInLbs: Int,
    val size: Size,
    val neutered: Boolean,
    val species: Species,
    val breed: String,
    val description: String,
)

enum class Species {
    CAT,
    DOG
}

enum class Gender {
    MALE,
    FEMALE
}

enum class Size {
    SMALL,
    MEDIUM,
    LARGE,
    EXTRA_LARGE
}

/**
 * {
 *     "id": "123",
 *     "name": "Pizzicatto",
 *     "gender": "MALE",
 *     "color": "Spotted",
 *     "age": "3 months",
 *     "weightInLbs": 5,
 *     "neutered": false,
 *     "species": "CAT",
 *     "breed": "Street",
 *     "description": "Street cat found in Duluth"
 * }
 */