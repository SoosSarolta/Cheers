package hu.bme.aut.cheers.ui.list.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import hu.bme.aut.cheers.R
import hu.bme.aut.cheers.ui.list.CoctailItemComparator
import hu.bme.aut.cheers.ui.list.ListPresenter
import kotlinx.android.synthetic.main.item_coctail.view.*

class CoctailsAdapter(
    private val context: Context,
    val clickListener: (ListPresenter.CoctailItem) -> Unit,
    val longClickListener: (ListPresenter.CoctailItem) -> Boolean
) : ListAdapter<ListPresenter.CoctailItem, CoctailsAdapter.ViewHolder>(CoctailItemComparator) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoctailsAdapter.ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_coctail, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: CoctailsAdapter.ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private var coctailName: TextView = itemView.coctailName
        private var coctailType: TextView = itemView.coctailType
        private var coctailImage: ImageView = itemView.coctailThumbnail

        private var coctail: ListPresenter.CoctailItem? = null

        init {
            itemView.setOnClickListener {
                clickListener(coctail!!)
            }
            itemView.setOnLongClickListener {
                longClickListener(coctail!!)
            }
        }

        fun bind(item: ListPresenter.CoctailItem) {
            coctail = item

            coctailName.text = item.name
            coctailType.text = item.type

            Glide.with(coctailImage)
                .load(item.thumbnailUrl)
                .into(coctailImage)
        }
    }
}