package com.example.quran.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.quran.R
import com.example.quran.fragments.*
import com.example.quran.models.QuranWord
import com.example.quran.models.Verset
import kotlinx.android.synthetic.main.costum_row_aya.view.*
import kotlinx.android.synthetic.main.costum_row_aya_result.view.*
import kotlinx.android.synthetic.main.custom_row_word.view.*

class ListAyaResultAdapter(): RecyclerView.Adapter<ListAyaAdapter.MyViewHolder>() {

    private var wordsList = ArrayList<QuranWord>()


    class MyViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListAyaAdapter.MyViewHolder {
        return ListAyaAdapter.MyViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.custom_row_word, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ListAyaAdapter.MyViewHolder, position: Int) {
        val currentItem = wordsList[position]
        holder.itemView.word_id_txt.setText(currentItem.ID_Word.toString())
        holder.itemView.ar_word_txt.setText(currentItem.ArabicWord )
        holder.itemView.en_word_txt.setText(currentItem.englishWord)

        holder.itemView.setOnClickListener {
           val action = ResultAyaListFragmentDirections.actionResultAyaListFragmentToAyaDetailFragment2(currentItem)
            holder.itemView.findNavController().navigate(action)
        }
    }

    override fun getItemCount(): Int {
        return wordsList.size
    }

    fun setData(newAyat: ArrayList<QuranWord>){
        this.wordsList = newAyat
        notifyDataSetChanged()
    }
}