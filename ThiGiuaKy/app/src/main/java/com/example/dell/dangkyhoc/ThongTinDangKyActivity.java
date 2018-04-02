package com.example.dell.dangkyhoc;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import java.util.ArrayList;

public class ThongTinDangKyActivity extends AppCompatActivity {
    Button btnThem;
    EditText editHoten;
    EditText edtNgaySinh;
    RadioButton rbtnNam;
    RadioButton rbtnNu;
    CheckBox cbWord;
    CheckBox cbExcel;
    CheckBox cbPTS;
    CheckBox cbAccess;
    Button btnNhapLai;
    Button btnHienThi;
    String gioiTinh="Nam";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_thong_tin_dang_ky_hoc);
        btnThem=findViewById(R.id.btnThem);
        editHoten= findViewById(R.id.edtHoTen);
        edtNgaySinh=findViewById(R.id.edtNgaySinh);
        rbtnNam=findViewById(R.id.rbtnNam);
        rbtnNu=findViewById(R.id.rbtnNu);
        cbWord=findViewById(R.id.cbWordNC);
        cbExcel=findViewById(R.id.cbExcelNC);
        cbPTS=findViewById(R.id.cbPhotoshop);
        cbAccess=findViewById(R.id.cbAccess);
        btnNhapLai=findViewById(R.id.btnNhapLai);
        btnHienThi=findViewById(R.id.btnHienThi);


        rbtnNam.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked==true) {
                    rbtnNu.setChecked(false);
                    gioiTinh = "Nam";
                }
            }
        });

        rbtnNu.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked==true) {
                    rbtnNam.setChecked(false);
                    gioiTinh = "Nu";
                }
            }
        });

        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String khoahoc="";
                ArrayList<String> khoahocs = new ArrayList<>();
                if(cbWord.isChecked()==true)khoahocs.add(cbWord.getText().toString());
                if(cbExcel.isChecked()==true)khoahocs.add(cbExcel.getText().toString());
                if(cbPTS.isChecked()==true)khoahocs.add(cbPTS.getText().toString());
                if(cbAccess.isChecked()==true)khoahocs.add(cbAccess.getText().toString());

                for (String item:khoahocs
                     ) {
                    if(khoahoc!=""){
                        khoahoc+=" , ";
                    }
                    khoahoc+=item;
                }
                /*DBAccess access = new DBAccess(ThongTinDangKyActivity.this);
                access.insret(new ThongTinDangKy(editHoten.getText().toString(),edtNgaySinh.getText().toString(),gioiTinh,khoahoc));*/
                Instance.thongtins.add(new ThongTinDangKy(editHoten.getText().toString(),edtNgaySinh.getText().toString(),gioiTinh,khoahoc));

                Toast.makeText(ThongTinDangKyActivity.this,"Đã thêm", Toast.LENGTH_SHORT).show();
            }
        });

        btnNhapLai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editHoten.setText("");
                edtNgaySinh.setText("");
                rbtnNam.setChecked(true);
                cbWord.setChecked(false);
                cbExcel.setChecked(false);
                cbAccess.setChecked(false);
                cbPTS.setChecked(false);

            }
        });

        btnHienThi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                Intent intent = new Intent(ThongTinDangKyActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
