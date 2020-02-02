package lln.recycler.fragment.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.fragment_imagem.*
import lln.recycler.fragment.R
import lln.recycler.fragment.adapter.ImagemAdapter
import lln.recycler.fragment.model.ImagemModel

class ImagemFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        recycler_imagem.layoutManager = GridLayoutManager(context, 2)
        recycler_imagem.adapter = ImagemAdapter(context!!, mockImagens())
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_imagem, container, false)
    }

    private fun mockImagens(): List<ImagemModel> {
        return listOf(
            ImagemModel(R.drawable.ic_bitcoin),
            ImagemModel(R.drawable.ic_ethereum),
            ImagemModel(R.drawable.ic_litecoin),
            ImagemModel(R.drawable.ic_real),
            ImagemModel(R.drawable.ic_ripple),
            ImagemModel(R.drawable.ic_euro)
        )
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            ImagemFragment()
    }
}
