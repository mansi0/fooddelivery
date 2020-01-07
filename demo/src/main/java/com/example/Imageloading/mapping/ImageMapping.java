package com.example.Imageloading.mapping;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.example.Imageloading.entity.ImageEntity;

import org.springframework.jdbc.core.RowMapper;


/**
 * ImageMapping
 */
public class ImageMapping implements RowMapper<ImageEntity> {
    @Override
    public ImageEntity mapRow(ResultSet rs,int arg) throws SQLException {

        ImageEntity imageEntity=new ImageEntity();

        imageEntity.setImage(rs.getString("imagepath"));
        return imageEntity;
    }
}