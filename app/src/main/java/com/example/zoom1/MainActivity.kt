package com.example.zoom1

import android.app.AlertDialog
import android.content.Intent
import android.graphics.ColorSpace
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.Menu
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.zoom1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    var adapter: Adapter? = null

    var listofshowdata: ArrayList<MODEL> = ArrayList()
    lateinit var sqlite: SQLITE
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        sqlite = SQLITE(this)
        supportActionBar?.hide()

        adapter = Adapter(this)
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this)

        getdata()
        newdata()


//        if (listofshowdata.isEmpty()){
//            binding.button.visibility=View.VISIBLE
//            binding.recyclerView.visibility=View.GONE
//            binding.button.setOnClickListener {
//                getdata()
//            }
//
//        }else{
//            binding.button.visibility=View.GONE
////            binding.recyclerView.visibility=View.VISIBLE
//        }

    }

    private fun newdata() {
        binding.imageView.setOnClickListener {

            var layout = LayoutInflater.from(this).inflate(R.layout.addrespo, null)
            var owner = layout.findViewById<EditText>(R.id.ownername)
            var desc = layout.findViewById<EditText>(R.id.descword)
            var al = AlertDialog.Builder(this)
            al.setView(layout)

            al.setNegativeButton("CANCLE") { dialog, _ ->
                dialog.dismiss()
            }
            al.setPositiveButton("OK") { dialog, _ ->

                var name = owner.text.toString()
                var descdata = desc.text.toString()

                if (name.isEmpty() && descdata.isEmpty()) {
                    Toast.makeText(this@MainActivity,
                        "FILED IS EMPTY PLEASE ENTER THE VALUE",
                        Toast.LENGTH_LONG).show()
                } else {
                    var model = MODEL(owner = name, descerptions = descdata)
                    var sucess = sqlite.insertdata(model)
                    getdata()
                    if (sucess > -1) {
                        Toast.makeText(this@MainActivity, "VALUE ADD", Toast.LENGTH_LONG).show()
                        dialog.dismiss()
                    } else {
                        Toast.makeText(this@MainActivity, "VALUE NOT ADD", Toast.LENGTH_LONG).show()
                    }
                }
            }
            al.show()
        }
    }

    private fun getdata() {
        val sqllistdata = sqlite.getalldata()
        adapter!!.additem(sqllistdata)
    }
}