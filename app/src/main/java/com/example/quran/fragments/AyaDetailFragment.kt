package com.example.quran.fragments

import android.media.AudioManager
import android.media.MediaPlayer
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.example.quran.R
import com.example.quran.models.AyaRef
import com.example.quran.models.Verset
import com.example.quran.viewmodel.RacineViewModel
import kotlinx.android.synthetic.main.fragment_aya_detail.view.*
import java.io.IOException

class AyaDetailFragment() : Fragment() {

    private lateinit var ayaRef:AyaRef
    private lateinit var mRacineViewModel: RacineViewModel
    private val args by navArgs<AyaDetailFragmentArgs>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_aya_detail, container, false)


        //get aya

        var indexAya:Int
         mRacineViewModel = ViewModelProvider(this).get(RacineViewModel::class.java)
         mRacineViewModel.getVersetById(args.currentItem.Id_Aya).observe(viewLifecycleOwner, Observer { aya ->
            //Toast.makeText(requireContext(),aya.Text_AR, Toast.LENGTH_LONG).show()
             view.text_ar.setText(aya.Text_AR)
             view.numAya.setText("الآية : "+ aya.NumAya.toString())

             // idSourat/idAya
             ayaRef= AyaRef(aya.IdSourat,aya.NumAya)
             mRacineViewModel.getSurahById(aya.IdSourat).observe(viewLifecycleOwner, Observer { surah ->
                 view.nomSourat.setText(surah.NomSourat)
             })

             mRacineViewModel.getSurahById(aya.IdSourat-1).observe(viewLifecycleOwner, Observer { surah ->
                 
             })
         })





        


        view.fav.setOnClickListener {
            view.fav.setImageResource(R.drawable.ic_favorit_full)
        }


        view.listen_aya.setOnClickListener {
            Toast.makeText(requireContext(),"not implemented yet ",Toast.LENGTH_SHORT).show()
            playAudio(ayaRef.numAyah.toString())
        }
        view.read_tafssir.setOnClickListener {
            val action = AyaDetailFragmentDirections.actionAyaDetailFragment2ToTafssirFragment2(ayaRef)
            view.read_tafssir.findNavController().navigate(action)
        }
        return view
    }

    private fun playAudio(id:String) {
        val audioUrl = "https://cdn.islamic.network/quran/audio/128/ar.alafasy/"+id+".mp3"
        val mPlayer = MediaPlayer()
        mPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC)

        try{
            mPlayer.setDataSource(audioUrl)
            mPlayer.prepare()
            mPlayer.start()

        }catch (e: IOException){
            e.printStackTrace()
            Toast.makeText(requireContext(),"error happend ",Toast.LENGTH_SHORT).show()
        }

    }



}