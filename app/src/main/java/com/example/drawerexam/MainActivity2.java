package com.example.drawerexam;

import androidx.annotation.RequiresPermission;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.Toast;

import com.example.drawerexam.databinding.ActivityMain2Binding;
import com.example.drawerexam.databinding.ActivityMainBinding;
import com.google.android.material.navigation.NavigationView;

public class MainActivity2 extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityMain2Binding binding;

    NavController navController;

    DrawerLayout drawerLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main2);

        binding = ActivityMain2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

//        mAppBarConfiguration=new AppBarConfiguration.Builder(R.navigation.mobile_navigation).build();

        NavHostFragment navhost = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment_content_main);

        assert navhost != null;
        navController = navhost.getNavController();

         navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);



          drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
         RelativeLayout content = (RelativeLayout) findViewById(R.id.content);


        drawerLayout.setScrimColor(Color.TRANSPARENT);

        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close) {

            private float scaleFactor = 6f;

            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                super.onDrawerSlide(drawerView, slideOffset);

                float slideX = drawerView.getWidth() * slideOffset;
                content.setTranslationX(slideX);
                content.setScaleX(1 - (slideOffset / scaleFactor));
                content.setScaleY(1 - (slideOffset / scaleFactor));

            }
        };

        drawerLayout.setScrimColor(Color.TRANSPARENT);
        drawerLayout.setDrawerElevation(0f);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);


        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.


        binding.btnMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                drawerLayout.openDrawer(Gravity.LEFT);

            }
        });



        getSupportActionBar().hide();

    }

    public void onClick(View view) {

        switch(view.getId())
        {
            case R.id.tv1:

                Toast.makeText(MainActivity2.this,"tv1",Toast.LENGTH_SHORT).show();
                drawerLayout.close();

                navController.navigate(R.id.nav_home);

                break;

            case R.id.tv2:

                Toast.makeText(MainActivity2.this,"tv2",Toast.LENGTH_SHORT).show();
                drawerLayout.close();

                navController.navigate(R.id.nav_gallery);

                break;

            case R.id.tv3:

                Toast.makeText(MainActivity2.this,"tv3",Toast.LENGTH_SHORT).show();
                drawerLayout.close();

                navController.navigate(R.id.nav_slideshow);

                break;
        }




    }
}