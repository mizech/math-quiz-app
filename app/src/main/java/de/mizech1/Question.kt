package de.mizech1

data class Question(val text: String, val option1: String, val option2: String,
                    val option3: String, val option4: String, val correctAnswer: String,
                    val correctOption: Int)