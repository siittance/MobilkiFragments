package com.example.pract15;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView btm;
    private DrawerLayout dl;
    private ActionBarDrawerToggle tg;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btm = findViewById(R.id.bottom_menu);
        setFragment(new FirstFragment());
        btm.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int Id = item.getItemId();
                if (Id == R.id.first_item){
                    setFragment(new FirstFragment());
                    return true;
                }
                else if (Id == R.id.second_item){
                    setFragment(new SecondFragment());
                    return true;
                }
                else if (Id == R.id.third_item){
                    setFragment(new ThirdSecond());
                    return true;
                }
                return false;
            }
        });



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.option_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();
        if (id == R.id.settings){
            return true;
        }else if (id == R.id.frag_first){
            setFragment(new FirstFragment());
            return true;
        }else if(id == R.id.frag_second){
            setFragment(new SecondFragment());
            return true;
        }else{
            return super.onOptionsItemSelected(item);
        }

    }

    public void setFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_layout, fragment, null)
                .commit();
    }

}