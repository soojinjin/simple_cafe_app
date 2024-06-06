package com.cookandroid.project_99;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.cookandroid.project_99.MenuModel;

import java.util.ArrayList;
import java.util.List;

public class DB_Menu2 extends SQLiteOpenHelper {
    public static final String MENU_TABLE = "MENU_TABLE";
    //public static final String USER_TABLE = "User";

    public static final String COLUMN_MENU_NAME = "MENU_NAME";
    public static final String COLUMN_MENU_PRICE = "MENU_PRICE";
    public static final String COLUMN_MENU_TYPE = "MENU_TYPE";
    public static final String COLUMN_ID = "ID";

    public DB_Menu2(@Nullable Context context) {
        super(context, "Basket.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableStatement = "CREATE TABLE " + MENU_TABLE + "  (" + COLUMN_ID +
                " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_MENU_NAME + " TEXT, "
                + COLUMN_MENU_PRICE + " INT, " + COLUMN_MENU_TYPE + " TEXT)";
        db.execSQL(createTableStatement);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        //db.execSQL("drop table if exists Menu");
       // onCreate(db);
    }

    public boolean addOne(MenuModel menuModel){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_MENU_NAME, menuModel.getName());
        cv.put(COLUMN_MENU_PRICE, menuModel.getPrice());
        cv.put(COLUMN_MENU_TYPE, menuModel.getType());

        long insert = db.insert(MENU_TABLE, null, cv);

        if(insert == -1){
            return false;
        }else{
            return true;
        }
    }

    public boolean deleteOne(MenuModel menuModel){
        SQLiteDatabase db = this.getWritableDatabase();
        String queryString = " DELETE FROM " + MENU_TABLE + " WHERE " + COLUMN_ID + " = " + menuModel.getId();

        Cursor cursor = db.rawQuery(queryString, null);

        if(cursor.moveToFirst()){
            return true;
        }else{
            return  false;
        }
    }

    public List<MenuModel> getEverything(){
        List<MenuModel> returnList = new ArrayList<>();
        //
        String queryString = " SELECT * FROM " + MENU_TABLE ;

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery(queryString, null);

        if (cursor.moveToFirst()) {
            //
            do {
                int menu_Id = cursor.getInt(0);
                String name = cursor.getString(1);
                int price = cursor.getInt(2);
                String type = cursor.getString(3);

                MenuModel newModel = new MenuModel(menu_Id, name, price, type);
                returnList.add(newModel);

            } while (cursor.moveToNext());
        }
        else {
            //
        }
        cursor.close();
        db.close();
        return returnList;
    }

}
