package com.example.dell.dangkyhoc;

import android.content.Intent;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.SearchView;

import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {

    ListView lvDanhSach;
    LinkedList<ThongTinDangKy> thongTinDangKIES;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvDanhSach = findViewById(R.id.lvDanhSach);
        DBAccess access = new DBAccess(MainActivity.this);
        thongTinDangKIES=access.getAll();
        thongTinDangKIES =access.getAll();
        for (ThongTinDangKy thongtin:Instance.thongtins
             ) {
            thongTinDangKIES.add(thongtin);
        }
        ListAdapter adapter = new ListAdapter(MainActivity.this,R.layout.layout_item_danh_sach,thongTinDangKIES);
        lvDanhSach.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mymenu,menu);
        MenuItem menuItem = menu.findItem(R.id.menuThem);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case R.id.menuThem: {
                finish();
                Intent intent = new Intent(MainActivity.this, ThongTinDangKyActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.menuLuu: {
                for (ThongTinDangKy thongtin:Instance.thongtins
                     ) {
                    DBAccess access = new DBAccess(MainActivity.this);
                    access.insret(thongtin);
                }
                Instance.thongtins.clear();
                break;
            }
            case  R.id.menuThoat:{
                finish();
            }
        }
        return super.onOptionsItemSelected(item);
    }

}
