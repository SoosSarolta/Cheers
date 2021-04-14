package hu.bme.aut.cheers.ui.list

import androidx.recyclerview.widget.DiffUtil

object CoctailItemComparator : DiffUtil.ItemCallback<ListPresenter.CoctailItem>() {
    override fun areItemsTheSame(oldItem: ListPresenter.CoctailItem, newItem: ListPresenter.CoctailItem): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: ListPresenter.CoctailItem, newItem: ListPresenter.CoctailItem): Boolean {
        return oldItem == newItem
    }
}