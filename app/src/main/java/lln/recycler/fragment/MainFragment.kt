package lln.recycler.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.main_fragment.*
import lln.recycler.fragment.adapter.NomeAdapter
import lln.recycler.fragment.model.NomeModel


class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
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

}
