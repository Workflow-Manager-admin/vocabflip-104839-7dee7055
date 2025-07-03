package com.example.flashcardsappfrontend.data

/**
 * PUBLIC_INTERFACE
 * Data model representing a vocabulary flashcard.
 */
data class Flashcard(
    val id: Int,
    var word: String,
    var definition: String,
    var category: String,
    var isKnown: Boolean = false // For tracking progress
)
