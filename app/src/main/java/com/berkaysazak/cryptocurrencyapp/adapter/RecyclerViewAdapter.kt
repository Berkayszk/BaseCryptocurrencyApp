package com.berkaysazak.cryptocurrencyapp.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.berkaysazak.cryptocurrencyapp.R
import com.berkaysazak.cryptocurrencyapp.model.CryptoModel
import kotlinx.android.synthetic.main.row_layout.view.*

class RecyclerViewAdapter(private val cryptoList : ArrayList<CryptoModel>, private var listener : Listener) : RecyclerView.Adapter<RecyclerViewAdapter.RowHolder>() {
    private val colors : Array<String> = arrayOf("#0095a4","#afeeee","#d51ffb","#c4ff99","#f33434","#1192f3","#f6179a","#f7d62d")

    interface Listener {
        fun onItemClick(cryptoModel: CryptoModel)
    }

    class RowHolder(view : View) : RecyclerView.ViewHolder(view){
        fun bind(cryptoModel: CryptoModel, colors : Array<String>, position: Int, listener: Listener){
            itemView.setOnClickListener {
                listener.onItemClick(cryptoModel)
            }
            itemView.setBackgroundColor(Color.parseColor(colors[position % 8]))
            itemView.text_name.text = cryptoModel.currency
            itemView.text_price.text = cryptoModel.price
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RowHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row_layout,parent,false)
        return RowHolder(view)
    }

    override fun onBindViewHolder(holder: RowHolder, position: Int) {
        holder.bind(cryptoList[position],colors,position,listener)
    }

    override fun getItemCount(): Int {
        return cryptoList.count()
    }
}