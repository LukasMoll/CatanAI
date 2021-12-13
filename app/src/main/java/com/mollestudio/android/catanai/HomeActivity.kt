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

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var settlementStreetMap: HashMap<ImageView, List<ImageView>>

    private lateinit var streetSettlementMap: HashMap<ImageView, List<ImageView>>
    private lateinit var settlementTileMap: HashMap<ImageView, List<ImageView>>
    private lateinit var tileSettlementMap: HashMap<ImageView, List<ImageView>>
    private lateinit var portTileMap: HashMap<ImageView, String>

    private lateinit var numberList: MutableList<String>
    private lateinit var tileNumberList: List<ImageView>
    private lateinit var tileNumberInputList: List<EditText>

    private lateinit var streetList: List<ImageView>
    private lateinit var street1List: List<ImageView>
    private lateinit var street2List: List<ImageView>
    private lateinit var street3List: List<ImageView>
    private lateinit var settlementList: List<ImageView>
    private lateinit var _streetList: StreetList
    private lateinit var _settlementList: SettlementList
    private lateinit var tileList: List<ImageView>
    private lateinit var seaTileList: List<ImageView>
    private lateinit var portTileList: List<ImageView>

    private var blackSettlements by Delegates.notNull<Int>()
    private var redSettlements by Delegates.notNull<Int>()
    private var greenSettlements by Delegates.notNull<Int>()
    private var blueSettlements by Delegates.notNull<Int>()

    private lateinit var number1: String
    private lateinit var number2: String
    private lateinit var number3: String
    private lateinit var number4: String
    private lateinit var number5: String
    private lateinit var number6: String
    private lateinit var number7: String
    private lateinit var number8: String
    private lateinit var number9: String
    private lateinit var number10: String
    private lateinit var number11: String
    private lateinit var number12: String
    private lateinit var number13: String
    private lateinit var number14: String
    private lateinit var number15: String
    private lateinit var number16: String
    private lateinit var number17: String
    private lateinit var number18: String
    private lateinit var number19: String

    private lateinit var tile1: ImageView
    private lateinit var tile2: ImageView
    private lateinit var tile3: ImageView
    private lateinit var tile4: ImageView
    private lateinit var tile5: ImageView
    private lateinit var tile6: ImageView
    private lateinit var tile7: ImageView
    private lateinit var tile8: ImageView
    private lateinit var tile9: ImageView
    private lateinit var tile10: ImageView
    private lateinit var tile11: ImageView
    private lateinit var tile12: ImageView
    private lateinit var tile13: ImageView
    private lateinit var tile14: ImageView
    private lateinit var tile15: ImageView
    private lateinit var tile16: ImageView
    private lateinit var tile17: ImageView
    private lateinit var tile18: ImageView
    private lateinit var tile19: ImageView

    private lateinit var tile1Number: ImageView
    private lateinit var tile2Number: ImageView
    private lateinit var tile3Number: ImageView
    private lateinit var tile4Number: ImageView
    private lateinit var tile5Number: ImageView
    private lateinit var tile6Number: ImageView
    private lateinit var tile7Number: ImageView
    private lateinit var tile8Number: ImageView
    private lateinit var tile9Number: ImageView
    private lateinit var tile10Number: ImageView
    private lateinit var tile11Number: ImageView
    private lateinit var tile12Number: ImageView
    private lateinit var tile13Number: ImageView
    private lateinit var tile14Number: ImageView
    private lateinit var tile15Number: ImageView
    private lateinit var tile16Number: ImageView
    private lateinit var tile17Number: ImageView
    private lateinit var tile18Number: ImageView
    private lateinit var tile19Number: ImageView

    private lateinit var tile1NumberInput: EditText
    private lateinit var tile2NumberInput: EditText
    private lateinit var tile3NumberInput: EditText
    private lateinit var tile4NumberInput: EditText
    private lateinit var tile5NumberInput: EditText
    private lateinit var tile6NumberInput: EditText
    private lateinit var tile7NumberInput: EditText
    private lateinit var tile8NumberInput: EditText
    private lateinit var tile9NumberInput: EditText
    private lateinit var tile10NumberInput: EditText
    private lateinit var tile11NumberInput: EditText
    private lateinit var tile12NumberInput: EditText
    private lateinit var tile13NumberInput: EditText
    private lateinit var tile14NumberInput: EditText
    private lateinit var tile15NumberInput: EditText
    private lateinit var tile16NumberInput: EditText
    private lateinit var tile17NumberInput: EditText
    private lateinit var tile18NumberInput: EditText
    private lateinit var tile19NumberInput: EditText

    private lateinit var portTile1: ImageView
    private lateinit var portTile2: ImageView
    private lateinit var portTile3: ImageView
    private lateinit var portTile4: ImageView
    private lateinit var portTile5: ImageView
    private lateinit var portTile6: ImageView
    private lateinit var portTile7: ImageView
    private lateinit var portTile8: ImageView
    private lateinit var portTile9: ImageView
    private lateinit var portTile10: ImageView
    private lateinit var portTile11: ImageView
    private lateinit var portTile12: ImageView
    private lateinit var portTile13: ImageView
    private lateinit var portTile14: ImageView
    private lateinit var portTile15: ImageView
    private lateinit var portTile16: ImageView
    private lateinit var portTile17: ImageView
    private lateinit var portTile18: ImageView
    private lateinit var portTile19: ImageView
    private lateinit var portTile20: ImageView
    private lateinit var portTile21: ImageView
    private lateinit var portTile22: ImageView
    private lateinit var portTile23: ImageView
    private lateinit var portTile24: ImageView
    private lateinit var portTile25: ImageView
    private lateinit var portTile26: ImageView
    private lateinit var portTile27: ImageView
    private lateinit var portTile28: ImageView
    private lateinit var portTile29: ImageView
    private lateinit var portTile30: ImageView

    private lateinit var seaTile1: ImageView
    private lateinit var seaTile2: ImageView
    private lateinit var seaTile3: ImageView
    private lateinit var seaTile4: ImageView
    private lateinit var seaTile5: ImageView
    private lateinit var seaTile6: ImageView
    private lateinit var seaTile7: ImageView
    private lateinit var seaTile8: ImageView
    private lateinit var seaTile9: ImageView
    private lateinit var seaTile10: ImageView
    private lateinit var seaTile11: ImageView
    private lateinit var seaTile12: ImageView
    private lateinit var seaTile13: ImageView
    private lateinit var seaTile14: ImageView
    private lateinit var seaTile15: ImageView
    private lateinit var seaTile16: ImageView
    private lateinit var seaTile17: ImageView
    private lateinit var seaTile18: ImageView

    private lateinit var street1: ImageView
    private lateinit var street1_2: ImageView
    private lateinit var street1_3: ImageView
    private lateinit var street1_4: ImageView
    private lateinit var street2: ImageView
    private lateinit var street2_2: ImageView
    private lateinit var street2_3: ImageView
    private lateinit var street2_4: ImageView
    private lateinit var street2_5: ImageView
    private lateinit var street3: ImageView
    private lateinit var street3_2: ImageView
    private lateinit var street3_3: ImageView
    private lateinit var street3_4: ImageView
    private lateinit var street3_5: ImageView
    private lateinit var street3_6: ImageView
    private lateinit var street4: ImageView
    private lateinit var street4_2: ImageView
    private lateinit var street4_3: ImageView
    private lateinit var street4_4: ImageView
    private lateinit var street4_5: ImageView
    private lateinit var street5: ImageView
    private lateinit var street5_2: ImageView
    private lateinit var street5_3: ImageView
    private lateinit var street5_4: ImageView
    private lateinit var street6: ImageView
    private lateinit var street6_2: ImageView
    private lateinit var street6_3: ImageView
    private lateinit var street7: ImageView
    private lateinit var street7_2: ImageView
    private lateinit var street7_3: ImageView
    private lateinit var street7_4: ImageView
    private lateinit var street8: ImageView
    private lateinit var street8_2: ImageView
    private lateinit var street8_3: ImageView
    private lateinit var street8_4: ImageView
    private lateinit var street8_5: ImageView
    private lateinit var street9: ImageView
    private lateinit var street9_2: ImageView
    private lateinit var street9_3: ImageView
    private lateinit var street9_4: ImageView
    private lateinit var street9_5: ImageView
    private lateinit var street10: ImageView
    private lateinit var street10_2: ImageView
    private lateinit var street10_3: ImageView
    private lateinit var street10_4: ImageView
    private lateinit var street11: ImageView
    private lateinit var street11_2: ImageView
    private lateinit var street11_3: ImageView
    private lateinit var street12: ImageView
    private lateinit var street12_2: ImageView
    private lateinit var street12_3: ImageView
    private lateinit var street13: ImageView
    private lateinit var street13_2: ImageView
    private lateinit var street13_3: ImageView
    private lateinit var street13_4: ImageView
    private lateinit var street14: ImageView
    private lateinit var street14_2: ImageView
    private lateinit var street14_3: ImageView
    private lateinit var street14_4: ImageView
    private lateinit var street14_5: ImageView
    private lateinit var street15: ImageView
    private lateinit var street15_2: ImageView
    private lateinit var street15_3: ImageView
    private lateinit var street15_4: ImageView
    private lateinit var street15_5: ImageView
    private lateinit var street16: ImageView
    private lateinit var street16_2: ImageView
    private lateinit var street16_3: ImageView
    private lateinit var street16_4: ImageView
    private lateinit var street17: ImageView
    private lateinit var street17_2: ImageView
    private lateinit var street17_3: ImageView

    private lateinit var settlement_b2: ImageView
    private lateinit var settlement_b3: ImageView
    private lateinit var settlement_c1: ImageView
    private lateinit var settlement_c2: ImageView
    private lateinit var settlement_c3: ImageView
    private lateinit var settlement_c4: ImageView
    private lateinit var settlement_d2: ImageView
    private lateinit var settlement_d3: ImageView
    private lateinit var settlement_d4: ImageView
    private lateinit var settlement_e1: ImageView
    private lateinit var settlement_e2: ImageView
    private lateinit var settlement_e3: ImageView
    private lateinit var settlement_e4: ImageView
    private lateinit var settlement_e5: ImageView
    private lateinit var settlement_f2: ImageView
    private lateinit var settlement_f3: ImageView
    private lateinit var settlement_f4: ImageView
    private lateinit var settlement_f5: ImageView
    private lateinit var settlement_g2: ImageView
    private lateinit var settlement_g3: ImageView
    private lateinit var settlement_g4: ImageView
    private lateinit var settlement_g5: ImageView
    private lateinit var settlement_h1: ImageView
    private lateinit var settlement_h2: ImageView
    private lateinit var settlement_h3: ImageView
    private lateinit var settlement_h4: ImageView
    private lateinit var settlement_h5: ImageView
    private lateinit var settlement_i2: ImageView
    private lateinit var settlement_i3: ImageView
    private lateinit var settlement_i4: ImageView
    private lateinit var settlement_j1: ImageView
    private lateinit var settlement_j2: ImageView
    private lateinit var settlement_j3: ImageView
    private lateinit var settlement_j4: ImageView
    private lateinit var settlement_k2: ImageView
    private lateinit var settlement_k3: ImageView

    private lateinit var cards: ImageView
    private lateinit var brick_card: ConstraintLayout
    private lateinit var lumber_card: ConstraintLayout
    private lateinit var sheep_card: ConstraintLayout
    private lateinit var grain_card: ConstraintLayout
    private lateinit var ore_card: ConstraintLayout

    private lateinit var brick1: ImageView
    private lateinit var lumber1: ImageView
    private lateinit var sheep1: ImageView
    private lateinit var grain1: ImageView
    private lateinit var ore1: ImageView
    private lateinit var desert1: ImageView

    private lateinit var colorButton: ImageView
    private var brick1Visibility by Delegates.notNull<Boolean>()
    private var lumber1Visibility by Delegates.notNull<Boolean>()
    private var sheep1Visibility by Delegates.notNull<Boolean>()
    private var grain1Visibility by Delegates.notNull<Boolean>()
    private var ore1Visibility by Delegates.notNull<Boolean>()
    private var desert1Visibility by Delegates.notNull<Boolean>()

    private lateinit var maskDragMessage: String

    private lateinit var testButton: TextView

    private var fase by Delegates.notNull<Int>()

    @SuppressLint("UseSwitchCompatOrMaterialCode", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)

        // Switch to AppTheme for displaying the activity
        setTheme(R.style.AppTheme)

        super.onCreate(savedInstanceState)

        requestWindowFeature(Window.FEATURE_NO_TITLE)
        WindowManager.LayoutParams.FLAG_FULLSCREEN
        WindowManager.LayoutParams.FLAG_FULLSCREEN
        supportActionBar!!.hide()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        attachViewDragListener()

        // only for recording
        binding.clearButton.visibility = View.VISIBLE

        // only for testing
        binding.next.visibility = View.VISIBLE
        testButton = binding.next

        /*
    tile1 = binding.tile1
    tile2 = binding.tile2
    tile3 = binding.tile3
    tile4 = binding.tile4
    tile5 = binding.tile5
    tile6 = binding.tile6
    tile7 = binding.tile7
    tile8 = binding.tile8
    tile9 = binding.tile9
    tile10 = binding.tile10
    tile11 = binding.tile11
    tile12 = binding.tile12
    tile13 = binding.tile13
    tile14 = binding.tile14
    tile15 = binding.tile15
    tile16 = binding.tile16
    tile17 = binding.tile17
    tile18 = binding.tile18
    tile19 = binding.tile19
    */
        //binding.next.visibility = View.INVISIBLE

        tile1 = findViewById(R.id.tile1)
        tile2 = findViewById(R.id.tile2)
        tile3 = findViewById(R.id.tile3)
        tile4 = findViewById(R.id.tile4)
        tile5 = findViewById(R.id.tile5)
        tile6 = findViewById(R.id.tile6)
        tile7 = findViewById(R.id.tile7)
        tile8 = findViewById(R.id.tile8)
        tile9 = findViewById(R.id.tile9)
        tile10 = findViewById(R.id.tile10)
        tile11 = findViewById(R.id.tile11)
        tile12 = findViewById(R.id.tile12)
        tile13 = findViewById(R.id.tile13)
        tile14 = findViewById(R.id.tile14)
        tile15 = findViewById(R.id.tile15)
        tile16 = findViewById(R.id.tile16)
        tile17 = findViewById(R.id.tile17)
        tile18 = findViewById(R.id.tile18)
        tile19 = findViewById(R.id.tile19)

        tile1Number = binding.tile1Number
        tile2Number = binding.tile2Number
        tile3Number = binding.tile3Number
        tile4Number = binding.tile4Number
        tile5Number = binding.tile5Number
        tile6Number = binding.tile6Number
        tile7Number = binding.tile7Number
        tile8Number = binding.tile8Number
        tile9Number = binding.tile9Number
        tile10Number = binding.tile10Number
        tile11Number = binding.tile11Number
        tile12Number = binding.tile12Number
        tile13Number = binding.tile13Number
        tile14Number = binding.tile14Number
        tile15Number = binding.tile15Number
        tile16Number = binding.tile16Number
        tile17Number = binding.tile17Number
        tile18Number = binding.tile18Number
        tile19Number = binding.tile19Number

        tile1NumberInput = binding.tile1NumberInput
        tile2NumberInput = binding.tile2NumberInput
        tile3NumberInput = binding.tile3NumberInput
        tile4NumberInput = binding.tile4NumberInput
        tile5NumberInput = binding.tile5NumberInput
        tile6NumberInput = binding.tile6NumberInput
        tile7NumberInput = binding.tile7NumberInput
        tile8NumberInput = binding.tile8NumberInput
        tile9NumberInput = binding.tile9NumberInput
        tile10NumberInput = binding.tile10NumberInput
        tile11NumberInput = binding.tile11NumberInput
        tile12NumberInput = binding.tile12NumberInput
        tile13NumberInput = binding.tile13NumberInput
        tile14NumberInput = binding.tile14NumberInput
        tile15NumberInput = binding.tile15NumberInput
        tile16NumberInput = binding.tile16NumberInput
        tile17NumberInput = binding.tile17NumberInput
        tile18NumberInput = binding.tile18NumberInput
        tile19NumberInput = binding.tile19NumberInput

        portTile1 = binding.portTile1
        portTile2 = binding.portTile2
        portTile3 = binding.portTile3
        portTile4 = binding.portTile4
        portTile5 = binding.portTile5
        portTile6 = binding.portTile6
        portTile7 = binding.portTile7
        portTile8 = binding.portTile8
        portTile9 = binding.portTile9
        portTile10 = binding.portTile10
        portTile11 = binding.portTile11
        portTile12 = binding.portTile12
        portTile13 = binding.portTile13
        portTile14 = binding.portTile14
        portTile15 = binding.portTile15
        portTile16 = binding.portTile16
        portTile17 = binding.portTile17
        portTile18 = binding.portTile18
        portTile19 = binding.portTile19
        portTile20 = binding.portTile20
        portTile21 = binding.portTile21
        portTile22 = binding.portTile22
        portTile23 = binding.portTile23
        portTile24 = binding.portTile24
        portTile25 = binding.portTile25
        portTile26 = binding.portTile26
        portTile27 = binding.portTile27
        portTile28 = binding.portTile28
        portTile29 = binding.portTile29
        portTile30 = binding.portTile30

        seaTile1 = binding.seaTile1
        seaTile2 = binding.seaTile2
        seaTile3 = binding.seaTile3
        seaTile4 = binding.seaTile4
        seaTile5 = binding.seaTile5
        seaTile6 = binding.seaTile6
        seaTile7 = binding.seaTile7
        seaTile8 = binding.seaTile8
        seaTile9 = binding.seaTile9
        seaTile10 = binding.seaTile10
        seaTile11 = binding.seaTile11
        seaTile12 = binding.seaTile12
        seaTile13 = binding.seaTile13
        seaTile14 = binding.seaTile14
        seaTile15 = binding.seaTile15
        seaTile16 = binding.seaTile16
        seaTile17 = binding.seaTile17
        seaTile18 = binding.seaTile18

        street1 = binding.street1a
        street1_2 = binding.street1b
        street1_3 = binding.street1c
        street1_4 = binding.street1d
        street2 = binding.street2a
        street2_2 = binding.street2b
        street2_3 = binding.street2c
        street2_4 = binding.street2d
        street2_5 = binding.street2e
        street3 = binding.street3a
        street3_2 = binding.street3b
        street3_3 = binding.street3c
        street3_4 = binding.street3d
        street3_5 = binding.street3e
        street3_6 = binding.street3f
        street4 = binding.street4a
        street4_2 = binding.street4b
        street4_3 = binding.street4c
        street4_4 = binding.street4d
        street4_5 = binding.street4e
        street5 = binding.street5a
        street5_2 = binding.street5b
        street5_3 = binding.street5c
        street5_4 = binding.street5d
        street6 = binding.street6a
        street6_2 = binding.street6b
        street6_3 = binding.street6c
        street7 = binding.street7a
        street7_2 = binding.street7b
        street7_3 = binding.street7c
        street7_4 = binding.street7d
        street8 = binding.street8a
        street8_2 = binding.street8b
        street8_3 = binding.street8c
        street8_4 = binding.street8d
        street8_5 = binding.street8e
        street9 = binding.street9a
        street9_2 = binding.street9b
        street9_3 = binding.street9c
        street9_4 = binding.street9d
        street9_5 = binding.street9e
        street10 = binding.street10a
        street10_2 = binding.street10b
        street10_3 = binding.street10c
        street10_4 = binding.street10d
        street11 = binding.street11a
        street11_2 = binding.street11b
        street11_3 = binding.street11c
        street12 = binding.street12a
        street12_2 = binding.street12b
        street12_3 = binding.street12c
        street13 = binding.street13a
        street13_2 = binding.street13b
        street13_3 = binding.street13c
        street13_4 = binding.street13d
        street14 = binding.street14a
        street14_2 = binding.street14b
        street14_3 = binding.street14c
        street14_4 = binding.street14d
        street14_5 = binding.street14e
        street15 = binding.street15a
        street15_2 = binding.street15b
        street15_3 = binding.street15c
        street15_4 = binding.street15d
        street15_5 = binding.street15e
        street16 = binding.street16a
        street16_2 = binding.street16b
        street16_3 = binding.street16c
        street16_4 = binding.street16d
        street17 = binding.street17a
        street17_2 = binding.street17b
        street17_3 = binding.street17c

        settlement_b2 = binding.settlementB2
        settlement_b3 = binding.settlementB3
        settlement_c1 = binding.settlementC1
        settlement_c2 = binding.settlementC2
        settlement_c3 = binding.settlementC3
        settlement_c4 = binding.settlementC4
        settlement_d2 = binding.settlementD2
        settlement_d3 = binding.settlementD3
        settlement_d4 = binding.settlementD4
        settlement_e1 = binding.settlementE1
        settlement_e2 = binding.settlementE2
        settlement_e3 = binding.settlementE3
        settlement_e4 = binding.settlementE4
        settlement_e5 = binding.settlementE5
        settlement_f2 = binding.settlementF2
        settlement_f3 = binding.settlementF3
        settlement_f4 = binding.settlementF4
        settlement_f5 = binding.settlementF5
        settlement_g2 = binding.settlementG2
        settlement_g3 = binding.settlementG3
        settlement_g4 = binding.settlementG4
        settlement_g5 = binding.settlementG5
        settlement_h1 = binding.settlementH1
        settlement_h2 = binding.settlementH2
        settlement_h3 = binding.settlementH3
        settlement_h4 = binding.settlementH4
        settlement_h5 = binding.settlementH5
        settlement_i2 = binding.settlementI2
        settlement_i3 = binding.settlementI3
        settlement_i4 = binding.settlementI4
        settlement_j1 = binding.settlementJ1
        settlement_j2 = binding.settlementJ2
        settlement_j3 = binding.settlementJ3
        settlement_j4 = binding.settlementJ4
        settlement_k2 = binding.settlementK2
        settlement_k3 = binding.settlementK3

        number1 = "0"
        number2 = "0"
        number3 = "0"
        number4 = "0"
        number5 = "0"
        number6 = "0"
        number7 = "0"
        number8 = "0"
        number9 = "0"
        number10 = "0"
        number11 = "0"
        number12 = "0"
        number13 = "0"
        number14 = "0"
        number15 = "0"
        number16 = "0"
        number17 = "0"
        number18 = "0"
        number19 = "0"

        cards = binding.cards
        brick_card = binding.brickCard
        lumber_card = binding.lumberCard
        sheep_card = binding.sheepCard
        grain_card = binding.grainCard
        ore_card = binding.oreCard

        brick1 = binding.brick1
        lumber1 = binding.lumber1
        sheep1 = binding.wool1
        grain1 = binding.grain1
        ore1 = binding.ore1
        desert1 = binding.desert

        colorButton = binding.colorButton

        maskDragMessage = "message"

        val colorButton = binding.colorButton

        /*
    for (index in 0 until (binding.board as ViewGroup).childCount) {
      val nextChild = (binding.board as ViewGroup).getChildAt(index)
      val content = nextChild.contentDescription
      if (content != null && content.length >= 4 && content.substring(0, 4) == "tile") {
        nextChild.setOnDragListener(tileDragListener)
      }
    }
    */

        binding.tile1DropArea.setOnDragListener(tile1DragListener)
        binding.tile2DropArea.setOnDragListener(tile2DragListener)
        binding.tile3DropArea.setOnDragListener(tile3DragListener)
        binding.tile4DropArea.setOnDragListener(tile4DragListener)
        binding.tile5DropArea.setOnDragListener(tile5DragListener)
        binding.tile6DropArea.setOnDragListener(tile6DragListener)
        binding.tile7DropArea.setOnDragListener(tile7DragListener)
        binding.tile8DropArea.setOnDragListener(tile8DragListener)
        binding.tile9DropArea.setOnDragListener(tile9DragListener)
        binding.tile10DropArea.setOnDragListener(tile10DragListener)
        binding.tile11DropArea.setOnDragListener(tile11DragListener)
        binding.tile12DropArea.setOnDragListener(tile12DragListener)
        binding.tile13DropArea.setOnDragListener(tile13DragListener)
        binding.tile14DropArea.setOnDragListener(tile14DragListener)
        binding.tile15DropArea.setOnDragListener(tile15DragListener)
        binding.tile16DropArea.setOnDragListener(tile16DragListener)
        binding.tile17DropArea.setOnDragListener(tile17DragListener)
        binding.tile18DropArea.setOnDragListener(tile18DragListener)
        binding.tile19DropArea.setOnDragListener(tile19DragListener)

        colorButton.setOnClickListener {
            if (colorButton.contentDescription == "black") {
                colorButton.setImageResource(R.drawable.red_button)
                colorButton.contentDescription = "red"
            }
            else if (colorButton.contentDescription == "red") {
                colorButton.setImageResource(R.drawable.blue_button)
                colorButton.contentDescription = "blue"
            }
            else if (colorButton.contentDescription == "blue") {
                colorButton.setImageResource(R.drawable.green_button)
                colorButton.contentDescription = "green"
            }
            else if (colorButton.contentDescription == "green") {
                colorButton.setImageResource(R.drawable.black_button)
                colorButton.contentDescription = "black"
            }
        }

        binding.clearButton.setOnClickListener {
            for (tile in tileList) {
                tile.setImageResource(R.drawable.tile)
                val content = tile.contentDescription
                tile.contentDescription = content.substring(0, 5) + "Empty"
            }

            for (street in streetList) {
                street.visibility = View.INVISIBLE
                setStreet(street, "empty")
            }

            for (settlement in settlementList) {
                settlement.visibility = View.INVISIBLE
                settlement.setImageResource(R.drawable.empty_settlement)
            }

            for (animation in pulsatingStreetMap.values) {
                animation.reverse()
                animation.end()
            }

            for (animation in pulsatingSettlementMap.values) {
                animation.reverse()
                animation.end()
            }

            for (portTile in portTileList) {
                portTile.visibility = View.INVISIBLE
            }

            for (tileNumber in tileNumberList) {
                tileNumber.visibility = View.INVISIBLE
                tileNumber.setImageResource(R.drawable.number_background)
            }

            for (tileNumberInput in tileNumberList) {
                tileNumberInput.visibility = View.INVISIBLE
            }

            for (tileNumberInput in tileNumberInputList) {
                tileNumberInput.setText("")
            }

            disableNumbers()

            seaTileClickListener()

            brick1.visibility = View.VISIBLE
            lumber1.visibility = View.VISIBLE
            sheep1.visibility = View.VISIBLE
            grain1.visibility = View.VISIBLE
            ore1.visibility = View.VISIBLE
            binding.desert.visibility = View.VISIBLE

            numberOfBrickCards = 3
            numberOfLumberCards = 4
            numberOfSheepCards = 4
            numberOfGrainCards = 4
            numberOfOreCards = 3
            numberOfDesertCards = 1

            blackSettlements = 0
            redSettlements = 0
            blueSettlements = 0
            greenSettlements = 0

            fase = 0

            binding.continueButton.visibility = View.INVISIBLE
            binding.colorButton.visibility = View.INVISIBLE
            _settlementList = SettlementList(settlementList)
        }

        tileNumberList = listOf(binding.tile1Number, binding.tile2Number,
            binding.tile3Number, binding.tile4Number, binding.tile5Number,
            binding.tile6Number, binding.tile7Number, binding.tile8Number,
            binding.tile9Number, binding.tile10Number, binding.tile11Number,
            binding.tile12Number, binding.tile13Number, binding.tile14Number,
            binding.tile15Number, binding.tile16Number, binding.tile17Number,
            binding.tile18Number, binding.tile19Number)
        tileNumberInputList = listOf(binding.tile1NumberInput, binding.tile2NumberInput,
            binding.tile3NumberInput, binding.tile4NumberInput, binding.tile5NumberInput,
            binding.tile6NumberInput, binding.tile7NumberInput, binding.tile8NumberInput,
            binding.tile9NumberInput, binding.tile10NumberInput, binding.tile11NumberInput,
            binding.tile12NumberInput, binding.tile13NumberInput, binding.tile14NumberInput,
            binding.tile15NumberInput, binding.tile16NumberInput, binding.tile17NumberInput,
            binding.tile18NumberInput, binding.tile19NumberInput)
        numberList = mutableListOf(number1, number2, number3, number4, number5, number6, number7,
            number8, number9, number10, number11, number12, number13, number14, number15,
            number16, number17, number18, number19)

        fase = 0

        var testing = false

        fun checkNumberOfSettlements(): Boolean {
            if ((colorButton.contentDescription == "black" && blackSettlements == 2) ||
                (colorButton.contentDescription == "red" && redSettlements == 2) ||
                (colorButton.contentDescription == "blue" && blueSettlements == 2) ||
                (colorButton.contentDescription == "green" && greenSettlements == 2)) {
                return false
            }
            return true
        }

        binding.continueButton.setOnClickListener {
            if (fase == 0) {
                for (pair in tileNumberList.zip(tileNumberInputList)) {
                    if (checkIfTileNumberInDesert(pair.first)) {
                        continue
                    }
                    pair.first.visibility = View.VISIBLE
                    pair.second.visibility = View.VISIBLE
                }

                fase++
                disableSeaTiles()
                disableTiles()
            }
            else if (fase == 1) {

                if (!checkIfInputNumbersValid()) {
                    Toast.makeText(this, "Numbers incorrect", Toast.LENGTH_SHORT).show()
                }

                else {
                    val desertNumber = getDesertNumber()

                    for (i in tileNumberList.indices) {
                        if (desertNumber != i.toString()) {
                            numberList[i] = tileNumberInputList[i].text.toString()
                            setImageNumber(tileNumberList[i], numberList[i])
                        }
                        else {
                            numberList[i] = "0"
                        }
                    }

                    showStreetsAndSettlements()
                    disableNumbers()
                    binding.continueButton.text = "solve"
                    fase++
                    colorButton.visibility = View.VISIBLE
                }
            }

            else if (fase == 2) {
                if (!checkNumberOfSettlements()) {
                    Toast.makeText(this, "Already 2 settlements of color " +
                            "${colorButton.contentDescription}!", Toast.LENGTH_SHORT).show()
                }
                else {
                    //hideStreetsAndSettlements()
                    solver()
                    if (colorButton.contentDescription == "black") {
                        blackSettlements++
                    }
                    else if (colorButton.contentDescription == "red") {
                        redSettlements++
                    }
                    else if (colorButton.contentDescription == "blue") {
                        blueSettlements++
                    }
                    else if (colorButton.contentDescription == "green") {
                        greenSettlements++
                    }
                }
            }
        }

        seaTileClickListener()

        settlement_b2.setOnClickListener(settlementb2ClickListener)
        settlement_b3.setOnClickListener(settlementb3ClickListener)
        settlement_c1.setOnClickListener(settlementc1ClickListener)
        settlement_c2.setOnClickListener(settlementc2ClickListener)
        settlement_c3.setOnClickListener(settlementc3ClickListener)
        settlement_c4.setOnClickListener(settlementc4ClickListener)
        settlement_d2.setOnClickListener(settlementd2ClickListener)
        settlement_d3.setOnClickListener(settlementd3ClickListener)
        settlement_d4.setOnClickListener(settlementd4ClickListener)
        settlement_e1.setOnClickListener(settlemente1ClickListener)
        settlement_e2.setOnClickListener(settlemente2ClickListener)
        settlement_e3.setOnClickListener(settlemente3ClickListener)
        settlement_e4.setOnClickListener(settlemente4ClickListener)
        settlement_e5.setOnClickListener(settlemente5ClickListener)
        settlement_f2.setOnClickListener(settlementf2ClickListener)
        settlement_f3.setOnClickListener(settlementf3ClickListener)
        settlement_f4.setOnClickListener(settlementf4ClickListener)
        settlement_f5.setOnClickListener(settlementf5ClickListener)
        settlement_g2.setOnClickListener(settlementg2ClickListener)
        settlement_g3.setOnClickListener(settlementg3ClickListener)
        settlement_g4.setOnClickListener(settlementg4ClickListener)
        settlement_g5.setOnClickListener(settlementg5ClickListener)
        settlement_h1.setOnClickListener(settlementh1ClickListener)
        settlement_h2.setOnClickListener(settlementh2ClickListener)
        settlement_h3.setOnClickListener(settlementh3ClickListener)
        settlement_h4.setOnClickListener(settlementh4ClickListener)
        settlement_h5.setOnClickListener(settlementh5ClickListener)
        settlement_i2.setOnClickListener(settlementi2ClickListener)
        settlement_i3.setOnClickListener(settlementi3ClickListener)
        settlement_i4.setOnClickListener(settlementi4ClickListener)
        settlement_j1.setOnClickListener(settlementj1ClickListener)
        settlement_j2.setOnClickListener(settlementj2ClickListener)
        settlement_j3.setOnClickListener(settlementj3ClickListener)
        settlement_j4.setOnClickListener(settlementj4ClickListener)
        settlement_k2.setOnClickListener(settlementk2ClickListener)
        settlement_k3.setOnClickListener(settlementk3ClickListener)

        // todo revert

        testButton.setOnClickListener {
            fun test1() {
                fase = 2

                tile1.contentDescription = "tile1_grain"
                tile1.setImageResource(R.drawable.grain2)
                number1 = "4"
                tile1Number.setImageResource(R.drawable.number4)

                tile2.contentDescription = "tile2_wool"
                tile2.setImageResource(R.drawable.wool2)
                number2 = "8"
                tile2Number.setImageResource(R.drawable.number8)

                tile3.contentDescription = "tile3_brick"
                tile3.setImageResource(R.drawable.brick2)
                number3 = "5"
                tile3Number.setImageResource(R.drawable.number5)

                tile4.contentDescription = "tile4_lumber"
                tile4.setImageResource(R.drawable.lumber2)
                number4 = "2"
                tile4Number.setImageResource(R.drawable.number2)

                tile5.contentDescription = "tile5_grain"
                tile5.setImageResource(R.drawable.grain2)
                number5 = "6"
                tile5Number.setImageResource(R.drawable.number6)

                tile6.contentDescription = "tile6_lumber"
                tile6.setImageResource(R.drawable.lumber2)
                number6 = "3"
                tile6Number.setImageResource(R.drawable.number3)

                tile7.contentDescription = "desert"
                tile7.setImageResource(R.drawable.desert2)
                number7 = "0"

                tile8.contentDescription = "tile8_grain"
                tile8.setImageResource(R.drawable.grain2)
                number8 = "8"
                tile8Number.setImageResource(R.drawable.number8)

                tile9.contentDescription = "tile9_wool"
                tile9.setImageResource(R.drawable.wool2)
                number9 = "10"
                tile9Number.setImageResource(R.drawable.number10)

                tile10.contentDescription = "tile10_ore"
                tile10.setImageResource(R.drawable.ore2)
                number10 = "9"
                tile10Number.setImageResource(R.drawable.number9)

                tile11.contentDescription = "tile11_ore"
                tile11.setImageResource(R.drawable.ore2)
                number11 = "12"
                tile11Number.setImageResource(R.drawable.number12)

                tile12.contentDescription = "tile12_brick"
                tile12.setImageResource(R.drawable.brick2)
                number12 = "11"
                tile12Number.setImageResource(R.drawable.number11)

                tile13.contentDescription = "tile13_lumber"
                tile13.setImageResource(R.drawable.lumber2)
                number13 = "3"
                tile13Number.setImageResource(R.drawable.number3)

                tile14.contentDescription = "tile14_ore"
                tile14.setImageResource(R.drawable.ore2)
                number14 = "10"
                tile14Number.setImageResource(R.drawable.number10)

                tile15.contentDescription = "tile15_wool"
                tile15.setImageResource(R.drawable.wool2)
                number15 = "9"
                tile15Number.setImageResource(R.drawable.number9)

                tile16.contentDescription = "tile16_grain"
                tile16.setImageResource(R.drawable.grain2)
                number16 = "4"
                tile16Number.setImageResource(R.drawable.number4)

                tile17.contentDescription = "tile17_lumber"
                tile17.setImageResource(R.drawable.lumber2)
                number17 = "5"
                tile17Number.setImageResource(R.drawable.number5)

                tile18.contentDescription = "tile18_brick"
                tile18.setImageResource(R.drawable.brick2)
                number18 = "6"
                tile18Number.setImageResource(R.drawable.number6)

                tile19.contentDescription = "tile19_wool"
                tile19.setImageResource(R.drawable.wool2)
                number19 = "11"
                tile19Number.setImageResource(R.drawable.number11)

                binding.continueButton.visibility = View.VISIBLE
                setNumbersToForeground()

                disableSeaTiles()
                disableTiles()

                for (tileNumber in tileNumberList) {
                    if (tileNumber != tile7Number) {
                        tileNumber.visibility = View.VISIBLE
                    }
                }
                colorButton.visibility = View.VISIBLE

                testing = true

                showStreetsAndSettlements()
            }
            fun test2() {
                fase = 2

                tile1.contentDescription = "tile1_wool"
                tile1.setImageResource(R.drawable.wool2)
                number1 = "6"
                tile1Number.setImageResource(R.drawable.number6)

                tile2.contentDescription = "tile2_grain"
                tile2.setImageResource(R.drawable.grain2)
                number2 = "3"
                tile2Number.setImageResource(R.drawable.number3)

                tile3.contentDescription = "tile3_wool"
                tile3.setImageResource(R.drawable.wool2)
                number3 = "8"
                tile3Number.setImageResource(R.drawable.number8)

                tile4.contentDescription = "tile4_lumber"
                tile4.setImageResource(R.drawable.lumber2)
                number4 = "10"
                tile4Number.setImageResource(R.drawable.number10)

                tile5.contentDescription = "tile5_lumber"
                tile5.setImageResource(R.drawable.lumber2)
                number5 = "9"
                tile5Number.setImageResource(R.drawable.number9)

                tile6.contentDescription = "tile6_brick"
                tile6.setImageResource(R.drawable.brick2)
                number6 = "12"
                tile6Number.setImageResource(R.drawable.number12)

                tile17.contentDescription = "desert"
                tile17.setImageResource(R.drawable.desert2)
                number17 = "0"

                tile7.contentDescription = "tile8_brick"
                tile7.setImageResource(R.drawable.brick2)
                number7 = "11"
                tile7Number.setImageResource(R.drawable.number11)

                tile8.contentDescription = "tile9_ore"
                tile8.setImageResource(R.drawable.ore2)
                number8 = "4"
                tile8Number.setImageResource(R.drawable.number4)

                tile9.contentDescription = "tile10_ore"
                tile9.setImageResource(R.drawable.ore2)
                number9 = "8"
                tile9Number.setImageResource(R.drawable.number8)

                tile10.contentDescription = "tile11_grain"
                tile10.setImageResource(R.drawable.grain2)
                number10 = "10"
                tile10Number.setImageResource(R.drawable.number10)

                tile11.contentDescription = "tile12_lumber"
                tile11.setImageResource(R.drawable.lumber2)
                number11 = "5"
                tile11Number.setImageResource(R.drawable.number5)

                tile12.contentDescription = "tile13_grain"
                tile12.setImageResource(R.drawable.grain2)
                number12 = "2"
                tile12Number.setImageResource(R.drawable.number2)

                tile13.contentDescription = "tile14_lumber"
                tile13.setImageResource(R.drawable.lumber2)
                number13 = "4"
                tile13Number.setImageResource(R.drawable.number4)

                tile14.contentDescription = "tile15_ore"
                tile14.setImageResource(R.drawable.ore2)
                number14 = "5"
                tile14Number.setImageResource(R.drawable.number5)

                tile15.contentDescription = "tile16_wool"
                tile15.setImageResource(R.drawable.wool2)
                number15 = "6"
                tile15Number.setImageResource(R.drawable.number6)

                tile16.contentDescription = "tile17_brick"
                tile16.setImageResource(R.drawable.brick2)
                number16 = "3"
                tile16Number.setImageResource(R.drawable.number3)

                tile18.contentDescription = "tile18_wool"
                tile18.setImageResource(R.drawable.wool2)
                number18 = "9"
                tile18Number.setImageResource(R.drawable.number9)

                tile19.contentDescription = "tile19_grain"
                tile19.setImageResource(R.drawable.grain2)
                number19 = "11"
                tile19Number.setImageResource(R.drawable.number11)

                portTileMap[tile1] = "question"
                portTile1.setImageResource(R.drawable.question_port)
                portTile1.visibility = View.VISIBLE

                portTileMap[tile2] = "question"
                portTile4.setImageResource(R.drawable.question_port)
                portTile4.visibility = View.VISIBLE

                portTileMap[tile4] = "question"
                portTile8.setImageResource(R.drawable.question_port)
                portTile8.visibility = View.VISIBLE

                portTileMap[tile5] = "ore"
                portTile11.setImageResource(R.drawable.ore_port)
                portTile11.visibility = View.VISIBLE

                portTileMap[tile6] = "question"
                portTile14.setImageResource(R.drawable.question_port)
                portTile14.visibility = View.VISIBLE

                portTileMap[tile8] = "brick"
                portTile18.setImageResource(R.drawable.brick_port)
                portTile18.visibility = View.VISIBLE

                portTileMap[tile9] = "lumber"
                portTile21.setImageResource(R.drawable.lumber_port)
                portTile21.visibility = View.VISIBLE

                portTileMap[tile10] = "grain"
                portTile24.setImageResource(R.drawable.grain_port)
                portTile24.visibility = View.VISIBLE

                portTileMap[tile12] = "wool"
                portTile28.setImageResource(R.drawable.sheep_port)
                portTile28.visibility = View.VISIBLE

                binding.continueButton.visibility = View.VISIBLE
                setNumbersToForeground()

                disableSeaTiles()
                disableTiles()

                for (tileNumber in tileNumberList) {
                    if (tileNumber != tile17Number) {
                        tileNumber.visibility = View.VISIBLE
                    }
                }
                colorButton.visibility = View.VISIBLE

                testing = true

                showStreetsAndSettlements()
            }
            test1()
        }

        streetList = mutableListOf(street1, street1_2, street1_3, street1_4, street2,
            street2_2, street2_3, street2_4, street2_5, street3, street3_2, street3_3,
            street3_4, street3_5, street3_6, street4, street4_2, street4_3, street4_4,
            street4_5, street5, street5_2, street5_3, street5_4, street6, street6_2,
            street6_3, street7, street7_2, street7_3, street7_4, street8, street8_2,
            street8_3, street8_4, street8_5, street9, street9_2, street9_3, street9_4,
            street9_5, street10, street10_2, street10_3, street10_4, street11,
            street11_2, street11_3, street12, street12_2, street12_3, street13,
            street13_2, street13_3, street13_4, street14, street14_2, street14_3,
            street14_4, street14_5, street15, street15_2, street15_2, street15_3,
            street15_4, street15_5, street16, street16_2, street16_3, street16_4,
            street17, street17_2, street17_3)

        street1List = listOf(street1, street1_2, street1_3, street1_4, street2,
            street2_2, street2_3, street2_4, street2_5, street3, street3_2, street3_3,
            street3_4, street3_5, street3_6, street4, street4_2, street4_3, street4_4,
            street4_5, street5, street5_2, street5_3, street5_4)

        street2List = listOf(street12, street12_2, street12_3, street13,
            street13_2, street13_3, street13_4, street14, street14_2, street14_3,
            street14_4, street14_5, street15, street15_2, street15_2, street15_3,
            street15_4, street15_5, street16, street16_2, street16_3, street16_4,
            street17, street17_2, street17_3)

        street3List = listOf(street6, street6_2,
            street6_3, street7, street7_2, street7_3, street7_4, street8, street8_2,
            street8_3, street8_4, street8_5, street9, street9_2, street9_3, street9_4,
            street9_5, street10, street10_2, street10_3, street10_4, street11,
            street11_2, street11_3)

        settlementList = mutableListOf(settlement_b2, settlement_b3, settlement_c1,
            settlement_c2, settlement_c3, settlement_c4, settlement_d2, settlement_d3,
            settlement_d4, settlement_e1, settlement_e2, settlement_e3, settlement_e4,
            settlement_e5, settlement_f2, settlement_f3, settlement_f4, settlement_f5,
            settlement_g2, settlement_g3, settlement_g4, settlement_g5, settlement_h1,
            settlement_h2, settlement_h3, settlement_h4, settlement_h5, settlement_i2,
            settlement_i3, settlement_i4, settlement_j1, settlement_j2, settlement_j3,
            settlement_j4, settlement_k2, settlement_k3)

        tileList = listOf(tile1, tile2, tile3, tile4, tile5, tile6, tile7, tile8,
            tile9, tile10, tile11, tile12, tile13, tile14, tile15, tile16, tile17,
            tile18, tile19)
        seaTileList = listOf(seaTile1, seaTile2, seaTile3, seaTile4, seaTile5,
            seaTile6, seaTile7, seaTile8, seaTile9, seaTile10, seaTile11, seaTile12,
            seaTile13, seaTile14, seaTile15, seaTile16, seaTile17, seaTile18)
        portTileList = listOf(portTile1, portTile2, portTile3, portTile4,
            portTile5, portTile6, portTile7, portTile8, portTile9, portTile10,
            portTile11, portTile12, portTile13, portTile14, portTile15, portTile16,
            portTile17, portTile18, portTile19, portTile20, portTile21, portTile22,
            portTile23, portTile24, portTile25, portTile26, portTile27, portTile28,
            portTile29, portTile30)

        numberList = mutableListOf(number1, number2, number3, number4, number5, number6,
            number7, number8, number9, number10, number11, number12, number13, number14,
            number15, number16, number17, number18, number19)

        _settlementList = SettlementList(settlementList)
        _streetList = StreetList(streetList)


        settlementStreetMap = hashMapOf(
            settlement_b2 to listOf(street12, street6_2, street1_2),
            settlement_b3 to listOf(street12_2, street6_3, street1_3),
            settlement_c1 to listOf(street1, street7, street13),
            settlement_c2 to listOf(street1_2, street7_2, street13_2),
            settlement_c3 to listOf(street1_3, street7_3, street13_3),
            settlement_c4 to listOf(street1_4, street7_4, street13_4),
            settlement_d2 to listOf(street13, street2_2, street7_2),
            settlement_d3 to listOf(street13_2, street7_3, street2_3),
            settlement_d4 to listOf(street7_4, street13_3, street2_4),
            settlement_e1 to listOf(street2, street8, street14),
            settlement_e2 to listOf(street2_2, street8_2, street14_2),
            settlement_e3 to listOf(street2_3, street8_3, street14_3),
            settlement_e4 to listOf(street2_4, street8_4, street14_4),
            settlement_e5 to listOf(street2_5, street8_5, street14_5),
            settlement_f2 to listOf(street14, street8_2, street3_2),
            settlement_f3 to listOf(street14_2, street8_3, street3_3),
            settlement_f4 to listOf(street14_3, street8_4, street3_4),
            settlement_f5 to listOf(street14_4, street8_5, street3_5),
            settlement_g2 to listOf(street3_2, street9, street15_2),
            settlement_g3 to listOf(street3_3, street9_2, street15_3),
            settlement_g4 to listOf(street3_4, street9_3, street15_4),
            settlement_g5 to listOf(street3_5, street9_4, street15_5),
            settlement_h1 to listOf(street15, street9, street4),
            settlement_h2 to listOf(street15_2, street9_2, street4_2),
            settlement_h3 to listOf(street15_3, street9_3, street4_3),
            settlement_h4 to listOf(street15_4, street9_4, street4_4),
            settlement_h5 to listOf(street15_5, street9_5, street4_5),
            settlement_i2 to listOf(street4_2, street10, street16_2),
            settlement_i3 to listOf(street4_3, street10_2, street16_3),
            settlement_i4 to listOf(street4_4, street10_3, street16_4),
            settlement_j1 to listOf(street16, street5, street10),
            settlement_j2 to listOf(street16_2, street5_2, street10_2),
            settlement_j3 to listOf(street16_3, street5_3, street10_3),
            settlement_j4 to listOf(street16_4, street5_4, street10_4),
            settlement_k2 to listOf(street11, street5_2, street17_2),
            settlement_k3 to listOf(street11_2, street5_3, street17_3))

        streetSettlementMap = hashMapOf(street1 to listOf(settlement_c1),
            street1_2 to listOf(settlement_b2, settlement_c2),
            street1_3 to listOf(settlement_b3, settlement_c3),
            street1_4 to listOf(settlement_c4), street2 to listOf(settlement_e1),
            street2_2 to listOf(settlement_d2, settlement_e2),
            street2_3 to listOf(settlement_d3, settlement_e3),
            street2_4 to listOf(settlement_d4, settlement_e4),
            street2_5 to listOf(settlement_e5),
            street3_2 to listOf(settlement_f2, settlement_g2),
            street3_3 to listOf(settlement_f3, settlement_g3),
            street3_4 to listOf(settlement_f4, settlement_g4),
            street3_5 to listOf(settlement_f5, settlement_g5),
            street4 to listOf(settlement_h1),
            street4_2 to listOf(settlement_h2, settlement_i2),
            street4_3 to listOf(settlement_h3, settlement_i3),
            street4_4 to listOf(settlement_h4, settlement_i4),
            street4_5 to listOf(settlement_h5), street5 to listOf(settlement_j1),
            street5_2 to listOf(settlement_j2, settlement_k2),
            street5_3 to listOf(settlement_j3, settlement_k3),
            street5_4 to listOf(settlement_j4), street6_2 to listOf(settlement_b2),
            street6_3 to listOf(settlement_b3), street7 to listOf(settlement_c1),
            street7_2 to listOf(settlement_c2, settlement_d2),
            street7_3 to listOf(settlement_c3, settlement_d3),
            street7_4 to listOf(settlement_c4, settlement_d4),
            street8 to listOf(settlement_e1),
            street8_2 to listOf(settlement_e2, settlement_f2),
            street8_3 to listOf(settlement_e3, settlement_f3),
            street8_4 to listOf(settlement_e4, settlement_f4),
            street8_5 to listOf(settlement_e5, settlement_f5),
            street9 to listOf(settlement_g2, settlement_h1),
            street9_2 to listOf(settlement_g3, settlement_h2),
            street9_3 to listOf(settlement_g4, settlement_h3),
            street9_4 to listOf(settlement_g5, settlement_h4),
            street9_5 to listOf(settlement_h5),
            street10 to listOf(settlement_i2, settlement_j1),
            street10_2 to listOf(settlement_i3, settlement_j2),
            street10_3 to listOf(settlement_i4, settlement_j3),
            street10_4 to listOf(settlement_j4), street11 to listOf(settlement_k2),
            street11_2 to listOf(settlement_k3), street12 to listOf(settlement_b2),
            street12_2 to listOf(settlement_b3),
            street13 to listOf(settlement_c1, settlement_d2),
            street13_2 to listOf(settlement_c2, settlement_d3),
            street13_3 to listOf(settlement_c3, settlement_d4),
            street13_4 to listOf(settlement_c4),
            street14 to listOf(settlement_e1, settlement_f2),
            street14_2 to listOf(settlement_e2, settlement_f3),
            street14_3 to listOf(settlement_e3, settlement_f4),
            street14_4 to listOf(settlement_e4, settlement_f5),
            street14_5 to listOf(settlement_e5), street15 to listOf(settlement_h1),
            street15_2 to listOf(settlement_g2, settlement_h2),
            street15_3 to listOf(settlement_g3, settlement_h3),
            street15_4 to listOf(settlement_g4, settlement_h4),
            street15_5 to listOf(settlement_g5, settlement_h5),
            street16 to listOf(settlement_j1),
            street16_2 to listOf(settlement_i2, settlement_j2),
            street16_3 to listOf(settlement_i3, settlement_j3),
            street16_4 to listOf(settlement_i4, settlement_j4),
            street17_2 to listOf(settlement_k2), street17_3 to listOf(settlement_k3))

        settlementTileMap = hashMapOf(
            settlement_b2 to listOf(tile3, tile4),
            settlement_b3 to listOf(tile4, tile5),
            settlement_c1 to listOf(tile2, tile3),
            settlement_c2 to listOf(tile3, tile4, tile14),
            settlement_c3 to listOf(tile4, tile5, tile15),
            settlement_c4 to listOf(tile5, tile6),
            settlement_d2 to listOf(tile2, tile3, tile14),
            settlement_d3 to listOf(tile4, tile14, tile15),
            settlement_d4 to listOf(tile5, tile15, tile15),
            settlement_e1 to listOf(tile1, tile2),
            settlement_e2 to listOf(tile2, tile13, tile14),
            settlement_e3 to listOf(tile14, tile15, tile19),
            settlement_e4 to listOf(tile6, tile15, tile16),
            settlement_e5 to listOf(tile6, tile7),
            settlement_f2 to listOf(tile1, tile2, tile13),
            settlement_f3 to listOf(tile13, tile14, tile19),
            settlement_f4 to listOf(tile15, tile16, tile19),
            settlement_f5 to listOf(tile6, tile7, tile16),
            settlement_g2 to listOf(tile1, tile12, tile13),
            settlement_g3 to listOf(tile13, tile18, tile19),
            settlement_g4 to listOf(tile16, tile17, tile19),
            settlement_g5 to listOf(tile7, tile8, tile16),
            settlement_h1 to listOf(tile1, tile12),
            settlement_h2 to listOf(tile12, tile13, tile18),
            settlement_h3 to listOf(tile17, tile18, tile19),
            settlement_h4 to listOf(tile8, tile16, tile17),
            settlement_h5 to listOf(tile7, tile8),
            settlement_i2 to listOf(tile12, tile11, tile18),
            settlement_i3 to listOf(tile10, tile17, tile18),
            settlement_i4 to listOf(tile8, tile9, tile17),
            settlement_j1 to listOf(tile12, tile11),
            settlement_j2 to listOf(tile10, tile11, tile18),
            settlement_j3 to listOf(tile9, tile10, tile17),
            settlement_j4 to listOf(tile8, tile9),
            settlement_k2 to listOf(tile10, tile11),
            settlement_k3 to listOf(tile9, tile10))

        blackSettlements = 0
        redSettlements = 0
        blueSettlements = 0
        greenSettlements = 0

        portTileMap = hashMapOf()
    }

    private fun disableSeaTileExcept(exclude: ImageView) {
        for (seaTile in seaTileList) {
            disableClickExcept(seaTile, exclude)
        }
    }

    private fun enableAllClickOnBoard() {
        seaTileClickListener()
    }

    private fun seaTileClickListener() {
        seaTile1.setOnClickListener(seaTile1ClickListener)
        seaTile2.setOnClickListener(seaTile2ClickListener)
        seaTile3.setOnClickListener(seaTile3ClickListener)
        seaTile4.setOnClickListener(seaTile4ClickListener)
        seaTile5.setOnClickListener(seaTile5ClickListener)
        seaTile6.setOnClickListener(seaTile6ClickListener)
        seaTile7.setOnClickListener(seaTile7ClickListener)
        seaTile8.setOnClickListener(seaTile8ClickListener)
        seaTile9.setOnClickListener(seaTile9ClickListener)
        seaTile10.setOnClickListener(seaTile10ClickListener)
        seaTile11.setOnClickListener(seaTile11ClickListener)
        seaTile12.setOnClickListener(seaTile12ClickListener)
        seaTile13.setOnClickListener(seaTile13ClickListener)
        seaTile14.setOnClickListener(seaTile14ClickListener)
        seaTile15.setOnClickListener(seaTile15ClickListener)
        seaTile16.setOnClickListener(seaTile16ClickListener)
        seaTile17.setOnClickListener(seaTile17ClickListener)
        seaTile18.setOnClickListener(seaTile18ClickListener)
    }

    private fun disableDragExcept(image: ImageView, exclude: ImageView) {
        if (image != exclude) {
            image.setOnDragListener(null)
        }
    }

    private fun disableClickExcept(image: ImageView, exclude: ImageView) {
        if (image != exclude) {
            image.setOnClickListener(null)
        }
    }

    private fun solver() {
        val tilePoints = hashMapOf(
            tile1 to Pair(getResourceOfTile(tile1), getNumberProbability(number1)),
            tile2 to Pair(getResourceOfTile(tile2), getNumberProbability(number2)),
            tile3 to Pair(getResourceOfTile(tile3), getNumberProbability(number3)),
            tile4 to Pair(getResourceOfTile(tile4), getNumberProbability(number4)),
            tile5 to Pair(getResourceOfTile(tile5), getNumberProbability(number5)),
            tile6 to Pair(getResourceOfTile(tile6), getNumberProbability(number6)),
            tile7 to Pair(getResourceOfTile(tile7), getNumberProbability(number7)),
            tile8 to Pair(getResourceOfTile(tile8), getNumberProbability(number8)),
            tile9 to Pair(getResourceOfTile(tile9), getNumberProbability(number9)),
            tile10 to Pair(getResourceOfTile(tile10), getNumberProbability(number10)),
            tile11 to Pair(getResourceOfTile(tile11), getNumberProbability(number11)),
            tile12 to Pair(getResourceOfTile(tile12), getNumberProbability(number12)),
            tile13 to Pair(getResourceOfTile(tile13), getNumberProbability(number13)),
            tile14 to Pair(getResourceOfTile(tile14), getNumberProbability(number14)),
            tile15 to Pair(getResourceOfTile(tile15), getNumberProbability(number15)),
            tile16 to Pair(getResourceOfTile(tile16), getNumberProbability(number16)),
            tile17 to Pair(getResourceOfTile(tile17), getNumberProbability(number17)),
            tile18 to Pair(getResourceOfTile(tile18), getNumberProbability(number18)),
            tile19 to Pair(getResourceOfTile(tile19), getNumberProbability(number19)))

        val totalValueResources = getTotalValueResources(tilePoints)

        val tileResourceValue = getTileResourceValue(totalValueResources, tilePoints)

        val settlementResourceValue = getSettlementResourceValue(tileResourceValue)

        val settlementOtherSettlementValue = getSettlementOtherSettlementValue(tilePoints, totalValueResources)

        val bestSettlement = findBestSettlement(settlementResourceValue, settlementOtherSettlementValue)

        val bestStreet = findBestStreet(bestSettlement)

        if (colorButton.contentDescription == "black") {
            bestSettlement.setImageResource(R.drawable.black_settlement)
            bestSettlement.contentDescription = "black"
            setStreet(bestStreet, "black")
            ignoreSettlement(bestSettlement, "black", false)
        }

        else if (colorButton.contentDescription == "red") {
            bestSettlement.setImageResource(R.drawable.red_settlement)
            bestSettlement.contentDescription = "red"
            setStreet(bestStreet, "red")
            ignoreSettlement(bestSettlement, "red", false)
        }

        else if (colorButton.contentDescription == "blue") {
            bestSettlement.setImageResource(R.drawable.blue_settlement)
            bestSettlement.contentDescription = "blue"
            setStreet(bestStreet, "blue")
            ignoreSettlement(bestSettlement, "blue", false)
        }

        else if (colorButton.contentDescription == "green") {
            bestSettlement.setImageResource(R.drawable.green_settlement)
            bestSettlement.contentDescription = "green"
            setStreet(bestStreet, "green")
            ignoreSettlement(bestSettlement, "green", false)
        }

        for (street in settlementStreetMap[bestSettlement]!!) {
            for (settlement2 in streetSettlementMap[street]!!) {
                if (settlement2 != bestSettlement) {
                    _settlementList.remove(settlement2)
                    settlement2.visibility = View.INVISIBLE
                }
            }
        }
        bestSettlement.visibility = View.VISIBLE
        pulsatingSettlementMap[bestSettlement]?.reverse()
        pulsatingSettlementMap[bestSettlement]?.end()
        pulsatingImageExtra(bestSettlement)

        bestStreet.visibility = View.VISIBLE
        pulsatingStreetMap[bestSettlement]?.reverse()
        pulsatingStreetMap[bestSettlement]?.end()
        pulsatingImageExtra(bestStreet)
    }

    private fun setStreet(street: ImageView, color: String) {
        when (street.contentDescription) {
            "h" -> { when (color) {
                "black" -> street.setImageResource(R.drawable.black_street1)
                "red" -> street.setImageResource(R.drawable.red_street1)
                "green" -> street.setImageResource(R.drawable.green_street1)
                "blue" -> street.setImageResource(R.drawable.blue_street1)
                "empty" -> street.setImageResource(R.drawable.empty_street1)
                }
            }
            "lu" -> { when (color) {
                "black" -> street.setImageResource(R.drawable.black_street2)
                "red" -> street.setImageResource(R.drawable.red_street2)
                "green" -> street.setImageResource(R.drawable.green_street2)
                "blue" -> street.setImageResource(R.drawable.blue_street2)
                "empty" -> street.setImageResource(R.drawable.empty_street2)
                }
            }
            "ru" -> { when (color) {
                "black" -> street.setImageResource(R.drawable.black_street3)
                "red" -> street.setImageResource(R.drawable.red_street3)
                "green" -> street.setImageResource(R.drawable.green_street3)
                "blue" -> street.setImageResource(R.drawable.blue_street3)
                "empty" -> street.setImageResource(R.drawable.empty_street3)
                }
            }
        }
    }

    private fun findBestStreet(bestSettlement: ImageView): ImageView {
        val random = (0..2).random()
        return settlementStreetMap[bestSettlement]!![random]
    }

    // Puts extra value in missing resources
    private fun getSettlementOtherSettlementValue(tilePoints:
                                                  HashMap<ImageView, Pair<String, Int>>,
                                                  totalValueResources: HashMap<String, Int>): HashMap<ImageView, Int> {
        val settlementOtherSettlementValue = hashMapOf<ImageView, Int>()
        val color = colorButton.contentDescription
        var firstSettlement: ImageView? = null

        for (settlement in settlementList) {
            if (settlement.contentDescription == color) {
                firstSettlement = settlement
            }
        }

        val currentResourceValues = hashMapOf("brick" to 0, "lumber" to 0,
            "wool" to 0, "grain" to 0, "ore" to 0)

        if (firstSettlement != null) {
            for (tile in settlementTileMap[firstSettlement]!!) {
                if (getResourceOfTile(tile) != "desert") {
                    val _resource = tilePoints[tile]?.first
                    val _value = tilePoints[tile]?.second
                    var newValue = currentResourceValues[_resource]!!
                    newValue += _value!!
                    currentResourceValues[_resource!!] = newValue
                }
            }
        }

        else {
            for (settlement in _settlementList.get()) {
                val thisResourceValues = hashMapOf("brick" to 0, "lumber" to 0,
                    "wool" to 0, "grain" to 0, "ore" to 0)
                for (tile in settlementTileMap[settlement]!!) {
                    if (getResourceOfTile(tile) != "desert") {
                        val _resource = tilePoints[tile]?.first
                        val _value = tilePoints[tile]?.second
                        var newValue = thisResourceValues[_resource]!!
                        newValue += _value!!
                        thisResourceValues[_resource!!] = newValue
                    }
                }
                settlementOtherSettlementValue[settlement] = getResourcePoints2(
                    thisResourceValues, settlement, totalValueResources)
            }
            return settlementOtherSettlementValue
        }

        for (settlement in _settlementList.get()) {
            val thisResourceValues = HashMap(currentResourceValues)
            for (tile in settlementTileMap[settlement]!!) {
                if (getResourceOfTile(tile) != "desert") {
                    val _resource = tilePoints[tile]?.first
                    val _value = tilePoints[tile]?.second
                    var newValue = thisResourceValues[_resource]!!
                    newValue += _value!!
                    thisResourceValues[_resource!!] = newValue
                }
            }
            settlementOtherSettlementValue[settlement] = getResourcePoints(
                thisResourceValues, settlement, totalValueResources)
        }
        return settlementOtherSettlementValue
    }

    private fun getResourcePoints2(resourceValues: HashMap<String, Int>,
                                   settlement: ImageView, totalValueResources: HashMap<String, Int>): Int {
        val brick = listOf(Pair("brick", 1F))
        val lumber = listOf(Pair("lumber", 1F))
        val wool = listOf(Pair("wool", 1F))
        val grain = listOf(Pair("grain", 1F))
        val ore = listOf(Pair("ore", 1F))
        val buildList = listOf(brick, lumber, wool, grain, ore)
        var points = 0F
        for (building in buildList) {
            var minValue = 100F
            for (resourceValue in building) {
                val rvs = resourceValue.first
                val value = resourceValues[rvs]?.div(resourceValue.second)
                if (value!! < minValue) {
                    minValue = value
                }
            }
            if (building == brick) {
                points += 11 * minValue
            }
            else if (building == lumber) {
                points += 10 * minValue
            }
            else if (building == wool) {
                points += 12 * minValue
            }
            else if (building == grain) {
                points += 16 * minValue
            }
            else if (building == ore) {
                points += 18 * minValue
            }
        }
        return points.toInt()
    }

    private fun getResourcePoints(resourceValues: HashMap<String, Int>,
                                  settlement: ImageView, totalValueResources: HashMap<String, Int>): Int {
        val brick = listOf(Pair("brick", 1F))
        val lumber = listOf(Pair("lumber", 1F))
        val wool = listOf(Pair("wool", 1F))
        val grain = listOf(Pair("grain", 1F))
        val ore = listOf(Pair("ore", 1F))
        val city = listOf(Pair("grain", 2F), Pair("ore", 3F))
        val _settlement = listOf(Pair("brick", 1F), Pair("lumber", 1F),
            Pair("wool", 1F), Pair("grain", 1F))
        val street = listOf(Pair("brick", 1F), Pair("lumber", 1F))
        val developmentCard = listOf(Pair("wool", 1F), Pair("grain", 1F),
            Pair("ore", 1F))
        val buildList = listOf(brick, lumber, wool, grain, ore, city,
            _settlement, street, developmentCard)
        var points = 0F
        for (building in buildList) {
            var minValue = 100F
            for (resourceValue in building) {
                val rvs = resourceValue.first
                val value = resourceValues[rvs]?.div(resourceValue.second)
                if (value!! < minValue) {
                    minValue = value
                }
            }
            if (building == city) {
                points += 5 * minValue
            }
            else if (building == settlement) {
                points += 3 * minValue
            }
            else if (building == street) {
                points += minValue
            }
            else if (building == developmentCard) {
                points += minValue
            }
        }
        return points.toInt()
    }

    private fun findBestSettlement(settlementValue: HashMap<ImageView, Int>,
                                   sosv: HashMap<ImageView, Int>): ImageView {

        val totalSettlementValue = hashMapOf<ImageView, Int>()
        for (i in sosv) {
            totalSettlementValue[i.key] = i.value * settlementValue[i.key]!!
        }

        val maxValue = totalSettlementValue.values.maxOrNull()
        for (sv in totalSettlementValue) {
            if (sv.value == maxValue) {
                return sv.key
            }
        }
        return settlement_b2
    }

    private fun getSettlementResourceValue(tileResourceValue: HashMap<ImageView, Int>):
            HashMap<ImageView, Int> {
        val settlementResourceValue = hashMapOf<ImageView, Int>()
        for (settlement in _settlementList.get()) {
            var value = 0
            for (tile in settlementTileMap[settlement]!!) {
                if (getResourceOfTile(tile) != "desert") {
                    value += tileResourceValue[tile]!!
                }
            }
            settlementResourceValue[settlement] = value
        }
        return settlementResourceValue
    }

    private fun getTileResourceValue(totalValueResources: HashMap<String, Int>,
                                     tilePoints: HashMap<ImageView, Pair<String, Int>>): HashMap<ImageView, Int> {
        val tileResourceValue = hashMapOf<ImageView, Int>()
        var valueAllResources = 0
        for (i in totalValueResources) {
            valueAllResources += i.value
        }
        for (tilePoint in tilePoints) {
            if (tilePoint.value.first != "desert") {

                var _tileResourcePoint = (tilePoint.value.second.toDouble().pow(2.0)
                        * valueAllResources /
                        totalValueResources[tilePoint.value.first]!!)

                val totalLumberPoints = getTotalResourcePoints(tilePoints,
                    "lumber")
                val totalBrickPoints = getTotalResourcePoints(tilePoints,
                    "brick")
                val totalGrainPoints = getTotalResourcePoints(tilePoints,
                    "grain")
                val totalOrePoints = getTotalResourcePoints(tilePoints,
                    "ore")

                if (tilePoint.value.first == "brick") {
                    _tileResourcePoint *= (totalLumberPoints.toDouble() /
                            totalBrickPoints.toDouble()).pow(1/3.toDouble())
                }
                else if (tilePoint.value.first == "stone") {
                    _tileResourcePoint *= (totalBrickPoints.toDouble() /
                            totalLumberPoints.toDouble()).pow(1/3.toDouble())
                }
                else if (tilePoint.value.first == "ore") {
                    _tileResourcePoint *= (totalGrainPoints.toDouble() /
                            totalOrePoints.toDouble()).pow(1/3.toDouble())
                }
                else if (tilePoint.value.first == "grain") {
                    _tileResourcePoint *= (totalOrePoints.toDouble() /
                            totalGrainPoints.toDouble()).pow(1/3.toDouble())
                }

                tileResourceValue[tilePoint.key] = _tileResourcePoint.toInt()
            }
        }
        return tileResourceValue
    }

    private fun getTotalResourcePoints(tilePoints: HashMap<ImageView,
            Pair<String, Int>>, resource: String): Int {
        var totalResourcePoint = 0
        for (tilePoint in tilePoints) {
            if (tilePoint.value.first == resource) {
                totalResourcePoint += tilePoint.value.second
            }
        }
        return totalResourcePoint
    }

    private fun getTotalValueResources(tilePoints: HashMap<ImageView,
            Pair<String, Int>>): HashMap<String, Int> {
        val totalValueResources = hashMapOf("brick" to 0, "lumber" to 0,
            "wool" to 0, "grain" to 0, "ore" to 0)
        for (tilePoint in tilePoints) {
            if (tilePoint.value.first != "desert") {
                var number = totalValueResources[tilePoint.value.first]!!
                number += tilePoint.value.second
                totalValueResources[tilePoint.value.first] = number
            }
        }
        return totalValueResources
    }

    private fun getNumberProbability(number: String): Int {
        return when (number.toInt()) {
            2 -> 1
            3 -> 2
            4 -> 3
            5 -> 4
            6 -> 5
            8 -> 5
            9 -> 4
            10 -> 3
            11 -> 2
            12 -> 1
            else -> 0
        }
    }

    private fun disableSeaTiles() {
        seaTile1.setOnClickListener(null)
        seaTile2.setOnClickListener(null)
        seaTile3.setOnClickListener(null)
        seaTile4.setOnClickListener(null)
        seaTile5.setOnClickListener(null)
        seaTile6.setOnClickListener(null)
        seaTile7.setOnClickListener(null)
        seaTile8.setOnClickListener(null)
        seaTile9.setOnClickListener(null)
        seaTile10.setOnClickListener(null)
        seaTile11.setOnClickListener(null)
        seaTile12.setOnClickListener(null)
        seaTile13.setOnClickListener(null)
        seaTile14.setOnClickListener(null)
        seaTile15.setOnClickListener(null)
        seaTile16.setOnClickListener(null)
        seaTile17.setOnClickListener(null)
        seaTile18.setOnClickListener(null)
    }

    private fun disableTiles() {
        tile1.setOnDragListener(null)
        tile2.setOnDragListener(null)
        tile3.setOnDragListener(null)
        tile4.setOnDragListener(null)
        tile5.setOnDragListener(null)
        tile6.setOnDragListener(null)
        tile7.setOnDragListener(null)
        tile8.setOnDragListener(null)
        tile9.setOnDragListener(null)
        tile10.setOnDragListener(null)
        tile11.setOnDragListener(null)
        tile12.setOnDragListener(null)
        tile13.setOnDragListener(null)
        tile14.setOnDragListener(null)
        tile15.setOnDragListener(null)
        tile16.setOnDragListener(null)
        tile17.setOnDragListener(null)
        tile18.setOnDragListener(null)
        tile19.setOnDragListener(null)
    }

    private fun disableNumbers() {
        for (tileNumberInput in tileNumberInputList) {
            tileNumberInput.visibility = View.INVISIBLE
        }
    }

    private fun setImageNumber(tileNumber: ImageView, number: String) {
        val desertNumber = getDesertNumber()
        if (number != desertNumber) {
            when (number) {
                "2" -> tileNumber.setImageResource(R.drawable.number2)
                "3" -> tileNumber.setImageResource(R.drawable.number3)
                "4" -> tileNumber.setImageResource(R.drawable.number4)
                "5" -> tileNumber.setImageResource(R.drawable.number5)
                "6" -> tileNumber.setImageResource(R.drawable.number6)
                "8" -> tileNumber.setImageResource(R.drawable.number8)
                "9" -> tileNumber.setImageResource(R.drawable.number9)
                "10" -> tileNumber.setImageResource(R.drawable.number10)
                "11" -> tileNumber.setImageResource(R.drawable.number11)
                "12" -> tileNumber.setImageResource(R.drawable.number12)
            }
        }
    }

    private class StreetList(streetList: List<ImageView>) {
        val streetList = streetList.toMutableList()

        fun remove(e: ImageView) {
            streetList.remove(e)
        }

        fun get(): MutableList<ImageView> {
            return streetList
        }
    }

    private class SettlementList(settlementList: List<ImageView>) {
        val settlementList = settlementList.toMutableList()

        fun remove(e: ImageView) {
            settlementList.remove(e)
        }

        fun get(): MutableList<ImageView> {
            return settlementList
        }

        fun contains(e: ImageView): Boolean {
            return e in settlementList
        }
    }

    private fun ignoreSettlement(settlement: ImageView, color: String, streetState: Boolean) {
        settlement.visibility = View.VISIBLE

        _settlementList.remove(settlement)

        for (street in settlementStreetMap[settlement]!!) {
            for (settlement2 in streetSettlementMap[street]!!) {
                if (settlement2 != settlement) {
                    _settlementList.remove(settlement2)
                }
            }
        }

        if (streetState) {
            for (street in settlementStreetMap[settlement]!!) {
                street.visibility = View.VISIBLE
                val pulse = pulsatingImage(street)
                pulsatingStreetMap[street] = pulse
                street.setOnClickListener {
                    val _street3 = street
                    val _settlement = settlement
                    val streetList3 = settlementStreetMap[settlement]
                    for (_street in streetList3!!) {
                        if (_street != _street3) {
                            _street.visibility = View.INVISIBLE
                        }
                    }
                    when (street.contentDescription) {
                        "h" -> { when (color) {
                            "black" -> street.setImageResource(R.drawable.black_street1)
                            "red" -> street.setImageResource(R.drawable.red_street1)
                            "green" -> street.setImageResource(R.drawable.green_street1)
                            "blue" -> street.setImageResource(R.drawable.blue_street1)
                        }
                        }
                        "lu" -> { when (color) {
                            "black" -> street.setImageResource(R.drawable.black_street2)
                            "red" -> street.setImageResource(R.drawable.red_street2)
                            "green" -> street.setImageResource(R.drawable.green_street2)
                            "blue" -> street.setImageResource(R.drawable.blue_street2)
                        }
                        }
                        "ru" -> { when (color) {
                            "black" -> street.setImageResource(R.drawable.black_street3)
                            "red" -> street.setImageResource(R.drawable.red_street3)
                            "green" -> street.setImageResource(R.drawable.green_street3)
                            "blue" -> street.setImageResource(R.drawable.blue_street3)
                        }
                        }
                    }
                    for (_street in settlementStreetMap[_settlement]!!) {
                        if (_street != street) {
                            _street.visibility = View.INVISIBLE
                        }
                        pulsatingStreetMap[_street]?.reverse()
                        pulsatingStreetMap[_street]?.end()
                    }
                    showStreetsAndSettlements()
                    street.setOnClickListener(null)
                }
            }
        }
    }

    @SuppressLint("UseSwitchCompatOrMaterialCode")
    private fun settlementClickListener(settlement: ImageView) {
        hideStreetsAndSettlements()
        if (colorButton.contentDescription == "black") {
            blackSettlements++
            settlement.setImageResource(R.drawable.black_settlement)
            settlement.contentDescription = "black"
            ignoreSettlement(settlement, "black", true)
        }

        else if (colorButton.contentDescription == "red") {
            redSettlements++
            settlement.setImageResource(R.drawable.red_settlement)
            settlement.contentDescription = "red"
            ignoreSettlement(settlement, "red", true)
        }

        else if (colorButton.contentDescription == "blue") {
            blueSettlements++
            settlement.setImageResource(R.drawable.blue_settlement)
            settlement.contentDescription = "blue"
            ignoreSettlement(settlement, "blue", true)
        }

        else if (colorButton.contentDescription == "green") {
            greenSettlements++
            settlement.setImageResource(R.drawable.green_settlement)
            settlement.contentDescription = "green"
            ignoreSettlement(settlement, "green", true)
        }

        else {
            settlement.setImageResource(R.drawable.empty_settlement)
        }
        settlement.setOnClickListener(null)
    }

    fun checkNumberOfSettlements(): Boolean {
        if ((colorButton.contentDescription == "black" && blackSettlements == 2) ||
            (colorButton.contentDescription == "red" && redSettlements == 2) ||
            (colorButton.contentDescription == "blue" && blueSettlements == 2) ||
            (colorButton.contentDescription == "green" && greenSettlements == 2)) {
            return false
        }
        return true
    }

    @SuppressLint("UseSwitchCompatOrMaterialCode")
    private val settlementb2ClickListener = View.OnClickListener {
        if (!checkNumberOfSettlements()) {
            Toast.makeText(this, "Already 2 settlements of color " +
                    "${colorButton.contentDescription}!", Toast.LENGTH_SHORT).show()
        }
        else {
            settlementClickListener(settlement_b2)
            settlement_b2.setOnClickListener(null)
        }
    }

    private val settlementb3ClickListener = View.OnClickListener {
        if (!checkNumberOfSettlements()) {
            Toast.makeText(this, "Already 2 settlements of color " +
                    "${colorButton.contentDescription}!", Toast.LENGTH_SHORT).show()
        }
        else {
            settlementClickListener(settlement_b3)
            settlement_b3.setOnClickListener(null)
        }
    }

    private val settlementc1ClickListener = View.OnClickListener {
        if (!checkNumberOfSettlements()) {
            Toast.makeText(this, "Already 2 settlements of color " +
                    "${colorButton.contentDescription}!", Toast.LENGTH_SHORT).show()
        }
        else {
            settlementClickListener(settlement_c1)
            settlement_c1.setOnClickListener(null)
        }
    }

    private val settlementc2ClickListener = View.OnClickListener {
        if (!checkNumberOfSettlements()) {
            Toast.makeText(this, "Already 2 settlements of color " +
                    "${colorButton.contentDescription}!", Toast.LENGTH_SHORT).show()
        }
        else {
            settlementClickListener(settlement_c2)
            settlement_c2.setOnClickListener(null)
        }
    }

    private val settlementc3ClickListener = View.OnClickListener {
        if (!checkNumberOfSettlements()) {
            Toast.makeText(this, "Already 2 settlements of color " +
                    "${colorButton.contentDescription}!", Toast.LENGTH_SHORT).show()
        }
        else {
            settlementClickListener(settlement_c3)
            settlement_c3.setOnClickListener(null)
        }
    }

    private val settlementc4ClickListener = View.OnClickListener {
        if (!checkNumberOfSettlements()) {
            Toast.makeText(this, "Already 2 settlements of color " +
                    "${colorButton.contentDescription}!", Toast.LENGTH_SHORT).show()
        }
        else {
            settlementClickListener(settlement_c4)
            settlement_c4.setOnClickListener(null)
        }
    }

    private val settlementd2ClickListener = View.OnClickListener {
        if (!checkNumberOfSettlements()) {
            Toast.makeText(this, "Already 2 settlements of color " +
                    "${colorButton.contentDescription}!", Toast.LENGTH_SHORT).show()
        }
        else {
            settlementClickListener(settlement_d2)
            settlement_d2.setOnClickListener(null)
        }
    }

    private val settlementd3ClickListener = View.OnClickListener {
        if (!checkNumberOfSettlements()) {
            Toast.makeText(this, "Already 2 settlements of color " +
                    "${colorButton.contentDescription}!", Toast.LENGTH_SHORT).show()
        }
        else {
            settlementClickListener(settlement_d3)
            settlement_d3.setOnClickListener(null)
        }
    }

    private val settlementd4ClickListener = View.OnClickListener {
        if (!checkNumberOfSettlements()) {
            Toast.makeText(this, "Already 2 settlements of color " +
                    "${colorButton.contentDescription}!", Toast.LENGTH_SHORT).show()
        }
        else {
            settlementClickListener(settlement_d4)
            settlement_d4.setOnClickListener(null)
        }
    }

    private val settlemente1ClickListener = View.OnClickListener {
        if (!checkNumberOfSettlements()) {
            Toast.makeText(this, "Already 2 settlements of color " +
                    "${colorButton.contentDescription}!", Toast.LENGTH_SHORT).show()
        }
        else {
            settlementClickListener(settlement_e1)
            settlement_e1.setOnClickListener(null)
        }
    }

    private val settlemente2ClickListener = View.OnClickListener {
        if (!checkNumberOfSettlements()) {
            Toast.makeText(this, "Already 2 settlements of color " +
                    "${colorButton.contentDescription}!", Toast.LENGTH_SHORT).show()
        }
        else {
            settlementClickListener(settlement_e2)
            settlement_e2.setOnClickListener(null)
        }
    }

    private val settlemente3ClickListener = View.OnClickListener {
        if (!checkNumberOfSettlements()) {
            Toast.makeText(this, "Already 2 settlements of color " +
                    "${colorButton.contentDescription}!", Toast.LENGTH_SHORT).show()
        }
        else {
            settlementClickListener(settlement_e3)
            settlement_e3.setOnClickListener(null)
        }
    }

    private val settlemente4ClickListener = View.OnClickListener {
        if (!checkNumberOfSettlements()) {
            Toast.makeText(this, "Already 2 settlements of color " +
                    "${colorButton.contentDescription}!", Toast.LENGTH_SHORT).show()
        }
        else {
            settlementClickListener(settlement_e4)
            settlement_e4.setOnClickListener(null)
        }
    }

    private val settlemente5ClickListener = View.OnClickListener {
        if (!checkNumberOfSettlements()) {
            Toast.makeText(this, "Already 2 settlements of color " +
                    "${colorButton.contentDescription}!", Toast.LENGTH_SHORT).show()
        }
        else {
            settlementClickListener(settlement_e5)
            settlement_e5.setOnClickListener(null)
        }
    }

    private val settlementf2ClickListener = View.OnClickListener {
        if (!checkNumberOfSettlements()) {
            Toast.makeText(this, "Already 2 settlements of color " +
                    "${colorButton.contentDescription}!", Toast.LENGTH_SHORT).show()
        }
        else {
            settlementClickListener(settlement_f2)
            settlement_f2.setOnClickListener(null)
        }
    }

    private val settlementf3ClickListener = View.OnClickListener {
        if (!checkNumberOfSettlements()) {
            Toast.makeText(this, "Already 2 settlements of color " +
                    "${colorButton.contentDescription}!", Toast.LENGTH_SHORT).show()
        }
        else {
            settlementClickListener(settlement_f3)
            settlement_f3.setOnClickListener(null)
        }
    }

    private val settlementf4ClickListener = View.OnClickListener {
        if (!checkNumberOfSettlements()) {
            Toast.makeText(this, "Already 2 settlements of color " +
                    "${colorButton.contentDescription}!", Toast.LENGTH_SHORT).show()
        }
        else {
            settlementClickListener(settlement_f4)
            settlement_f4.setOnClickListener(null)
        }
    }

    private val settlementf5ClickListener = View.OnClickListener {
        if (!checkNumberOfSettlements()) {
            Toast.makeText(this, "Already 2 settlements of color " +
                    "${colorButton.contentDescription}!", Toast.LENGTH_SHORT).show()
        }
        else {
            settlementClickListener(settlement_f5)
            settlement_f5.setOnClickListener(null)
        }
    }

    private val settlementg2ClickListener = View.OnClickListener {
        if (!checkNumberOfSettlements()) {
            Toast.makeText(this, "Already 2 settlements of color " +
                    "${colorButton.contentDescription}!", Toast.LENGTH_SHORT).show()
        }
        else {
            settlementClickListener(settlement_g2)
            settlement_g2.setOnClickListener(null)
        }
    }

    private val settlementg3ClickListener = View.OnClickListener {
        if (!checkNumberOfSettlements()) {
            Toast.makeText(this, "Already 2 settlements of color " +
                    "${colorButton.contentDescription}!", Toast.LENGTH_SHORT).show()
        }
        else {
            settlementClickListener(settlement_g3)
            settlement_g3.setOnClickListener(null)
        }
    }

    private val settlementg4ClickListener = View.OnClickListener {
        if (!checkNumberOfSettlements()) {
            Toast.makeText(this, "Already 2 settlements of color " +
                    "${colorButton.contentDescription}!", Toast.LENGTH_SHORT).show()
        }
        else {
            settlementClickListener(settlement_g4)
            settlement_g4.setOnClickListener(null)
        }
    }

    private val settlementg5ClickListener = View.OnClickListener {
        if (!checkNumberOfSettlements()) {
            Toast.makeText(this, "Already 2 settlements of color " +
                    "${colorButton.contentDescription}!", Toast.LENGTH_SHORT).show()
        }
        else {
            settlementClickListener(settlement_g5)
            settlement_g5.setOnClickListener(null)
        }
    }

    private val settlementh1ClickListener = View.OnClickListener {
        if (!checkNumberOfSettlements()) {
            Toast.makeText(this, "Already 2 settlements of color " +
                    "${colorButton.contentDescription}!", Toast.LENGTH_SHORT).show()
        }
        else {
            settlementClickListener(settlement_h1)
            settlement_h1.setOnClickListener(null)
        }
    }

    private val settlementh2ClickListener = View.OnClickListener {
        if (!checkNumberOfSettlements()) {
            Toast.makeText(this, "Already 2 settlements of color " +
                    "${colorButton.contentDescription}!", Toast.LENGTH_SHORT).show()
        }
        else {
            settlementClickListener(settlement_h2)
            settlement_h2.setOnClickListener(null)
        }
    }

    private val settlementh3ClickListener = View.OnClickListener {
        if (!checkNumberOfSettlements()) {
            Toast.makeText(this, "Already 2 settlements of color " +
                    "${colorButton.contentDescription}!", Toast.LENGTH_SHORT).show()
        }
        else {
            settlementClickListener(settlement_h3)
            settlement_h3.setOnClickListener(null)
        }
    }

    private val settlementh4ClickListener = View.OnClickListener {
        if (!checkNumberOfSettlements()) {
            Toast.makeText(this, "Already 2 settlements of color " +
                    "${colorButton.contentDescription}!", Toast.LENGTH_SHORT).show()
        }
        else {
            settlementClickListener(settlement_h4)
            settlement_h4.setOnClickListener(null)
        }
    }

    private val settlementh5ClickListener = View.OnClickListener {
        if (!checkNumberOfSettlements()) {
            Toast.makeText(this, "Already 2 settlements of color " +
                    "${colorButton.contentDescription}!", Toast.LENGTH_SHORT).show()
        }
        else {
            settlementClickListener(settlement_h5)
            settlement_h5.setOnClickListener(null)
        }
    }

    private val settlementi2ClickListener = View.OnClickListener {
        if (!checkNumberOfSettlements()) {
            Toast.makeText(this, "Already 2 settlements of color " +
                    "${colorButton.contentDescription}!", Toast.LENGTH_SHORT).show()
        }
        else {
            settlementClickListener(settlement_i2)
            settlement_i2.setOnClickListener(null)
        }
    }

    private val settlementi3ClickListener = View.OnClickListener {
        if (!checkNumberOfSettlements()) {
            Toast.makeText(this, "Already 2 settlements of color " +
                    "${colorButton.contentDescription}!", Toast.LENGTH_SHORT).show()
        }
        else {
            settlementClickListener(settlement_i3)
            settlement_i3.setOnClickListener(null)
        }
    }

    private val settlementi4ClickListener = View.OnClickListener {
        if (!checkNumberOfSettlements()) {
            Toast.makeText(this, "Already 2 settlements of color " +
                    "${colorButton.contentDescription}!", Toast.LENGTH_SHORT).show()
        }
        else {
            settlementClickListener(settlement_i4)
            settlement_i4.setOnClickListener(null)
        }
    }

    private val settlementj1ClickListener = View.OnClickListener {
        if (!checkNumberOfSettlements()) {
            Toast.makeText(this, "Already 2 settlements of color " +
                    "${colorButton.contentDescription}!", Toast.LENGTH_SHORT).show()
        }
        else {
            settlementClickListener(settlement_j1)
            settlement_j1.setOnClickListener(null)
        }
    }

    private val settlementj2ClickListener = View.OnClickListener {
        if (!checkNumberOfSettlements()) {
            Toast.makeText(this, "Already 2 settlements of color " +
                    "${colorButton.contentDescription}!", Toast.LENGTH_SHORT).show()
        }
        else {
            settlementClickListener(settlement_j2)
            settlement_j2.setOnClickListener(null)
        }
    }

    private val settlementj3ClickListener = View.OnClickListener {
        if (!checkNumberOfSettlements()) {
            Toast.makeText(this, "Already 2 settlements of color " +
                    "${colorButton.contentDescription}!", Toast.LENGTH_SHORT).show()
        }
        else {
            settlementClickListener(settlement_j3)
            settlement_j3.setOnClickListener(null)
        }
    }

    private val settlementj4ClickListener = View.OnClickListener {
        if (!checkNumberOfSettlements()) {
            Toast.makeText(this, "Already 2 settlements of color " +
                    "${colorButton.contentDescription}!", Toast.LENGTH_SHORT).show()
        }
        else {
            settlementClickListener(settlement_j4)
            settlement_j4.setOnClickListener(null)
        }
    }

    private val settlementk2ClickListener = View.OnClickListener {
        if (!checkNumberOfSettlements()) {
            Toast.makeText(this, "Already 2 settlements of color " +
                    "${colorButton.contentDescription}!", Toast.LENGTH_SHORT).show()
        }
        else {
            settlementClickListener(settlement_k2)
            settlement_k2.setOnClickListener(null)
        }
    }

    private val settlementk3ClickListener = View.OnClickListener {
        if (!checkNumberOfSettlements()) {
            Toast.makeText(this, "Already 2 settlements of color " +
                    "${colorButton.contentDescription}!", Toast.LENGTH_SHORT).show()
        }
        else {
            settlementClickListener(settlement_k3)
            settlement_k3.setOnClickListener(null)
        }
    }

    private fun checkIfTileNumberInDesert(tile: ImageView): Boolean {
        val desertNumber = getDesertNumber()
        return desertNumber == getNumberTileNumber(tile)
    }

    private fun getNumberTileNumber(tile: ImageView): String {
        val content = tile.contentDescription
        return if (content[5].isDigit()) {
            content.substring(4, 6)
        }
        else {
            content.substring(4, 5)
        }
    }

    private fun getDesertNumber(): String {
        when ("desert") {
            getResourceOfTile(tile1) -> return "1"
            getResourceOfTile(tile2) -> return "2"
            getResourceOfTile(tile3) -> return "3"
            getResourceOfTile(tile4) -> return "4"
            getResourceOfTile(tile5) -> return "5"
            getResourceOfTile(tile6) -> return "6"
            getResourceOfTile(tile7) -> return "7"
            getResourceOfTile(tile8) -> return "8"
            getResourceOfTile(tile9) -> return "9"
            getResourceOfTile(tile10) -> return "10"
            getResourceOfTile(tile11) -> return "11"
            getResourceOfTile(tile12) -> return "12"
            getResourceOfTile(tile13) -> return "13"
            getResourceOfTile(tile14) -> return "14"
            getResourceOfTile(tile15) -> return "15"
            getResourceOfTile(tile16) -> return "16"
            getResourceOfTile(tile17) -> return "17"
            getResourceOfTile(tile18) -> return "18"
            getResourceOfTile(tile19) -> return "19"
            else -> return "0"
        }
    }

    private fun getResourceOfTile(tile: ImageView): String {
        val content = tile.contentDescription
        if (content == "desert") {
            return "desert"
        }
        val index = content.indexOf('_') + 1
        return content.substring(index)
    }

    val pulsatingSettlementMap = hashMapOf<ImageView, ObjectAnimator>()
    val pulsatingStreetMap = hashMapOf<ImageView, ObjectAnimator>()

    private fun hideStreetsAndSettlements() {
        for (settlement in _settlementList.get()) {
            settlement.visibility = View.INVISIBLE
            pulsatingSettlementMap[settlement]?.reverse()
            pulsatingSettlementMap[settlement]?.end()
        }
    }

    private fun showStreetsAndSettlements() {
        for (settlement in _settlementList.get()) {
            settlement.visibility = View.VISIBLE
            val pulse = pulsatingImage(settlement)
            pulsatingSettlementMap[settlement] = pulse
        }
    }

    private fun checkIfInputNumbersValid(): Boolean {
        val numbersList = mutableListOf("2", "3", "3", "4", "4", "5", "5", "6",
            "6", "8", "8", "9", "9", "10", "10", "11", "11", "12")

        val desertNumber = getDesertNumber()

        if (desertNumber != "1") {
            val text1 = tile1NumberInput.text.toString()
            if (text1 != "") {
                if (text1 !in numbersList) {
                    return false
                }
                numbersList.remove(text1)
            }
        }

        if (desertNumber != "2") {
            val text2 = tile2NumberInput.text.toString()
            if (text2 != "") {
                if (text2 !in numbersList) {
                    return false
                }
                numbersList.remove(text2)
            }
        }

        if (desertNumber != "3") {
            val text3 = tile3NumberInput.text.toString()
            if (text3 != "") {
                if (text3 !in numbersList) {
                    return false
                }
                numbersList.remove(text3)
            }
        }

        if (desertNumber != "4") {
            val text4 = tile4NumberInput.text.toString()
            if (text4 != "") {
                if (text4 !in numbersList) {
                    return false
                }
                numbersList.remove(text4)
            }
        }

        if (desertNumber != "5") {
            val text5 = tile5NumberInput.text.toString()
            if (text5 != "") {
                if (text5 !in numbersList) {
                    return false
                }
                numbersList.remove(text5)
            }
        }

        if (desertNumber != "6") {
            val text6 = tile6NumberInput.text.toString()
            if (text6 != "") {
                if (text6 !in numbersList) {
                    return false
                }
                numbersList.remove(text6)
            }
        }

        if (desertNumber != "7") {
            val text7 = tile7NumberInput.text.toString()
            if (text7 != "") {
                if (text7 !in numbersList) {
                    return false
                }
                numbersList.remove(text7)
            }
        }

        if (desertNumber != "8") {
            val text8 = tile8NumberInput.text.toString()
            if (text8 != "") {
                if (text8 !in numbersList) {
                    return false
                }
                numbersList.remove(text8)
            }
        }

        if (desertNumber != "9") {
            val text9 = tile9NumberInput.text.toString()
            if (text9 != "") {
                if (text9 !in numbersList) {
                    return false
                }
                numbersList.remove(text9)
            }
        }

        if (desertNumber != "10") {
            val text10 = tile10NumberInput.text.toString()
            if (text10 != "") {
                if (text10 !in numbersList) {
                    return false
                }
                numbersList.remove(text10)
            }
        }

        if (desertNumber != "11") {
            val text11 = tile11NumberInput.text.toString()
            if (text11 != "") {
                if (text11 !in numbersList) {
                    return false
                }
                numbersList.remove(text11)
            }
        }

        if (desertNumber != "12") {
            val text12 = tile12NumberInput.text.toString()
            if (text12 != "") {
                if (text12 !in numbersList) {
                    return false
                }
                numbersList.remove(text12)
            }
        }

        if (desertNumber != "13") {
            val text13 = tile13NumberInput.text.toString()
            if (text13 != "") {
                if (text13 !in numbersList) {
                    return false
                }
                numbersList.remove(text13)
            }
        }

        if (desertNumber != "14") {
            val text14 = tile14NumberInput.text.toString()
            if (text14 != "") {
                if (text14 !in numbersList) {
                    return false
                }
                numbersList.remove(text14)
            }
        }

        if (desertNumber != "15") {
            val text15 = tile15NumberInput.text.toString()
            if (text15 != "") {
                if (text15 !in numbersList) {
                    return false
                }
                numbersList.remove(text15)
            }
        }

        if (desertNumber != "16") {
            val text16 = tile16NumberInput.text.toString()
            if (text16 != "") {
                if (text16 !in numbersList) {
                    return false
                }
                numbersList.remove(text16)
            }
        }

        if (desertNumber != "17") {
            val text17 = tile17NumberInput.text.toString()
            if (text17 != "") {
                if (text17 !in numbersList) {
                    return false
                }
                numbersList.remove(text17)
            }
        }

        if (desertNumber != "18") {
            val text18 = tile18NumberInput.text.toString()
            if (text18 != "") {
                if (text18 !in numbersList) {
                    return false
                }
                numbersList.remove(text18)
            }
        }

        if (desertNumber != "19") {
            val text19 = tile19NumberInput.text.toString()
            if (text19 != "") {
                if (text19 !in numbersList) {
                    return false
                }
                numbersList.remove(text19)
            }
        }

        if (numbersList.isNotEmpty()) {
            return false
        }

        return true
    }

    @SuppressLint("Recycle")
    private fun pulsatingImage(image: ImageView): ObjectAnimator {

        val scaleDown = ObjectAnimator.ofPropertyValuesHolder(image,
            PropertyValuesHolder.ofFloat("scaleX", 1.2F),
            PropertyValuesHolder.ofFloat("scaleY", 1.2F))

        scaleDown.duration = 310
        scaleDown.repeatCount = ObjectAnimator.INFINITE
        scaleDown.repeatMode = ObjectAnimator.REVERSE
        scaleDown.start()
        image.bringToFront()
        return scaleDown
    }

    private fun pulsatingImageExtra(image: ImageView): ObjectAnimator {

        val scaleDown = ObjectAnimator.ofPropertyValuesHolder(image,
            PropertyValuesHolder.ofFloat("scaleX", 4F),
            PropertyValuesHolder.ofFloat("scaleY", 4F))

        scaleDown.duration = 310
        scaleDown.repeatCount = 1
        scaleDown.repeatMode = ObjectAnimator.REVERSE
        scaleDown.start()
        image.bringToFront()
        return scaleDown
    }

    private fun displayCards() {
        cards.visibility = View.VISIBLE
        brick_card.visibility = View.VISIBLE
        lumber_card.visibility = View.VISIBLE
        sheep_card.visibility = View.VISIBLE
        grain_card.visibility = View.VISIBLE
        ore_card.visibility = View.VISIBLE
    }

    private fun hideCards() {
        cards.visibility = View.INVISIBLE
        brick_card.visibility = View.INVISIBLE
        lumber_card.visibility = View.INVISIBLE
        sheep_card.visibility = View.INVISIBLE
        grain_card.visibility = View.INVISIBLE
        ore_card.visibility = View.INVISIBLE
    }

    private val setNumbersToForeground = {
        tile1Number.bringToFront()
        tile2Number.bringToFront()
        tile3Number.bringToFront()
        tile4Number.bringToFront()
        tile5Number.bringToFront()
        tile6Number.bringToFront()
        tile7Number.bringToFront()
        tile8Number.bringToFront()
        tile9Number.bringToFront()
        tile10Number.bringToFront()
        tile11Number.bringToFront()
        tile12Number.bringToFront()
        tile13Number.bringToFront()
        tile14Number.bringToFront()
        tile15Number.bringToFront()
        tile16Number.bringToFront()
        tile17Number.bringToFront()
        tile18Number.bringToFront()
        tile19Number.bringToFront()

        tile1NumberInput.bringToFront()
        tile2NumberInput.bringToFront()
        tile3NumberInput.bringToFront()
        tile4NumberInput.bringToFront()
        tile5NumberInput.bringToFront()
        tile6NumberInput.bringToFront()
        tile7NumberInput.bringToFront()
        tile8NumberInput.bringToFront()
        tile9NumberInput.bringToFront()
        tile10NumberInput.bringToFront()
        tile11NumberInput.bringToFront()
        tile12NumberInput.bringToFront()
        tile13NumberInput.bringToFront()
        tile14NumberInput.bringToFront()
        tile15NumberInput.bringToFront()
        tile16NumberInput.bringToFront()
        tile17NumberInput.bringToFront()
        tile18NumberInput.bringToFront()
        tile19NumberInput.bringToFront()


    }

    private fun singleSeaTileBrick(portTile: ImageView) {
        portTile.setImageResource(R.drawable.brick_port)
        portTile.visibility = View.VISIBLE
        hideCards()
    }

    private fun singleSeaTileLumber(portTile: ImageView) {
        portTile.setImageResource(R.drawable.lumber_port)
        portTile.visibility = View.VISIBLE
        hideCards()
    }

    private fun singleSeaTileSheep(portTile: ImageView) {
        portTile.setImageResource(R.drawable.sheep_port)
        portTile.visibility = View.VISIBLE
        hideCards()
    }

    private fun singleSeaTileGrain(portTile: ImageView) {
        portTile.setImageResource(R.drawable.grain_port)
        portTile.visibility = View.VISIBLE
        hideCards()
    }

    private fun singleSeaTileOre(portTile: ImageView) {
        portTile.setImageResource(R.drawable.ore_port)
        portTile.visibility = View.VISIBLE
        hideCards()
    }

    private fun singleSeaTileQuestion(portTile: ImageView) {
        portTile.setImageResource(R.drawable.question_port)
        portTile.visibility = View.VISIBLE
        hideCards()
    }

    private fun singleSeaTile(portTile: ImageView, tile: ImageView, seaTile: ImageView) {
        displayCards()
        brick_card.setOnClickListener {
            singleSeaTileBrick(portTile)
            portTileMap[tile] = "brick"
            seaTile.setOnClickListener(null)
            seaTile.setImageResource(R.drawable.sea2)
            enableAllClickOnBoard()
        }
        lumber_card.setOnClickListener {
            singleSeaTileLumber(portTile)
            portTileMap[tile] = "lumber"
            seaTile.setOnClickListener(null)
            seaTile.setImageResource(R.drawable.sea2)
            enableAllClickOnBoard()
        }
        sheep_card.setOnClickListener {
            singleSeaTileSheep(portTile)
            portTileMap[tile] = "sheep"
            seaTile.setOnClickListener(null)
            seaTile.setImageResource(R.drawable.sea2)
            enableAllClickOnBoard()
        }
        grain_card.setOnClickListener {
            singleSeaTileGrain(portTile)
            portTileMap[tile] = "grain"
            seaTile.setOnClickListener(null)
            seaTile.setImageResource(R.drawable.sea2)
            enableAllClickOnBoard()
        }
        ore_card.setOnClickListener {
            singleSeaTileOre(portTile)
            portTileMap[tile] = "ore"
            seaTile.setOnClickListener(null)
            seaTile.setImageResource(R.drawable.sea2)
            enableAllClickOnBoard()
        }
    }

    private fun doubleSeaTile(portTile1: ImageView, portTile2: ImageView,
                              tile1: ImageView, tile2: ImageView, seaTile: ImageView) {
        displayCards()
        brick_card.setOnClickListener {
            val pulse1 = pulsatingImage(tile1)
            val pulse2 = pulsatingImage(tile2)
            seaTile.setOnClickListener(null)
            seaTile.setImageResource(R.drawable.sea2)
            setNumbersToForeground()
            tile1.setOnClickListener {
                portTile1.setImageResource(R.drawable.brick_port)
                portTile1.visibility = View.VISIBLE
                portTile2.visibility = View.INVISIBLE
                tile1.setOnClickListener(null)
                tile2.setOnClickListener(null)
                pulse1.reverse()
                pulse2.reverse()
                pulse1.end()
                pulse2.end()
                setNumbersToForeground()
                enableAllClickOnBoard()
            }
            tile2.setOnClickListener {
                portTile2.setImageResource(R.drawable.brick_port)
                portTile1.visibility = View.INVISIBLE
                portTile2.visibility = View.VISIBLE
                tile1.setOnClickListener(null)
                tile2.setOnClickListener(null)
                pulse1.reverse()
                pulse2.reverse()
                pulse1.end()
                pulse2.end()
                setNumbersToForeground()
                enableAllClickOnBoard()
            }
            hideCards()
        }
        lumber_card.setOnClickListener {
            val pulse1 = pulsatingImage(tile1)
            val pulse2 = pulsatingImage(tile2)
            seaTile.setOnClickListener(null)
            seaTile.setImageResource(R.drawable.sea2)
            setNumbersToForeground()
            tile1.setOnClickListener {
                portTile1.setImageResource(R.drawable.lumber_port)
                portTile1.visibility = View.VISIBLE
                portTile2.visibility = View.INVISIBLE
                tile1.setOnClickListener(null)
                tile2.setOnClickListener(null)
                pulse1.reverse()
                pulse2.reverse()
                pulse1.end()
                pulse2.end()
                setNumbersToForeground()
                enableAllClickOnBoard()
            }
            tile2.setOnClickListener {
                portTile2.setImageResource(R.drawable.lumber_port)
                portTile1.visibility = View.INVISIBLE
                portTile2.visibility = View.VISIBLE
                tile1.setOnClickListener(null)
                tile2.setOnClickListener(null)
                pulse1.reverse()
                pulse2.reverse()
                pulse1.end()
                pulse2.end()
                setNumbersToForeground()
                enableAllClickOnBoard()
            }
            hideCards()
        }
        sheep_card.setOnClickListener {
            val pulse1 = pulsatingImage(tile1)
            val pulse2 = pulsatingImage(tile2)
            seaTile.setOnClickListener(null)
            seaTile.setImageResource(R.drawable.sea2)
            setNumbersToForeground()
            tile1.setOnClickListener {
                portTile1.setImageResource(R.drawable.sheep_port)
                portTile1.visibility = View.VISIBLE
                portTile2.visibility = View.INVISIBLE
                tile1.setOnClickListener(null)
                tile2.setOnClickListener(null)
                pulse1.reverse()
                pulse2.reverse()
                pulse1.end()
                pulse2.end()
                setNumbersToForeground()
                enableAllClickOnBoard()
            }
            tile2.setOnClickListener {
                portTile2.setImageResource(R.drawable.sheep_port)
                portTile1.visibility = View.INVISIBLE
                portTile2.visibility = View.VISIBLE
                tile1.setOnClickListener(null)
                tile2.setOnClickListener(null)
                pulse1.reverse()
                pulse2.reverse()
                pulse1.end()
                pulse2.end()
                setNumbersToForeground()
                enableAllClickOnBoard()
            }
            hideCards()
        }
        grain_card.setOnClickListener {
            val pulse1 = pulsatingImage(tile1)
            val pulse2 = pulsatingImage(tile2)
            seaTile.setOnClickListener(null)
            seaTile.setImageResource(R.drawable.sea2)
            setNumbersToForeground()
            tile1.setOnClickListener {
                portTile1.setImageResource(R.drawable.grain_port)
                portTile1.visibility = View.VISIBLE
                portTile2.visibility = View.INVISIBLE
                tile1.setOnClickListener(null)
                tile2.setOnClickListener(null)
                pulse1.reverse()
                pulse2.reverse()
                pulse1.end()
                pulse2.end()
                setNumbersToForeground()
                enableAllClickOnBoard()
            }
            tile2.setOnClickListener {
                portTile2.setImageResource(R.drawable.grain_port)
                portTile1.visibility = View.INVISIBLE
                portTile2.visibility = View.VISIBLE
                tile1.setOnClickListener(null)
                tile2.setOnClickListener(null)
                pulse1.reverse()
                pulse2.reverse()
                pulse1.end()
                pulse2.end()
                setNumbersToForeground()
                enableAllClickOnBoard()
            }
            hideCards()
        }
        ore_card.setOnClickListener {
            val pulse1 = pulsatingImage(tile1)
            val pulse2 = pulsatingImage(tile2)
            seaTile.setOnClickListener(null)
            seaTile.setImageResource(R.drawable.sea2)
            setNumbersToForeground()
            tile1.setOnClickListener {
                portTile1.setImageResource(R.drawable.ore_port)
                portTile1.visibility = View.VISIBLE
                portTile2.visibility = View.INVISIBLE
                tile1.setOnClickListener(null)
                tile2.setOnClickListener(null)
                pulse1.reverse()
                pulse2.reverse()
                pulse1.end()
                pulse2.end()
                setNumbersToForeground()
                enableAllClickOnBoard()
            }
            tile2.setOnClickListener {
                portTile2.setImageResource(R.drawable.ore_port)
                portTile1.visibility = View.INVISIBLE
                portTile2.visibility = View.VISIBLE
                tile1.setOnClickListener(null)
                tile2.setOnClickListener(null)
                pulse1.reverse()
                pulse2.reverse()
                pulse1.end()
                pulse2.end()
                setNumbersToForeground()
                enableAllClickOnBoard()
            }
            hideCards()
        }
        seaTile.setOnClickListener {
            val pulse1 = pulsatingImage(tile1)
            val pulse2 = pulsatingImage(tile2)
            seaTile.setOnClickListener(null)
            seaTile.setImageResource(R.drawable.sea2)
            setNumbersToForeground()
            tile1.setOnClickListener {
                portTile1.setImageResource(R.drawable.question_port)
                portTile1.visibility = View.VISIBLE
                portTile2.visibility = View.INVISIBLE
                tile1.setOnClickListener(null)
                tile2.setOnClickListener(null)
                pulse1.reverse()
                pulse2.reverse()
                pulse1.end()
                pulse2.end()
                setNumbersToForeground()
                enableAllClickOnBoard()
            }
            tile2.setOnClickListener {
                portTile2.setImageResource(R.drawable.question_port)
                portTile1.visibility = View.INVISIBLE
                portTile2.visibility = View.VISIBLE
                tile1.setOnClickListener(null)
                tile2.setOnClickListener(null)
                pulse1.reverse()
                pulse2.reverse()
                pulse1.end()
                pulse2.end()
                setNumbersToForeground()
                enableAllClickOnBoard()
            }
            hideCards()
        }
    }

    private val seaTile1ClickListener = View.OnClickListener {
        disableSeaTileExcept(seaTile1)
        seaTile1.setImageResource(R.drawable.sea2_question)
        singleSeaTile(portTile1, tile1, seaTile1)
        seaTile1.setOnClickListener {
            singleSeaTileQuestion(portTile1)
            portTileMap[tile1] = "question"
            seaTile1.setOnClickListener(null)
            seaTile1.setImageResource(R.drawable.sea2)
            enableAllClickOnBoard()
        }
    }

    private val seaTile2ClickListener = View.OnClickListener {
        disableSeaTileExcept(seaTile2)
        seaTile2.setImageResource(R.drawable.sea2_question)
        doubleSeaTile(portTile2, portTile3, tile1, tile2, seaTile2)
    }

    private val seaTile3ClickListener = View.OnClickListener {
        disableSeaTileExcept(seaTile3)
        seaTile3.setImageResource(R.drawable.sea2_question)
        doubleSeaTile(portTile4, portTile5, tile2, tile3, seaTile3)
    }

    private val seaTile4ClickListener = View.OnClickListener {
        disableSeaTileExcept(seaTile4)
        seaTile4.setImageResource(R.drawable.sea2_question)
        singleSeaTile(portTile6, tile3, seaTile4)
        seaTile4.setOnClickListener {
            singleSeaTileQuestion(portTile6)
            portTileMap[tile3] = "question"
            seaTile4.setOnClickListener(null)
            seaTile4.setImageResource(R.drawable.sea2)
            enableAllClickOnBoard()
        }
    }

    private val seaTile5ClickListener = View.OnClickListener {
        disableSeaTileExcept(seaTile5)
        seaTile5.setImageResource(R.drawable.sea2_question)
        doubleSeaTile(portTile7, portTile8, tile3, tile4, seaTile5)
    }

    private val seaTile6ClickListener = View.OnClickListener {
        disableSeaTileExcept(seaTile6)
        seaTile6.setImageResource(R.drawable.sea2_question)
        doubleSeaTile(portTile9, portTile10, tile4, tile5, seaTile6)
    }

    private val seaTile7ClickListener = View.OnClickListener {
        disableSeaTileExcept(seaTile7)
        seaTile7.setImageResource(R.drawable.sea2_question)
        singleSeaTile(portTile11, tile5, seaTile7)
        seaTile7.setOnClickListener {
            singleSeaTileQuestion(portTile11)
            portTileMap[tile5] = "question"
            seaTile7.setOnClickListener(null)
            seaTile7.setImageResource(R.drawable.sea2)
            seaTile7.setImageResource(R.drawable.sea2)
            enableAllClickOnBoard()
        }

    }

    private val seaTile8ClickListener = View.OnClickListener {
        disableSeaTileExcept(seaTile8)
        seaTile8.setImageResource(R.drawable.sea2_question)
        doubleSeaTile(portTile12, portTile13, tile5, tile6, seaTile8)
    }

    private val seaTile9ClickListener = View.OnClickListener {
        disableSeaTileExcept(seaTile9)
        seaTile9.setImageResource(R.drawable.sea2_question)
        doubleSeaTile(portTile14, portTile15, tile6, tile7, seaTile9)
    }

    private val seaTile10ClickListener = View.OnClickListener {
        disableSeaTileExcept(seaTile10)
        seaTile10.setImageResource(R.drawable.sea2_question)
        singleSeaTile(portTile16, tile7, seaTile10)
        seaTile10.setOnClickListener {
            singleSeaTileQuestion(portTile16)
            portTileMap[tile7] = "question"
            seaTile10.setOnClickListener(null)
            seaTile10.setImageResource(R.drawable.sea2)
            enableAllClickOnBoard()
        }
    }

    private val seaTile11ClickListener = View.OnClickListener {
        disableSeaTileExcept(seaTile11)
        seaTile11.setImageResource(R.drawable.sea2_question)
        doubleSeaTile(portTile17, portTile18, tile7, tile8, seaTile11)
    }

    private val seaTile12ClickListener = View.OnClickListener {
        disableSeaTileExcept(seaTile12)
        seaTile12.setImageResource(R.drawable.sea2_question)
        doubleSeaTile(portTile19, portTile20, tile8, tile9, seaTile12)
    }

    private val seaTile13ClickListener = View.OnClickListener {
        disableSeaTileExcept(seaTile13)
        seaTile13.setImageResource(R.drawable.sea2_question)
        singleSeaTile(portTile21, tile9, seaTile13)
        seaTile13.setOnClickListener {
            singleSeaTileQuestion(portTile21)
            portTileMap[tile9] = "question"
            seaTile13.setOnClickListener(null)
            seaTile13.setImageResource(R.drawable.sea2)
            enableAllClickOnBoard()
        }
    }

    private val seaTile14ClickListener = View.OnClickListener {
        disableSeaTileExcept(seaTile14)
        seaTile14.setImageResource(R.drawable.sea2_question)
        doubleSeaTile(portTile22, portTile23, tile9, tile10, seaTile14)
    }

    private val seaTile15ClickListener = View.OnClickListener {
        disableSeaTileExcept(seaTile15)
        seaTile15.setImageResource(R.drawable.sea2_question)
        doubleSeaTile(portTile24, portTile25, tile10, tile11, seaTile15)
    }

    private val seaTile16ClickListener = View.OnClickListener {
        disableSeaTileExcept(seaTile16)
        seaTile16.setImageResource(R.drawable.sea2_question)
        singleSeaTile(portTile26, tile11, seaTile16)
        seaTile16.setOnClickListener {
            singleSeaTileQuestion(portTile26)
            portTileMap[tile11] = "question"
            seaTile16.setOnClickListener(null)
            seaTile16.setImageResource(R.drawable.sea2)
            enableAllClickOnBoard()
        }
    }

    private val seaTile17ClickListener = View.OnClickListener {
        disableSeaTileExcept(seaTile17)
        seaTile17.setImageResource(R.drawable.sea2_question)
        doubleSeaTile(portTile27, portTile28, tile11, tile12, seaTile17)
    }

    private val seaTile18ClickListener = View.OnClickListener {
        disableSeaTileExcept(seaTile18)
        seaTile18.setImageResource(R.drawable.sea2_question)
        doubleSeaTile(portTile29, portTile30, tile12, tile1, seaTile18)
    }

    var numberOfBrickCards = 3
    var numberOfLumberCards = 4
    var numberOfSheepCards = 4
    var numberOfGrainCards = 4
    var numberOfOreCards = 3
    var numberOfDesertCards = 1

    private fun isTileEmpty(tile: ImageView): Boolean {
        return tile.contentDescription.substring(5) == "Empty" || tile.contentDescription.substring(6) == "Empty"
    }

    private fun dragEventDrop(draggableItem: View, view: View, tile: ImageView, tileNumber: Int) {
        // reset opacity if the mask is dropped
        //binding.tile1DropArea.alpha = 1.0f

        val dragContent = draggableItem.contentDescription
        val tileContent = tile.contentDescription

        if (dragContent in listOf("brick", "lumber", "wool",
                "grain", "ore", "desert") && isTileEmpty(tile)) {

            val parent = draggableItem.parent as ConstraintLayout

            when (draggableItem.contentDescription) {
                "brick" -> { tile.setImageResource(R.drawable.brick2)
                    numberOfBrickCards--
                    tile.contentDescription = "tile" + tileNumber + "_brick"
                    if (numberOfBrickCards == 0) {
                        brick1.visibility = View.INVISIBLE
                    }
                }
                "lumber" -> { tile.setImageResource(R.drawable.lumber2)
                    numberOfLumberCards--
                    tile.contentDescription = "tile" + tileNumber + "_lumber"
                    if (numberOfLumberCards == 0) {
                        lumber1.visibility = View.INVISIBLE
                    }
                }
                "wool" -> { tile.setImageResource(R.drawable.wool2)
                    numberOfSheepCards--
                    tile.contentDescription = "tile" + tileNumber + "_wool"
                    if (numberOfSheepCards == 0) {
                        sheep1.visibility = View.INVISIBLE
                    }
                }
                "grain" -> { tile.setImageResource(R.drawable.grain2)
                    numberOfGrainCards--
                    tile.contentDescription = "tile" + tileNumber + "_grain"
                    if (numberOfGrainCards == 0) {
                        grain1.visibility = View.INVISIBLE
                    }
                }
                "ore" -> { tile.setImageResource(R.drawable.ore2)
                    numberOfOreCards--
                    tile.contentDescription = "tile" + tileNumber + "_ore"
                    if (numberOfOreCards == 0) {
                        ore1.visibility = View.INVISIBLE
                    }
                }
                "desert" -> { tile.setImageResource(R.drawable.desert2)
                    numberOfDesertCards--
                    tile.contentDescription = "tile" + tileNumber + "_desert"
                    desert1.visibility = View.INVISIBLE
                }
            }
            if (numberOfBrickCards == 0 && numberOfLumberCards == 0 && numberOfSheepCards == 0
                && numberOfGrainCards == 0 && numberOfOreCards == 0 && numberOfDesertCards == 0) {
                binding.continueButton.visibility = View.VISIBLE
            }
        }

        else if (dragContent !in listOf("brick", "lumber",
                "wool", "grain", "ore", "desert") &&
            draggableItem.contentDescription != tile.contentDescription) {

            val dragContent = draggableItem.contentDescription
            var index = dragContent.indexOf('_')
            val dragTile = dragContent.substring(0, index)
            val dragResource = dragContent.substring(index + 1, dragContent.length)

            val tileContent = tile.contentDescription

            var tileResource = "empty"
            if (!isTileEmpty(tile)) {
                index = tileContent.indexOf('_')
                tileResource = tileContent.substring(index + 1, tileContent.length)
            }

            var tileTemp = tile1
            when (dragTile) {
                "tile2" -> tileTemp = tile2
                "tile3" -> tileTemp = tile3
                "tile4" -> tileTemp = tile4
                "tile5" -> tileTemp = tile5
                "tile6" -> tileTemp = tile6
                "tile7" -> tileTemp = tile7
                "tile8" -> tileTemp = tile8
                "tile9" -> tileTemp = tile9
                "tile10" -> tileTemp = tile10
                "tile11" -> tileTemp = tile11
                "tile12" -> tileTemp = tile12
                "tile13" -> tileTemp = tile13
                "tile14" -> tileTemp = tile14
                "tile15" -> tileTemp = tile15
                "tile16" -> tileTemp = tile16
                "tile17" -> tileTemp = tile17
                "tile18" -> tileTemp = tile18
                "tile19" -> tileTemp = tile19
            }

            lateinit var dragNumber: String
            val numberIndex = dragTile.lastIndex
            if (dragTile[numberIndex - 1].isDigit()) {
                dragNumber = dragTile.substring(numberIndex - 1, numberIndex + 1)
            }
            else {
                dragNumber = dragTile[numberIndex].toString()
            }

            when (dragResource) {
                "brick" -> { tile.setImageResource(R.drawable.brick2)
                    tile.contentDescription = "tile" + tileNumber + "_brick"}
                "lumber" -> { tile.setImageResource(R.drawable.lumber2)
                    tile.contentDescription = "tile" + tileNumber + "_lumber"}
                "wool" -> { tile.setImageResource(R.drawable.wool2)
                    tile.contentDescription = "tile" + tileNumber + "_wool"}
                "grain" -> { tile.setImageResource(R.drawable.grain2)
                    tile.contentDescription = "tile" + tileNumber + "_grain"}
                "ore" -> { tile.setImageResource(R.drawable.ore2)
                    tile.contentDescription = "tile" + tileNumber + "_ore"}
                "desert" -> { tile.setImageResource(R.drawable.desert2)
                    tile.contentDescription = "tile" + tileNumber + "_desert"}
            }

            when (tileResource) {
                "brick" -> { tileTemp.setImageResource(R.drawable.brick2)
                    tileTemp.contentDescription = "tile" + dragNumber + "_brick"}
                "lumber" -> { tileTemp.setImageResource(R.drawable.lumber2)
                    tileTemp.contentDescription = "tile" + dragNumber + "_lumber"}
                "wool" -> { tileTemp.setImageResource(R.drawable.wool2)
                    tileTemp.contentDescription = "tile" + dragNumber + "_wool"}
                "grain" -> { tileTemp.setImageResource(R.drawable.grain2)
                    tileTemp.contentDescription = "tile" + dragNumber + "_grain"}
                "ore" -> { tileTemp.setImageResource(R.drawable.ore2)
                    tileTemp.contentDescription = "tile" + dragNumber + "_ore"}
                "desert" -> { tileTemp.setImageResource(R.drawable.desert2)
                    tileTemp.contentDescription = "tile" + dragNumber + "_desert"}
                else -> { tileTemp.setImageResource(R.drawable.tile)
                    tileTemp.contentDescription = "tile" + dragNumber + "Empty"
                }
            }

            if (numberOfBrickCards == 0 && numberOfLumberCards == 0 && numberOfSheepCards == 0
                && numberOfGrainCards == 0 && numberOfOreCards == 0 && numberOfDesertCards == 0) {
                binding.continueButton.visibility = View.VISIBLE
            }
        }

        else {
            Toast.makeText(this, "This tile is not free", Toast.LENGTH_SHORT).show()
        }

        //checkIfMaskIsOnFace(dragEvent)
    }

    private fun checkIfTilesZero(draggableItem: View): Boolean {
        val content = draggableItem.contentDescription

        if (content == "brick" && numberOfBrickCards == 0) {
            return true
        }
        else if (content == "lumber" && numberOfLumberCards == 0) {
            return true
        }
        else if (content == "wool" && numberOfSheepCards == 0) {
            return true
        }
        else if (content == "grain" && numberOfGrainCards == 0) {
            return true
        }
        else if (content == "ore" && numberOfOreCards == 0) {
            return true
        }
        else if (content == "desert" && numberOfDesertCards == 0) {
            return true
        }
        return false
    }

    // Creates a tile drag event listener
    private val tile1DragListener = View.OnDragListener { view, dragEvent ->

        val draggableItem = dragEvent.localState as View

        when (dragEvent.action) {
            DragEvent.ACTION_DRAG_STARTED -> {
                true
            }
            DragEvent.ACTION_DRAG_ENTERED -> {
                // dims the view when the mask has entered the drop area
                binding.tile1.alpha = 0.5f
                true
            }
            DragEvent.ACTION_DRAG_LOCATION -> {
                true
            }
            DragEvent.ACTION_DRAG_EXITED -> {
                // reset opacity if the mask exits drop area without drop action
                binding.tile1.alpha = 1.0f
                //when mask exits drop-area without dropping set mask visibility to VISIBLE
                //draggableItem.visibility = View.VISIBLE

                view.invalidate()
                true
            }
            DragEvent.ACTION_DROP -> {
                dragEventDrop(draggableItem, view, tile1, 1)
                binding.tile1.alpha = 1.0f
                true
            }
            DragEvent.ACTION_DRAG_ENDED -> {
                if (!checkIfTilesZero(draggableItem)) {
                    draggableItem.visibility = View.VISIBLE
                }
                view.invalidate()
                true
            }
            else -> {
                false
            }
        }
    }

    private val tile2DragListener = View.OnDragListener { view, dragEvent ->

        val draggableItem = dragEvent.localState as View

        when (dragEvent.action) {
            DragEvent.ACTION_DRAG_STARTED -> {
                true
            }
            DragEvent.ACTION_DRAG_ENTERED -> {
                // dims the view when the mask has entered the drop area
                binding.tile2.alpha = 0.5f
                true
            }
            DragEvent.ACTION_DRAG_LOCATION -> {
                true
            }
            DragEvent.ACTION_DRAG_EXITED -> {
                // reset opacity if the mask exits drop area without drop action
                binding.tile2.alpha = 1.0f
                //when mask exits drop-area without dropping set mask visibility to VISIBLE
                //draggableItem.visibility = View.VISIBLE
                view.invalidate()
                true
            }
            DragEvent.ACTION_DROP -> {
                dragEventDrop(draggableItem, view, tile2, 2)
                binding.tile2.alpha = 1.0f
                true
            }
            DragEvent.ACTION_DRAG_ENDED -> {
                if (!checkIfTilesZero(draggableItem)) {
                    draggableItem.visibility = View.VISIBLE
                }
                view.invalidate()
                true
            }
            else -> {
                false
            }

        }
    }

    private val tile3DragListener = View.OnDragListener { view, dragEvent ->

        val draggableItem = dragEvent.localState as View

        when (dragEvent.action) {
            DragEvent.ACTION_DRAG_STARTED -> {
                true
            }
            DragEvent.ACTION_DRAG_ENTERED -> {
                // dims the view when the mask has entered the drop area
                binding.tile3.alpha = 0.5f
                true
            }
            DragEvent.ACTION_DRAG_LOCATION -> {
                true
            }
            DragEvent.ACTION_DRAG_EXITED -> {
                // reset opacity if the mask exits drop area without drop action
                binding.tile3.alpha = 1.0f
                //when mask exits drop-area without dropping set mask visibility to VISIBLE
                //draggableItem.visibility = View.VISIBLE
                view.invalidate()
                true
            }
            DragEvent.ACTION_DROP -> {
                dragEventDrop(draggableItem, view, tile3, 3)
                binding.tile3.alpha = 1.0f
                true
            }
            DragEvent.ACTION_DRAG_ENDED -> {
                if (!checkIfTilesZero(draggableItem)) {
                    draggableItem.visibility = View.VISIBLE
                }
                view.invalidate()
                true
            }
            else -> {
                false
            }

        }
    }

    private val tile4DragListener = View.OnDragListener { view, dragEvent ->

        val draggableItem = dragEvent.localState as View

        when (dragEvent.action) {
            DragEvent.ACTION_DRAG_STARTED -> {
                true
            }
            DragEvent.ACTION_DRAG_ENTERED -> {
                // dims the view when the mask has entered the drop area
                binding.tile4.alpha = 0.5f
                true
            }
            DragEvent.ACTION_DRAG_LOCATION -> {
                true
            }
            DragEvent.ACTION_DRAG_EXITED -> {
                // reset opacity if the mask exits drop area without drop action
                binding.tile4.alpha = 1.0f
                //when mask exits drop-area without dropping set mask visibility to VISIBLE
                //draggableItem.visibility = View.VISIBLE
                view.invalidate()
                true
            }
            DragEvent.ACTION_DROP -> {
                dragEventDrop(draggableItem, view, tile4, 4)
                binding.tile4.alpha = 1.0f
                true
            }
            DragEvent.ACTION_DRAG_ENDED -> {
                if (!checkIfTilesZero(draggableItem)) {
                    draggableItem.visibility = View.VISIBLE
                }
                view.invalidate()
                true
            }
            else -> {
                false
            }

        }
    }

    private val tile5DragListener = View.OnDragListener { view, dragEvent ->

        val draggableItem = dragEvent.localState as View

        when (dragEvent.action) {
            DragEvent.ACTION_DRAG_STARTED -> {
                true
            }
            DragEvent.ACTION_DRAG_ENTERED -> {
                // dims the view when the mask has entered the drop area
                binding.tile5.alpha = 0.5f
                true
            }
            DragEvent.ACTION_DRAG_LOCATION -> {
                true
            }
            DragEvent.ACTION_DRAG_EXITED -> {
                // reset opacity if the mask exits drop area without drop action
                binding.tile5.alpha = 1.0f
                //when mask exits drop-area without dropping set mask visibility to VISIBLE
                //draggableItem.visibility = View.VISIBLE
                view.invalidate()
                true
            }
            DragEvent.ACTION_DROP -> {
                dragEventDrop(draggableItem, view, tile5, 5)
                binding.tile5.alpha = 1.0f
                true
            }
            DragEvent.ACTION_DRAG_ENDED -> {
                if (!checkIfTilesZero(draggableItem)) {
                    draggableItem.visibility = View.VISIBLE
                }
                view.invalidate()
                true
            }
            else -> {
                false
            }

        }
    }

    private val tile6DragListener = View.OnDragListener { view, dragEvent ->

        val draggableItem = dragEvent.localState as View

        when (dragEvent.action) {
            DragEvent.ACTION_DRAG_STARTED -> {
                true
            }
            DragEvent.ACTION_DRAG_ENTERED -> {
                // dims the view when the mask has entered the drop area
                binding.tile6.alpha = 0.5f
                true
            }
            DragEvent.ACTION_DRAG_LOCATION -> {
                true
            }
            DragEvent.ACTION_DRAG_EXITED -> {
                // reset opacity if the mask exits drop area without drop action
                binding.tile6.alpha = 1.0f
                //when mask exits drop-area without dropping set mask visibility to VISIBLE
                //draggableItem.visibility = View.VISIBLE
                view.invalidate()
                true
            }
            DragEvent.ACTION_DROP -> {
                dragEventDrop(draggableItem, view, tile6, 6)
                binding.tile6.alpha = 1.0f
                true
            }
            DragEvent.ACTION_DRAG_ENDED -> {
                if (!checkIfTilesZero(draggableItem)) {
                    draggableItem.visibility = View.VISIBLE
                }
                view.invalidate()
                true
            }
            else -> {
                false
            }

        }
    }

    private val tile7DragListener = View.OnDragListener { view, dragEvent ->

        val draggableItem = dragEvent.localState as View

        when (dragEvent.action) {
            DragEvent.ACTION_DRAG_STARTED -> {
                true
            }
            DragEvent.ACTION_DRAG_ENTERED -> {
                // dims the view when the mask has entered the drop area
                binding.tile7.alpha = 0.5f
                true
            }
            DragEvent.ACTION_DRAG_LOCATION -> {
                true
            }
            DragEvent.ACTION_DRAG_EXITED -> {
                // reset opacity if the mask exits drop area without drop action
                binding.tile7.alpha = 1.0f
                //when mask exits drop-area without dropping set mask visibility to VISIBLE
                //draggableItem.visibility = View.VISIBLE
                view.invalidate()
                true
            }
            DragEvent.ACTION_DROP -> {
                dragEventDrop(draggableItem, view, tile7, 7)
                binding.tile7.alpha = 1.0f
                true
            }
            DragEvent.ACTION_DRAG_ENDED -> {
                if (!checkIfTilesZero(draggableItem)) {
                    draggableItem.visibility = View.VISIBLE
                }
                view.invalidate()
                true
            }
            else -> {
                false
            }

        }
    }

    private val tile8DragListener = View.OnDragListener { view, dragEvent ->

        val draggableItem = dragEvent.localState as View

        when (dragEvent.action) {
            DragEvent.ACTION_DRAG_STARTED -> {
                true
            }
            DragEvent.ACTION_DRAG_ENTERED -> {
                // dims the view when the mask has entered the drop area
                binding.tile8.alpha = 0.5f
                true
            }
            DragEvent.ACTION_DRAG_LOCATION -> {
                true
            }
            DragEvent.ACTION_DRAG_EXITED -> {
                // reset opacity if the mask exits drop area without drop action
                binding.tile8.alpha = 1.0f
                //when mask exits drop-area without dropping set mask visibility to VISIBLE
                //draggableItem.visibility = View.VISIBLE
                view.invalidate()
                true
            }
            DragEvent.ACTION_DROP -> {
                dragEventDrop(draggableItem, view, tile8, 8)
                binding.tile8.alpha = 1.0f
                true
            }
            DragEvent.ACTION_DRAG_ENDED -> {
                if (!checkIfTilesZero(draggableItem)) {
                    draggableItem.visibility = View.VISIBLE
                }
                view.invalidate()
                true
            }
            else -> {
                false
            }

        }
    }

    private val tile9DragListener = View.OnDragListener { view, dragEvent ->

        val draggableItem = dragEvent.localState as View

        when (dragEvent.action) {
            DragEvent.ACTION_DRAG_STARTED -> {
                true
            }
            DragEvent.ACTION_DRAG_ENTERED -> {
                // dims the view when the mask has entered the drop area
                binding.tile9.alpha = 0.5f
                true
            }
            DragEvent.ACTION_DRAG_LOCATION -> {
                true
            }
            DragEvent.ACTION_DRAG_EXITED -> {
                // reset opacity if the mask exits drop area without drop action
                binding.tile9.alpha = 1.0f
                //when mask exits drop-area without dropping set mask visibility to VISIBLE
                //draggableItem.visibility = View.VISIBLE
                view.invalidate()
                true
            }
            DragEvent.ACTION_DROP -> {
                dragEventDrop(draggableItem, view, tile9, 9)
                binding.tile9.alpha = 1.0f
                true
            }
            DragEvent.ACTION_DRAG_ENDED -> {
                if (!checkIfTilesZero(draggableItem)) {
                    draggableItem.visibility = View.VISIBLE
                }
                view.invalidate()
                true
            }
            else -> {
                false
            }

        }
    }

    private val tile10DragListener = View.OnDragListener { view, dragEvent ->

        val draggableItem = dragEvent.localState as View

        when (dragEvent.action) {
            DragEvent.ACTION_DRAG_STARTED -> {
                true
            }
            DragEvent.ACTION_DRAG_ENTERED -> {
                // dims the view when the mask has entered the drop area
                binding.tile10.alpha = 0.5f
                true
            }
            DragEvent.ACTION_DRAG_LOCATION -> {
                true
            }
            DragEvent.ACTION_DRAG_EXITED -> {
                // reset opacity if the mask exits drop area without drop action
                binding.tile10.alpha = 1.0f
                //when mask exits drop-area without dropping set mask visibility to VISIBLE
                //draggableItem.visibility = View.VISIBLE
                view.invalidate()
                true
            }
            DragEvent.ACTION_DROP -> {
                dragEventDrop(draggableItem, view, tile10, 10)
                binding.tile10.alpha = 1.0f
                true
            }
            DragEvent.ACTION_DRAG_ENDED -> {
                if (!checkIfTilesZero(draggableItem)) {
                    draggableItem.visibility = View.VISIBLE
                }
                view.invalidate()
                true
            }
            else -> {
                false
            }

        }
    }

    private val tile11DragListener = View.OnDragListener { view, dragEvent ->

        val draggableItem = dragEvent.localState as View

        when (dragEvent.action) {
            DragEvent.ACTION_DRAG_STARTED -> {
                true
            }
            DragEvent.ACTION_DRAG_ENTERED -> {
                // dims the view when the mask has entered the drop area
                binding.tile11.alpha = 0.5f
                true
            }
            DragEvent.ACTION_DRAG_LOCATION -> {
                true
            }
            DragEvent.ACTION_DRAG_EXITED -> {
                // reset opacity if the mask exits drop area without drop action
                binding.tile11.alpha = 1.0f
                //when mask exits drop-area without dropping set mask visibility to VISIBLE
                //draggableItem.visibility = View.VISIBLE
                view.invalidate()
                true
            }
            DragEvent.ACTION_DROP -> {
                dragEventDrop(draggableItem, view, tile11, 11)
                binding.tile11.alpha = 1.0f
                true
            }
            DragEvent.ACTION_DRAG_ENDED -> {
                if (!checkIfTilesZero(draggableItem)) {
                    draggableItem.visibility = View.VISIBLE
                }
                view.invalidate()
                true
            }
            else -> {
                false
            }

        }
    }

    private val tile12DragListener = View.OnDragListener { view, dragEvent ->

        val draggableItem = dragEvent.localState as View

        when (dragEvent.action) {
            DragEvent.ACTION_DRAG_STARTED -> {
                true
            }
            DragEvent.ACTION_DRAG_ENTERED -> {
                // dims the view when the mask has entered the drop area
                binding.tile12.alpha = 0.5f
                true
            }
            DragEvent.ACTION_DRAG_LOCATION -> {
                true
            }
            DragEvent.ACTION_DRAG_EXITED -> {
                // reset opacity if the mask exits drop area without drop action
                binding.tile12.alpha = 1.0f
                //when mask exits drop-area without dropping set mask visibility to VISIBLE
                //draggableItem.visibility = View.VISIBLE
                view.invalidate()
                true
            }
            DragEvent.ACTION_DROP -> {
                dragEventDrop(draggableItem, view, tile12, 12)
                binding.tile12.alpha = 1.0f
                true
            }
            DragEvent.ACTION_DRAG_ENDED -> {
                if (!checkIfTilesZero(draggableItem)) {
                    draggableItem.visibility = View.VISIBLE
                }
                view.invalidate()
                true
            }
            else -> {
                false
            }

        }
    }

    private val tile13DragListener = View.OnDragListener { view, dragEvent ->

        val draggableItem = dragEvent.localState as View

        when (dragEvent.action) {
            DragEvent.ACTION_DRAG_STARTED -> {
                true
            }
            DragEvent.ACTION_DRAG_ENTERED -> {
                // dims the view when the mask has entered the drop area
                binding.tile13.alpha = 0.5f
                true
            }
            DragEvent.ACTION_DRAG_LOCATION -> {
                true
            }
            DragEvent.ACTION_DRAG_EXITED -> {
                // reset opacity if the mask exits drop area without drop action
                binding.tile13.alpha = 1.0f
                //when mask exits drop-area without dropping set mask visibility to VISIBLE
                //draggableItem.visibility = View.VISIBLE
                view.invalidate()
                true
            }
            DragEvent.ACTION_DROP -> {
                dragEventDrop(draggableItem, view, tile13, 13)
                binding.tile13.alpha = 1.0f
                true
            }
            DragEvent.ACTION_DRAG_ENDED -> {
                if (!checkIfTilesZero(draggableItem)) {
                    draggableItem.visibility = View.VISIBLE
                }
                view.invalidate()
                true
            }
            else -> {
                false
            }

        }
    }

    private val tile14DragListener = View.OnDragListener { view, dragEvent ->

        val draggableItem = dragEvent.localState as View

        when (dragEvent.action) {
            DragEvent.ACTION_DRAG_STARTED -> {
                true
            }
            DragEvent.ACTION_DRAG_ENTERED -> {
                // dims the view when the mask has entered the drop area
                binding.tile14.alpha = 0.5f
                true
            }
            DragEvent.ACTION_DRAG_LOCATION -> {
                true
            }
            DragEvent.ACTION_DRAG_EXITED -> {
                // reset opacity if the mask exits drop area without drop action
                binding.tile14.alpha = 1.0f
                //when mask exits drop-area without dropping set mask visibility to VISIBLE
                //draggableItem.visibility = View.VISIBLE
                view.invalidate()
                true
            }
            DragEvent.ACTION_DROP -> {
                dragEventDrop(draggableItem, view, tile14, 14)
                binding.tile14.alpha = 1.0f
                true
            }
            DragEvent.ACTION_DRAG_ENDED -> {
                if (!checkIfTilesZero(draggableItem)) {
                    draggableItem.visibility = View.VISIBLE
                }
                view.invalidate()
                true
            }
            else -> {
                false
            }
        }
    }

    private val tile15DragListener = View.OnDragListener { view, dragEvent ->

        val draggableItem = dragEvent.localState as View

        when (dragEvent.action) {
            DragEvent.ACTION_DRAG_STARTED -> {
                true
            }
            DragEvent.ACTION_DRAG_ENTERED -> {
                // dims the view when the mask has entered the drop area
                binding.tile15.alpha = 0.5f
                true
            }
            DragEvent.ACTION_DRAG_LOCATION -> {
                true
            }
            DragEvent.ACTION_DRAG_EXITED -> {
                // reset opacity if the mask exits drop area without drop action
                binding.tile15.alpha = 1.0f
                //when mask exits drop-area without dropping set mask visibility to VISIBLE
                //draggableItem.visibility = View.VISIBLE
                view.invalidate()
                true
            }
            DragEvent.ACTION_DROP -> {
                dragEventDrop(draggableItem, view, tile15, 15)
                binding.tile15.alpha = 1.0f
                true
            }
            DragEvent.ACTION_DRAG_ENDED -> {
                if (!checkIfTilesZero(draggableItem)) {
                    draggableItem.visibility = View.VISIBLE
                }
                view.invalidate()
                true
            }
            else -> {
                false
            }

        }
    }

    private val tile16DragListener = View.OnDragListener { view, dragEvent ->

        val draggableItem = dragEvent.localState as View

        when (dragEvent.action) {
            DragEvent.ACTION_DRAG_STARTED -> {
                true
            }
            DragEvent.ACTION_DRAG_ENTERED -> {
                // dims the view when the mask has entered the drop area
                binding.tile16.alpha = 0.5f
                true
            }
            DragEvent.ACTION_DRAG_LOCATION -> {
                true
            }
            DragEvent.ACTION_DRAG_EXITED -> {
                // reset opacity if the mask exits drop area without drop action
                binding.tile16.alpha = 1.0f
                //when mask exits drop-area without dropping set mask visibility to VISIBLE
                //draggableItem.visibility = View.VISIBLE
                view.invalidate()
                true
            }
            DragEvent.ACTION_DROP -> {
                dragEventDrop(draggableItem, view, tile16, 16)
                binding.tile16.alpha = 1.0f
                true
            }
            DragEvent.ACTION_DRAG_ENDED -> {
                if (!checkIfTilesZero(draggableItem)) {
                    draggableItem.visibility = View.VISIBLE
                }
                view.invalidate()
                true
            }
            else -> {
                false
            }

        }
    }

    private val tile17DragListener = View.OnDragListener { view, dragEvent ->

        val draggableItem = dragEvent.localState as View

        when (dragEvent.action) {
            DragEvent.ACTION_DRAG_STARTED -> {
                true
            }
            DragEvent.ACTION_DRAG_ENTERED -> {
                // dims the view when the mask has entered the drop area
                binding.tile17.alpha = 0.5f
                true
            }
            DragEvent.ACTION_DRAG_LOCATION -> {
                true
            }
            DragEvent.ACTION_DRAG_EXITED -> {
                // reset opacity if the mask exits drop area without drop action
                binding.tile17.alpha = 1.0f
                //when mask exits drop-area without dropping set mask visibility to VISIBLE
                //draggableItem.visibility = View.VISIBLE
                view.invalidate()
                true
            }
            DragEvent.ACTION_DROP -> {
                dragEventDrop(draggableItem, view, tile17, 17)
                binding.tile17.alpha = 1.0f
                true
            }
            DragEvent.ACTION_DRAG_ENDED -> {
                if (!checkIfTilesZero(draggableItem)) {
                    draggableItem.visibility = View.VISIBLE
                }
                view.invalidate()
                true
            }
            else -> {
                false
            }

        }
    }

    private val tile18DragListener = View.OnDragListener { view, dragEvent ->

        val draggableItem = dragEvent.localState as View

        when (dragEvent.action) {
            DragEvent.ACTION_DRAG_STARTED -> {
                true
            }
            DragEvent.ACTION_DRAG_ENTERED -> {
                // dims the view when the mask has entered the drop area
                binding.tile18.alpha = 0.5f
                true
            }
            DragEvent.ACTION_DRAG_LOCATION -> {
                true
            }
            DragEvent.ACTION_DRAG_EXITED -> {
                // reset opacity if the mask exits drop area without drop action
                binding.tile18.alpha = 1.0f
                //when mask exits drop-area without dropping set mask visibility to VISIBLE
                //draggableItem.visibility = View.VISIBLE
                view.invalidate()
                true
            }
            DragEvent.ACTION_DROP -> {
                dragEventDrop(draggableItem, view, tile18, 18)
                binding.tile18.alpha = 1.0f
                true
            }
            DragEvent.ACTION_DRAG_ENDED -> {
                if (!checkIfTilesZero(draggableItem)) {
                    draggableItem.visibility = View.VISIBLE
                }
                view.invalidate()
                true
            }
            else -> {
                false
            }

        }
    }

    private val tile19DragListener = View.OnDragListener { view, dragEvent ->

        val draggableItem = dragEvent.localState as View

        when (dragEvent.action) {
            DragEvent.ACTION_DRAG_STARTED -> {
                true
            }
            DragEvent.ACTION_DRAG_ENTERED -> {
                // dims the view when the mask has entered the drop area
                binding.tile19.alpha = 0.5f
                true
            }
            DragEvent.ACTION_DRAG_LOCATION -> {
                true
            }
            DragEvent.ACTION_DRAG_EXITED -> {
                // reset opacity if the mask exits drop area without drop action
                binding.tile19.alpha = 1.0f
                //when mask exits drop-area without dropping set mask visibility to VISIBLE
                //draggableItem.visibility = View.VISIBLE
                view.invalidate()
                true
            }
            DragEvent.ACTION_DROP -> {
                dragEventDrop(draggableItem, view, tile19, 19)
                binding.tile19.alpha = 1.0f
                true
            }
            DragEvent.ACTION_DRAG_ENDED -> {
                if (!checkIfTilesZero(draggableItem)) {
                    draggableItem.visibility = View.VISIBLE
                }
                view.invalidate()
                true
            }
            else -> {
                false
            }

        }
    }

    /**
     * Method checks whether the mask is dropped on the face and
     * displays an appropriate Toast message
     *
     * @param dragEvent DragEvent
     */

    /**
     * Method enables drag feature on the draggable view
     */

    private fun attachViewDragListener() {

        binding.brick1.setOnLongClickListener { view: View ->

            // Create a new ClipData.Item with custom text data
            val item = ClipData.Item(maskDragMessage)

            // Create a new ClipData using a predefined label, the plain text MIME type, and
            // the already-created item. This will create a new ClipDescription object within the
            // ClipData, and set its MIME type entry to "text/plain"
            val dataToDrag = ClipData(
                maskDragMessage,
                arrayOf(ClipDescription.MIMETYPE_TEXT_PLAIN),
                item
            )



            // Instantiates the drag shadow builder.
            val maskShadow = MaskDragShadowBuilder(view)

            // Starts the drag
            if (Build.VERSION.SDK_INT < Build.VERSION_CODES.N) {
                //support pre-Nougat versions
                @Suppress("DEPRECATION")
                view.startDrag(dataToDrag, maskShadow, view, 0)
            } else {
                //supports Nougat and beyond
                view.startDragAndDrop(dataToDrag, maskShadow, view, 0)
            }

            view.visibility = View.INVISIBLE

            true
        }

        binding.lumber1.setOnLongClickListener { view: View ->

            // Create a new ClipData.Item with custom text data
            val item = ClipData.Item(maskDragMessage)

            // Create a new ClipData using a predefined label, the plain text MIME type, and
            // the already-created item. This will create a new ClipDescription object within the
            // ClipData, and set its MIME type entry to "text/plain"
            val dataToDrag = ClipData(
                maskDragMessage,
                arrayOf(ClipDescription.MIMETYPE_TEXT_PLAIN),
                item
            )

            // Instantiates the drag shadow builder.
            val maskShadow = MaskDragShadowBuilder(view)

            // Starts the drag
            if (Build.VERSION.SDK_INT < Build.VERSION_CODES.N) {
                //support pre-Nougat versions
                @Suppress("DEPRECATION")
                view.startDrag(dataToDrag, maskShadow, view, 0)
            } else {
                //supports Nougat and beyond
                view.startDragAndDrop(dataToDrag, maskShadow, view, 0)
            }

            view.visibility = View.INVISIBLE

            true
        }

        binding.wool1.setOnLongClickListener { view: View ->

            // Create a new ClipData.Item with custom text data
            val item = ClipData.Item(maskDragMessage)

            // Create a new ClipData using a predefined label, the plain text MIME type, and
            // the already-created item. This will create a new ClipDescription object within the
            // ClipData, and set its MIME type entry to "text/plain"
            val dataToDrag = ClipData(
                maskDragMessage,
                arrayOf(ClipDescription.MIMETYPE_TEXT_PLAIN),
                item
            )

            // Instantiates the drag shadow builder.
            val maskShadow = MaskDragShadowBuilder(view)

            // Starts the drag
            if (Build.VERSION.SDK_INT < Build.VERSION_CODES.N) {
                //support pre-Nougat versions
                @Suppress("DEPRECATION")
                view.startDrag(dataToDrag, maskShadow, view, 0)
            } else {
                //supports Nougat and beyond
                view.startDragAndDrop(dataToDrag, maskShadow, view, 0)
            }

            view.visibility = View.INVISIBLE

            true
        }

        binding.grain1.setOnLongClickListener { view: View ->

            // Create a new ClipData.Item with custom text data
            val item = ClipData.Item(maskDragMessage)

            // Create a new ClipData using a predefined label, the plain text MIME type, and
            // the already-created item. This will create a new ClipDescription object within the
            // ClipData, and set its MIME type entry to "text/plain"
            val dataToDrag = ClipData(
                maskDragMessage,
                arrayOf(ClipDescription.MIMETYPE_TEXT_PLAIN),
                item
            )

            // Instantiates the drag shadow builder.
            val maskShadow = MaskDragShadowBuilder(view)

            // Starts the drag
            if (Build.VERSION.SDK_INT < Build.VERSION_CODES.N) {
                //support pre-Nougat versions
                @Suppress("DEPRECATION")
                view.startDrag(dataToDrag, maskShadow, view, 0)
            } else {
                //supports Nougat and beyond
                view.startDragAndDrop(dataToDrag, maskShadow, view, 0)
            }

            view.visibility = View.INVISIBLE

            true
        }

        binding.ore1.setOnLongClickListener { view: View ->

            // Create a new ClipData.Item with custom text data
            val item = ClipData.Item(maskDragMessage)

            // Create a new ClipData using a predefined label, the plain text MIME type, and
            // the already-created item. This will create a new ClipDescription object within the
            // ClipData, and set its MIME type entry to "text/plain"
            val dataToDrag = ClipData(
                maskDragMessage,
                arrayOf(ClipDescription.MIMETYPE_TEXT_PLAIN),
                item
            )

            // Instantiates the drag shadow builder.
            val maskShadow = MaskDragShadowBuilder(view)

            // Starts the drag
            if (Build.VERSION.SDK_INT < Build.VERSION_CODES.N) {
                //support pre-Nougat versions
                @Suppress("DEPRECATION")
                view.startDrag(dataToDrag, maskShadow, view, 0)
            } else {
                //supports Nougat and beyond
                view.startDragAndDrop(dataToDrag, maskShadow, view, 0)
            }

            view.visibility = View.INVISIBLE

            true
        }

        binding.desert.setOnLongClickListener { view: View ->

            // Create a new ClipData.Item with custom text data
            val item = ClipData.Item(maskDragMessage)

            // Create a new ClipData using a predefined label, the plain text MIME type, and
            // the already-created item. This will create a new ClipDescription object within the
            // ClipData, and set its MIME type entry to "text/plain"
            val dataToDrag = ClipData(
                maskDragMessage,
                arrayOf(ClipDescription.MIMETYPE_TEXT_PLAIN),
                item
            )

            // Instantiates the drag shadow builder.
            val maskShadow = MaskDragShadowBuilder(view)

            // Starts the drag
            if (Build.VERSION.SDK_INT < Build.VERSION_CODES.N) {
                //support pre-Nougat versions
                @Suppress("DEPRECATION")
                view.startDrag(dataToDrag, maskShadow, view, 0)
            } else {
                //supports Nougat and beyond
                view.startDragAndDrop(dataToDrag, maskShadow, view, 0)
            }

            view.visibility = View.INVISIBLE
            true
        }

        binding.tile1.setOnLongClickListener { view: View ->

            // Create a new ClipData.Item with custom text data
            val item = ClipData.Item(maskDragMessage)

            // Create a new ClipData using a predefined label, the plain text MIME type, and
            // the already-created item. This will create a new ClipDescription object within the
            // ClipData, and set its MIME type entry to "text/plain"
            val dataToDrag = ClipData(
                maskDragMessage,
                arrayOf(ClipDescription.MIMETYPE_TEXT_PLAIN),
                item
            )

            if (!isTileEmpty(view as ImageView)) {
                // Instantiates the drag shadow builder.
                val maskShadow = MaskDragShadowBuilder(view)

                // Starts the drag
                if (Build.VERSION.SDK_INT < Build.VERSION_CODES.N) {
                    //support pre-Nougat versions
                    @Suppress("DEPRECATION")
                    view.startDrag(dataToDrag, maskShadow, view, 0)
                } else {
                    //supports Nougat and beyond
                    view.startDragAndDrop(dataToDrag, maskShadow, view, 0)
                }

                view.visibility = View.INVISIBLE
            }

            true
        }

        binding.tile2.setOnLongClickListener { view: View ->

            // Create a new ClipData.Item with custom text data
            val item = ClipData.Item(maskDragMessage)

            // Create a new ClipData using a predefined label, the plain text MIME type, and
            // the already-created item. This will create a new ClipDescription object within the
            // ClipData, and set its MIME type entry to "text/plain"
            val dataToDrag = ClipData(
                maskDragMessage,
                arrayOf(ClipDescription.MIMETYPE_TEXT_PLAIN),
                item
            )

            if (!isTileEmpty(view as ImageView)) {
                // Instantiates the drag shadow builder.
                val maskShadow = MaskDragShadowBuilder(view)

                // Starts the drag
                if (Build.VERSION.SDK_INT < Build.VERSION_CODES.N) {
                    //support pre-Nougat versions
                    @Suppress("DEPRECATION")
                    view.startDrag(dataToDrag, maskShadow, view, 0)
                } else {
                    //supports Nougat and beyond
                    view.startDragAndDrop(dataToDrag, maskShadow, view, 0)
                }

                view.visibility = View.INVISIBLE
            }

            true
        }

        binding.tile3.setOnLongClickListener { view: View ->

            // Create a new ClipData.Item with custom text data
            val item = ClipData.Item(maskDragMessage)

            // Create a new ClipData using a predefined label, the plain text MIME type, and
            // the already-created item. This will create a new ClipDescription object within the
            // ClipData, and set its MIME type entry to "text/plain"
            val dataToDrag = ClipData(
                maskDragMessage,
                arrayOf(ClipDescription.MIMETYPE_TEXT_PLAIN),
                item
            )

            if (!isTileEmpty(view as ImageView)) {
                // Instantiates the drag shadow builder.
                val maskShadow = MaskDragShadowBuilder(view)

                // Starts the drag
                if (Build.VERSION.SDK_INT < Build.VERSION_CODES.N) {
                    //support pre-Nougat versions
                    @Suppress("DEPRECATION")
                    view.startDrag(dataToDrag, maskShadow, view, 0)
                } else {
                    //supports Nougat and beyond
                    view.startDragAndDrop(dataToDrag, maskShadow, view, 0)
                }

                view.visibility = View.INVISIBLE
            }

            true
        }

        binding.tile4.setOnLongClickListener { view: View ->

            // Create a new ClipData.Item with custom text data
            val item = ClipData.Item(maskDragMessage)

            // Create a new ClipData using a predefined label, the plain text MIME type, and
            // the already-created item. This will create a new ClipDescription object within the
            // ClipData, and set its MIME type entry to "text/plain"
            val dataToDrag = ClipData(
                maskDragMessage,
                arrayOf(ClipDescription.MIMETYPE_TEXT_PLAIN),
                item
            )

            if (!isTileEmpty(view as ImageView)) {
                // Instantiates the drag shadow builder.
                val maskShadow = MaskDragShadowBuilder(view)

                // Starts the drag
                if (Build.VERSION.SDK_INT < Build.VERSION_CODES.N) {
                    //support pre-Nougat versions
                    @Suppress("DEPRECATION")
                    view.startDrag(dataToDrag, maskShadow, view, 0)
                } else {
                    //supports Nougat and beyond
                    view.startDragAndDrop(dataToDrag, maskShadow, view, 0)
                }

                view.visibility = View.INVISIBLE
            }

            true
        }

        binding.tile5.setOnLongClickListener { view: View ->

            // Create a new ClipData.Item with custom text data
            val item = ClipData.Item(maskDragMessage)

            // Create a new ClipData using a predefined label, the plain text MIME type, and
            // the already-created item. This will create a new ClipDescription object within the
            // ClipData, and set its MIME type entry to "text/plain"
            val dataToDrag = ClipData(
                maskDragMessage,
                arrayOf(ClipDescription.MIMETYPE_TEXT_PLAIN),
                item
            )

            if (!isTileEmpty(view as ImageView)) {
                // Instantiates the drag shadow builder.
                val maskShadow = MaskDragShadowBuilder(view)

                // Starts the drag
                if (Build.VERSION.SDK_INT < Build.VERSION_CODES.N) {
                    //support pre-Nougat versions
                    @Suppress("DEPRECATION")
                    view.startDrag(dataToDrag, maskShadow, view, 0)
                } else {
                    //supports Nougat and beyond
                    view.startDragAndDrop(dataToDrag, maskShadow, view, 0)
                }

                view.visibility = View.INVISIBLE
            }

            true
        }

        binding.tile6.setOnLongClickListener { view: View ->

            // Create a new ClipData.Item with custom text data
            val item = ClipData.Item(maskDragMessage)

            // Create a new ClipData using a predefined label, the plain text MIME type, and
            // the already-created item. This will create a new ClipDescription object within the
            // ClipData, and set its MIME type entry to "text/plain"
            val dataToDrag = ClipData(
                maskDragMessage,
                arrayOf(ClipDescription.MIMETYPE_TEXT_PLAIN),
                item
            )

            if (!isTileEmpty(view as ImageView)) {
                // Instantiates the drag shadow builder.
                val maskShadow = MaskDragShadowBuilder(view)

                // Starts the drag
                if (Build.VERSION.SDK_INT < Build.VERSION_CODES.N) {
                    //support pre-Nougat versions
                    @Suppress("DEPRECATION")
                    view.startDrag(dataToDrag, maskShadow, view, 0)
                } else {
                    //supports Nougat and beyond
                    view.startDragAndDrop(dataToDrag, maskShadow, view, 0)
                }

                view.visibility = View.INVISIBLE
            }

            true
        }

        binding.tile7.setOnLongClickListener { view: View ->

            // Create a new ClipData.Item with custom text data
            val item = ClipData.Item(maskDragMessage)

            // Create a new ClipData using a predefined label, the plain text MIME type, and
            // the already-created item. This will create a new ClipDescription object within the
            // ClipData, and set its MIME type entry to "text/plain"
            val dataToDrag = ClipData(
                maskDragMessage,
                arrayOf(ClipDescription.MIMETYPE_TEXT_PLAIN),
                item
            )

            if (!isTileEmpty(view as ImageView)) {
                // Instantiates the drag shadow builder.
                val maskShadow = MaskDragShadowBuilder(view)

                // Starts the drag
                if (Build.VERSION.SDK_INT < Build.VERSION_CODES.N) {
                    //support pre-Nougat versions
                    @Suppress("DEPRECATION")
                    view.startDrag(dataToDrag, maskShadow, view, 0)
                } else {
                    //supports Nougat and beyond
                    view.startDragAndDrop(dataToDrag, maskShadow, view, 0)
                }

                view.visibility = View.INVISIBLE
            }

            true
        }

        binding.tile8.setOnLongClickListener { view: View ->

            // Create a new ClipData.Item with custom text data
            val item = ClipData.Item(maskDragMessage)

            // Create a new ClipData using a predefined label, the plain text MIME type, and
            // the already-created item. This will create a new ClipDescription object within the
            // ClipData, and set its MIME type entry to "text/plain"
            val dataToDrag = ClipData(
                maskDragMessage,
                arrayOf(ClipDescription.MIMETYPE_TEXT_PLAIN),
                item
            )

            if (!isTileEmpty(view as ImageView)) {
                // Instantiates the drag shadow builder.
                val maskShadow = MaskDragShadowBuilder(view)

                // Starts the drag
                if (Build.VERSION.SDK_INT < Build.VERSION_CODES.N) {
                    //support pre-Nougat versions
                    @Suppress("DEPRECATION")
                    view.startDrag(dataToDrag, maskShadow, view, 0)
                } else {
                    //supports Nougat and beyond
                    view.startDragAndDrop(dataToDrag, maskShadow, view, 0)
                }

                view.visibility = View.INVISIBLE
            }

            true
        }

        binding.tile9.setOnLongClickListener { view: View ->

            // Create a new ClipData.Item with custom text data
            val item = ClipData.Item(maskDragMessage)

            // Create a new ClipData using a predefined label, the plain text MIME type, and
            // the already-created item. This will create a new ClipDescription object within the
            // ClipData, and set its MIME type entry to "text/plain"
            val dataToDrag = ClipData(
                maskDragMessage,
                arrayOf(ClipDescription.MIMETYPE_TEXT_PLAIN),
                item
            )

            if (!isTileEmpty(view as ImageView)) {
                // Instantiates the drag shadow builder.
                val maskShadow = MaskDragShadowBuilder(view)

                // Starts the drag
                if (Build.VERSION.SDK_INT < Build.VERSION_CODES.N) {
                    //support pre-Nougat versions
                    @Suppress("DEPRECATION")
                    view.startDrag(dataToDrag, maskShadow, view, 0)
                } else {
                    //supports Nougat and beyond
                    view.startDragAndDrop(dataToDrag, maskShadow, view, 0)
                }

                view.visibility = View.INVISIBLE
            }

            true
        }

        binding.tile10.setOnLongClickListener { view: View ->

            // Create a new ClipData.Item with custom text data
            val item = ClipData.Item(maskDragMessage)

            // Create a new ClipData using a predefined label, the plain text MIME type, and
            // the already-created item. This will create a new ClipDescription object within the
            // ClipData, and set its MIME type entry to "text/plain"
            val dataToDrag = ClipData(
                maskDragMessage,
                arrayOf(ClipDescription.MIMETYPE_TEXT_PLAIN),
                item
            )

            if (!isTileEmpty(view as ImageView)) {
                // Instantiates the drag shadow builder.
                val maskShadow = MaskDragShadowBuilder(view)

                // Starts the drag
                if (Build.VERSION.SDK_INT < Build.VERSION_CODES.N) {
                    //support pre-Nougat versions
                    @Suppress("DEPRECATION")
                    view.startDrag(dataToDrag, maskShadow, view, 0)
                } else {
                    //supports Nougat and beyond
                    view.startDragAndDrop(dataToDrag, maskShadow, view, 0)
                }

                view.visibility = View.INVISIBLE
            }

            true
        }

        binding.tile11.setOnLongClickListener { view: View ->

            // Create a new ClipData.Item with custom text data
            val item = ClipData.Item(maskDragMessage)

            // Create a new ClipData using a predefined label, the plain text MIME type, and
            // the already-created item. This will create a new ClipDescription object within the
            // ClipData, and set its MIME type entry to "text/plain"
            val dataToDrag = ClipData(
                maskDragMessage,
                arrayOf(ClipDescription.MIMETYPE_TEXT_PLAIN),
                item
            )

            if (!isTileEmpty(view as ImageView)) {
                // Instantiates the drag shadow builder.
                val maskShadow = MaskDragShadowBuilder(view)

                // Starts the drag
                if (Build.VERSION.SDK_INT < Build.VERSION_CODES.N) {
                    //support pre-Nougat versions
                    @Suppress("DEPRECATION")
                    view.startDrag(dataToDrag, maskShadow, view, 0)
                } else {
                    //supports Nougat and beyond
                    view.startDragAndDrop(dataToDrag, maskShadow, view, 0)
                }

                view.visibility = View.INVISIBLE
            }

            true
        }

        binding.tile12.setOnLongClickListener { view: View ->

            // Create a new ClipData.Item with custom text data
            val item = ClipData.Item(maskDragMessage)

            // Create a new ClipData using a predefined label, the plain text MIME type, and
            // the already-created item. This will create a new ClipDescription object within the
            // ClipData, and set its MIME type entry to "text/plain"
            val dataToDrag = ClipData(
                maskDragMessage,
                arrayOf(ClipDescription.MIMETYPE_TEXT_PLAIN),
                item
            )

            if (!isTileEmpty(view as ImageView)) {
                // Instantiates the drag shadow builder.
                val maskShadow = MaskDragShadowBuilder(view)

                // Starts the drag
                if (Build.VERSION.SDK_INT < Build.VERSION_CODES.N) {
                    //support pre-Nougat versions
                    @Suppress("DEPRECATION")
                    view.startDrag(dataToDrag, maskShadow, view, 0)
                } else {
                    //supports Nougat and beyond
                    view.startDragAndDrop(dataToDrag, maskShadow, view, 0)
                }

                view.visibility = View.INVISIBLE
            }

            true
        }

        binding.tile13.setOnLongClickListener { view: View ->

            // Create a new ClipData.Item with custom text data
            val item = ClipData.Item(maskDragMessage)

            // Create a new ClipData using a predefined label, the plain text MIME type, and
            // the already-created item. This will create a new ClipDescription object within the
            // ClipData, and set its MIME type entry to "text/plain"
            val dataToDrag = ClipData(
                maskDragMessage,
                arrayOf(ClipDescription.MIMETYPE_TEXT_PLAIN),
                item
            )

            if (!isTileEmpty(view as ImageView)) {
                // Instantiates the drag shadow builder.
                val maskShadow = MaskDragShadowBuilder(view)

                // Starts the drag
                if (Build.VERSION.SDK_INT < Build.VERSION_CODES.N) {
                    //support pre-Nougat versions
                    @Suppress("DEPRECATION")
                    view.startDrag(dataToDrag, maskShadow, view, 0)
                } else {
                    //supports Nougat and beyond
                    view.startDragAndDrop(dataToDrag, maskShadow, view, 0)
                }

                view.visibility = View.INVISIBLE
            }

            true
        }

        binding.tile14.setOnLongClickListener { view: View ->

            // Create a new ClipData.Item with custom text data
            val item = ClipData.Item(maskDragMessage)

            // Create a new ClipData using a predefined label, the plain text MIME type, and
            // the already-created item. This will create a new ClipDescription object within the
            // ClipData, and set its MIME type entry to "text/plain"
            val dataToDrag = ClipData(
                maskDragMessage,
                arrayOf(ClipDescription.MIMETYPE_TEXT_PLAIN),
                item
            )

            if (!isTileEmpty(view as ImageView)) {
                // Instantiates the drag shadow builder.
                val maskShadow = MaskDragShadowBuilder(view)

                // Starts the drag
                if (Build.VERSION.SDK_INT < Build.VERSION_CODES.N) {
                    //support pre-Nougat versions
                    @Suppress("DEPRECATION")
                    view.startDrag(dataToDrag, maskShadow, view, 0)
                } else {
                    //supports Nougat and beyond
                    view.startDragAndDrop(dataToDrag, maskShadow, view, 0)
                }

                view.visibility = View.INVISIBLE
            }

            true
        }

        binding.tile15.setOnLongClickListener { view: View ->

            // Create a new ClipData.Item with custom text data
            val item = ClipData.Item(maskDragMessage)

            // Create a new ClipData using a predefined label, the plain text MIME type, and
            // the already-created item. This will create a new ClipDescription object within the
            // ClipData, and set its MIME type entry to "text/plain"
            val dataToDrag = ClipData(
                maskDragMessage,
                arrayOf(ClipDescription.MIMETYPE_TEXT_PLAIN),
                item
            )

            if (!isTileEmpty(view as ImageView)) {
                // Instantiates the drag shadow builder.
                val maskShadow = MaskDragShadowBuilder(view)

                // Starts the drag
                if (Build.VERSION.SDK_INT < Build.VERSION_CODES.N) {
                    //support pre-Nougat versions
                    @Suppress("DEPRECATION")
                    view.startDrag(dataToDrag, maskShadow, view, 0)
                } else {
                    //supports Nougat and beyond
                    view.startDragAndDrop(dataToDrag, maskShadow, view, 0)
                }

                view.visibility = View.INVISIBLE
            }

            true
        }

        binding.tile16.setOnLongClickListener { view: View ->

            // Create a new ClipData.Item with custom text data
            val item = ClipData.Item(maskDragMessage)

            // Create a new ClipData using a predefined label, the plain text MIME type, and
            // the already-created item. This will create a new ClipDescription object within the
            // ClipData, and set its MIME type entry to "text/plain"
            val dataToDrag = ClipData(
                maskDragMessage,
                arrayOf(ClipDescription.MIMETYPE_TEXT_PLAIN),
                item
            )

            if (!isTileEmpty(view as ImageView)) {
                // Instantiates the drag shadow builder.
                val maskShadow = MaskDragShadowBuilder(view)

                // Starts the drag
                if (Build.VERSION.SDK_INT < Build.VERSION_CODES.N) {
                    //support pre-Nougat versions
                    @Suppress("DEPRECATION")
                    view.startDrag(dataToDrag, maskShadow, view, 0)
                } else {
                    //supports Nougat and beyond
                    view.startDragAndDrop(dataToDrag, maskShadow, view, 0)
                }

                view.visibility = View.INVISIBLE
            }

            true
        }

        binding.tile17.setOnLongClickListener { view: View ->

            // Create a new ClipData.Item with custom text data
            val item = ClipData.Item(maskDragMessage)

            // Create a new ClipData using a predefined label, the plain text MIME type, and
            // the already-created item. This will create a new ClipDescription object within the
            // ClipData, and set its MIME type entry to "text/plain"
            val dataToDrag = ClipData(
                maskDragMessage,
                arrayOf(ClipDescription.MIMETYPE_TEXT_PLAIN),
                item
            )

            if (!isTileEmpty(view as ImageView)) {
                // Instantiates the drag shadow builder.
                val maskShadow = MaskDragShadowBuilder(view)

                // Starts the drag
                if (Build.VERSION.SDK_INT < Build.VERSION_CODES.N) {
                    //support pre-Nougat versions
                    @Suppress("DEPRECATION")
                    view.startDrag(dataToDrag, maskShadow, view, 0)
                } else {
                    //supports Nougat and beyond
                    view.startDragAndDrop(dataToDrag, maskShadow, view, 0)
                }

                view.visibility = View.INVISIBLE
            }

            true
        }

        binding.tile18.setOnLongClickListener { view: View ->

            // Create a new ClipData.Item with custom text data
            val item = ClipData.Item(maskDragMessage)

            // Create a new ClipData using a predefined label, the plain text MIME type, and
            // the already-created item. This will create a new ClipDescription object within the
            // ClipData, and set its MIME type entry to "text/plain"
            val dataToDrag = ClipData(
                maskDragMessage,
                arrayOf(ClipDescription.MIMETYPE_TEXT_PLAIN),
                item
            )

            if (!isTileEmpty(view as ImageView)) {
                // Instantiates the drag shadow builder.
                val maskShadow = MaskDragShadowBuilder(view)

                // Starts the drag
                if (Build.VERSION.SDK_INT < Build.VERSION_CODES.N) {
                    //support pre-Nougat versions
                    @Suppress("DEPRECATION")
                    view.startDrag(dataToDrag, maskShadow, view, 0)
                } else {
                    //supports Nougat and beyond
                    view.startDragAndDrop(dataToDrag, maskShadow, view, 0)
                }

                view.visibility = View.INVISIBLE
            }

            true
        }

        binding.tile19.setOnLongClickListener { view: View ->

            // Create a new ClipData.Item with custom text data
            val item = ClipData.Item(maskDragMessage)

            // Create a new ClipData using a predefined label, the plain text MIME type, and
            // the already-created item. This will create a new ClipDescription object within the
            // ClipData, and set its MIME type entry to "text/plain"
            val dataToDrag = ClipData(
                maskDragMessage,
                arrayOf(ClipDescription.MIMETYPE_TEXT_PLAIN),
                item
            )

            if (!isTileEmpty(view as ImageView)) {
                // Instantiates the drag shadow builder.
                val maskShadow = MaskDragShadowBuilder(view)

                // Starts the drag
                if (Build.VERSION.SDK_INT < Build.VERSION_CODES.N) {
                    //support pre-Nougat versions
                    @Suppress("DEPRECATION")
                    view.startDrag(dataToDrag, maskShadow, view, 0)
                } else {
                    //supports Nougat and beyond
                    view.startDragAndDrop(dataToDrag, maskShadow, view, 0)
                }

                view.visibility = View.INVISIBLE
            }

            true

        }
    }

    private fun dragListenerTile(tile: ImageView) {
        tile.setOnLongClickListener { view: View ->

            // Create a new ClipData.Item with custom text data
            val item = ClipData.Item(maskDragMessage)

            // Create a new ClipData using a predefined label, the plain text MIME type, and
            // the already-created item. This will create a new ClipDescription object within the
            // ClipData, and set its MIME type entry to "text/plain"
            val dataToDrag = ClipData(
                maskDragMessage,
                arrayOf(ClipDescription.MIMETYPE_TEXT_PLAIN),
                item
            )

            if (!isTileEmpty(view as ImageView)) {
                // Instantiates the drag shadow builder.
                val maskShadow = MaskDragShadowBuilder(view)

                // Starts the drag
                if (Build.VERSION.SDK_INT < Build.VERSION_CODES.N) {
                    //support pre-Nougat versions
                    @Suppress("DEPRECATION")
                    view.startDrag(dataToDrag, maskShadow, view, 0)
                } else {
                    //supports Nougat and beyond
                    view.startDragAndDrop(dataToDrag, maskShadow, view, 0)
                }

                view.visibility = View.INVISIBLE
            }

            true
        }
    }
}

