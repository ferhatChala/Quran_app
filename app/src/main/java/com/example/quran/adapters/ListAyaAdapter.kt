package com.example.quran.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.navigation.findNavController
import com.example.quran.models.Verset
import androidx.recyclerview.widget.RecyclerView
import com.example.quran.R
import com.example.quran.fragments.AyatListFragmentDirections
import com.example.quran.models.QuranWord
import kotlinx.android.synthetic.main.costum_row_aya.view.*


class ListAyaAdapter() : RecyclerView.Adapter<ListAyaAdapter.MyViewHolder>() {
    private var ayatList = ArrayList<Verset>()

    class MyViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.costum_row_aya,parent,false))
    }
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = ayatList[position]

        holder.itemView.text_aya.text = currentItem.Text_AR

        //holder.itemView.setOnClickListener {
            //val action = AyatListFragmentDirections.actionAyatListFragment3ToAyaDetailFragment2(currentItem)
            //holder.itemView.findNavController().navigate(action)

         //  val detailAya= AyaDetailFragment()
         //   supportFragmentManager.beginTransaction().apply{
         //  replace(R.id.mainContainer,detailAya).commit()
          //}
        //}
    }

    override fun getItemCount(): Int {
        return ayatList.size

    }

    fun setData(ayat: ArrayList<Verset>){
        this.ayatList = ayat
        notifyDataSetChanged()
    }

}