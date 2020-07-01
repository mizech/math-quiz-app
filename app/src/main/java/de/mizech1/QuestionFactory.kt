package de.mizech1

import android.util.Log

class QuestionFactory() {
    var list = ArrayList<Question>()
    init {
        list?.add(
            Question(
                "3 + 4", "6",
                "7", "9", "10", 1
            )
        )
        list?.add(
            Question(
                "3 * 4", "16",
                "17", "12", "9", 2
            )
        )
        list?.add(
            Question(
                "9 - 3", "6",
                "7", "8", "5", 0
            )
        )
        list?.add(
            Question(
                "12 / 3", "5",
                "4", "3", "6",1
            )
        )
        list?.add(
            Question(
                "9 + 2", "11",
                "10", "13", "14", 0
            )
        )
        list?.add(
            Question(
                "13 + 8", "22",
                "19", "21", "20", 2
            )
        )
        list?.add(
            Question(
                "7 * 6", "42",
                "40", "39", "43", 0
            )
        )
        list?.add(
            Question(
                "52 - 13", "40",
                "38", "41", "39", 3
            )
        )
        list?.add(
            Question(
                "28 / 4", "6",
                "7", "8", "9", 1
            )
        )
        list?.add(
            Question(
                "11 * 4", "44",
                "45", "43", "42", 0
            )
        )
        list?.add(
            Question(
                "13 + 10", "20",
                "24", "23", "12", 2
            )
        )
        list?.add(
            Question(
                "9 * 5", "45",
                "44", "46", "43", 0
            )
        )
        list?.add(
            Question(
                "21 / 3", "4",
                "3", "7", "6", 2
            )
        )
        list?.add(
            Question(
                "23 + 13", "37",
                "38", "34", "36", 3
            )
        )
        list?.add(
            Question(
                "30 / 3", "9",
                "10", "11", "8", 1
            )
        )
        list?.add(
            Question(
                "9 * 11", "99",
                "98", "101", "100", 0
            )
        )
        list?.add(
            Question(
                "12 + 5", "18",
                "17", "19", "20", 1
            )
        )
        list?.add(
            Question(
                "30 / 6", "4",
                "5", "7", "6", 1
            )
        )
        list?.add(
            Question(
                "28 + 13", "41",
                "38", "34", "36", 0
            )
        )
        list?.add(
            Question(
                "43 - 12", "32",
                "35", "31", "33", 2
            )
        )
    }

