package com.android.messaging.presentation

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.support.design.widget.Snackbar
import android.support.v4.app.FragmentManager
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.View
import com.android.messaging.R
import dagger.android.support.DaggerFragment


/**
 * This fragment is used to hold general fragment logic, that is relevant in all screens
 * Created by kalman.bencze on 20/12/2017.
 */
abstract class BaseFragment : DaggerFragment(), FragmentManager.OnBackStackChangedListener {

    protected var actionBar: ActionBar? = null

    protected var drawerLayout: DrawerLayout? = null

    protected var mUiHandler = Handler(Looper.getMainLooper())
    /**
     * SnackBar reference used for hiding previous snackbar on frequent calls on showSnackBar() methods
     */
    protected var mSnackBar: Snackbar? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retainInstance = true//we retain all fragments by default
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val toolbar = view.findViewById(R.id.toolbar) as Toolbar
        drawerLayout = view.findViewById(R.id.drawer_layout)
        (activity as AppCompatActivity).setSupportActionBar(toolbar)
        toolbar.setNavigationOnClickListener({ v -> activity!!.onBackPressed() })
        actionBar = (activity as AppCompatActivity).supportActionBar
    }

    override fun onStart() {
        super.onStart()
        fragmentManager!!.addOnBackStackChangedListener(this)
    }

    override fun onStop() {
        fragmentManager!!.removeOnBackStackChangedListener(this)
        super.onStop()
    }

    /**
     * This method will enable or disable back button from every fragment depending on the backstack
     * if backstack<=1 then back button from actionbar will be disabled.
     */
    override fun onBackStackChanged() {
        val navigationStackIsEmpty = fragmentManager!!.backStackEntryCount <= 1
        if (actionBar != null) {
            actionBar!!.setDisplayHomeAsUpEnabled(!navigationStackIsEmpty)
        }
        if (drawerLayout != null) {
            drawerLayout!!.setDrawerLockMode(if (navigationStackIsEmpty) DrawerLayout.LOCK_MODE_UNLOCKED else DrawerLayout.LOCK_MODE_LOCKED_CLOSED)
        }
    }

    @JvmOverloads
    fun showSnackBar(resId: Int, duration: Int, button: String? = null, onClick: Runnable? = null) {
        showSnackBar(getText(resId), duration, button, onClick)
    }

    fun showSnackBar(resId: Int, duration: Int, buttonResId: Int, onClick: Runnable) {
        showSnackBar(getText(resId), duration, getText(buttonResId), onClick)
    }

    @JvmOverloads
    fun showSnackBar(text: CharSequence, duration: Int, button: CharSequence? = null, onClick: Runnable? = null) {
        mUiHandler.post(object : Runnable {

            internal var shouldGoUp: Boolean = false

            override fun run() {
                val view = view
                if (mSnackBar != null && mSnackBar!!.isShown) {
                    mSnackBar!!.setText(text)
                    mSnackBar!!.duration = duration
                    if (button != null && onClick != null) {
                        mSnackBar!!.setAction(button) { v -> onClick.run() }
                    }
                    return
                }
                if (view == null) {
                    return
                }
                mSnackBar = Snackbar.make(view, text, duration)
                if (button != null && onClick != null) {
                    mSnackBar!!.setAction(button) { v -> onClick.run() }
                }
                shouldGoUp = true
                mSnackBar!!.show()
            }
        })
    }
}
