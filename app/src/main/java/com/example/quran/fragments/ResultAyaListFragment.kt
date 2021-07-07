package com.example.quran.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.quran.R
import com.example.quran.adapters.ListAyaAdapter
import com.example.quran.adapters.ListAyaResultAdapter
import com.example.quran.models.QuranWord
import com.example.quran.models.Verset
import com.example.quran.viewmodel.RacineViewModel
import kotlinx.android.synthetic.main.fragment_ayat_list.view.*
import kotlinx.android.synthetic.main.fragment_result_aya_list.view.*
import kotlinx.android.synthetic.main.fragment_result_aya_list.view.word_res_title

class ResultAyaListFragment : Fragment() {

    private val args by navArgs<ResultAyaListFragmentArgs>()

    //private var wordList = ArrayList<QuranWord>()
    //private var ayatListResult= mutableListOf<Verset>()


    private lateinit var mRacineViewModel: RacineViewModel
    private var idracine:Int = 1
    private val adapter : ListAyaResultAdapter by lazy { ListAyaResultAdapter() }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment

       val  view = inflater.inflate(R.layout.fragment_result_aya_list, container, false)


        //recyclerview
        val recyclerView = view.ayat_result_recyclerview
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())


        //MainViewModel
        mRacineViewModel = ViewModelProvider(this).get(RacineViewModel::class.java)
        mRacineViewModel.getWordByIdRacine(args.currentItem.idRacine).observe(viewLifecycleOwner, Observer { words ->
            adapter.setData(words as ArrayList<QuranWord>)
            //Toast.makeText(requireContext(),words[0].ArabicWord,Toast.LENGTH_LONG).show()
            view.word_res_title.setText( " الكلمات المشتقة من : " + args.currentItem.Racine + " " + words.size )
        })
        
           // mRacineViewModel.getVersetById("1.1").observe(viewLifecycleOwner, Observer { aya ->
//            Toast.makeText(requireContext(),aya.Text_AR,Toast.LENGTH_LONG).show()
                //ayatListResult.add(aya)
           // })


        return view
    }

}