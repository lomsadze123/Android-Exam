package com.example.android_exam.presentation.util

import android.Manifest
import android.app.WallpaperManager
import android.content.Context
import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.widget.Toast
import androidx.annotation.RequiresPermission
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition
import com.example.android_exam.data.common.AppError
import javax.inject.Inject

class WallpaperUtil @Inject constructor(val context: Context) {

    @RequiresPermission(Manifest.permission.SET_WALLPAPER)
    fun setWallpaper(
        bitmap: Bitmap,
        setHomeScreen: Boolean = true,
        setLockScreen: Boolean = false
    ) {
        try {
            val flags = when {
                setHomeScreen && setLockScreen -> WallpaperManager.FLAG_SYSTEM or WallpaperManager.FLAG_LOCK
                setHomeScreen -> WallpaperManager.FLAG_SYSTEM
                setLockScreen -> WallpaperManager.FLAG_LOCK
                else -> 0
            }
            WallpaperManager.getInstance(context).setBitmap(bitmap, null, true, flags)
        } catch (t: Throwable) {
            val errorMessage = AppError.fromException(t).message
            Toast.makeText(context, errorMessage, Toast.LENGTH_SHORT).show()
        }
    }

    fun downloadAndSetWallpaper(
        imageUrl: String,
        setHomeScreen: Boolean = true,
        setLockScreen: Boolean = false
    ) {
        Glide.with(context).asBitmap().load(imageUrl).into(object : CustomTarget<Bitmap>() {
            @RequiresPermission(Manifest.permission.SET_WALLPAPER)
            override fun onResourceReady(resource: Bitmap, transition: Transition<in Bitmap>?) {
                setWallpaper(resource, setHomeScreen, setLockScreen)
            }

            override fun onLoadCleared(placeholder: Drawable?) {}
        })
    }
}