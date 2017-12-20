package com.android.messaging.presentation.fragment

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.design.widget.Snackbar
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AlertDialog
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.Toolbar
import android.util.Log
import android.view.*
import android.widget.TextView
import com.android.messaging.MainNavigator
import com.android.messaging.R
import com.android.messaging.data.model.Contact
import com.android.messaging.data.model.User
import com.android.messaging.databinding.FragmentContactsBinding
import com.android.messaging.presentation.BaseFragment
import com.android.messaging.presentation.CircleImageView
import com.android.messaging.presentation.ContactBindingAdapter
import com.android.messaging.presentation.databinding.DefaultBindingComponent
import com.android.messaging.presentation.databinding.OnContactClickListener
import com.android.messaging.presentation.viewmodel.ContactsViewModel
import com.bumptech.glide.Glide
import com.bumptech.glide.Priority
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.signature.StringSignature
import javax.inject.Inject

/**
 * Created by kalman.bencze on 02/11/2017.
 */
class ContactsFragment : BaseFragment() {

    companion object {
        const val TAG: String = "ConversationFragment"
    }

    @Inject
    internal lateinit var viewModelFactory: ViewModelProvider.Factory

    val itemListener = OnContactClickListener()

    private lateinit var viewModel: ContactsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModelFactory.create(ContactsViewModel::class.java)

        viewModel = ViewModelProviders.of(this, viewModelFactory).get(ContactsViewModel::class.java)
    }

    override fun onStart() {
        super.onStart()
        itemListener.observe(this, Observer { contact ->
            Log.d(TAG, "onStart: " + contact)
            contact?.let { openConversation(contact) }
        })

    }

    @Inject
    internal lateinit var navigator: MainNavigator

    private fun openConversation(contact: Contact) {
        navigator.openConversationScreen(contact)
    }

    private lateinit var adapter: ContactBindingAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil.inflate<FragmentContactsBinding>(inflater, R.layout.fragment_contacts, null, false, DefaultBindingComponent()) as FragmentContactsBinding
        binding.viewModel = viewModel
        activity?.let {
            adapter = ContactBindingAdapter(it, itemListener)
            binding.contactList.adapter = adapter
            binding.contactList.layoutManager = LinearLayoutManager(activity)
            viewModel.contactList.observe(this, Observer<List<Contact>> { list -> list?.let { data -> adapter.setData(data) } })
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setActionBarTitle(getString(R.string.app_name))
        initializeSideMenuDrawer()
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu_contacts_toolbar, menu)
    }

    fun setActionBarTitle(title: String) {
        actionBar?.title = title
    }

    @Inject
    lateinit var user: User

    private fun initializeSideMenuDrawer() {

        // Initializing Toolbar
        val toolbar = view?.findViewById(R.id.toolbar) as Toolbar

        // Initializing Drawer Layout
        val drawerLayout = view?.findViewById(R.id.drawer_layout) as DrawerLayout

        // Initializing NavigationView
        val navigationView = view?.findViewById(R.id.navigation_view) as NavigationView

        /* Setting Navigation View Item Selected Listener to handle the item click of the
         navigation menu. This method will trigger on item Click of navigation menu
         */
        navigationView.setNavigationItemSelectedListener({ menuItem ->
            // Closing drawer on item click
            drawerLayout.closeDrawers()
            // Check to see which item was being clicked and perform appropriate action
            var message = "Not yet implemented."
            when (menuItem.getItemId()) {
                R.id.navigation_settings -> message = "Settings Selected"
                R.id.navigation_help -> message = "Help Selected"
                R.id.navigation_about -> message = "About Selected"
                R.id.navigation_logout -> {
                    context?.let {
                        AlertDialog.Builder(it)
                                .setTitle(R.string.logout_title_label)
                                .setMessage(R.string.log_out_confirmation_message)
                                .setPositiveButton(R.string.yes_label, { dialog, id -> {} })
                                .setNegativeButton(R.string.no_label, { dialog, id -> dialog.cancel() })
                                .show()
                    }
                }
            }
            showSnackBar(message, Snackbar.LENGTH_SHORT)
            true
        })
        val headerView = navigationView.getHeaderView(0)
        val profilePictureImageView = headerView.findViewById(R.id.profile_image) as CircleImageView
        Glide.with(context)
                .load(user.photo)
                .fitCenter()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .skipMemoryCache(false)
                .signature(StringSignature(user.name + " " + user.photo))
                .priority(Priority.IMMEDIATE)
                .error(R.drawable.vector_profile_placeholder).into(profilePictureImageView)

        val usernameTextView = headerView.findViewById(R.id.user_textview) as TextView
        usernameTextView.setText(user.name)

        val emailTextView = headerView.findViewById(R.id.email_textview) as TextView
        emailTextView.setText(user.number)

        val actionBarDrawerToggle = ActionBarDrawerToggle(activity,
                drawerLayout, toolbar, R.string.app_name, R.string.app_name)
        // Setting the actionbarToggle to drawer layout
        drawerLayout.addDrawerListener(actionBarDrawerToggle)
        // Calling sync state is necessary or else your hamburger icon won't show up
        actionBarDrawerToggle.syncState()
        drawerLayout.addDrawerListener(object : DrawerLayout.DrawerListener {

            override fun onDrawerSlide(drawerView: View, slideOffset: Float) {}

            override fun onDrawerOpened(drawerView: View) {}

            override fun onDrawerClosed(drawerView: View) {}

            override fun onDrawerStateChanged(newState: Int) {
            }
        })

    }


}
