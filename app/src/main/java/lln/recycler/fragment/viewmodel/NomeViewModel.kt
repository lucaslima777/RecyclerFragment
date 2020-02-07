package lln.recycler.fragment.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import lln.recycler.fragment.ScreenState

class NomeViewModel : ViewModel() {

    private var _nomeLiveData = String()

    val nomeLiveData: String
        get() = _nomeLiveData


    fun setNome(nome: String) {
        _nomeLiveData = nome
    }

    init {

    }


    val _nome: MutableLiveData<ScreenState<String>> by lazy {
        MutableLiveData<ScreenState<String>>()
    }

    fun getNome(): MutableLiveData<ScreenState<String>> {
        return _nome
    }



    fun setScreenState(screenState: ScreenState<String>) {
        when (screenState) {
            is ScreenState.Success -> {
                Log.i("NomeViewModel", screenState.data)
            }
        }
    }


}