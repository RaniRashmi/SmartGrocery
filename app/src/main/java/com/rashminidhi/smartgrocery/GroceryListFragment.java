package com.rashminidhi.smartgrocery;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class GroceryListFragment extends Fragment {

    Button mButton1,mButton2,mButton3,mButton4;


    public GroceryListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_grocery_list, container, false);

        mButton1 = (Button)v.findViewById(R.id.sampleButton);
        mButton2 = (Button)v.findViewById(R.id.addProduct);
        mButton3 = (Button)v.findViewById(R.id.viewAddedProduct);
        mButton4 = (Button)v.findViewById(R.id.previousAddedList);

        mButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        mButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getActivity(),AddProductActivity.class);
                startActivity(intent);

            }
        });
        mButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(),ViewAddedeProductActivity.class);
                startActivity(i);


            }
        });
        mButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        return v;
    }

}