/**
 * Drag shadow builder builds a shadow for the mask when drag is ongoing
 *
 * @param view View for which drag shadow has to be displayed
 */

class MaskDragShadowBuilder(view: View) : View.DragShadowBuilder(view) {

    //set shadow to be the actual mask
    private var resource = view.contentDescription

    // Defines a callback that sends the drag shadow dimensions and touch point back to the
    // system.

    private var shadow: Drawable? = ResourcesCompat.getDrawable(view.context.resources, R.drawable.brick2, view.context.theme)

    override fun onProvideShadowMetrics(size: Point, touch: Point) {

        //var shadow: Drawable? = ResourcesCompat.getDrawable(view.context.resources, R.drawable.brick2, view.context.theme)

        if (resource[0] == 't') {
            val index = resource.indexOf('_')
            resource = resource.substring(index + 1, resource.length)
        }
        when (resource) {
            "brick" -> { shadow = ResourcesCompat.getDrawable(view.context.resources,
                R.drawable.brick2, view.context.theme)
                Toast.makeText(view.context, "brick", Toast.LENGTH_SHORT).show()
            }
            "lumber" -> { shadow = ResourcesCompat.getDrawable(view.context.resources,
                R.drawable.lumber2, view.context.theme)
                Toast.makeText(view.context, "lumber", Toast.LENGTH_SHORT).show()
            }
            "wool" -> { shadow = ResourcesCompat.getDrawable(view.context.resources,
                R.drawable.wool2, view.context.theme)
                Toast.makeText(view.context, "wool", Toast.LENGTH_SHORT).show()
            }
            "grain" -> { shadow = ResourcesCompat.getDrawable(view.context.resources,
                R.drawable.grain2, view.context.theme)
                Toast.makeText(view.context, "grain", Toast.LENGTH_SHORT).show()
            }
            "ore" -> { shadow = ResourcesCompat.getDrawable(view.context.resources,
                R.drawable.ore2, view.context.theme)
                Toast.makeText(view.context, "ore", Toast.LENGTH_SHORT).show()
            }
            "desert" -> { shadow = ResourcesCompat.getDrawable(view.context.resources,
                R.drawable.desert2, view.context.theme)
                Toast.makeText(view.context, "desert", Toast.LENGTH_SHORT).show()
            }
        }

        // Sets the width of the shadow to full width of the original View
        val width: Int = view.width

        // Sets the height of the shadow to full height of the original View
        val height: Int = view.height

        // The drag shadow is a Drawable. This sets its dimensions to be the same as the
        // Canvas that the system will provide. As a result, the drag shadow will fill the
        // Canvas.
        shadow?.setBounds(0, 0, width, height)

        // Sets the size parameter's width and height values. These get back to the system
        // through the size parameter.
        size.set(width, height)

        // Sets the touch point's position to be in the middle of the drag shadow
        touch.set(width / 2, height / 2)
    }

    // Defines a callback that draws the drag shadow in a Canvas that the system constructs
    // from the dimensions passed in onProvideShadowMetrics().
    override fun onDrawShadow(canvas: Canvas) {

        // Draws the Drawable in the Canvas passed in from the system.
        shadow?.draw(canvas)
    }
}


