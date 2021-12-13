package com.mollestudio.android.catanai.adapter

import android.content.Context
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AlphaAnimation
import android.widget.ImageView
import android.widget.TextView
import androidx.viewpager.widget.PagerAdapter
import com.mollestudio.android.catanai.R
import com.mollestudio.android.catanai.model.OnBoardingData
import pl.droidsonroids.gif.GifImageView
import java.util.*
import java.util.logging.Handler
import kotlin.concurrent.schedule
import java.util.concurrent.TimeUnit

class OnBoardingViewPagerAdapter(private var context: Context, private var onBoardingDataList: List<OnBoardingData>) : PagerAdapter() {
    override fun getCount(): Int {
        return onBoardingDataList.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val view = LayoutInflater.from(context).inflate(R.layout.onboardin_screen_layout, null)
        val imageView: GifImageView
        val title: TextView
        val desc: TextView

        imageView = view.findViewById(R.id.imageView)
        title = view.findViewById(R.id.title2)
        desc = view.findViewById(R.id.desc)

        imageView.setImageResource(onBoardingDataList[position].imageUrl)
        title.text = onBoardingDataList[position].title
        desc.text = onBoardingDataList[position].desc

        container.addView(view)
        return view
    }

}