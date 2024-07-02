package ru.itis.summerpractice24

import android.content.Context
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.RequestManager
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import ru.itis.summerpractice24.databinding.ItemCityBinding

class CityHolder(
    private val binding: ItemCityBinding,
    private val glide: RequestManager,
    private val onClick: (City) -> Unit,
) : ViewHolder(binding.root) {

    private val requestOptions = RequestOptions
        .diskCacheStrategyOf(
            DiskCacheStrategy.ALL
        )

    private val context: Context
        get() = itemView.context

    fun onBind(city: City) {
        binding.run {
            tvCity.text = city.name
            tvCountry.text = city.country

            glide
                .load(city.url)
                .error(R.drawable.img_not_found)
                .placeholder(R.drawable.img_cat)
                .apply(requestOptions)
                .into(ivImage)

            root.setOnClickListener {
                onClick.invoke(city)
            }

            tvCity.setTextColor(context.getColor(city.getTitleColor()))
        }
    }

    private fun City.getTitleColor(): Int = if (url.length > 120) {
        R.color.purple
    } else {
        R.color.blue
    }
}
