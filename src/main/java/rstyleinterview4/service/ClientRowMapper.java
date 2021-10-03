package rstyleinterview4.service;

import org.springframework.jdbc.core.RowMapper;
import rstyleinterview4.model.Client;


import java.sql.Array;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClientRowMapper implements RowMapper<Client> {
    @Override
    public Client mapRow(ResultSet resultSet, int i) throws SQLException{
        //Client client = new Client();
        Client client = new Client(resultSet.getInt("id"),
                resultSet.getString("lastname"),
                resultSet.getString("firstname"),
                resultSet.getInt("documenttype"),
                resultSet.getString("documentnumber"),
                resultSet.getDate("birthdate"),
                resultSet.getString("birthplace"),
                (Integer[]) resultSet.getArray("arrests").getArray());
        /*client.setId(resultSet.getInt("id"));
        client.setLastName(resultSet.getString("lastname"));
        client.setFirstName(resultSet.getString("firstname"));
        client.setDocumentType(resultSet.getInt("documenttype"));
        client.setDocumentNumber(resultSet.getString("documentnumber"));
        client.setBirthDate(resultSet.getDate("birthdate"));
        client.setBirthPlace("birthplace");
        client.setArrests((Integer[]) resultSet.getArray("arrests").getArray());*/
        return client;
    }
}
