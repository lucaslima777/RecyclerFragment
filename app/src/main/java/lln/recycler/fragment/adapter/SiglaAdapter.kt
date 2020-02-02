package lln.recycler.fragment.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_sigla.view.*
import lln.recycler.fragment.R
import lln.recycler.fragment.model.SiglaModel

class SiglaAdapter(private val context: Context,
                   private val siglas: List<SiglaModel>) : RecyclerView.Adapter<SiglaAdapter.ViewHolder>() {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val sigla = siglas[position]
        holder?.let {
            it.bindView(sigla)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_sigla, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return siglas.size
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindView(sigla: SiglaModel) {
            val siglaView = itemView.item_sigla

            siglaView.text = sigla.sigla
        }

    }
}