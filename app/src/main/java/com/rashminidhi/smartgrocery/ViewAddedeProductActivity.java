package com.rashminidhi.smartgrocery;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ViewAddedeProductActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_addede_product);

        ViewAddedProductFragment viewAddedProductFragment= new ViewAddedProductFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.container2,viewAddedProductFragment);
        //fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}
