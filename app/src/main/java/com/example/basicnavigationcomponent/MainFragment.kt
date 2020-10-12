package com.example.basicnavigationcomponent

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_main.*
class MainFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btn_login.setOnClickListener { btnLogin ->
            btnLogin.findNavController().navigate(R.id.action_mainFragment_to_loginFragment)
        }
        btn_sign_up.setOnClickListener { btnSignUp ->
            btnSignUp.findNavController().navigate(R.id.action_mainFragment_to_signUpFragment)
        }
    }
}