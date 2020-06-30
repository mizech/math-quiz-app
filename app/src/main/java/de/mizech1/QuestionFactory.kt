package de.mizech1

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

        fun create(chargeSize: Int = 10): ArrayList<Question> {
            addQuestionsToList()
            var randomList = ArrayList<Question>()
            var usedIndex = mutableListOf<Int>()

            while (randomList.size < chargeSize) {
                val randomInt = (0..list.size).random()

                if (randomInt !in usedIndex) {
                    randomList.add(list.get(randomInt))
                }
            }

            return randomList
        }
    }
}