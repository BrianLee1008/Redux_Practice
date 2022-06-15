package com.example.redux_practice_02.vm

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.redux_practice_02.redux.NumberAddAction
import com.example.redux_practice_02.redux.ReduxModule.numberAddReducerStore
import org.reduxkotlin.StoreSubscription

class MainViewModel : ViewModel() {

    private val numberAddStore = numberAddReducerStore()

    private val box: MutableList<Int> = mutableListOf()
    var cnt = 0

    lateinit var unSubscription : StoreSubscription

    private val _countLiveData = MutableLiveData<Int>()
    val countLiveData : LiveData<Int> get() = _countLiveData

    fun numberAddStoreDispatchTest() {
        numberAddStore.dispatch(NumberAddAction.Add(1))
    }

    // ERNote 다음 클릭 들어올때 한번씩 누적되서 들어옴 왜?? -> SecondFragment onCreate할때마다 subscribe 새롭게 하나 더 늘어나서.. 즉, SecondFragment Instance가 하나 더 생겨서 (스택에?)
    //          이전 이벤트에 대한 subscribe까지 누적되는 것. 실제로 SecondFragment 한번 홨다가 Add 계속 누르면 1번씩만 count 됨
    //          해결법은? Fragment 안에서 직접 subscribe 해야하나? ㄴㄴ
    fun numberAddStoreSubscribeTest() {
        unSubscription = numberAddStore.subscribe {
            Result.success(successCallback(numberAddStore.state.addCount))
        }
    }

    private fun successCallback(count: Int) {
        // 성공했을 경우 그 다음 로직.
        _countLiveData.value = if (box.size == 100) {
            box.removeLast()
            box.size
        } else {
            box.add(count)
            box.size
        }
        Log.d("testTest", "mainViewModel : ${countLiveData.value}")
    }
}