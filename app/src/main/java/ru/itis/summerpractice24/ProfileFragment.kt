package ru.itis.summerpractice24

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import ru.itis.summerpractice24.databinding.FragmentProfileBinding

class ProfileFragment : Fragment(R.layout.fragment_profile) {

    private var binding: FragmentProfileBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentProfileBinding.bind(view)

        val email = arguments?.getString(ARG_EMAIL) ?: "ERROR"

        binding?.run {
            tvTitle.text = "${tvTitle.text} + $email"
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    companion object {

        private const val ARG_EMAIL = "ARG_EMAIL"
        private const val ARG_AGE = "ARG_AGE"

        fun bundle(email: String, age: Int): Bundle = Bundle().apply {
            putString(ARG_EMAIL, email)
            putInt(ARG_AGE, age)
        }
    }
}