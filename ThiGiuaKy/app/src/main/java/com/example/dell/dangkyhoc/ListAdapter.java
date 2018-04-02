package com.example.dell.dangkyhoc;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.LinkedList;

import static com.example.dell.dangkyhoc.R.drawable.man;

public class ListAdapter extends BaseAdapter {

    Context context;
    int resource;
    LinkedList<ThongTinDangKy> thongTinDangKIES;

    public ListAdapter(Context context, int resource, LinkedList<ThongTinDangKy> thongTinDangKIES) {
        this.context = context;
        this.resource = resource;
        this.thongTinDangKIES = thongTinDangKIES;
    }

    @Override
    public int getCount() {
        return thongTinDangKIES.size();
    }

    @Override
    public Object getItem(int position) {
        return thongTinDangKIES.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        convertView = LayoutInflater.from(context).inflate(resource,null);
        TextView txtHoTen;
        TextView txtNgaySinh;
        TextView txtGioiTinh;
        TextView txtDangKy;
        ImageView img;
        txtHoTen = convertView.findViewById(R.id.txtvHoTen);
        txtNgaySinh = convertView.findViewById(R.id.txtvNgaySinh);
        txtGioiTinh = convertView.findViewById(R.id.txtvGioiTinh);
        txtDangKy = convertView.findViewById(R.id.txtvDangKi);
        img = convertView.findViewById(R.id.imgHinh);

        if(thongTinDangKIES.get(position).getGioiTinh().contentEquals("Nam")){
            img.setImageResource(R.drawable.man);
        }
        else {
            img.setImageResource(R.drawable.woman);
        }
        txtHoTen.setText(txtHoTen.getText() + thongTinDangKIES.get(position).getHoTen());
        txtNgaySinh.setText(txtNgaySinh.getText()+thongTinDangKIES.get(position).getNgaySinh());
        txtGioiTinh.setText(txtGioiTinh.getText() +thongTinDangKIES.get(position).getGioiTinh());
        txtDangKy.setText(txtDangKy.getText()+thongTinDangKIES.get(position).getKhoaHoc());

        return convertView;

    }
}
