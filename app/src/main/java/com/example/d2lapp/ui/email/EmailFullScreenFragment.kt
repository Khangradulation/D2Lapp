package com.example.d2lapp.ui.email

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import com.example.d2lapp.R

class EmailFullScreenFragment : Fragment(R.layout.fragment_email_full_screen) {

    private lateinit var email: Email

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            email = it.getParcelable(EMAIL_KEY)!!
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val senderTextView: TextView = view.findViewById(R.id.senderTextView)
        val subjectTextView: TextView = view.findViewById(R.id.subjectTextView)
        val bodyTextView: TextView = view.findViewById(R.id.bodyTextView)

        senderTextView.text = email.sender
        subjectTextView.text = email.subject
        bodyTextView.text = email.body
    }

    companion object {
        private const val EMAIL_KEY = "email"

        fun newInstance(email: Email): EmailFullScreenFragment {
            val args = Bundle().apply {
                putParcelable(EMAIL_KEY, email)
            }
            return EmailFullScreenFragment().apply {
                arguments = args
            }
        }
    }
}
