package com.example.redux_practice_02.redux

import com.example.redux_practice_02.util.addOrRemove


sealed interface NumberAddAction {

    data class Add(
        val count: Int
    ) : NumberAddAction
}

data class NumberAddState(
    val addCount: Int = 0
)

private fun numberAddReducer(state: Int, action: Any) =
    when (action) {
        is NumberAddAction.Add -> action.count
        else -> state
    }

fun numberReducer(state: NumberAddState, action: Any) =
    NumberAddState(numberAddReducer(state.addCount, action))


