package com.example.mysql.repository;

import java.util.List;

import com.example.mysql.service.tbl_relasi;

public interface SourceRelasi {
    String save(tbl_relasi tbl_relasi);

    String update(tbl_relasi tbl_relasi);

    tbl_relasi findById(String id);

    String deleteById(String id);

    List<tbl_relasi> findAll();

    List<tbl_relasi> findByPublished(boolean published);

    List<tbl_relasi> findByTitleContaining(String title);

    String deleteAll();

}
