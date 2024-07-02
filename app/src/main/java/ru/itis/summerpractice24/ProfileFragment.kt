package ru.itis.summerpractice24

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import ru.itis.summerpractice24.databinding.FragmentProfileBinding
import ru.itis.summerpractice24.utils.showSnackbar

class ProfileFragment : Fragment(R.layout.fragment_profile) {

    private var binding: FragmentProfileBinding? = null

    private var counter = 0

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentProfileBinding.bind(view)

        counter = savedInstanceState?.getInt(ARG_COUNTER).orZero()

        val email = arguments?.getString(ARG_EMAIL) ?: "ERROR"

        binding?.run {
            tvTitle.text = "${tvTitle.text} + $email"

            tvTitle.setOnClickListener {
                counter++

                root.showSnackbar("Counter: $counter")
            }
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        outState.putInt(ARG_COUNTER, counter)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    private fun Int?.orZero() = this ?: 0

    companion object {

        private const val ARG_COUNTER = "ARG_COUNTER"

        private const val ARG_EMAIL = "ARG_EMAIL"
        private const val ARG_AGE = "ARG_AGE"

        fun bundle(email: String, age: Int): Bundle = Bundle().apply {
            putString(ARG_EMAIL, email)
            putInt(ARG_AGE, age)
        }
    }
}