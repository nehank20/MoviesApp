package com.example.moviesapp_customnetworksdk

import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.moviesapp_customnetworksdk.core.views.BaseActivity
import com.example.moviesapp_customnetworksdk.databinding.ActivityMainBinding
import com.nehank.networking.api_netlink.ApiNetLink
import dagger.hilt.android.AndroidEntryPoint

/*


Create A Movies List App
● Use the Custom Network SDK developed above for Networking
● Consume TMDb API https://developers.themoviedb.org/3/getting-started/introduction
● Show Movies List Page With Tab for Latest & Popular and Movie Detail Page
● For List Design Reference - https://www.themoviedb.org/?language=en-US
● For Details Page Designs Reference -
https://www.themoviedb.org/movie/181812-star-wars-the-rise-of-skywalker?language=en
-US
 */

@AndroidEntryPoint
class MainActivity : BaseActivity() {

    lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bottomNavigationView.post {
            binding.bottomNavigationView.setupWithNavController(binding.moviesContainerView.findNavController())
        }



    }

}