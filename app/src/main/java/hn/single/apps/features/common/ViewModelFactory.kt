package hn.single.apps.features.common

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import hn.single.apps.features.retrofit_coroutines.PostFragmentViewModel
import hn.single.apps.features.retrofit_coroutines_list.ListPostViewModel

class ViewModelFactory(private val repository: PlaceHolderRepository) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(PostFragmentViewModel::class.java) -> {
                PostFragmentViewModel(repository) as T
            }
            modelClass.isAssignableFrom(ListPostViewModel::class.java) -> {
                ListPostViewModel(repository) as T
            }
            else -> {
                throw IllegalArgumentException("ViewModel Not Found")
            }
        }
    }
}