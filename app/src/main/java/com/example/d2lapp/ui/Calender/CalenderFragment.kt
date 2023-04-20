package com.example.d2lapp.ui.Calender

import android.os.Build
import com.example.d2lapp.R
import android.os.Bundle
import android.view.*
import android.widget.Button
import android.widget.CalendarView
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.d2lapp.databinding.FragmentCalenderBinding
import java.text.DateFormat
import java.time.LocalDate
import java.time.YearMonth

class CalenderFragment : Fragment() {

    private lateinit var calendarView: CalendarView
    private lateinit var eventView: TextView
    private lateinit var viewModel: CalenderViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_calender, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Find the views by ID
        calendarView = view.findViewById(R.id.calendarView)
        eventView = view.findViewById(R.id.eventView)

        // Get the view model
        viewModel = ViewModelProvider(this).get(CalenderViewModel::class.java)

        // Set the calendar view date change listener
        calendarView.setOnDateChangeListener { _, year, month, dayOfMonth ->
            // Call the onDayClick method to handle the day click event
            onDayClick(year, month, dayOfMonth)
        }
    }

    private fun onDayClick(year: Int, month: Int, dayOfMonth: Int) {
        // Set the event view text to the events for the selected date
        val events = viewModel.getEventsForDate(year, month, dayOfMonth)
        eventView.text = if (events.isNotEmpty()) {
            events.joinToString("\n")
        } else {
            "No events for selected date."
        }
    }
}
















