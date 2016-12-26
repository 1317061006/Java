package com.Test.Dao.JDBC;

import com.Test.entity.County;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

/**
 * Created by han on 2016/11/30.
 */
@Repository
public class JDBCUserRepository {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;


    private   final  String sql_countySelect="select id,countryname,countrycode from county where id = ?";
    private  final String Insert_country="insert into county(id,countryname,countrycode)"+"values"+
            "(:id,:countryname,:countrycode )";

    @Autowired
    public JDBCUserRepository(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate=jdbcTemplate;
    }

    public County findone(long id) {
        return jdbcTemplate.queryForObject(sql_countySelect, new countyRowMapper(),id);
    }

 /*java8的方式*/
//    public  County findone(long id) {
//       return jdbcTemplate.queryForObject(sql_countySelect,
//               (rs,rowNum)-> {
//                   return new County(rs.getInt("id")
//                           , rs.getString("countryname")
//                           , rs.getString("countrycode"));
//               },id);
//    }


    public  void addcountry(County county) {
        HashMap<String,Object> paramMap = new HashMap<String,Object>(){};
        paramMap.put("id",county.getId());
        paramMap.put("countryname",county.getCountryname());
        paramMap.put("countrycode",county.getCountrycode());
        namedParameterJdbcTemplate.update(Insert_country,paramMap);//数据插入
    }


    private County mapcounty(ResultSet rs,int row)throws SQLException{
        return new County(rs.getInt("id")
                          ,rs.getString("countryname")
                         ,rs.getString("countrycode")
        );
    }

    private static class countyRowMapper implements RowMapper<County> {
        public County mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new County(
                    rs.getInt("id"),
                    rs.getString("countryname"),
                    rs.getString("countrycode"));
        }

    }
}
