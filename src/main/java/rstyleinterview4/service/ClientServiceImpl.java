package rstyleinterview4.service;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import rstyleinterview4.model.Client;

import java.sql.ResultSet;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class ClientServiceImpl implements ClientService{
    private static final AtomicInteger CLIENT_ID = new AtomicInteger();
    private final JdbcTemplate jdbcTemplate;

    public ClientServiceImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void create(Client client) {
        createTable();
        final int clientId= CLIENT_ID.incrementAndGet();
        jdbcTemplate.update("INSERT INTO client VALUES(?,?,?,?,?,?,?,?)", clientId, client.getLastName(), client.getFirstName(), client.getDocumentType(), client.getDocumentNumber(), client.getBirthDate(), client.getBirthPlace(), client.getArrests());
    }

    @Override
    public List<Client> readAll() {
        createTable();
        return jdbcTemplate.query("SELECT * FROM client", new ClientRowMapper());
    }

    @Override
    public Client read(String lastName, String firstName, int documentType, String documentNumber) {
        createTable();
        return jdbcTemplate.query("SELECT * FROM client WHERE lastname=? AND firstname=? AND documenttype=? AND documentnumber=?", new ClientRowMapper(), lastName, firstName, documentType, documentNumber).stream().findAny().orElse(null);
    }


    @Override
    public void createTable() {
        jdbcTemplate.execute("CREATE TABLE IF NOT EXISTS client(id SERIAL, lastname varchar(30), firstname varchar(30), documenttype int, documentnumber text, birthdate date, birthplace varchar(250), arrests int[])");
    }


}
