package com.example.basicnavigationcomponent

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.findNavController
import kotlinx.android.synthetic.main.fragment_login.*
import kotlinx.android.synthetic.main.fragment_login.btn_sign_up
import kotlinx.android.synthetic.main.fragment_login.edt_id
import kotlinx.android.synthetic.main.fragment_login.edt_password
import kotlinx.android.synthetic.main.fragment_sign_up.*

class LoginFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btn_login.setOnClickListener { btnLogin ->
            if (edt_id.text.toString().toIntOrNull() != null)
                navigateToHomeFragment(btnLogin, edt_id.text.toString())
        }
        btn_sign_up.setOnClickListener { btnSignUp ->
            btnSignUp.findNavController().navigate(R.id.action_loginFragment_to_signUpFragment)
        }
        callBackArgumentFromSignUp()
    }

    private fun navigateToHomeFragment(view: View, id: String) {
        val direction = LoginFragmentDirections.actionLoginFragmentToHomeFragment(
            id = id.toInt()
        )
        view.findNavController().navigate(direction)
    }

    private fun callBackArgumentFromSignUp() {
        arguments?.let { arguments ->
            val args = LoginFragmentArgs.fromBundle(arguments)
            val id = args.id
            val password = args.password
            setViewCallBack(if (id == -1) null else id.toString(), password)
        }
    }

    private fun setViewCallBack(id: String?, password: String?) {
        if (!(id.isNullOrBlank() || password.isNullOrBlank())) {
            edt_id.setText(id)
            edt_password.setText(password)
        }
    }
}