package com.example.d2lapp.ui.email

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment.Companion.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.d2lapp.R
import com.example.d2lapp.databinding.FragmentEmailBinding


class EmailFragment : Fragment(R.layout.fragment_email) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val emails = listOf(
            Email("sender1@example.com", "Subject 1", "Body 1"),
            Email("sender2@example.com", "Subject 2", "Body 2"),
            Email("sender3@example.com", "Subject 3", "Body 3"),
            Email("sender1@example.com", "Subject 1", "Body 4"),
            Email("sender2@example.com", "Subject 2", "Body 5"),
            Email("sender3@example.com", "Subject 3", "Body 6")
        )

        val emailRecyclerView: RecyclerView = view.findViewById(R.id.emailRecyclerView)
        emailRecyclerView.adapter = EmailAdapter(emails)
    }
}

