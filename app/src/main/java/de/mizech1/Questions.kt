package de.mizech1

class Questions() {
    var list = ArrayList<Question>()
    init {
        list?.add(
            Question(
                "3 + 4", "6",
                "7", "9", "10", "7", 1
            )
        )
        list?.add(
            Question(
                "3 * 4", "16",
                "17", "12", "9", "12", 2
            )
        )
        list?.add(
            Question(
                "9 - 3", "6",
                "7", "8", "5", "6", 0
            )
        )
        list?.add(
            Question(
                "12 / 3", "5",
                "4", "3", "6", "4",1
            )
        )
        list?.add(
            Question(
                "9 + 2", "11",
                "10", "13", "14", "11", 0
            )
        )
    }
}