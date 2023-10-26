package com.example.mysql.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.mysql.service.tbl_relasi;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

@Repository
public class KategoriRepository implements SourceRelasi {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<tbl_relasi> findAll() {
        return jdbcTemplate.query("SELECT *  from tbl_kategori",
                BeanPropertyRowMapper.newInstance(tbl_relasi.class));
    }

    @Override
    public String save(tbl_relasi tbl_relasi) {
        jdbcTemplate.update("INSERT INTO tbl_kategori (kd_kategori, nm_kategori, dupd) VALUES(?,?,CURDATE())",
                new Object[] { tbl_relasi.getKd_kategori(), tbl_relasi.getNm_kategori() });
        return "save berhasil";
    }

    @Override
    public String update(tbl_relasi tbl_relasi) {
        jdbcTemplate.update("UPDATE tbl_kategori SET nm_kategori = ? WHERE kd_kategori = ? ",
                new Object[] { tbl_relasi.getNm_kategori(), tbl_relasi.getKd_kategori() });
        return "update berhasil";
    }

    @Override
    public tbl_relasi findById(String id) {
        try {
            tbl_relasi tbl_relasi = jdbcTemplate.queryForObject("SELECT * FROM tbl_kategori WHERE kd_kategori=?",
                    BeanPropertyRowMapper.newInstance(tbl_relasi.class), id);
            return tbl_relasi;
        } catch (IncorrectResultSizeDataAccessException e) {
            return null;
        }
    }

    @Override
    public String deleteById(String id) {
        jdbcTemplate.update("DELETE FROM tbl_kategori WHERE kd_kategori = ? ",
                new Object[] { id });
        return "berhasil";
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