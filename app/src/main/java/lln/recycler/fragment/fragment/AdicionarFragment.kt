package lln.recycler.fragment.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.fragment_adicionar.*
import lln.recycler.fragment.R
import lln.recycler.fragment.ScreenState
import lln.recycler.fragment.viewmodel.NomeViewModel

class AdicionarFragment : Fragment() {

    lateinit var viewModel: NomeViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(NomeViewModel::class.java)
        observeViewModel()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_adicionar, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initListeners()
        val nomeObserver = Observer<ScreenState<String>> { nomes ->
            setScreenState(nomes)
        }

        viewModel.getNome().observe(activity!!, nomeObserver)
    }

    fun setScreenState(screenState: ScreenState<String>) {
        when (screenState) {
            is ScreenState.Success -> {
                Log.i(AdicionarFragment.javaClass.simpleName, screenState.data)
            }
        }
    }

    private fun initListeners() {
        btn_add_nome?.setOnClickListener {
            viewModel._nome.value = ScreenState.Success(edittext_add_nome.text.toString())
        }
    }

    private fun observeViewModel() {
        viewModel._nome.observe(this, Observer {
        })

    }

    private fun showToast(value: String) {
        Toast.makeText(activity, value, Toast.LENGTH_LONG).show()
    }

    companion object {

        @JvmStatic
        fun newInstance() =
            AdicionarFragment()
    }
}
