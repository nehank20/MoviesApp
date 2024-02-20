package com.example.moviesapp_customnetworksdk.movies_feature.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.moviesapp_customnetworksdk.R
import com.example.moviesapp_customnetworksdk.databinding.FragmentMovieDetailsBinding
import com.example.moviesapp_customnetworksdk.movies_feature.util.HelperFunctions.listToString
import com.example.moviesapp_customnetworksdk.movies_feature.util.binding.loadImageUrl
import com.example.moviesapp_customnetworksdk.movies_feature.viewmodel.MovieViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MovieDetailsFragment : Fragment(R.layout.fragment_movie_details) {

    private val movieViewModel: MovieViewModel by viewModels()
    lateinit var binding : FragmentMovieDetailsBinding
    private val args : MovieDetailsFragmentArgs by navArgs()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMovieDetailsBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupObservers()
        movieViewModel.getMovieDetail(args.movieId)

    }

    private fun setupObservers() {
        movieViewModel.movieDetail.observe(viewLifecycleOwner) { movieDetail ->
            binding.apply {
                loadImageUrl(imageViewBackDrop, movieDetail.backdropPath)
                loadImageUrl(imageViewPoster, movieDetail.posterPath)
                titleTextView.text = movieDetail.title
                tagLineTextView.text = movieDetail.tagline
                overviewTextView.text = movieDetail.overview
                releaseDateTextView.text = movieDetail.releaseDate
                genreTextView.text = listToString(movieDetail.genres)

            }
        }
    }

}