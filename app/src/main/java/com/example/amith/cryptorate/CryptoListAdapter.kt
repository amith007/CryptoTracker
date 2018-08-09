package com.example.amith.cryptorate

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.coinlist_row.view.*

class CryptoListAdapter(val coinList: ArrayList<Coin>) : RecyclerView.Adapter<CryptoListAdapter.CryptoViewHolder>() {

    override fun getItemCount(): Int {
        return coinList.size
    }

    override fun onBindViewHolder(holder: CryptoViewHolder, position: Int) {
        holder.coinName.text = coinList.get(position).name
        holder.coinName.setOnClickListener {
            if (!holder.coinName.isChecked) {
                holder.coinName.setCheckMarkDrawable(R.drawable.checkbox_marked)
                holder.coinName.isChecked = true
            } else {
                holder.coinName.setCheckMarkDrawable(R.drawable.checkbox_blank_outline)
                holder.coinName.isChecked = false
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CryptoViewHolder {
        return CryptoViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.coinlist_row, parent, false))
    }

    class CryptoViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var coinName = view.coinListItem
    }

}



