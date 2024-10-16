import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.tastefinder.R
import com.example.tastefinder.Restaurant

class FavoritesAdapter(
    private val items: List<Restaurant>,
    private val onFavoriteClick: (Restaurant) -> Unit
) : RecyclerView.Adapter<FavoritesAdapter.FavoritesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoritesViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.fav_restaurant, parent, false)
        return FavoritesViewHolder(view)
    }

    override fun onBindViewHolder(holder: FavoritesViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size

    inner class FavoritesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val logo: ImageView = itemView.findViewById(R.id.logo)
        private val name: TextView = itemView.findViewById(R.id.name)
        private val favoriteIcon: ImageView = itemView.findViewById(R.id.favorite)

        fun bind(restaurant: Restaurant) {
            name.text = restaurant.name
            logo.setImageResource(restaurant.imageResource)

            // Toggle favorite state on click
            favoriteIcon.setOnClickListener {
                onFavoriteClick(restaurant)
            }
        }
    }
}
