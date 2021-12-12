package com.dawaai.myecommerceapp.helper

import android.R
import android.content.Context
import android.content.Intent
import android.widget.ImageView
import com.bumptech.glide.Glide

fun Context.navigateToActivity(cls : Class<*>)
{
    val intent = Intent(this,cls)
    intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
    startActivity(intent)

}
fun ImageView.loadImage(url:String, context: Context)
{ Glide.with(context).load(url).into(this)
}