package com.example.basicnavigationcomponent

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btn_logout.setOnClickListener { btnSignUp ->
            btnSignUp.findNavController().navigate(R.id.action_homeFragment_to_mainFragment)
        }
        callBackArgumentFromLogin()
    }

    private fun callBackArgumentFromLogin() {
        arguments?.let { arguments ->
            val args = HomeFragmentArgs.fromBundle(arguments)
            val id = args.id
            setViewCallBack(id.toString())
        }
    }

    private fun setViewCallBack(id: String) {
        tv_id.text = id
    }
}