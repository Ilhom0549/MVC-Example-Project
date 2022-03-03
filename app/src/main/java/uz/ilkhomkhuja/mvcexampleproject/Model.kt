package uz.ilkhomkhuja.mvcexampleproject

import java.util.*
import kotlin.collections.ArrayList

class Model : Observable() {

    private val list: ArrayList<Int> = ArrayList(3)
    init {
        list.add(0)
        list.add(0)
        list.add(0)
    }

    @Throws(IndexOutOfBoundsException::class)
    fun getValueAtIndex(theIndex: Int): Int {
        return list[theIndex]
    }

    @Throws(IndexOutOfBoundsException::class)
    fun setValueAtIndex(theIndex: Int) {
        list[theIndex] += 1
        setChanged()
        notifyObservers()
    }
}