package com.example.moviesapp_customnetworksdk.core.views

import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.moviesapp_customnetworksdk.core.viewmodel.BaseViewModel

open class BaseActivity : AppCompatActivity() {

    private val TAG = this.javaClass.name

    protected fun setupBaseViewModel(viewModel: BaseViewModel){

        viewModel.errorMessages.observe(this) {
            Log.e(TAG, "setupBaseViewModel: Error $it")
        }

        viewModel.loading.observe(this) {
            if(it) {
                // TODO show progress bar loader
            }else {
                // TODO hide progress bar loader
            }
        }

        viewModel.exception.observe(this) {
            Log.e(TAG, "setupBaseViewModel: Exception $it")
        }
    }
}