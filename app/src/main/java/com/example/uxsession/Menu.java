package com.example.uxsession;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Menu extends AppCompatActivity {

    private final String[] name = ProductInfo.name;
    private final int[] image = ProductInfo.image;
    private final String[] price = ProductInfo.price;
    private final String[] type =ProductInfo.type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        //get username from MainActivity
        String namePass = getIntent().getStringExtra("UserName");
        Bundle getUsername = new Bundle();

        //pass to HomeFragment
        getUsername.putString("uName", namePass);
        BottomNavigationView bottomNav = findViewById(R.id.bottomNavigationView);
        bottomNav.setOnNavigationItemSelectedListener(navListener);

        //set Home Fragment as default
        HomeFragment homeFragment = new HomeFragment();
        homeFragment.setArguments(getUsername);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, homeFragment).commit();
    }

    private final BottomNavigationView.OnNavigationItemSelectedListener navListener =
            item ->
            {
                Fragment selectedFragment = null;
                switch (item.getItemId())
                {
                        //Home button
                    case R.id.homePage:
                        String namePass = getIntent().getStringExtra("UserName");
                        Bundle getUsername = new Bundle();

                        //pass username to HomeFragment
                        getUsername.putString("uName", namePass);
                        HomeFragment homeFragment = new HomeFragment();
                        homeFragment.setArguments(getUsername);
                        selectedFragment = homeFragment;
                        break;

                        //Product Button
                    case R.id.productPage:
                        selectedFragment = new ProductFragment();
                        break;

                        //About Button
                    case R.id.aboutPage:
                        selectedFragment = new AboutFragment();
                        break;

                        //Logout button
                    default:
                        Intent openLogin = new Intent(Menu.this, MainActivity.class);
                        startActivity(openLogin);
                       break;
                }
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, selectedFragment).commit();
                return true;
            };
}





