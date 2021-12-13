package com.mollestudio.android.catanai
import com.mollestudio.android.catanai.solver.*

import android.animation.ObjectAnimator
import android.animation.PropertyValuesHolder
import android.annotation.SuppressLint
import android.content.*
import android.content.pm.ActivityInfo
import android.graphics.Canvas
import android.graphics.Point
import android.graphics.drawable.Drawable
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.res.ResourcesCompat
import com.mollestudio.android.catanai.databinding.ActivityMainBinding
import org.junit.Assert.assertEquals
import org.junit.Assert.assertThat
import org.junit.Test
import java.lang.Math.pow
import kotlin.math.pow
import kotlin.math.sqrt
import kotlin.properties.Delegates
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.mollestudio.android.catanai.adapter.OnBoardingViewPagerAdapter
import com.mollestudio.android.catanai.model.OnBoardingData
import org.w3c.dom.Text


/**
 * Main Screen
 */

class MainActivity : AppCompatActivity() {

  var onBoardingViewPagerAdapter: OnBoardingViewPagerAdapter? = null
  var tabLayout: TabLayout? = null
  var onBoardingViewPager: ViewPager? = null
  var next: TextView? = null
  var position = 0
  var sharedPreferences: SharedPreferences? = null
  private lateinit var binding: ActivityMainBinding

  @SuppressLint("UseSwitchCompatOrMaterialCode", "SetTextI18n")
  override fun onCreate(savedInstanceState: Bundle?) {

    setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)

    // Switch to AppTheme for displaying the activity
    setTheme(R.style.AppTheme)

    super.onCreate(savedInstanceState)
    // onboarding
    if (restorePrefData()) {
      val i = Intent(applicationContext, HomeActivity::class.java)
      startActivity(i)
      finish()
    }
    requestWindowFeature(Window.FEATURE_NO_TITLE)
    WindowManager.LayoutParams.FLAG_FULLSCREEN
    WindowManager.LayoutParams.FLAG_FULLSCREEN
    supportActionBar!!.hide()

    binding = ActivityMainBinding.inflate(layoutInflater)
    setContentView(binding.root)

    // onboarding
    next = findViewById(R.id.next)
    binding.board.visibility = View.INVISIBLE
    binding.brick1.visibility = View.INVISIBLE
    binding.lumber1.visibility = View.INVISIBLE
    binding.wool1.visibility = View.INVISIBLE
    binding.grain1.visibility = View.INVISIBLE
    binding.ore1.visibility = View.INVISIBLE
    binding.desert.visibility = View.INVISIBLE
    tabLayout = findViewById(R.id.tab_indicator)
    binding.clearButton.visibility = View.INVISIBLE
    val onBoardingData: MutableList<OnBoardingData> = ArrayList()
    onBoardingData.add(OnBoardingData("", "", R.drawable.intro1))
    onBoardingData.add(OnBoardingData("", "", R.drawable.intro2))
    onBoardingData.add(OnBoardingData("", "", R.drawable.intro3))
    onBoardingData.add(OnBoardingData("", "", R.drawable.intro4))
    //onBoardingData.add(OnBoardingData("Easy Payment", "Pay online", R.drawable.testgif))
    setOnBoardingViewPagerAdapter(onBoardingData)
    position = onBoardingViewPager!!.currentItem
    next?.setOnClickListener {
      if (position < onBoardingData.size) {
        position++
        onBoardingViewPager!!.currentItem = position
      }
      if (position == onBoardingData.size) {
        savePrefData()
        val i = Intent(applicationContext, HomeActivity::class.java)
        startActivity(i)
      }
    }
    tabLayout!!.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
      override fun onTabSelected(tab: TabLayout.Tab?) {
        position = tab!!.position
        if (tab.position == onBoardingData.size - 1) {
          next!!.text = "Get Started"
        } else {
          next!!.text = "Next"
        }
      }

      override fun onTabUnselected(tab: TabLayout.Tab?) {
      }

      override fun onTabReselected(tab: TabLayout.Tab?) {
      }
    })
  }

  private fun setOnBoardingViewPagerAdapter(onBoardingData: List<OnBoardingData>) {

    // todo revert this for gif
    onBoardingViewPager = findViewById(R.id.screenPager)
    onBoardingViewPagerAdapter = OnBoardingViewPagerAdapter(this, onBoardingData)
    onBoardingViewPager!!.adapter = onBoardingViewPagerAdapter
    tabLayout?.setupWithViewPager(onBoardingViewPager)

  }

  private fun savePrefData() {

    sharedPreferences = applicationContext.getSharedPreferences("pref", Context.MODE_PRIVATE)
    val editor = sharedPreferences!!.edit()
    editor.putBoolean("isFirstTimeRun", true)
    editor.apply()

  }

  private fun restorePrefData(): Boolean {
    sharedPreferences = applicationContext.getSharedPreferences("pref", Context.MODE_PRIVATE)
    return sharedPreferences!!.getBoolean("isFirstTimeRun", false)
  }
}