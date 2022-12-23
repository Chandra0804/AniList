package com.example.anilist

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.anilist.databinding.FragmentSecondBinding

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class CreateAccount : Fragment() {

    private var _binding: FragmentSecondBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.changetosignin.setOnClickListener {
            findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
        }

        binding.SignUp.setOnClickListener {
            signUpUser()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun signUpUser(){
        val email : String = binding.Email.text.toString()
        val password : String = binding.Password.text.toString()
        val confpass : String = binding.confirmPassword.text.toString()
        val userName :String = binding.userName.text.toString()

        if(!binding.checkBox.isChecked){
            Toast.makeText(requireContext(),"You need to agree to our terms of service",Toast.LENGTH_SHORT).show()
            return
        }
        if(email.isBlank() || password.isBlank() || confpass.isBlank() || userName.isBlank()){
            Toast.makeText(requireContext(),"Please fill the required fields",Toast.LENGTH_SHORT).show()
            return
        }
        if(password != confpass){
            Toast.makeText(requireContext(),"Password and Confirm Password fields does not match",Toast.LENGTH_SHORT).show()
            return
        }
    }
}