package com.example.dllo.project_a_section;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;

import com.example.dllo.project_a_section.Cata.CategoryFragment;
import com.example.dllo.project_a_section.Gift.GiftFragment;
import com.example.dllo.project_a_section.Home.HomeFragment;
import com.example.dllo.project_a_section.Profilt.ProfileFragment;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private RadioButton radioButton_one,radioButton_two,radioButton_three,radioButton_four;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        radioButton_one = (RadioButton) findViewById(R.id.rbt_home);
        radioButton_two = (RadioButton) findViewById(R.id.rbt_gift);
        radioButton_three = (RadioButton) findViewById(R.id.rbt_category);
        radioButton_four = (RadioButton) findViewById(R.id.rbt_profile);
        radioButton_one.setOnClickListener(this);
        radioButton_two.setOnClickListener(this);
        radioButton_three.setOnClickListener(this);
        radioButton_four.setOnClickListener(this);
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.replace, new HomeFragment());
        transaction.commit();
    }

    @Override
    public void onClick(View view) {
        FragmentManager manager =getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        switch (view.getId()){
            case R.id.rbt_home:
                transaction.replace(R.id.replace,new HomeFragment());
                break;
            case R.id.rbt_gift:
                transaction.replace(R.id.replace,new GiftFragment());
                break;
            case R.id.rbt_category:
                transaction.replace(R.id.replace,new CategoryFragment());
                break;
            case R.id.rbt_profile:
                transaction.replace(R.id.replace,new ProfileFragment());
                break;

        }
        transaction.commit();


    }
}
