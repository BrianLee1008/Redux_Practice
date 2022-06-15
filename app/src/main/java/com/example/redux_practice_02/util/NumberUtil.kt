package com.example.redux_practice_02.util



internal fun Int.addOrRemove(element: Int): Int {
    val box : MutableList<Int> = mutableListOf()
    return if (box.size == 10) {
        box.removeLast()
        box.size
    } else {
        box.add(element)
        box.size
    }
}