package com.example.retrofitkullanimi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //kisiSil()
        //kisiEkle()
        //kisiGuncelle()
        //tumKisiler()
        kisiAra()

    }


    fun kisiSil(){
        val kdi = ApiUtils.getKisilerDaoInterface()

        kdi.kisiSil(542).enqueue(object : Callback<CRUDcevap>{
            override fun onResponse(call: Call<CRUDcevap>, response: Response<CRUDcevap>) {

                if (response != null){

                    Log.e("Başarı",response.body()!!.success.toString())
                    Log.e("Başarı",response.body()!!.message)

                }
            }

            override fun onFailure(call: Call<CRUDcevap>, t: Throwable) {

            }


        })
    }

    fun kisiEkle(){
        val kdi = ApiUtils.getKisilerDaoInterface()

        kdi.kisiEkle("BUASLDJADKAJL","0535565644656Q46456.....").enqueue(object : Callback<CRUDcevap>{
            override fun onResponse(call: Call<CRUDcevap>, response: Response<CRUDcevap>) {

                if (response != null){

                    Log.e("Başarı",response.body()!!.success.toString())
                    Log.e("Başarı",response.body()!!.message)

                }
            }

            override fun onFailure(call: Call<CRUDcevap>, t: Throwable) {

            }


        })
    }

    fun kisiGuncelle(){

        val kdi = ApiUtils.getKisilerDaoInterface()

        kdi.kisiGuncelle(546,"MUHAMMET SALIH ","111111111").enqueue(object : Callback<CRUDcevap>{
            override fun onResponse(call: Call<CRUDcevap>, response: Response<CRUDcevap>) {

                if (response != null){

                    Log.e("Başarı",response.body()!!.success.toString())
                    Log.e("Başarı",response.body()!!.message)

                }
            }

            override fun onFailure(call: Call<CRUDcevap>, t: Throwable) {

            }


        })
    }

    fun tumKisiler(){
        val kdi = ApiUtils.getKisilerDaoInterface()

        kdi.tumKisiler().enqueue(object : Callback<KisilerCevap>{
            override fun onResponse(call: Call<KisilerCevap>, response: Response<KisilerCevap>) {

                if (response != null){
                    val kisilerListe = response.body()!!.kisiler

                    for (k in kisilerListe){
                        Log.e("************","*************")
                        Log.e("Kisi_id",k.kisiId.toString())
                        Log.e("Kisi ad",k.kisiAd)
                        Log.e("Kisi tel",k.kisiTel)
                    }

                }
            }

            override fun onFailure(call: Call<KisilerCevap>, t: Throwable) {

            }


        })
    }

    fun kisiAra(){

        val kdi = ApiUtils.getKisilerDaoInterface()

        kdi.kisiArama("A").enqueue(object : Callback<KisilerCevap>{
            override fun onResponse(call: Call<KisilerCevap>, response: Response<KisilerCevap>) {

                if (response != null){
                    val kisilerListe = response.body()!!.kisiler

                    for (k in kisilerListe){
                        Log.e("************","*************")
                        Log.e("Kisi_id",k.kisiId.toString())
                        Log.e("Kisi ad",k.kisiAd)
                        Log.e("Kisi tel",k.kisiTel)
                    }

                }
            }

            override fun onFailure(call: Call<KisilerCevap>, t: Throwable) {

            }


        })
    }
}