package com.ovrbach.kitabsawtichallenge.contact


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ovrbach.kitabsawtichallenge.base.BaseFragment

class ContactFragment : BaseFragment<ContactViewModel>(ContactViewModel::class.java) {

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_contact, container, false)
    }

    companion object {
        @JvmStatic
        fun newInstance() =
                ContactFragment()
    }
}
