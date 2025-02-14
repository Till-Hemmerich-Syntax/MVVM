package com.syntax.hemmerich.batch17_mvvm.ui

import android.media.Image.Plane
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModel
import com.syntax.hemmerich.batch17_mvvm.R
import com.syntax.hemmerich.batch17_mvvm.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private val viewModel : HomeViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        addAllObserver()


        binding.btnNextPlane.setOnClickListener {
            viewModel.nextPlane()
        }
        binding.btnPrevPlane.setOnClickListener {
            viewModel.prevPlane()
        }
        binding.btnFirst.setOnClickListener {
            viewModel.goToFirstPlane()
        }
    }

    private fun addAllObserver(){
        viewModel.currentPlane.observe(viewLifecycleOwner){
            binding.tvPlaneNbr.text = it.planeNumber.toString()
            binding.tvPlaneName.text = it.planeName
        }
    }


}