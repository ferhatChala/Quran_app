package com.example.quran.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.quran.R
import com.example.quran.models.TafssirModel
import com.example.quran.retrofit.RetrofitServices
import kotlinx.android.synthetic.main.fragment_tafssir.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import android.widget.Toast
import androidx.navigation.fragment.navArgs

class TafssirFragment : Fragment() {

    private val args by navArgs<TafssirFragmentArgs>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_tafssir, container, false)

        //retrofit API call
        val call= RetrofitServices.RETROFIT_TAFSSIR_ENDPOINT.getTafssir(args.ayaDet.numSourah,args.ayaDet.numAyah)
        call.enqueue(object : Callback<TafssirModel> {

            override fun onResponse(
                call: Call<TafssirModel>,
                response: Response<TafssirModel>
            ) {
                if(response.isSuccessful){
                    val tafssir=response.body()
                    if(tafssir!=null){
                        view.tafssir_txt.setText(tafssir.text)
                    }else{Toast.makeText(requireContext(),"error client",Toast.LENGTH_SHORT).show()}
                }

            }

            override fun onFailure(call: Call<TafssirModel>, t: Throwable) {
                Toast.makeText(requireContext(),t.message,Toast.LENGTH_SHORT).show()
            }

        })


        return view
    }

}