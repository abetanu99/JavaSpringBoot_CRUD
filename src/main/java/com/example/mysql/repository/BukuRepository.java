package com.example.mysql.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.mysql.service.tbl_relasi;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

@Repository
public class BukuRepository implements SourceRelasi {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<tbl_relasi> findAll() {
        return jdbcTemplate.query(
                "SELECT * from tbl_kategori inner join tbl_buku on tbl_kategori.kd_kategori = tbl_buku.kd_kategori",
                BeanPropertyRowMapper.newInstance(tbl_relasi.class));
    }

    @Override
    public String save(tbl_relasi tbl_relasi) {
        jdbcTemplate.update("INSERT INTO tbl_buku (kd_kategori, nm_buku, kd_buku) VALUES(?,?,?)",
                new Object[] { tbl_relasi.getKd_kategori(), tbl_relasi.getNm_buku(), tbl_relasi.getKd_buku() });
        return "save berhasil";
    }

    @Override
    public String update(tbl_relasi tbl_relasi) {
        jdbcTemplate.update("UPDATE tbl_buku SET nm_buku = ?,kd_kategori = ? WHERE kd_buku = ? ",
                new Object[] { tbl_relasi.getNm_buku(), tbl_relasi.getKd_kategori(), tbl_relasi.getKd_buku() });
        return "update berhasil";
    }

    @Override
    public tbl_relasi findById(String id) {
        tbl_relasi tbl_relasi = jdbcTemplate.queryForObject("SELECT * FROM tbl_buku WHERE kd_buku=?",
                BeanPropertyRowMapper.newInstance(tbl_relasi.class), id);
        return tbl_relasi;
    }

    @Override
    public String deleteById(String id) {
        jdbcTemplate.update("DELETE FROM tbl_buku WHERE kd_buku = ? ",
                new Object[] { id });
        return "delete buku berhasil";
    }

    @Override
    public List<tbl_relasi> findByPublished(boolean published) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByPublished'");
    }

    @Override
    public List<tbl_relasi> findByTitleContaining(String title) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByTitleContaining'");
    }

    @Override
    public String deleteAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteAll'");
    }

}