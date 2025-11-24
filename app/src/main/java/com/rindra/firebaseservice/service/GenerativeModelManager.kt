package com.rindra.firebaseservice.service

import com.google.firebase.Firebase
import com.google.firebase.ai.GenerativeModel
import com.google.firebase.ai.ai

fun generativeModel():GenerativeModel{
    return Firebase.ai()
        .generativeModel("gemini-2.5-flash")
}