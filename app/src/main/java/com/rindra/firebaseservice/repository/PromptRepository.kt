package com.rindra.firebaseservice.repository

import com.rindra.firebaseservice.service.generativeModel

class PromptRepository {
    suspend fun generateSuggestions(): String{
        val prompt = "Generate 10 suggestions of cool projects I can do as a student"

        val response = generativeModel().generateContent(prompt)
        return response.text.orEmpty()
    }
}