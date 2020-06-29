package com.kubra.koubitirme

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detail.*

open class AnimalDetail : AppCompatActivity() {
    private var sahiplen: Button? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        sahiplen = findViewById(R.id.sahiplen)


        setupUI()


        var gelen=getIntent().getStringExtra("pass")
        var gelenName=getIntent().getStringExtra("adi")
        var gelenEgitim=getIntent().getBooleanExtra("egitim",true)
        var gelenUysal=getIntent().getBooleanExtra("uysal",true)


        var resim : ImageView = findViewById(R.id.Resim)
        var poster : ImageView = findViewById(R.id.hayvanResmi)
        var isim : TextView=findViewById(R.id.Name)
        var egitim:CheckBox=findViewById(R.id.eðitim)
        var uysal:CheckBox=findViewById(R.id.uysal)


        Picasso.get().load(gelen).into(resim)
        Picasso.get().load(gelen).into(poster)
        isim.setText(gelenName)

        if(gelenEgitim == true ){
            egitim.setChecked(true)
        }else{
            egitim.setChecked(false)
        }
        if(gelenUysal==true){
            uysal.setChecked(true)
        }else{
            uysal.setChecked(false)
        }
        fun setChecked(viewId: Int, checked: Boolean) {
            (findViewById<View>(viewId) as Checkable).isChecked = checked
        }

        sahiplen?.setOnClickListener{
            val alert = AlertDialog.Builder(this)
            alert.setTitle(gelenName.toString())
            alert.setMessage("Barýnak ile iletiþime geçmek ister misiniz?")
            alert.setCancelable(false)
            alert.setIcon(R.drawable.paw)
            alert.setPositiveButton("Evet") { dialogInterface: DialogInterface, i: Int ->
                val intent= Intent(this,AnimalList::class.java)
                startActivity(intent)}
            alert.setNegativeButton("Hayýr") {dialogInterface: DialogInterface, i: Int ->
                val intent=Intent(this,AnimalList::class.java)
                startActivity(intent)}
            alert.show()
        }



    }
    private fun setupUI(){
        setSupportActionBar(detail_toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowTitleEnabled(false)

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

}

