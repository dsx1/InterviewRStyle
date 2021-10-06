package rstyleinterview4.service;

import org.springframework.jdbc.core.RowMapper;
import rstyleinterview4.model.Client;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ClientRowMapper implements RowMapper<Client> {
    @Override
    public Client mapRow(ResultSet resultSet, int i) throws SQLException{

        return new Client(resultSet.getInt("id"),
                resultSet.getString("lastname"),
                resultSet.getString("firstname"),
                resultSet.getInt("documenttype"),
                resultSet.getString("documentnumber"),
                resultSet.getDate("birthdate"),
                resultSet.getString("birthplace"),
                (Integer[]) resultSet.getArray("arrests").getArray());
    }
}
