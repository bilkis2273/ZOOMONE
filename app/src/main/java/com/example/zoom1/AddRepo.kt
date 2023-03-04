package com.example.zoom1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.zoom1.databinding.ActivityAddRepoBinding

class AddRepo : AppCompatActivity() {
    lateinit var binding: ActivityAddRepoBinding
    lateinit var sqlite: SQLITE
    var adapter: Adapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddRepoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        sqlite = SQLITE(this)
        adapter = Adapter(this)

//        binding.addbtn.setOnClickListener {
//
//            var ownertxt = binding.ownername.text.toString()
//            var desctxt = binding.descword.text.toString()
//
//            if (ownertxt.isEmpty() && desctxt.isEmpty()) {
//                Toast.makeText(this@AddRepo,
//                    "FILED IS EMPTY PLEASE ENTER THE VALUE",
//                    Toast.LENGTH_LONG).show()
//            } else {
//                var model = MODEL(owner = ownertxt, descerptions = desctxt)
//                var sucess = sqlite.insertdata(model)
//                adapter!!.notifyDataSetChanged()
//                if (sucess > -1) {
//                    Toast.makeText(this@AddRepo, "VALUE ADD", Toast.LENGTH_LONG).show()
//                    binding.ownername.setText("")
//                    binding.descword.setText("")
//                    adapter!!.notifyDataSetChanged()
//                    finish()
//                } else {
//                    Toast.makeText(this@AddRepo, "VALUE NOT ADD", Toast.LENGTH_LONG).show()
//                }
//            }
//
//        }
    }
}