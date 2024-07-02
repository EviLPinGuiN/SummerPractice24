package ru.itis.summerpractice24

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.core.content.edit
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import ru.itis.summerpractice24.databinding.FragmentMainBinding
import ru.itis.summerpractice24.utils.showSnackbar

class MainFragment : Fragment(R.layout.fragment_main) {

    private var binding: FragmentMainBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentMainBinding.bind(view)

        val pref = context?.getSharedPreferences("Default", Context.MODE_PRIVATE)

        binding?.run {

            pref?.getString("ARG_TEXT", "")
                ?.takeIf { it.isNotEmpty() }
                ?.let {
                    root.showSnackbar(it)
                }

            tvTitle.setOnClickListener {

                val text = etEmail.text.toString()

                pref?.edit {
                    putString("ARG_TEXT", text)
                }
//                val bundle = Bundle()
//                bundle.putString("ARG_EMAIL", text)

                // findNavController - получаем контроллер для работы с навигацией
                findNavController().navigate(
                    resId = R.id.action_mainFragment_to_profileFragment,
                    args = ProfileFragment.bundle(
                        email = text,
                        age = 10,
                    )
                )
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}