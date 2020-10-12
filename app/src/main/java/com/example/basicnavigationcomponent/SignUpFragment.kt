package com.example.basicnavigationcomponent

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import kotlinx.android.synthetic.main.fragment_sign_up.*

class SignUpFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sign_up, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btn_sign_up.setOnClickListener { btnSignUp ->
            if (edt_id.text.toString().toIntOrNull() != null){
                if (edt_password.text.toString() == edt_confirm_password.text.toString())
                    navigateToLoginFragment(btnSignUp, edt_id.text.toString(), edt_password.text.toString())
            }
        }
    }

    private fun navigateToLoginFragment(view: View, id: String, password: String) {
        val direction = SignUpFragmentDirections.actionSignUpFragmentToLoginFragment(
            id = id.toInt(),
            password = password
        )
        view.findNavController().navigate(direction)
    }
}