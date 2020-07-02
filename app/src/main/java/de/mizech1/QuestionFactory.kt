package de.mizech1

import android.util.Log

class QuestionFactory() {
    companion object {
        fun setQuestionAttributes(text: String, result: Int): Question {
            var question = Question()
            var factors
                    = mutableListOf<Int>(result + 1, result + 2, result - 1, result - 2)
            factors.shuffle()
            val randomIndex = (0..3).random()
            factors.set(randomIndex, result)

            question.text = text
            question.option1 = (factors[0]).toString()
            question.option2 = (factors[1]).toString()
            question.option3 = (factors[2]).toString()
            question.option4 = (factors[3]).toString()
            question.correctOption = randomIndex

            return question
        }

        fun createRandomQuestion(): Question? {
            val calcType = listOf<String>("add", "subtract", "multiply", "divide")
            val random = (calcType.indices).random()

            when (calcType.get(random)) {
                "add" -> {
                    val a = (0..99).random()
                    val b = (0..99).random()
                    val sum = a + b

                    return setQuestionAttributes("$a + $b", sum)
                }
                "subtract" -> {
                    val a = (0..99).random()
                    val b = (0..99).random()
                    val difference = a - b

                    return setQuestionAttributes("$a - $b", difference)
                }
                "multiply" -> {
                    val a = (1..10).random()
                    val b = (1..10).random()
                    val product = a * b

                    return setQuestionAttributes("$a * $b", product)
                }
                else -> {
                    var a = (0..99).random()
                    val b = (0..49).random()

                    while (a % b != 0) {
                        a++
                    }
                    val quotient = a / b

                    return setQuestionAttributes("$a / $b", quotient)
                }
            }
        }

        fun create(chargeSize: Int = 10): ArrayList<Question?> {
            var randomList = ArrayList<Question?>()
            var i = 0
            while (i < chargeSize) {
                randomList.add(createRandomQuestion())
                i++
            }

            return randomList
        }
    }
}