
## Android Geometry Shapes App

This is a simple Android application that demonstrates the use of basic geometric shapes (circle, rectangle, and square) in Java. The app includes implementations for calculating the area and perimeter of these shapes.

### Features

- Calculate the area and perimeter of a circle
- Calculate the area and perimeter of a rectangle
- Calculate the area and perimeter of a square

### Getting Started

#### Prerequisites

- Android Studio installed on your machine
- Basic knowledge of Java and Android development

#### Installation

1. Clone the repository:
   ```bash
      git clone https://github.com/yourusername/geometry-shapes-app.git
      ```
2. Open the project in Android Studio.
3. Build and run the project on an emulator or physical device.
### Project Structure
- `MainActivity.java`: The main activity of the application where the user interacts with the app.
- `circle.java`: Contains the implementation of the `Circle` class, including methods to calculate the area and perimeter.
- `rectangle.java`: Contains the implementation of the `Rectangle` class, including methods to calculate the area and perimeter.
- `square.java`: Contains the implementation of the `Square` class, including methods to calculate the area and perimeter.
### Usage
1. Launch the application.
2. Choose the shape you want to calculate (circle, rectangle, or square etc).
3. Enter the required dimensions.
4. Press the calculate button to see the results.
### Screenshots
#### Landing Interface
![App Screenshot](https://via.placeholder.com/468x300?text=App+Screenshot+Here)
#### Sliding Drawwer 
![App Screenshot](https://via.placeholder.com/468x300?text=App+Screenshot+Here)
#### calculation
![App Screenshot](https://via.placeholder.com/468x300?text=App+Screenshot+Here)
### Example Code
#### circle.java
``` bash
package com.example.geometryshapesapp;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

public class circle extends AppCompatActivity {

    @Override
        protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                        setContentView(R.layout.activity_circle);

                                // Implement your circle logic here
                                    }
                                    }
```
#### rectangle.java
``` bash
package com.example.geometryshapesapp;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

public class rectangle extends AppCompatActivity {

    @Override
        protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                        setContentView(R.layout.activity_rectangle);

                                // Implement your rectangle logic here
                                    }
                                    }
```
### License
- This project is licensed under the MIT License - see the [LICENSE](https://choosealicense.com/licenses/mit/) file for details.
### Acknowledgments
- Inspired by basic geometric calculations in Java.