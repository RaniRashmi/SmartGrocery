package com.rashminidhi.smartgrocery;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;


/**
 * A simple {@link Fragment} subclass.
 */
public class AddProductFragment extends Fragment {

    EditText mEditText1,mEditText2;
    Button mButton;
    Spinner mSpinner;
    String[] unit ={"kg","gram","ml","litre"};
    ArrayAdapter mArrayAdapter;
    GroceryDataBase mGroceryDataBase;

    public AddProductFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_add_product, container, false);
        mEditText1 = (EditText)v.findViewById(R.id.editText1);
        mEditText2 = (EditText)v.findViewById(R.id.editText2);
        mButton = (Button)v.findViewById(R.id.button1);
        mSpinner = (Spinner)v.findViewById(R.id.spinner);
        mArrayAdapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,unit);
        mSpinner.setAdapter(mArrayAdapter);

        mGroceryDataBase = new GroceryDataBase(getActivity());
        mGroceryDataBase.open();

        mSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                final String quantity_unit = unit[position];
                mButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        String item = mEditText1.getText().toString();
                        int quantity = Integer.parseInt(mEditText2.getText().toString());
                        //int price =0;
                        //mGroceryDataBase.insertGroceryItem(item,quantity,quantity_unit,price);
                        mGroceryDataBase.insertGroceryItem(item,quantity,quantity_unit);
                        mGroceryDataBase.open();
                    }
                });
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        return v;
    }

}
