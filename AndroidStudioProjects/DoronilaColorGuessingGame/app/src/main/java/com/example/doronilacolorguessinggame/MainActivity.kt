package com.example.doronilacolorguessinggame


import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Button
import java.util.*




class MainActivity : AppCompatActivity() {

    private lateinit var colorNameTextView: TextView
    private lateinit var redView: View
    private lateinit var blueView: View
    private lateinit var greenView: View
    private lateinit var yellowView: View
    private lateinit var grayView: View
    private lateinit var resetButton: Button
    private lateinit var backHomeButton: Button


    private val colorNames = listOf("Red", "Blue", "Green", "Yellow", "Gray")
    private val colors = listOf(Color.RED, Color.BLUE, Color.GREEN, Color.YELLOW, Color.GRAY)
    private var currentColorIndex: Int = 0
    private var correctGuesses: Int = 0
    private var totalGuesses: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        backHomeButton = findViewById(R.id.backHomeButton)
        backHomeButton.setOnLongClickListener{
            val backHomeIntent = Intent(this, HomeActivity::class.java)
            startActivity(backHomeIntent)
            finish()
            true
        }


        colorNameTextView = findViewById(R.id.colorNameTextView)
        redView = findViewById(R.id.redView)
        blueView = findViewById(R.id.blueView)
        greenView = findViewById(R.id.greenView)
        yellowView = findViewById(R.id.yellowView)
        grayView = findViewById(R.id.grayView)
        resetButton = findViewById(R.id.resetButton)


        setupGame()
        setupResetButton()
    }

    private fun setupGame() {
        // Initialize game state
        pickRandomColor()

        // Set up click listeners for color views
        redView.setOnClickListener { checkAnswer(Color.RED) }
        blueView.setOnClickListener { checkAnswer(Color.BLUE) }
        greenView.setOnClickListener { checkAnswer(Color.GREEN) }
        yellowView.setOnClickListener { checkAnswer(Color.YELLOW) }
        grayView.setOnClickListener { checkAnswer(Color.GRAY) }
    }


    private fun setupResetButton() {
        resetButton.setOnLongClickListener{
            // Reset game
            correctGuesses = 0
            totalGuesses = 0
            pickRandomColor()
            true
        }
    }

    private fun pickRandomColor() {
        // Pick a random color index
        currentColorIndex = Random().nextInt(colors.size)

        // Display the color name
        colorNameTextView.text = colorNames[currentColorIndex]

    }

    private fun checkAnswer(selectedColor: Int) {
        if (selectedColor == colors[currentColorIndex]) {
            // Correct answer
            colorNameTextView.text = getString(R.string.correct)
            colorNameTextView.setTextColor(Color.GREEN)
            correctGuesses++
        } else {
            // Incorrect answer
            colorNameTextView.text = getString(R.string.incorrect)
            colorNameTextView.setTextColor(Color.RED)
        }

        totalGuesses++
        if (totalGuesses == 5) {
            // Calculate and display score
            val score = (correctGuesses.toDouble() / totalGuesses.toDouble()) * 100
            val scoreText = getString(R.string.score_text, score)
            colorNameTextView.text = scoreText
            colorNameTextView.setTextColor(Color.BLACK)

            // Reset game
            correctGuesses = 0
            totalGuesses = 0

        } else {
            // Delay for a short period before moving to the next color
            val timer = Timer()
            timer.schedule(object : TimerTask() {
                override fun run() {
                    runOnUiThread {
                        // Reset text color
                        colorNameTextView.setTextColor(Color.BLACK)
                        // Pick a new random color
                        pickRandomColor()
                    }
                }
            },1500) // Delay for 1.5 seconds
        }
    }
}