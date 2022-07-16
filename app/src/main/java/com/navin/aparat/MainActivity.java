package com.navin.aparat;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationBarView;
import com.navin.aparat.adapter.TabsAdapter;
import com.navin.aparat.databinding.ActivityMainBinding;
import com.navin.aparat.fragments.CategoryFragment;
import com.navin.aparat.fragments.FavoriteFragment;
import com.navin.aparat.fragments.HomeFragment;
import com.navin.aparat.utility.TestSingleton;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    ActivityMainBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getSupportFragmentManager().beginTransaction().replace(R.id.frame_container, new HomeFragment()).commit();


        binding.bottomNav.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {


                    case R.id.item_home:

                        binding.pager.setCurrentItem(0);
                        binding.bottomNav.getMenu().findItem(R.id.item_home).setChecked(true);

                        // getSupportFragmentManager().beginTransaction().replace(R.id.frame_container , new HomeFragment()).commit();


                        break;

                    case R.id.item_category:

                        binding.pager.setCurrentItem(1);
                        binding.bottomNav.getMenu().findItem(R.id.item_category).setChecked(true);

                        // getSupportFragmentManager().beginTransaction().replace(R.id.frame_container , new CategoryFragment()).commit();


                        break;


                    case R.id.item_favorite:


                        binding.pager.setCurrentItem(2);
                        binding.bottomNav.getMenu().findItem(R.id.item_favorite).setChecked(true);
                        //  getSupportFragmentManager().beginTransaction().replace(R.id.frame_container , new FavoriteFragment()).commit();


                        break;


                }

                return false;
            }
        });


        List<Fragment> fragmentList = new ArrayList<>();

        fragmentList.add(new HomeFragment());
        fragmentList.add(new CategoryFragment());
        fragmentList.add(new FavoriteFragment());

        TabsAdapter adapter = new TabsAdapter(this, fragmentList);
        binding.pager.setAdapter(adapter);


        binding.pager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels);
            }

            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);

                switch (position) {
                    case 0:

                        binding.bottomNav.getMenu().findItem(R.id.item_home).setChecked(true);

                        break;

                    case 1:

                        binding.bottomNav.getMenu().findItem(R.id.item_category).setChecked(true);

                        break;

                    case 2:

                        binding.bottomNav.getMenu().findItem(R.id.item_favorite).setChecked(true);

                        break;
                }

            }

            @Override
            public void onPageScrollStateChanged(int state) {
                super.onPageScrollStateChanged(state);
            }
        });

        binding.pager.setUserInputEnabled(false);



        TestSingleton test = TestSingleton.getInstance();

        Calendar calendar = Calendar.getInstance();


    }


}