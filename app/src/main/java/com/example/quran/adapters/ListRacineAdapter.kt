package com.example.quran.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.quran.R

import com.example.quran.fragments.ArabicRootsFragmentDirections
import com.example.quran.models.Racine
import kotlinx.android.synthetic.main.costum_row_aya.view.*
import kotlinx.android.synthetic.main.custom_row_root.view.*

class ListRacineAdapter: RecyclerView.Adapter<ListRacineAdapter.MyViewHolder>() {

    private var racineList = emptyList<Racine>()
    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.custom_row_root,parent,false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = racineList[position]
        holder.itemView.root_id_txt.text = currentItem.idRacine.toString()
        holder.itemView.root_txt.text = currentItem.Racine

        holder.itemView.racine_item_layout.setOnClickListener {
            val action = ArabicRootsFragmentDirections.actionArabicRootsFragment3ToResultAyaListFragment(currentItem)
            holder.itemView.findNavController().navigate(action)
        }
    }

    override fun getItemCount(): Int {
        return racineList.size
    }

    fun setData(racines:List<Racine>){
        this.racineList = racines
        notifyDataSetChanged()
    }

}