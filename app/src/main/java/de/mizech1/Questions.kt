package de.mizech1

class Questions() {
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
    }
}