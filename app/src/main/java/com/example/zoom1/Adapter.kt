package com.example.zoom1

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class Adapter(var context: Context) : RecyclerView.Adapter<Adapter.ViewHolder>() {
    var showdata: ArrayList<MODEL> = ArrayList()

    fun additem(itemadd: ArrayList<MODEL>) {
        this.showdata = itemadd
        notifyDataSetChanged()
    }


    class ViewHolder(var item: View) : RecyclerView.ViewHolder(item) {

        var owneradddata = item.findViewById<TextView>(R.id.textView)
        var descpertionadddata = item.findViewById<TextView>(R.id.textView2)
        var share = item.findViewById<ImageView>(R.id.imageView2)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var item = LayoutInflater.from(parent.context).inflate(R.layout.sample, parent, false)
        return ViewHolder(item)


    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var currentitem = showdata[position]
        holder.owneradddata.text = currentitem.owner
        holder.descpertionadddata.text = currentitem.descerptions
        holder.share.setOnClickListener {
            var intent = Intent()
            intent.setAction(Intent.ACTION_SEND)
            intent.type = "text/plain"
            intent.putExtra(Intent.EXTRA_TEXT,
                "Share to:\n\n https://github.com/bilkis2273?tab=repositories" + holder.owneradddata.text.toString())
            context.startActivity(Intent.createChooser(intent, "Choose Any"))
        }

        holder.itemView.setOnClickListener {
            uri("https://github.com/bilkis2273?tab=repositories")
        }
    }

    private fun uri(s: String) {

        var uri = Uri.parse(s)
        context.startActivity(Intent(Intent.ACTION_VIEW, uri))
    }


    override fun getItemCount(): Int {
        return showdata.size
    }
}