package lln.recycler.fragment.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_nome.*
import lln.recycler.fragment.R
import lln.recycler.fragment.adapter.NomeAdapter
import lln.recycler.fragment.model.NomeModel

class NomeFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_nome, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        recycler_nome.layoutManager = LinearLayoutManager(context)
        recycler_nome.adapter = NomeAdapter(context!!, mockNomes())
    }

    private fun mockNomes(): List<NomeModel> {
        return listOf(
            NomeModel("Bitcoin"),
            NomeModel("Ethereum"),
            NomeModel("Litecoin"),
            NomeModel("Real"),
            NomeModel("Ripple"),
            NomeModel("Euro")
        )
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            NomeFragment()
    }
}
