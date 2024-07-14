package com.nasza.latihanparsingsuperheroapi.model

import com.google.gson.annotations.SerializedName

data class SuperHero(
    val id: String?,
    val name: String?,
    val powerstats: PowerStats?,
    val biography: Biography?,
    val appearance: Appearance?,
    val work: Work?,
    val connections: Connections?,
    val image: Image?
)

data class PowerStats(
    val intelligence: String?,
    val strength: String?,
    val speed: String?,
    val durability: String?,
    val power: String?,
    val combat: String?
)

data class Biography(
    @field:SerializedName("full-name") val fullName: String?,
    @field:SerializedName("place-of-birth") val placeOfBirth: String?,
    @field:SerializedName("first-appearance") val firstAppearance: String?,
    val publisher: String?
)

data class Appearance(
    val gender: String?,
    val race: String?,
    val height: List<String>?,
    val weight: List<String>?,
    @field:SerializedName("eye-color")val eyeColor: String?,
    @field:SerializedName("hair-color")val hairColor: String?
)

data class Work(
    val occupation: String?,
    val base: String?
)

data class Connections(
    @field:SerializedName("group-affiliation")val groupAffiliation: String?,
    val relatives: String?
)

data class Image(
    val url: String?
)
