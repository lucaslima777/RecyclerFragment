package lln.recycler.fragment.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_sigla.*
import lln.recycler.fragment.R
import lln.recycler.fragment.adapter.SiglaAdapter
import lln.recycler.fragment.model.SiglaModel

class SiglaFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        recycler_sigla.layoutManager = LinearLayoutManager(context)
        recycler_sigla.adapter = SiglaAdapter(context!!, mockSiglas())
    }

    private fun mockSiglas(): List<SiglaModel> {
        return listOf(
            SiglaModel("BTC"),
            SiglaModel("ETH"),
            SiglaModel("LTC"),
            SiglaModel("BRL"),
            SiglaModel("XRP"),
            SiglaModel("EUR")
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_sigla, container, false)
    }

    companion object {

        private val ARG_NOME = "Fragment_Nome"

        @JvmStatic
        fun newInstance() =
            SiglaFragment()
    }
}
