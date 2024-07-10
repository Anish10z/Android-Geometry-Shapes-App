package com.unique.survey;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

public class rectangle extends AppCompatActivity {

    private EditText editTextLength;
    private EditText editTextWidth;
    private TextView textViewResult;
    private AppCompatButton buttonCalculateArea;
    private AppCompatButton buttonCalculatePerimeter;
    private AppCompatButton backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rectangle);

        // Find views by their IDs
        backButton = findViewById(R.id.back_square);
        editTextLength = findViewById(R.id.editTextLength);
        editTextWidth = findViewById(R.id.editTextWidth);
        textViewResult = findViewById(R.id.textView);
        buttonCalculateArea = findViewById(R.id.button4);
        buttonCalculatePerimeter = findViewById(R.id.button5);

        // Set OnClickListener for the back button
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        // Set OnClickListener for the "Calculate Area" button
        buttonCalculateArea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateArea();
                hideKeyboard();
            }
        });

        // Set OnClickListener for the "Calculate Perimeter" button
        buttonCalculatePerimeter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculatePerimeter();
                hideKeyboard();
            }
        });
    }

    @Override
    public void onBackPressed() {
        // Your custom back button behavior here
        // This method will be called when the physical back button or your button is pressed
        super.onBackPressed();
    }

    private void calculateArea() {
        // Get the length and width from the EditText
        String lengthText = editTextLength.getText().toString().trim();
        String widthText = editTextWidth.getText().toString().trim();

        if (!lengthText.isEmpty() && !widthText.isEmpty()) {
            // Parse the input and calculate the area
            double length = Double.parseDouble(lengthText);
            double width = Double.parseDouble(widthText);
            double area = length * width;

            // Display the result in the TextView
            textViewResult.setText("AREA = LENGTH x WIDTH\n" + "Area: " + area);
            textViewResult.setVisibility(View.VISIBLE);
        } else {
            // Handle empty input
            textViewResult.setText("Please enter both length and width");
            textViewResult.setVisibility(View.VISIBLE);
        }
    }

    private void calculatePerimeter() {
        // Get the length and width from the EditText
        String lengthText = editTextLength.getText().toString().trim();
        String widthText = editTextWidth.getText().toString().trim();

        if (!lengthText.isEmpty() && !widthText.isEmpty()) {
            // Parse the input and calculate the perimeter
            double length = Double.parseDouble(lengthText);
            double width = Double.parseDouble(widthText);
            double perimeter = 2 * (length + width);

            // Display the result in the TextView
            textViewResult.setText("PERIMETER = 2 x (LENGTH + WIDTH)\n" + "Perimeter: " + perimeter);
            textViewResult.setVisibility(View.VISIBLE);
        } else {
            // Handle empty input
            textViewResult.setText("Please enter both length and width");
            textViewResult.setVisibility(View.VISIBLE);
        }
    }
    private void hideKeyboard() {
        // Check if no view has focus
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
}}
