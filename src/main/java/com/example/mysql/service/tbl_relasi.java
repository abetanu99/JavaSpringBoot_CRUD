package com.example.mysql.service;

// import jakarta.persistence.Column;

public class tbl_relasi {
    private String kd_kategori;
    private String nm_kategori;
    private String dupd;
    private String kd_buku;
    private String nm_buku;

    public String getKd_kategori() {
        return kd_kategori;
    }

    public void setKd_kategori(String kd_kategori) {
        this.kd_kategori = kd_kategori;
    }

    public String getNm_kategori() {
        return nm_kategori;
    }

    public void setNm_kategori(String nm_kategori) {
        this.nm_kategori = nm_kategori;
    }

    public String getDupd() {
        return dupd;
    }

    public void setDupd(String dupd) {
        this.dupd = dupd;
    }

    public String getKd_buku() {
        return kd_buku;
    }

    public void setKd_buku(String kd_buku) {
        this.kd_buku = kd_buku;
    }

    public String getNm_buku() {
        return nm_buku;
    }

    public void setNm_buku(String nm_buku) {
        this.nm_buku = nm_buku;
    }

}
