package com.unique.survey;


import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

public class square extends AppCompatActivity {



    private EditText editTextNumber;
    private TextView textView;
    private AppCompatButton buttonArea;
    private AppCompatButton buttonPerimeter;
    private AppCompatButton BACKBUTTON;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_square);

        BACKBUTTON=findViewById(R.id.back_square);
        BACKBUTTON.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });




        // Find views by their IDs
        editTextNumber = findViewById(R.id.editTextNumber);
        textView = findViewById(R.id.textView);
        buttonArea = findViewById(R.id.button4);
        buttonPerimeter = findViewById(R.id.button5);

        // Set OnClickListener for the "Area" button
        buttonArea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateArea();
                hideKeyboard();
            }
        });

        // Set OnClickListener for the "Perimeter" button
        buttonPerimeter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculatePerimeter();
                hideKeyboard();
            }
        });
    }
    public void onBackPressed() {
        // Your custom back button behavior here
        // This method will be called when the physical back button or your button is pressed
        super.onBackPressed();
    }

    private void calculateArea() {
        // Get the edge length from the EditText
        String edgeText = editTextNumber.getText().toString().trim();

        if (!edgeText.isEmpty()) {
            // Parse the input and calculate the area
            double edge = Double.parseDouble(edgeText);
            double area = edge * edge;

            // Display the result in the TextView

            textView.setText("AREA = EDGE x EDGE\n"+"Area: " + area);
            textView.setVisibility(View.VISIBLE);
        } else {
            // Handle empty input
            textView.setText("Please enter the edge length");
            textView.setVisibility(View.VISIBLE);
        }
    }

    private void calculatePerimeter() {
        // Get the edge length from the EditText
        String edgeText = editTextNumber.getText().toString().trim();

        if (!edgeText.isEmpty()) {
            // Parse the input and calculate the perimeter
            double edge = Double.parseDouble(edgeText);
            double perimeter = 4 * edge;

            // Display the result in the TextView
            textView.setText("PERIMETER = 4 x EDGE\n"+"Perimeter: " + perimeter);
            textView.setVisibility(View.VISIBLE);
        } else {
            // Handle empty input
            textView.setText("Please enter the edge length");
            textView.setVisibility(View.VISIBLE);
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