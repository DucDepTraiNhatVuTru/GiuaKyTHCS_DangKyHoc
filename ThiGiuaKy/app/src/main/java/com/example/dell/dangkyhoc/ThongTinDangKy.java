package com.example.dell.dangkyhoc;

public class ThongTinDangKy {
    private int id;
    private String hoTen;
    private String ngaySinh;
    private String gioiTinh;
    private String khoaHoc;

    public ThongTinDangKy() {
    }

    public ThongTinDangKy(int id, String hoTen, String ngaySinh, String gioiTinh, String khoaHoc) {
        this.id = id;
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        this.khoaHoc = khoaHoc;
    }

    public ThongTinDangKy(String hoTen, String ngaySinh, String gioiTinh, String khoaHoc) {
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        this.khoaHoc = khoaHoc;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getKhoaHoc() {
        return khoaHoc;
    }

    public void setKhoaHoc(String khoaHoc) {
        this.khoaHoc = khoaHoc;
    }
}
