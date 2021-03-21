package com.example.clevertabsdk

import android.content.Context
import android.graphics.Bitmap
import android.graphics.drawable.Drawable


interface LibCleverTap {


    fun drawableToBitmap(drawable: Drawable): Bitmap


}