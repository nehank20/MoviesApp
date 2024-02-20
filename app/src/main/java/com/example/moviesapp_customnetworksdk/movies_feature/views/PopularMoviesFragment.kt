package com.example.moviesapp_customnetworksdk.movies_feature.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.moviesapp_customnetworksdk.R
import com.example.moviesapp_customnetworksdk.databinding.FragmentPopularMoviesBinding
import com.example.moviesapp_customnetworksdk.movies_feature.util.adapter.MovieListAdapter
import com.example.moviesapp_customnetworksdk.movies_feature.viewmodel.MovieViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PopularMoviesFragment : Fragment(R.layout.fragment_popular_movies) {

    private val movieViewModel: MovieViewModel by viewModels()
    lateinit var movieListAdapter: MovieListAdapter
    lateinit var binding : FragmentPopularMoviesBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPopularMoviesBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerView()
        setupObservers()
        movieViewModel.getPopularMovies()
    }

    private fun setupRecyclerView() {
        movieListAdapter = MovieListAdapter{

            val action = PopularMoviesFragmentDirections.actionPopularMoviesFragmentToMovieDetailsFragment(it.id.toString())
            findNavController().navigate(action)

        }
        binding.popularRecyclerView.apply {
            adapter = movieListAdapter
            layoutManager = LinearLayoutManager(context)
        }
    }

    private fun setupObservers() {
        movieViewModel.popularMovies.observe(viewLifecycleOwner) { movieList ->
            movieList.results?.let {
                movieListAdapter.differ.submitList(it)
            }
        }
    }

}