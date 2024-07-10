package com.unique.survey;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

public class circle extends AppCompatActivity {

    private EditText editTextRadius;
    private TextView textViewResult;
    private AppCompatButton buttonCalculateArea;
    private AppCompatButton buttonCalculateCircumference;
    private AppCompatButton backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circle);

        // Find views by their IDs
        backButton = findViewById(R.id.back_circle);
        editTextRadius = findViewById(R.id.editTextNumber);
        textViewResult = findViewById(R.id.textView);
        buttonCalculateArea = findViewById(R.id.button4);
        buttonCalculateCircumference = findViewById(R.id.button5);

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

        // Set OnClickListener for the "Calculate Circumference" button
        buttonCalculateCircumference.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateCircumference();
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
        // Get the radius from the EditText
        String radiusText = editTextRadius.getText().toString().trim();

        if (!radiusText.isEmpty()) {
            // Parse the input and calculate the area
            double radius = Double.parseDouble(radiusText);
            double area = Math.PI * radius * radius;

            // Display the result in the TextView
            textViewResult.setText("AREA = π x R x R\n" + "Area: " + area);
            textViewResult.setVisibility(View.VISIBLE);
        } else {
            // Handle empty input
            textViewResult.setText("Please enter the radius");
            textViewResult.setVisibility(View.VISIBLE);
        }
    }

    private void calculateCircumference() {
        // Get the radius from the EditText
        String radiusText = editTextRadius.getText().toString().trim();

        if (!radiusText.isEmpty()) {
            // Parse the input and calculate the circumference
            double radius = Double.parseDouble(radiusText);
            double circumference = 2 * Math.PI * radius;

            // Display the result in the TextView
            textViewResult.setText("PERIMETER = 2 x π x R\n" + "Perimeter: " + circumference);
            textViewResult.setVisibility(View.VISIBLE);
        } else {
            // Handle empty input
            textViewResult.setText("Please enter the radius");
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
    }
}
