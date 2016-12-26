package com.Test.Dao.Spring_Data_JPA;

import com.Test.entity.County;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by han on 2016/12/1.
 */
public interface CountyRepository  extends JpaRepository<County,Integer> ,CountySweeper {


    List<County> findBycountryname(String countryname);

    @Query("   from County  c  where c.id = :id")
    List<County> ceshi(@Param("id") int id);

}
