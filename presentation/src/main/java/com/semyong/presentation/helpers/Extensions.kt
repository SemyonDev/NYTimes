package com.semyong.presentation.helpers

import android.content.Context
import android.database.Cursor
import android.net.Uri
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import com.bumptech.glide.Glide

infix fun ViewGroup.inflate(layout: Int) =
    LayoutInflater.from(context).inflate(layout, this, false)

fun ImageView.load(url: String) =
    Glide.with(this)
        .load(url)
        .into(this)

fun  Uri.getRealPathFromUri(context: Context): String? {
    val proj = arrayOf(MediaStore.Images.Media.DATA)
    var cursor: Cursor? = context.contentResolver.query(this, proj, null, null, null)
    val returnString = cursor?.let {
        it.moveToFirst()
        it.getString(it.getColumnIndexOrThrow(MediaStore.Images.Media.DATA))
    }
    cursor?.close()
    return returnString
}