package lln.recycler.fragment.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_nome.view.*
import lln.recycler.fragment.R
import lln.recycler.fragment.model.NomeModel

class NomeAdapter(private val context: Context,
                  private val nomes: List<NomeModel>) : RecyclerView.Adapter<NomeAdapter.ViewHolder>() {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val nome = nomes[position]
        holder?.let {
            it.bindView(nome)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_nome, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return nomes.size
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindView(nome: NomeModel) {
            val nomeView = itemView.item_nome

            nomeView.text = nome.nome
        }

    }
}