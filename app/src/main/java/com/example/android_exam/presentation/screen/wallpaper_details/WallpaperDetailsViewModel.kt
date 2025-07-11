package com.example.android_exam.presentation.screen.wallpaper_details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.android_exam.BuildConfig
import com.example.android_exam.presentation.event.WallpaperDetailsEvent
import com.example.android_exam.presentation.state.wallpaper_details.WallpaperDetailsState
import com.example.android_exam.data.common.Resource
import com.example.android_exam.domain.usecase.profile.SetUserImageUseCase
import com.example.android_exam.domain.usecase.wallpaper_details.GetWallpaperDetailsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WallpaperDetailsViewModel @Inject constructor(
    private val getWallpaperDetailsUseCase: GetWallpaperDetailsUseCase,
    private val setUserImageUseCase: SetUserImageUseCase
) : ViewModel() {
    private val _imageDetailsStateFlow = MutableStateFlow(WallpaperDetailsState())
    val imageDetailsStateFlow = _imageDetailsStateFlow.asStateFlow()

    fun onEvent(event: WallpaperDetailsEvent) {
        when (event) {
            is WallpaperDetailsEvent.GetData -> setData(id = event.id)
            is WallpaperDetailsEvent.SetUserImageEvent -> setUserImage(url = event.url)
        }
    }

    private fun setData(id: Long) {
        viewModelScope.launch {
            getWallpaperDetailsUseCase(BuildConfig.API_KEY, id).collect { resource ->
                _imageDetailsStateFlow.update { currentState ->
                    when (resource) {
                        is Resource.Loading -> currentState.copy(isLoading = resource.loading)
                        is Resource.Success -> currentState.copy(data = resource.successData)
                        is Resource.Error -> currentState.copy(errorMessage = resource.errorMessage)
                    }
                }
            }
        }
    }

    private fun setUserImage(url: String) {
        viewModelScope.launch {
            setUserImageUseCase(url).collect { resource ->
                when (resource) {
                    is Resource.Loading -> _imageDetailsStateFlow.update { currentState ->
                        currentState.copy(
                            isLoading = resource.loading
                        )
                    }

                    is Resource.Error -> _imageDetailsStateFlow.update { currentState ->
                        currentState.copy(
                            errorMessage = resource.errorMessage
                        )
                    }

                    is Resource.Success -> Unit
                }
            }
        }
    }
}

