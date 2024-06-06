package com.cookandroid.project_99;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

public class ProductDBHelper extends SQLiteOpenHelper {//TYPE 선택시 TYPE ITEM 만 나오도록 구현//
    private static ProductDBHelper dbHelper = null;

    private static final String DATABASE_NAME = "productdb";
    private static final String TABLE_NAME = "product";
    private static final int DB_VERSION = 1;

    public static final String COL_0 = "serialNumber";
    public static final String COL_1 = "id";
    public static final String COL_2 = "name";
    public static final String COL_3 = "price";
    public static final String COL_4 = "image";
    public static final String COL_5 = "type";

    private Context mContext;

    public static ProductDBHelper getInstance(Context context){
        if(dbHelper == null){
            dbHelper = new ProductDBHelper(context.getApplicationContext());
        }

        return dbHelper;
    }

    private ProductDBHelper(Context context){
        super(context, DATABASE_NAME, null, DB_VERSION);
        this.mContext = context;

        deleteAllProduct();
        initProduct();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "create table " + TABLE_NAME + " ( "
                + COL_0 + " integer primary key autoincrement, "
                + COL_1 + " integer unique, "
                + COL_2 + " text not null, "
                + COL_3 + " integer, "
                + COL_4 + " blob, "
                + COL_5 + " text not null "
                + ")";

        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "drop table " + TABLE_NAME;
        db.execSQL(sql);
        onCreate(db);
    }

    public long insertProduct(ProductBean product){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();


        values.put(COL_1, product.getId());
        values.put(COL_2, product.getName());
        values.put(COL_3, product.getPrice());
        values.put(COL_4, product.getImage());
        values.put(COL_5, product.getType());

        return db.insert(TABLE_NAME, null, values);
    }

    @SuppressLint("Range")
    public ArrayList<ProductBean> getAllProduct() {
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.query(TABLE_NAME, null, null, null, null, null, null);
        ArrayList<ProductBean> result = new ArrayList<>();

        while (cursor.moveToNext()) {
            ProductBean product = new ProductBean();

            product.setSerialNumber(cursor.getInt(cursor.getColumnIndex(COL_0)));
            product.setId(cursor.getInt(cursor.getColumnIndex(COL_1)));
            product.setName(cursor.getString(cursor.getColumnIndex(COL_2)));
            product.setPrice(cursor.getInt(cursor.getColumnIndex(COL_3)));
            product.setImage(cursor.getBlob(cursor.getColumnIndex(COL_4)));
            product.setType(cursor.getString(cursor.getColumnIndex(COL_5)));

            result.add(product);
        }

        return result;
    }

    @SuppressLint("Range")
    public ArrayList<ProductBean> getRandomProduct(){
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from " + TABLE_NAME  + " order by random() limit 6 ", null );
        ArrayList<ProductBean> result = new ArrayList<>();

        while (cursor.moveToNext()) {
            ProductBean product = new ProductBean();

            product.setSerialNumber(cursor.getInt(cursor.getColumnIndex(COL_0)));
            product.setId(cursor.getInt(cursor.getColumnIndex(COL_1)));
            product.setName(cursor.getString(cursor.getColumnIndex(COL_2)));
            product.setPrice(cursor.getInt(cursor.getColumnIndex(COL_3)));
            product.setImage(cursor.getBlob(cursor.getColumnIndex(COL_4)));
            product.setType(cursor.getString(cursor.getColumnIndex(COL_5)));

            result.add(product);
        }

        return result;
    }

    @SuppressLint("Range")
    public ArrayList<ProductBean> getProductbyType(String type){
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.query(TABLE_NAME, null, "type = ?", new String[] {type.toLowerCase()}, null, null, null);
        ArrayList<ProductBean> result = new ArrayList<>();

        while (cursor.moveToNext()) {
            ProductBean product = new ProductBean();

            product.setSerialNumber(cursor.getInt(cursor.getColumnIndex(COL_0)));
            product.setId(cursor.getInt(cursor.getColumnIndex(COL_1)));
            product.setName(cursor.getString(cursor.getColumnIndex(COL_2)));
            product.setPrice(cursor.getInt(cursor.getColumnIndex(COL_3)));
            product.setImage(cursor.getBlob(cursor.getColumnIndex(COL_4)));
            product.setType(cursor.getString(cursor.getColumnIndex(COL_5)));

            result.add(product);
        }

        return result;
    }

    public long deleteAllProduct(){
        SQLiteDatabase db = getWritableDatabase();
        return db.delete(TABLE_NAME, null, null);
    }

