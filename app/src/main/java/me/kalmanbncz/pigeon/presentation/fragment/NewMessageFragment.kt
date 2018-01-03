package me.kalmanbncz.pigeon.presentation.fragment

import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import me.kalmanbncz.pigeon.MainNavigator
import me.kalmanbncz.pigeon.R
import me.kalmanbncz.pigeon.data.model.User
import me.kalmanbncz.pigeon.databinding.FragmentNewMessageBinding
import me.kalmanbncz.pigeon.presentation.BaseFragment
import me.kalmanbncz.pigeon.presentation.databinding.DefaultBindingComponent
import me.kalmanbncz.pigeon.presentation.viewmodel.NewMessageViewModel
import javax.inject.Inject

/**
 * Created by kalman.bencze on 02/11/2017.
 */
class NewMessageFragment : BaseFragment() {

    companion object {
        const val TAG: String = "NewMessageFragment"
        fun get(): NewMessageFragment {
            val f = NewMessageFragment()
            return f
        }
    }

    @Inject
    internal lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var viewModel: NewMessageViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModelFactory.create(NewMessageViewModel::class.java)

        viewModel = ViewModelProviders.of(this, viewModelFactory).get(NewMessageViewModel::class.java)
    }

    @Inject
    internal lateinit var navigator: MainNavigator

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil.inflate<FragmentNewMessageBinding>(inflater, R.layout.fragment_new_message, null, false, DefaultBindingComponent()) as FragmentNewMessageBinding
        binding.viewModel = viewModel
        activity?.let {
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setActionBarTitle(getString(R.string.new_message_title))
    }

    fun setActionBarTitle(title: String) {
        actionBar?.title = title
    }

    @Inject
    lateinit var user: User

}
