package ru.itis.summerpractice24

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import ru.itis.summerpractice24.databinding.FragmentMainBinding

class MainFragment : Fragment(R.layout.fragment_main) {

    private var binding: FragmentMainBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentMainBinding.bind(view)

        binding?.run {
            tvTitle.setOnClickListener {

//                val text = etEmail.text.toString()
//                val bundle = Bundle()
//                bundle.putString("ARG_EMAIL", text)

                // findNavController - получаем контроллер для работы с навигацией
                findNavController().navigate(
                    resId = R.id.action_mainFragment_to_profileFragment,
                    args = ProfileFragment.bundle(
                        email = etEmail.text.toString(),
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