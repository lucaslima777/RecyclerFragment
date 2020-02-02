package lln.recycler.fragment.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_imagem.view.*
import lln.recycler.fragment.R
import lln.recycler.fragment.model.ImagemModel

class ImagemAdapter(private val context: Context,
                    private val idImagens: List<ImagemModel>) : RecyclerView.Adapter<ImagemAdapter.ViewHolder>() {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val imagemId = idImagens[position]
        holder?.let {
            it.bindView(imagemId)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_imagem, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return idImagens.size
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindView(id: ImagemModel) {
            val imagemView = itemView.item_img

            imagemView.setImageResource(id.idImagem)
        }

    }
}