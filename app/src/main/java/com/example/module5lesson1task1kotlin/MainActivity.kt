package com.example.module5lesson1task1kotlin

import android.graphics.Color
import android.os.Bundle
import android.text.SpannableString
import android.text.Spanned
import android.text.TextPaint
import android.text.method.LinkMovementMethod
import android.text.style.BackgroundColorSpan
import android.text.style.ClickableSpan
import android.text.style.ForegroundColorSpan
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import androidx.viewpager.widget.ViewPager.OnPageChangeListener
import com.tbuonomo.viewpagerdotsindicator.WormDotsIndicator

class MainActivity : AppCompatActivity() {

    lateinit var viewPager: ViewPager
    lateinit var adapter: CustomPagerAdapter
    lateinit var indicator: WormDotsIndicator
    lateinit var textView: TextView
    lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()
    }

    private fun initViews() {
        textView = findViewById(R.id.textView)
        button = findViewById(R.id.button)
        viewPager = findViewById(R.id.viewPager)
        indicator = findViewById(R.id.worm_dots_indicator)
        adapter = CustomPagerAdapter(supportFragmentManager)

        viewPager.setAdapter(adapter)
        indicator.setViewPager(viewPager)

        val ssString = SpannableString(textView.getText())
        val bcs = BackgroundColorSpan(Color.WHITE)
        val fcs = ForegroundColorSpan(Color.RED)

        val clickableSpan: ClickableSpan = object : ClickableSpan() {
            override fun onClick(view: View) {
                viewPager.setCurrentItem(2, true)
                button.setVisibility(View.VISIBLE)
            }

            override fun updateDrawState(ds: TextPaint) {
                ds.color = Color.BLUE
                ds.isUnderlineText = true
            }
        }
        ssString.setSpan(bcs, 0, textView.getText().length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        ssString.setSpan(
            clickableSpan,
            0,
            textView.getText().length,
            Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        textView.setText(ssString)
        textView.setMovementMethod(LinkMovementMethod.getInstance())
        viewPager.addOnPageChangeListener(object : OnPageChangeListener {
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
            }

            override fun onPageSelected(position: Int) {
                if (position != 2) {
                    button.setVisibility(View.INVISIBLE)
                } else {
                    button.setVisibility(View.VISIBLE)
                }
            }

            override fun onPageScrollStateChanged(state: Int) {}
        })
    }
}