    companion object {
        var list = ArrayList<Question>()

        private fun addQuestionsToList() {
            list?.add(
                Question(
                    "3 + 4", "6",
                    "7", "9", "10", 1
                )
            )
            list?.add(
                Question(
                    "3 * 4", "16",
                    "17", "12", "9", 2
                )
            )
            list?.add(
                Question(
                    "9 - 3", "6",
                    "7", "8", "5", 0
                )
            )
            list?.add(
                Question(
                    "12 / 3", "5",
                    "4", "3", "6",1
                )
            )
            list?.add(
                Question(
                    "9 + 2", "11",
                    "10", "13", "14", 0
                )
            )
            list?.add(
                Question(
                    "13 + 8", "22",
                    "19", "21", "20", 2
                )
            )
            list?.add(
                Question(
                    "7 * 6", "42",
                    "40", "39", "43", 0
                )
            )
            list?.add(
                Question(
                    "52 - 13", "40",
                    "38", "41", "39", 3
                )
            )
            list?.add(
                Question(
                    "28 / 4", "6",
                    "7", "8", "9", 1
                )
            )
            list?.add(
                Question(
                    "11 * 4", "44",
                    "45", "43", "42", 0
                )
            )
            list?.add(
                Question(
                    "13 + 10", "20",
                    "24", "23", "12", 2
                )
            )
            list?.add(
                Question(
                    "9 * 5", "45",
                    "44", "46", "43", 0
                )
            )
            list?.add(
                Question(
                    "21 / 3", "4",
                    "3", "7", "6", 2
                )
            )
            list?.add(
                Question(
                    "23 + 13", "37",
                    "38", "34", "36", 3
                )
            )
            list?.add(
                Question(
                    "30 / 3", "9",
                    "10", "11", "8", 1
                )
            )
            list?.add(
                Question(
                    "9 * 11", "99",
                    "98", "101", "100", 0
                )
            )
            list?.add(
                Question(
                    "12 + 5", "18",
                    "17", "19", "20", 1
                )
            )
            list?.add(
                Question(
                    "30 / 6", "4",
                    "5", "7", "6", 1
                )
            )
            list?.add(
                Question(
                    "28 + 13", "41",
                    "38", "34", "36", 0
                )
            )
            list?.add(
                Question(
                    "43 - 12", "32",
                    "35", "31", "33", 2
                )
            )
        }

        fun createRandomQuestion(): Question {
            val calcType = listOf<String>("add", "subtract", "multiply", "divide")
            val random = (calcType.indices).random()
            var question = Question()

            when (calcType.get(random)) {
                "add" -> {
                    val a = (0..99).random()
                    val b = (0..99).random()
                    val sum = a + b

                    var factors
                            = mutableListOf<Int>(sum + 1, sum + 2, sum - 1, sum - 2)
                    factors.shuffle()
                    val randomIndex = (0..3).random()
                    factors.set(randomIndex, sum)

                    question.text = "$a + $b"
                    question.option1 = (factors[0]).toString()
                    question.option2 = (factors[1]).toString()
                    question.option3 = (factors[2]).toString()
                    question.option4 = (factors[3]).toString()
                    question.correctOption = randomIndex
                }
                "subtract" -> {
                    val a = (0..99).random()
                    val b = (0..99).random()
                    val difference = a - b

                    var factors
                            = mutableListOf<Int>(difference - 1, difference - 2, difference + 1, difference + 2)
                    factors.shuffle()
                    val randomIndex = (0..3).random()
                    factors.set(randomIndex, difference)

                    question.text = "$a - $b"
                    question.option1 = (factors[0]).toString()
                    question.option2 = (factors[1]).toString()
                    question.option3 = (factors[2]).toString()
                    question.option4 = (factors[3]).toString()
                    question.correctOption = randomIndex
                }
                "multiply" -> {
                    val a = (1..10).random()
                    val b = (1..10).random()
                    val product = a * b

                    var factors
                            = mutableListOf<Int>(product + 1, product + 2, product - 1, product - 2)
                    factors.shuffle()
                    val randomIndex = (0..3).random()
                    factors.set(randomIndex, product)

                    question.text = "$a * $b"
                    question.option1 = (factors[0]).toString()
                    question.option2 = (factors[1]).toString()
                    question.option3 = (factors[2]).toString()
                    question.option4 = (factors[3]).toString()
                    question.correctOption = randomIndex
                }
                "divide" -> {
                    var a = (0..99).random()
                    val b = (0..49).random()

                    while (a % b != 0) {
                        a++
                    }
                    val quotient = a / b

                    var factors
                            = mutableListOf<Int>(quotient + 1, quotient + 2, quotient - 1, quotient - 2)
                    factors.shuffle()
                    val randomIndex = (0..3).random()
                    factors.set(randomIndex, quotient)

                    question.text = "$a / $b"
                    question.option1 = (factors[0]).toString()
                    question.option2 = (factors[1]).toString()
                    question.option3 = (factors[2]).toString()
                    question.option4 = (factors[3]).toString()
                    question.correctOption = randomIndex
                }
            }

            return question
        }

        fun create(chargeSize: Int = 10): ArrayList<Question> {
            var randomList = ArrayList<Question>()
            var i = 0
            while (i < chargeSize) {
                randomList.add(createRandomQuestion())
                i++
            }

            Log.i("list", randomList.toString())

            return randomList
        }
    }
}