package com.unique.survey;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;

public class triangle extends AppCompatActivity {

    private CardView squareCard, triangleCard;
    private ConstraintLayout constraint1;
    private LinearLayout constraint2,image_area;
    private EditText edge1, edge2, edge4, baseEditText, heightEditText;
    private AppCompatButton areaButtonSquare, perimeterButtonSquare, areaButtonTriangle;
    private LinearLayout ansLayout;
    private TextView resultTextView;
    private AppCompatButton backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_triangle);
        squareCard = findViewById(R.id.card_square);
        triangleCard = findViewById(R.id.card_triangle);
        constraint1 = findViewById(R.id.CONST1);
        constraint2 = findViewById(R.id.linearLayout);
        edge1 = findViewById(R.id.edge1);
        edge2 = findViewById(R.id.edge2);
        edge4 = findViewById(R.id.edge4);
        baseEditText = findViewById(R.id.base);
        heightEditText = findViewById(R.id.HEIGHT);
        areaButtonSquare = findViewById(R.id.button4);
        perimeterButtonSquare = findViewById(R.id.button5);
        areaButtonTriangle = findViewById(R.id.button6);
        ansLayout = findViewById(R.id.ANS_layout);
        resultTextView = findViewById(R.id.textView);
        backButton = findViewById(R.id.back_square);
        image_area=findViewById(R.id.ANSIMG_layout);
        squareCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                constraint1.setVisibility(View.GONE);
                constraint2.setVisibility(View.VISIBLE);
                resultTextView.setVisibility(View.GONE);
                image_area.setVisibility(View.GONE);
            }
        });

        triangleCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                constraint1.setVisibility(View.VISIBLE);
                constraint2.setVisibility(View.GONE);
                resultTextView.setVisibility(View.GONE);
                image_area.setVisibility(View.GONE);
            }
        });

        areaButtonSquare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculateSquareArea();
                hideKeyboard();
            }
        });

        perimeterButtonSquare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculateSquarePerimeter();
                hideKeyboard();
            }
        });

        areaButtonTriangle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculateTriangleArea();
                hideKeyboard();
            }
        });


        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }

    private void calculateSquareArea() {
        String lengthText1 = edge1.getText().toString().trim();
        String lengthText2 = edge2.getText().toString().trim();
        String lengthText3 = edge4.getText().toString().trim();
        if (!lengthText1.isEmpty() && !lengthText2.isEmpty() && !lengthText3.isEmpty()) {
            double length1 = Double.parseDouble(lengthText1);
            double length2 = Double.parseDouble(lengthText2);
            double length3 = Double.parseDouble(lengthText3);
            if((length1+length2)>length3 && (length3+length2)>length1 && (length1+length3)>length2){

                double s = (length1 + length2 + length3) / 2;
                double area = Math.sqrt(s * (s - length1) * (s - length2) * (s - length3));
                resultTextView.setText("Area:" + area);
                resultTextView.setVisibility(View.VISIBLE);
                image_area.setVisibility(View.VISIBLE);

            }
            else {
                resultTextView.setText("These edges don't satisfy the triangle inequality theorem");
                resultTextView.setVisibility(View.VISIBLE);
                image_area.setVisibility(View.GONE);
            }


        } else {
            resultTextView.setText("Please Enter Length of All Edge(s)");
            resultTextView.setVisibility(View.VISIBLE);
            image_area.setVisibility(View.GONE);
        }
    }

    private void calculateSquarePerimeter() {
        String lengthText1 = edge1.getText().toString().trim();
        String lengthText2 = edge2.getText().toString().trim();
        String lengthText3 = edge4.getText().toString().trim();
        if (!lengthText1.isEmpty() && !lengthText2.isEmpty() && !lengthText3.isEmpty()) {
            double length1 = Double.parseDouble(lengthText1);
            double length2 = Double.parseDouble(lengthText2);
            double length3 = Double.parseDouble(lengthText3);
            if((length1+length2)>length3 && (length3+length2)>length1 && (length1+length3)>length2){
            double perimeter = (length1 + length2 + length3);
            resultTextView.setText("PERIMETER=Edge1+Edge2+Edge3\n"+"Perimeter:" + perimeter);
            resultTextView.setVisibility(View.VISIBLE);
                image_area.setVisibility(View.GONE);}
            else {
                resultTextView.setText("These edges don't satisfy the triangle inequality theorem");
                resultTextView.setVisibility(View.VISIBLE);
                image_area.setVisibility(View.GONE);
            }
        } else {
            resultTextView.setText("Please Enter Length of All Edge(s)");
            resultTextView.setVisibility(View.VISIBLE);
            image_area.setVisibility(View.GONE);
        }
    }

    private void calculateTriangleArea() {
        String lengthText1 = baseEditText.getText().toString().trim();
        String lengthText2 = heightEditText.getText().toString().trim();
        if (!lengthText1.isEmpty() && !lengthText2.isEmpty()) {

            double base = Double.parseDouble(lengthText1);
            double height = Double.parseDouble(lengthText2);
            double area = (base * height) / 2;
            resultTextView.setText("AREA=(BasexHeight)/2\n"+"Area:" + area);
            resultTextView.setVisibility(View.VISIBLE);
        } else {
            resultTextView.setText("Please Enter Length of All Edge(s)");
            resultTextView.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
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
