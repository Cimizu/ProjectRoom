package c14220131.paba.projectroom

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import c14220131.paba.projectroom.adapterDaftar.OnItemClickCallback
import c14220131.paba.projectroom.database.historyBelanja

class adapterHistory (private val historyBelanja : MutableList<historyBelanja>): RecyclerView.Adapter<adapterHistory.ListViewHolder>() {

    private lateinit var onItemClickCallback : OnItemClickCallback


    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var _tvTanggaal = itemView.findViewById<TextView>(R.id.tanggal)
        var _tvItemBarang = itemView.findViewById<TextView>(R.id.Item)
        var _tvjumlahBarang = itemView.findViewById<TextView>(R.id.jumlah)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): adapterHistory.ListViewHolder {
        val view : View = LayoutInflater.from(parent.context).inflate(R.layout.item_listhistory,parent,false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: adapterHistory.ListViewHolder, position: Int) {
        val history = historyBelanja[position]
        holder._tvTanggaal.text = history.tanggal
        holder._tvItemBarang.text = history.item
        holder._tvjumlahBarang.text = history.jumlah
    }

    override fun getItemCount(): Int {
        return historyBelanja.size
    }
}