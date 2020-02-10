package lln.recycler.fragment.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import lln.recycler.fragment.ScreenState

class NomeViewModel : ViewModel() {

    val liveData = MutableLiveData<ScreenState<String>>()


    open var changeObserver = Observer<ScreenState<String>> { value ->
        value?.let {
            setScreenState(it)
        }
    }


    fun setScreenState(screenState: ScreenState<String>) {
        when (screenState) {
            is ScreenState.Success -> {
                //liveData.postValue(ScreenState.Success(screenState.data))
                //liveData.value = ScreenState.Success(screenState.data)
            }
        }
    }

}