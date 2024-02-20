package com.example.moviesapp_customnetworksdk.movies_feature.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.moviesapp_customnetworksdk.R
import com.example.moviesapp_customnetworksdk.databinding.FragmentUpcomingMoviesBinding
import com.example.moviesapp_customnetworksdk.movies_feature.util.adapter.MovieListAdapter
import com.example.moviesapp_customnetworksdk.movies_feature.viewmodel.MovieViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class UpcomingMoviesFragment : Fragment(R.layout.fragment_upcoming_movies) {


    private val movieViewModel: MovieViewModel by viewModels()
    lateinit var movieListAdapter: MovieListAdapter
    lateinit var binding : FragmentUpcomingMoviesBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentUpcomingMoviesBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerView()
        setupObservers()
        movieViewModel.getUpcomingMovies()
    }

    private fun setupRecyclerView() {
        movieListAdapter = MovieListAdapter {
            val action = UpcomingMoviesFragmentDirections.actionUpcomingMoviesFragmentToMovieDetailsFragment(it.id.toString())
            findNavController().navigate(action)
        }
        binding.popularRecyclerView.apply {
            adapter = movieListAdapter
            layoutManager = LinearLayoutManager(context)
        }
    }

    private fun setupObservers() {
        movieViewModel.upcomingMovies.observe(viewLifecycleOwner) { movieList ->
            movieList.results?.let {
                movieListAdapter.differ.submitList(it)
            }
        }
    }

}