    private void initProduct(){
        init("product", 1, "콜드브루", 4500, getByteArrayFromDrawable(R.drawable.ice1), "coffee");
        init("product", 2,"카페라뗴", 3500, getByteArrayFromDrawable(R.drawable.ice2), "coffee");
        init("product", 3, "바닐라라떼", 4000, getByteArrayFromDrawable(R.drawable.ice3), "beverage");
        init("product", 4, "녹차라떼", 4000, getByteArrayFromDrawable(R.drawable.ice4), "beverage");
        init("product", 5, "카라멜마끼아또", 4000, getByteArrayFromDrawable(R.drawable.ice5), "beverage");
        init("product", 6, "초코라떼", 4000, getByteArrayFromDrawable(R.drawable.ice6), "beverage");
        init("product", 7, "아샷추", 3000, getByteArrayFromDrawable(R.drawable.ice7), "coffee");
        init("product", 8, "아메리카노", 3000, getByteArrayFromDrawable(R.drawable.ice8), "coffee");
        init("product", 9, "레몬에이드", 4500, getByteArrayFromDrawable(R.drawable.ice9), "beverage");
        init("product", 10, "자몽에이드", 4500, getByteArrayFromDrawable(R.drawable.ice10), "beverage");
        init("product", 11, "청포도에이드", 4500, getByteArrayFromDrawable(R.drawable.ice11), "beverage");
        init("product", 12, "딸기에이드", 4000, getByteArrayFromDrawable(R.drawable.ice12), "beverage");
        init("product", 13, "삼라봉에이드", 5000, getByteArrayFromDrawable(R.drawable.ice13), "beverage");
        init("product", 14, "민트초코라떼", 4000, getByteArrayFromDrawable(R.drawable.ice14), "beverage");
        init("product", 15, "초코라떼", 4000, getByteArrayFromDrawable(R.drawable.ice15), "beverage");
        init("product", 16, "딸기라떼", 4000, getByteArrayFromDrawable(R.drawable.ice16), "beverage");
        init("product", 17, "블랙펄라떼", 4200, getByteArrayFromDrawable(R.drawable.ice17), "beverage");
        init("product", 18, "딸기요거트스무디", 4500, getByteArrayFromDrawable(R.drawable.ice18), "beverage");
        init("product", 19, "블루베리요거트스무디", 5300, getByteArrayFromDrawable(R.drawable.ice19), "beverage");
        init("product", 20, "플레인요거트스무디", 4000, getByteArrayFromDrawable(R.drawable.ice20), "beverage");
        init("product", 21, "깔라만시에이드", 4000, getByteArrayFromDrawable(R.drawable.ice21), "beverage");
        init("product", 22, "딸기주스", 4500, getByteArrayFromDrawable(R.drawable.ice22), "beverage");
        init("product", 23, "오렌지자몽블랙티", 4000, getByteArrayFromDrawable(R.drawable.ice23), "beverage");
        init("product", 24, "페퍼민트티", 3000, getByteArrayFromDrawable(R.drawable.ice24), "beverage");
        init("product", 25, "캐모마일티", 3000, getByteArrayFromDrawable(R.drawable.ice25), "beverage");
        init("product", 26, "수박주스", 43000, getByteArrayFromDrawable(R.drawable.ice26), "beverage");
        init("product", 27, "망고주스", 4000, getByteArrayFromDrawable(R.drawable.ice27), "beverage");
        init("product", 28, "토마토주스", 4500, getByteArrayFromDrawable(R.drawable.ice28), "beverage");
        init("product", 29, "순우유마카롱", 3000, getByteArrayFromDrawable(R.drawable.ice29), "dessert");
        init("product", 30, "딸기크런치마카롱", 3000, getByteArrayFromDrawable(R.drawable.ice30), "dessert");
        init("product", 31, "초코크런치마카롱", 3000, getByteArrayFromDrawable(R.drawable.ice31), "dessert");
        init("product", 32, "파맛공공치빵", 3000, getByteArrayFromDrawable(R.drawable.ice32), "dessert");
        init("product", 33,  "초코맛공공치빵", 3000, getByteArrayFromDrawable(R.drawable.ice33), "dessert");
        init("product", 34, "크리미슈", 2300, getByteArrayFromDrawable(R.drawable.ice34), "dessert");
        init("product", 35, "크리미단팥빵", 2300, getByteArrayFromDrawable(R.drawable.ice35), "dessert");
        init("product", 36, "소프트아이스크림", 1500, getByteArrayFromDrawable(R.drawable.ice36), "dessert");
        init("product", 37, "달고나크런치", 2000, getByteArrayFromDrawable(R.drawable.ice37), "dessert");
        init("product", 38, "페스츄리와플", 2500, getByteArrayFromDrawable(R.drawable.ice38), "dessert");
        init("product", 39, "오리지널마들렌", 2800, getByteArrayFromDrawable(R.drawable.ice39), "dessert");
        init("product", 40, "초콜릿머핀", 2300, getByteArrayFromDrawable(R.drawable.ice40), "dessert");

    }

    private void init(String tableName, int id, String pName, int pPrice, byte[] pImage, String type){
        ProductBean productBean = new ProductBean();

        productBean.setId(id);
        productBean.setName(pName);
        productBean.setPrice(pPrice);
        productBean.setImage(pImage);
        productBean.setType(type);

        insertProduct(productBean);
    }

    // drawable 이미지를 sqlite에 넣기 위해 byteArray로 변환하는 함수
    private byte[] getByteArrayFromDrawable(int image){
        Drawable drawable = mContext.getDrawable(image);
        Bitmap bitmap = ((BitmapDrawable)drawable).getBitmap();
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
        byte[] dataByte = stream.toByteArray();

        return dataByte;
    }
}