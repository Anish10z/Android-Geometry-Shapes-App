package com.unique.survey;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
DrawerLayout drawerLayout;
NavigationView navigationView;
Toolbar toolbar;
Button Tool_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        //cardview attatchments
        CardView cardview_square=findViewById(R.id.card_square);
        cardview_square.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this, square.class);
                startActivity(intent);
            }
        });
        CardView cardView_circle=findViewById(R.id.card_circle);
        cardView_circle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this, circle.class);
                startActivity(intent);
            }
        });
        CardView cardview_rectangle=findViewById(R.id. card_rectangle);
        cardview_rectangle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this, rectangle.class);
                startActivity(intent);
            }
        });
        CardView cardView_triangle=findViewById(R.id.card_triangle);
        cardView_triangle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this, triangle.class);
                startActivity(intent);
            }
        });
        CardView cardview_pentagon=findViewById(R.id.card_pentagon);
        cardview_pentagon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this, pentagon.class);
                startActivity(intent);
            }
        });
        CardView cardView_hexagon=findViewById(R.id.card_hexagon);
        cardView_hexagon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this, hexagon.class);
                startActivity(intent);
            }
        });








        drawerLayout=findViewById(R.id.drawer_layout);
        navigationView=findViewById(R.id.nav_view);
        toolbar=findViewById(R.id.tool_bar);
        Tool_button=findViewById(R.id.tool_button);


        setSupportActionBar(toolbar);



        navigationView.bringToFront();
        ActionBarDrawerToggle toggle=new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();


       Tool_button.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               drawerLayout.openDrawer(findViewById(R.id.nav_view));
           }
       });
navigationView.setNavigationItemSelectedListener(this);







        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        updateNavigationMenu();

    }

    @Override
    public void onBackPressed() {
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            // Check if you are on the home screen
            if (getSupportFragmentManager().getBackStackEntryCount() == 0) {
                // If on the home screen, close the app
                finish();
            } else {
                // If not on the home screen, perform the default back action
                super.onBackPressed();
            }
        }
        navigationView.setCheckedItem(R.id.nav_home);
    }

    private boolean isLoggedIn = false; // Set this based on your authentication state

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            // Handle home click
            drawerLayout.closeDrawer(GravityCompat.START);
        } else if (id == R.id.nav_square) {
            // Handle square click
            Intent intent=new Intent(MainActivity.this, square.class);
            startActivity(intent);
        } else if (id == R.id.nav_login) {
            isLoggedIn = true;
            updateNavigationMenu();
        } else if (id == R.id.nav_logout) {
            isLoggedIn = false;
            updateNavigationMenu();
        } else if (id==R.id.nav_circle) {
            Intent intent=new Intent(MainActivity.this, circle.class);
            startActivity(intent);
        } else if (id==R.id.nav_triangle) {
            Intent intent=new Intent(MainActivity.this, triangle.class);
            startActivity(intent);
        } else if (id==R.id.nav_rate_us) {
            String url="https://play.google.com/store/games?hl=en&gl=US&pli=1";
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            startActivity(intent);
        }
        else if (id==R.id.nav_share){
            Intent intent=new Intent(Intent.ACTION_SEND);
            intent.setType("text/plain");
            String sharebody="Download the \"MEASURE\" app using the given link";
            String sharelink="https://play.google.com/store/games?hl=en&gl=US&pli=1";
            String sharemessage=sharebody+"\n\n"+sharelink;
            intent.putExtra(Intent.EXTRA_TEXT,sharemessage);

            startActivity(Intent.createChooser(intent,"Share Using"));
        }

        // Handle other item clicks as needed

        return true;
    }


    private void updateNavigationMenu() {
        NavigationView navigationView = findViewById(R.id.nav_view);
        Menu menu = navigationView.getMenu();

        MenuItem loginItem = menu.findItem(R.id.nav_login);
        MenuItem logoutItem = menu.findItem(R.id.nav_logout);
        MenuItem profileItem = menu.findItem(R.id.nav_profile);

        loginItem.setVisible(!isLoggedIn);
        logoutItem.setVisible(isLoggedIn);
        profileItem.setVisible(isLoggedIn);
    }
}