package com.example.quran.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.quran.adapters.ListAyaAdapter
import com.example.quran.R
import com.example.quran.models.Verset
import com.example.quran.viewmodel.RacineViewModel

class AyatListFragment : Fragment(),View.OnClickListener {

    private lateinit var mRacineViewModel: RacineViewModel
    
    lateinit var navController: NavController
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val  view = inflater.inflate(R.layout.fragment_ayat_list, container, false)


        //recyclerview
        val adapter = ListAyaAdapter()
        val recyclerView = view.findViewById<RecyclerView>(R.id.ayat_recyclerview)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        //InterventionViewModel
        mRacineViewModel = ViewModelProvider(this).get(RacineViewModel::class.java)
        mRacineViewModel.readAllVersetData.observe(viewLifecycleOwner, Observer { ayat ->
            adapter.setData(ayat as ArrayList<Verset>)
        })


        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    override fun onClick(v: View?) {
        TODO("Not yet implemented")
    }


}