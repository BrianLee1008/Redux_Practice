package com.example.redux_practice_02.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.redux_practice_02.R
import com.example.redux_practice_02.databinding.FragmentSecondBinding
import com.example.redux_practice_02.vm.MainViewModel

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : Fragment() {

    private val mainViewModel: MainViewModel by activityViewModels()

    private var _binding: FragmentSecondBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonSecond.setOnClickListener {
            findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
        }
        // ERNote popTo 네비게이트 시킬때 특정 popTo로 지정해놓은애까지 다 날리고
        setupListener()

    }

    private fun setupListener(){
        setOnAddButtonListener()
    }

    private fun setOnAddButtonListener(){
        binding.buttonAdd.setOnClickListener {
            mainViewModel.numberAddStoreDispatchTest()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}