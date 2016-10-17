package com.rashminidhi.smartgrocery;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by RASHMI on 10/16/2016.
 */
public class GroceryDataBase {
    MyHelper m;
    SQLiteDatabase s;
    Cursor c;

    public GroceryDataBase(Context c){
        m = new MyHelper(c,"techpalle.db",null,1);
    }

    public void open(){
        s = m.getWritableDatabase(); //load database into memory

    }
   // public void insertGroceryItem(String item,int quantity,String quantity_unit,int price){

    public void insertGroceryItem(String item,int quantity,String quantity_unit){
        ContentValues c = new ContentValues();
        c.put("item",item);
        c.put("quantity",quantity);
        c.put("quantity_unit",quantity_unit);
        //c.put("price",price);
        s.insert("grocery",null,c);
    }
    public Cursor getItem(){
        c = s.query("grocery",null,null,null,null,null,null);
        return c;
    }
    public void close(){
        s.close();
    }

    public class MyHelper extends SQLiteOpenHelper{

        public MyHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
            super(context, name, factory, version);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL("create table grocery(_id integer primary key, item text, quantity integer, quantity_unit text, price integer);");

        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        }
    }
}
