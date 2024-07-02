package ru.itis.summerpractice24

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.google.android.material.snackbar.Snackbar
import ru.itis.summerpractice24.databinding.FragmentSettingsBinding
import ru.itis.summerpractice24.utils.showSnackbar

class SettingsFragment : Fragment(R.layout.fragment_settings) {

    private var binding: FragmentSettingsBinding? = null

    private var adapter: CityAdapter? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSettingsBinding.bind(view)
        initAdapter()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    private fun initAdapter() {
        binding?.run {
            adapter = CityAdapter(
                list = CityRepository.cities,
                glide = Glide.with(this@SettingsFragment),
                onClick = {

                    root.showSnackbar(it.url, duration = Snackbar.LENGTH_LONG)

//                    Snackbar.make(root, it.url, Snackbar.LENGTH_LONG).show()
                }
            )

            rvCity.adapter = adapter

//          по-умолчанию линерлайоутманагер строит вертикальный список
            rvCity.layoutManager = LinearLayoutManager(requireContext())
//            rvCity.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
//            rvCity.layoutManager = GridLayoutManager(requireContext(), 2)

            tvTitle.setOnClickListener {
                adapter?.updateDataset(CityRepository.citiesNew)
            }
        }
    }
}