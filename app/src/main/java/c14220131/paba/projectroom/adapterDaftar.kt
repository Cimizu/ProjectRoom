package c14220131.paba.projectroom

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import c14220131.paba.projectroom.database.daftarBelanja

class adapterDaftar (private val daftarBelanja : MutableList<daftarBelanja>): RecyclerView.Adapter<adapterDaftar.ListViewHolder>(){

    private lateinit var onItemClickCallback : OnItemClickCallback

    interface OnItemClickCallback{
        fun detData(dtBelanja: daftarBelanja)
        fun selesaiData(dtBelanja: daftarBelanja)
    }
    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback){
        this.onItemClickCallback = onItemClickCallback
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): adapterDaftar.ListViewHolder {
        val view : View = LayoutInflater.from(parent.context).inflate(R.layout.item_list,parent,false)
        return ListViewHolder(view)
    }

    inner class  ListViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var _tvTanggaal = itemView.findViewById<TextView>(R.id.tanggal)
        var _tvItemBarang = itemView.findViewById<TextView>(R.id.Item)
        var _tvjumlahBarang = itemView.findViewById<TextView>(R.id.jumlah)
        var _btnEdit = itemView.findViewById<ImageView>(R.id.btnUpdate)
        var _btnDelete = itemView.findViewById<ImageView>(R.id.btnDelete)
        var _btnDone = itemView.findViewById<Button>(R.id.btnDone)
    }
    override fun getItemCount(): Int {
        return daftarBelanja.size
    }

    fun isiData (daftar: List<daftarBelanja>){
        daftarBelanja.clear()
        daftarBelanja.addAll(daftar)
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: adapterDaftar.ListViewHolder, position: Int) {
        var daftar = daftarBelanja[position]
        holder._tvTanggaal.setText(daftar.tanggal)
        holder._tvItemBarang.setText(daftar.item)
        holder._tvjumlahBarang.setText(daftar.jumlah)

        holder._btnEdit.setOnClickListener {
            val intent = Intent(it.context, TambahDaftar::class.java)
            intent.putExtra("id", daftar.id)

            intent.putExtra("addEdit",1)
            it.context.startActivity(intent)
        }
        holder._btnDelete.setOnClickListener {
            onItemClickCallback.detData(daftar)
        }
        holder._btnDone.setOnClickListener {
            onItemClickCallback.selesaiData(daftar)
        }
    }
}