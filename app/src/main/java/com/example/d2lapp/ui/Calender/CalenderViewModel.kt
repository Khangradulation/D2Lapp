package com.example.d2lapp.ui.Calender

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.time.LocalDate
import java.time.YearMonth
import java.util.*
import java.util.*

class CalenderViewModel : ViewModel() {

    private val eventsMap = mutableMapOf<Long, MutableList<String>>()

    fun addEvent(year: Int, month: Int, dayOfMonth: Int, event: String) {
        val calendar = Calendar.getInstance().apply {
            set(Calendar.YEAR, year)
            set(Calendar.MONTH, month)
            set(Calendar.DAY_OF_MONTH, dayOfMonth)
        }
        val dateInMillis = calendar.timeInMillis

        if (eventsMap.containsKey(dateInMillis)) {
            eventsMap[dateInMillis]?.add(event)
        } else {
            eventsMap[dateInMillis] = mutableListOf(event)
        }
    }

    fun getEventsForDate(year: Int, month: Int, dayOfMonth: Int): List<String> {
        val calendar = Calendar.getInstance().apply {
            set(Calendar.YEAR, year)
            set(Calendar.MONTH, month)
            set(Calendar.DAY_OF_MONTH, dayOfMonth)
        }
        val dateInMillis = calendar.timeInMillis
        return eventsMap[dateInMillis] ?: emptyList()
    }
}






