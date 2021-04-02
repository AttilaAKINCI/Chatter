package com.akinci.chatter.feature.splash.view

import android.animation.Animator
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.NavHostFragment
import com.akinci.chatter.R
import com.akinci.chatter.databinding.FragmentSplashBinding
import com.akinci.chatter.feature.splash.viewmodel.SplashViewModel
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class SplashFragment : Fragment() {

    lateinit var binding: FragmentSplashBinding
    private val splashViewModel : SplashViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        /** Initialization of ViewBinding not need for DataBinding here **/
        binding = FragmentSplashBinding.inflate(layoutInflater)
        binding.lifecycleOwner = viewLifecycleOwner

        //hide appbar on splash screen
        (activity as AppCompatActivity).supportActionBar?.hide()

        binding.animation.addAnimatorListener(object : Animator.AnimatorListener {
            override fun onAnimationStart(animation: Animator?) {}
            override fun onAnimationEnd(animation: Animator?) { navigate() }
            override fun onAnimationCancel(animation: Animator?) {}
            override fun onAnimationRepeat(animation: Animator?) {}
        })

        Timber.d("SplashFragment created..")
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        splashViewModel.isLoggedIn.observe(viewLifecycleOwner){
            // when observe anything, start animation.
            binding.animation.playAnimation()
        }
    }

    private fun navigate(){
        Handler(Looper.getMainLooper()).postDelayed({
            if(splashViewModel.isLoggedIn.value.isNullOrBlank()){
                navigateToLogin()
            }else{
                navigateToChatDashboard()
            }
        }, 100)
    }

    private fun navigateToChatDashboard(){
        /** Navigate to Chat Dashboard Page **/
        NavHostFragment.findNavController(this).navigate(R.id.action_splashFragment_to_chatDashboardFragment)
    }

    private fun navigateToLogin(){
        val imageTransition = resources.getString(R.string.image_transition)

        val extras = FragmentNavigatorExtras(
            binding.animation to imageTransition
        )

        /** Navigate to Login Page **/
        NavHostFragment.findNavController(this).navigate(
            R.id.action_splashFragment_to_loginFragment,
            null,
            null,
            extras
        )
    }

}