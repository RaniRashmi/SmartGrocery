package com.rashminidhi.smartgrocery;


import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SimpleCursorAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class ViewAddedProductFragment extends Fragment {


    ListView mListView;
    GroceryDataBase mGroceryDataBase;


    public ViewAddedProductFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_view_added_product, container, false);

        mListView = (ListView)v.findViewById(R.id.listView);
        mGroceryDataBase = new GroceryDataBase(getActivity());
        mGroceryDataBase.open();

        Cursor c = mGroceryDataBase.getItem();
//        SimpleCursorAdapter s = new SimpleCursorAdapter(getActivity(),R.layout.row,c,new String[]{"_id","item","quantity","quantity_unit","price"},
//                 new int[]{R.id.textView2,R.id.textView3,R.id.textView4,R.id.textView5,R.id.editText3});
        SimpleCursorAdapter s = new SimpleCursorAdapter(getActivity(),R.layout.row,c,new String[]{"_id","item","quantity","quantity_unit"},
                new int[]{R.id.textView2,R.id.textView3,R.id.textView4,R.id.textView5});
        mListView.setAdapter(s);



        return v;
    }

}
