package com.example.d2lapp.ui.email

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView
import com.example.d2lapp.R
import com.example.d2lapp.ui.email.Email


class EmailViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val senderTextView: TextView = itemView.findViewById(R.id.senderTextView)
    val subjectTextView: TextView = itemView.findViewById(R.id.subjectTextView)
    val bodyTextView: TextView = itemView.findViewById(R.id.bodyTextView)
    private val topSeparatorView: View = itemView.findViewById(R.id.top_separator)
    private val bottomSeparatorView: View = itemView.findViewById(R.id.bottom_separator)
    val fullScreenButton: Button = itemView.findViewById(R.id.fullScreenButton)

    fun bind(email: Email, emails: List<Email>, fragmentManager: FragmentManager) {
        // Set the sender, subject, and body texts
        senderTextView.text = email.sender
        subjectTextView.text = email.subject
        bodyTextView.text = email.body

        // Show/hide the top and bottom separators based on the position
        if (adapterPosition == 0) {
            topSeparatorView.visibility = View.GONE
        } else {
            topSeparatorView.visibility = View.VISIBLE
        }
        if (adapterPosition == emails.size - 1) {
            bottomSeparatorView.visibility = View.GONE
        } else {
            bottomSeparatorView.visibility = View.VISIBLE
        }

        // Set the click listener for the "view email" button
        fullScreenButton.setOnClickListener {
            val emailFullScreenFragment = EmailFullScreenFragment.newInstance(email)
            fragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, emailFullScreenFragment) // replace with container ID of EmailFragment
                .addToBackStack(null)
                .commit()
        }
    }
}








