package com.example.tabby.Activities;

import androidx.appcompat.app.AppCompatActivity;

import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.Menu;
import android.widget.Toast;
import android.widget.Toolbar;

import com.example.tabby.Adapters.PagerAdapter;
import com.example.tabby.Fragments.PersonListFragment;
import com.example.tabby.Interfaces.OnPersonCreated;
import com.example.tabby.Models.Person;
import com.example.tabby.R;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity implements OnPersonCreated {

    ViewPager viewPager;
    public static final int FORM_FRAGMENT = 0;
    public static final int LIST_FRAGMENT = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Metodo 1
        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar);
        setActionBar(myToolbar);

        //Metodo 2
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        tabLayout.addTab(tabLayout.newTab().setText("Formulario"));
        tabLayout.addTab(tabLayout.newTab().setText("Lista"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        //Metodo 3
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        PagerAdapter adapter = new PagerAdapter(getSupportFragmentManager(),tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));



        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                Toast.makeText(MainActivity.this, "Seleccionado -> " + tab.getText(), Toast.LENGTH_SHORT).show();
                int position = tab.getPosition();
                viewPager.setCurrentItem(position);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                Toast.makeText(MainActivity.this, "Deseleccionado -> "+tab.getText(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                Toast.makeText(MainActivity.this, "Reseleccioando -> "+tab.getText(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public void createPerson(Person person) {
        PersonListFragment fragment = (PersonListFragment) getSupportFragmentManager().getFragments().get(LIST_FRAGMENT);
        fragment.AddPerson(person);
        viewPager.setCurrentItem(LIST_FRAGMENT);
    }
}