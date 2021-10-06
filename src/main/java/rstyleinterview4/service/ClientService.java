package rstyleinterview4.service;

import rstyleinterview4.model.Client;

import java.util.List;

public interface ClientService {
    void create(Client client);
    List<Client> readAll();
    Client read(String lastName, String firstName, int documentType, String documentNumber);
    void createTable();
}
