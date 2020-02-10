package lln.recycler.fragment.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_nome.*
import lln.recycler.fragment.R
import lln.recycler.fragment.ScreenState
import lln.recycler.fragment.adapter.NomeAdapter
import lln.recycler.fragment.model.NomeModel
import lln.recycler.fragment.viewmodel.NomeViewModel

class NomeFragment : Fragment() {

    lateinit var viewModel: NomeViewModel
    lateinit var adapter: NomeAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(NomeViewModel::class.java)
        viewModel.liveData.observe(this, viewModel.changeObserver)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_nome, container, false)
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        observeViewModel()

        recycler_nome.layoutManager = LinearLayoutManager(context)
        adapter = NomeAdapter(context!!, mockNomes())
        recycler_nome.adapter = adapter

    }

    fun setScreenState(screenState: ScreenState<String>) {
        when (screenState) {
            is ScreenState.Success -> {
                /*recycler_nome.layoutManager = LinearLayoutManager(context)
                recycler_nome.adapter = NomeAdapter(context!!, listOf(NomeModel(screenState.data)))
                adapter.notifyDataSetChanged()*/

                Toast.makeText(activity, "NomeFragment " + screenState.data, Toast.LENGTH_LONG)
                    .show()

            }
        }
    }

    private fun observeViewModel() {
        viewModel.liveData.observe(viewLifecycleOwner, Observer {
            setScreenState(it)
        })
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
