package rstyleinterview4.service;

import org.springframework.jdbc.core.RowMapper;
import rstyleinterview4.model.Arrest;

import java.sql.ResultSet;
import java.sql.SQLException;


public class ArrestRowMapper implements RowMapper<Arrest> {
    @Override
    public Arrest mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Arrest(
                rs.getInt("id"),
                rs.getInt("organcode"),
                rs.getDate("documentdate"),
                rs.getString("documentnumber"),
                rs.getString("purpose"),
                (long) rs.getFloat("amount"),
                rs.getString("refdocnum"),
                rs.getInt("status"));
    }
}
