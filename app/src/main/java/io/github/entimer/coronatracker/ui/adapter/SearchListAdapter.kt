package io.github.entimer.coronatracker.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import io.github.entimer.coronatracker.R
import io.github.entimer.coronatracker.api.country.Country

class SearchListAdapter(items: ArrayList<Country>): RecyclerView.Adapter<SearchListAdapter.ViewHolder>() {
    private var items = items

    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val nameView: TextView = view.findViewById(R.id.search_list_item_name)
        val codeView: TextView = view.findViewById(R.id.search_list_item_code)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context = parent.context
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view = inflater.inflate(R.layout.layout_item_search_list, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.nameView.text = items[position].name
        holder.codeView.text = items[position].code
    }

    fun updateList(items: ArrayList<Country>) {
        this.items = items
        notifyDataSetChanged()
    }
}