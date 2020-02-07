package lln.recycler.fragment

sealed class ScreenState<T> {
    class Success<T>(val data: T) : ScreenState<T>()
}