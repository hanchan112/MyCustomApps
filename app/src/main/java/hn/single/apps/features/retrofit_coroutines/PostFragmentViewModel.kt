package hn.single.apps.features.retrofit_coroutines

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import hn.single.apps.features.common.PlaceHolderRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import retrofit2.Response

class PostFragmentViewModel(private val repository: PlaceHolderRepository) : ViewModel() {

    private val _response: MutableLiveData<Response<Post>> = MutableLiveData()
    val response get() = _response

    fun fetchPostItem() {
        viewModelScope.launch {
            delay(1500)
            _response.value = repository.getPostItem()
        }
    }
}