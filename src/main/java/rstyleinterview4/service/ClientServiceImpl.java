package rstyleinterview4.service;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import rstyleinterview4.model.Client;

import java.sql.ResultSet;
import java.util.ArrayList;
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
        final int clientId= CLIENT_ID.incrementAndGet();
        jdbcTemplate.update("INSERT INTO client VALUES(?,?,?,?,?,?,?,?)", clientId, client.getLastName(), client.getFirstName(), client.getDocumentType(), client.getDocumentNumber(), client.getBirthDate(), client.getBirthPlace(), client.getArrests());
    }

    @Override
    public List<Client> readAll() {
        List<Client> resultList = jdbcTemplate.query("SELECT * FROM client", new ClientRowMapper());
        return resultList;
    }

    @Override
    public Client read(Client client) {
        return jdbcTemplate.query("SELECT * FROM client WHERE lastname=? AND firstname=? AND documenttype=? AND documentnumber=?", new BeanPropertyRowMapper<>(Client.class), client.getLastName(), client.getFirstName(), client.getDocumentType(), client.getDocumentNumber()).stream().findAny().orElse(null);
    }

    @Override
    public Client read(String lastName, String firstName, int documentType, String documentNumber) {
        return jdbcTemplate.query("SELECT * FROM client WHERE lastname=? AND firstname=? AND documenttype=? AND documentnumber=?", new ClientRowMapper(), lastName, firstName, documentType, documentNumber).stream().findAny().orElse(null);
    }


}
