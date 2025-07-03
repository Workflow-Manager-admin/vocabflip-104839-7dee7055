package com.example.flashcardsappfrontend.data

/**
 * PUBLIC_INTERFACE
 * Repository for managing flashcards.
 */
class FlashcardRepository {
    private val flashcards = mutableListOf<Flashcard>()
    private var nextId = 1

    // PUBLIC_INTERFACE
    fun getAll(): List<Flashcard> = flashcards

    // PUBLIC_INTERFACE
    fun add(word: String, definition: String, category: String): Flashcard {
        val card = Flashcard(id = nextId++, word = word, definition = definition, category = category)
        flashcards.add(card)
        return card
    }

    // PUBLIC_INTERFACE
    fun update(flashcard: Flashcard) {
        val idx = flashcards.indexOfFirst { it.id == flashcard.id }
        if (idx != -1) flashcards[idx] = flashcard
    }

    // PUBLIC_INTERFACE
    fun remove(flashcard: Flashcard) {
        flashcards.removeAll { it.id == flashcard.id }
    }

    // PUBLIC_INTERFACE
    fun findByCategory(category: String): List<Flashcard> = flashcards.filter { it.category == category }

    // PUBLIC_INTERFACE
    fun search(query: String): List<Flashcard> =
        flashcards.filter { it.word.contains(query, true) || it.definition.contains(query, true) }

    // PUBLIC_INTERFACE
    fun markKnown(id: Int, isKnown: Boolean) {
        flashcards.find { it.id == id }?.isKnown = isKnown
    }

    // PUBLIC_INTERFACE
    fun getCategories(): List<String> = flashcards.map { it.category }.distinct()
}
