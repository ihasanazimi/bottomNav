package ir.ha.bottomsheet

import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class FakeAdapter : RecyclerView.Adapter<FakeAdapter.VH>() {

    val list = arrayListOf<String>("ali" , "hasan" , "hosein" , "taqi" , "naqi" , "asgar" , "mahdi" , "shayan" , "amir" , "feyzi" , "danial" , " mohammad" , "nader" , " komeyl" , " mojtaba" , "qasem" , " hamid" , "shahram" , "alireza" , "mahasa" , "setayesh" , "mahan" , "milad" , " ahmad" , "parviz" , "mahmoood" , " rahim" , "qamar")


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        return VH(LayoutInflater.from(parent.context).inflate(R.layout.row,parent,false))
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.bind(list[position])

    }

        override fun getItemCount(): Int {
            return list.size
        }


        class VH(itemView: View) : RecyclerView.ViewHolder(itemView) {
            var tv: TextView = itemView.findViewById(R.id.tv)
            fun bind(t: String) {
                tv.text = "${adapterPosition.toString()}    --->    " + t
            }
        }
    }

