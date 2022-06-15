package com.example.redux_practice_02.redux

import org.reduxkotlin.Store
import org.reduxkotlin.createThreadSafeStore


typealias NumberAddStore = Store<NumberAddState>

object ReduxModule {

    fun numberAddReducerStore() : NumberAddStore = createThreadSafeStore(
        ::numberReducer,
        NumberAddState()
    )
}