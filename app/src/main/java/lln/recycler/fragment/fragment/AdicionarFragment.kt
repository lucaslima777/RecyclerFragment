package lln.recycler.fragment.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.MutableLiveData
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
        viewModel.liveData.observe(this, viewModel.changeObserver)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_adicionar, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        //observeViewModel()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initListeners()
    }

    fun setScreenState(screenState: ScreenState<String>) {
        when (screenState) {
            is ScreenState.Success -> {
                showToast("AdicionarFragment" + screenState.data)
                //viewModel.changeObserver.onChanged(screenState)
                Log.i(AdicionarFragment.javaClass.simpleName, screenState.data)
            }
        }
    }

    private fun initListeners() {
        btn_add_nome?.setOnClickListener {
            viewModel.liveData.postValue(ScreenState.Success(edittext_add_nome.text.toString()))
        }
    }

    private fun observeViewModel() {
        viewModel.liveData.observe(viewLifecycleOwner, Observer {
            setScreenState(it)
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
