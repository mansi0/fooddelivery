package com.example.Imageloading.dao;

import java.text.ParseException;
import java.util.List;

import com.example.Imageloading.entity.ImageEntity;
import com.example.Imageloading.mapping.ImageMapping;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

/**
 * ImageLoadingDaoImpl
 */
@Repository
public class ImageLoadingDaoImpl implements ImageLoadingdao {

    NamedParameterJdbcTemplate template;

    public ImageLoadingDaoImpl(NamedParameterJdbcTemplate template) {
        this.template = template;
    
    }
    

    @Override
    public List<ImageEntity> getImage() {

        String sql = "select * from image";
        List<ImageEntity> listOfImageEntities = template.query(sql, new ImageMapping());
    
        return listOfImageEntities;
    }

    @Override
    public int addImage(ImageEntity imageEntity) throws ParseException {

        try {

            String sql = "insert into image values(:imagepath)";
            SqlParameterSource param = new MapSqlParameterSource().addValue("imagepath", imageEntity.getImage());
            return template.update(sql, param);
        }
        catch(Exception e) {
            return 0;
        }
        
    }

    
}