package com.example.quran.fragments

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.quran.R
import com.example.quran.adapters.ListRacineAdapter
import com.example.quran.databinding.ActivityMainBinding
import com.example.quran.models.Racine
import com.example.quran.viewmodel.RacineViewModel
import kotlinx.android.synthetic.main.fragment_arabic_roots.view.*


class ArabicRootsFragment : Fragment() , SearchView.OnQueryTextListener {

    private lateinit var binding: ActivityMainBinding
    private lateinit var mRacineViewModel: RacineViewModel

    private val adapter : ListRacineAdapter by lazy { ListRacineAdapter() }
    private lateinit var searchView :SearchView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_arabic_roots, container, false)


        //recyclerview

        val recyclerView = view.racines_recyclerview
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())


        //InterventionViewModel
        mRacineViewModel = ViewModelProvider(this).get(RacineViewModel::class.java)
        mRacineViewModel.readAllRacineData.observe(viewLifecycleOwner, Observer { racines ->
            adapter.setData(racines)
        })

        //app menu
        setHasOptionsMenu(true)
        //recyclerview
        //val adapter = ListRacineAdapter()
        //val recyclerView = view.findViewById<RecyclerView>(R.id.racines_recyclerview)
        //recyclerView.adapter = adapter
        //recyclerView.layoutManager = LinearLayoutManager(requireContext())
       // adapter.setData(racines)


        return view
    }


    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.search_menu,menu)

        val search = menu?.findItem(R.id.menu_search)
        val searchView = search?.actionView as? SearchView
        searchView?.isSubmitButtonEnabled = true
        searchView?.setOnQueryTextListener(this)
    }

    override fun onQueryTextSubmit(query: String?): Boolean {
        if (query != null){
            searchRacine(query)
        }
        return true
    }

    override fun onQueryTextChange(query: String?): Boolean {
        if (query != null){
            searchRacine(query)
        }
        return true
    }

    private fun searchRacine(query:String){
        val searchQuery = "%$query%"
        mRacineViewModel.searchRacine(searchQuery).observe(viewLifecycleOwner, Observer{ list ->
                adapter.setData(list)
        })
    }

}
