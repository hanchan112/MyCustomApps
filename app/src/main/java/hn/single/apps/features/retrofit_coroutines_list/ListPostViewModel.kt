package hn.single.apps.features.retrofit_coroutines_list

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import hn.single.apps.features.common.PlaceHolderRepository
import hn.single.apps.features.retrofit_coroutines.Post
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import retrofit2.Response

class ListPostViewModel(private val repository: PlaceHolderRepository) : ViewModel() {

    private val _response: MutableLiveData<Response<List<Post>>> = MutableLiveData()
    val response get() = _response

    fun fetchListPostItem() {
        viewModelScope.launch {
            delay(1500)
            _response.value = repository.getListPostItem()
        }
    }

}

