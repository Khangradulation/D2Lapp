package com.example.d2lapp.ui.email

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.d2lapp.R

class EmailAdapter(private val emails: List<Email>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_email, parent, false)
        return EmailViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val emailViewHolder = holder as EmailViewHolder
        emailViewHolder.bind(emails[position])

        if (position < emails.size - 1) {
            emailViewHolder.bottom_separator.visibility = View.VISIBLE
            emailViewHolder.top_separator.visibility = View.VISIBLE
        } else {
            emailViewHolder.bottom_separator.visibility = View.GONE
            emailViewHolder.top_separator.visibility = View.GONE
        }
    }

    override fun getItemCount() = emails.size

    private class EmailViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val senderTextView: TextView = itemView.findViewById(R.id.senderTextView)
        private val subjectTextView: TextView = itemView.findViewById(R.id.subjectTextView)
        private val bodyTextView: TextView = itemView.findViewById(R.id.bodyTextView)
        val top_separator: View = itemView.findViewById(R.id.top_separator)
        val bottom_separator: View = itemView.findViewById(R.id.bottom_separator)

        fun bind(email: Email) {
            senderTextView.text = email.sender
            subjectTextView.text = email.subject
            bodyTextView.text = email.body
        }
    }
}
