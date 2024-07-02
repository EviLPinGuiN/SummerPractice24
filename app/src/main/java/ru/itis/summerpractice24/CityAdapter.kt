package ru.itis.summerpractice24

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import ru.itis.summerpractice24.databinding.ItemCityBinding

class CityAdapter(
    private var list: List<City>,
    private val glide: RequestManager,
    private val onClick: (City) -> Unit,
) : RecyclerView.Adapter<CityHolder>() {


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CityHolder = CityHolder(
        binding = ItemCityBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        ),
        glide = glide,
        onClick = onClick,
    )

    override fun onBindViewHolder(holder: CityHolder, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int = list.size

    fun updateDataset(newList: List<City>) {
        list = newList
        notifyDataSetChanged()
    }
}