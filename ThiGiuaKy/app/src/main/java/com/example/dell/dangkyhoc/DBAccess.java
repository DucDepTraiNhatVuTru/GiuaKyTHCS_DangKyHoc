package com.example.dell.dangkyhoc;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.print.PrinterId;
import android.widget.Toast;

import java.util.LinkedList;

public class DBAccess extends SQLiteOpenHelper {

    public static String DB_NAME="dang_ky_hoc";
    private static String TABLE_NAME ="thongtin";
    private static String TABLE_ID ="id";
    private static String TABLE_HOTEN ="hoten";
    private static String TABLE_NGAYSINH ="ngaysinh";
    private static String TABLE_GIOITINH = "gioitih";
    private static String TABLE_KHOAHOC="khoahoc";

    private Context context;
    private static String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME +" ( "+TABLE_ID +" INTEGER PRIMARY KEY AUTOINCREMENT , "
            +TABLE_HOTEN+" TEXT, "+TABLE_NGAYSINH+" TEXT, "+TABLE_GIOITINH+" TEXT, "+TABLE_KHOAHOC+" TEXT)";

    public DBAccess(Context context){
        super(context,DB_NAME,null,1);
        this.context=context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
    }

    public void insret(ThongTinDangKy thongTinDangKy){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(TABLE_HOTEN,thongTinDangKy.getHoTen());
        values.put(TABLE_NGAYSINH,thongTinDangKy.getNgaySinh());
        values.put(TABLE_GIOITINH,thongTinDangKy.getGioiTinh());
        values.put(TABLE_KHOAHOC,thongTinDangKy.getKhoaHoc());
        db.insert(TABLE_NAME,null,values);
        db.close();
        Toast.makeText(context,"Lưu thành công " + thongTinDangKy.getHoTen() ,Toast.LENGTH_SHORT).show();
    }

    public LinkedList<ThongTinDangKy> getAll(){
        LinkedList<ThongTinDangKy> thongTinDangKyLinkedList = new LinkedList<>();

        String query = "SELECT  * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        if (cursor.moveToFirst()) {
            do{
                thongTinDangKyLinkedList.add(new ThongTinDangKy(cursor.getInt(0),cursor.getString(1),cursor.getString(2),cursor.getString(3),cursor.getString(4)));
            }while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return thongTinDangKyLinkedList;
    }
}
