package rstyleinterview4.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import rstyleinterview4.model.Client;
import rstyleinterview4.service.ClientService;


import java.util.List;

@RestController
public class ClientController {
    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @RequestMapping(value = "/clients", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> create(@RequestBody Client client){
        clientService.create(client);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @RequestMapping(value = "/clients", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Client>> readAll(Model model){
        final List<Client> clients = clientService.readAll();
        model.addAttribute("people", clients);
        return clients != null && !clients.isEmpty() ? new ResponseEntity<>(clients,HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @RequestMapping(value="/client", method = RequestMethod.GET)
    public ResponseEntity<Client> read(@RequestParam("lastname") String lastName,@RequestParam("firstname") String firstName,@RequestParam("documenttype") int documentType,@RequestParam("documentnumber") String documentNumber){
        final Client gotClient = clientService.read(lastName,firstName,documentType,documentNumber);
        return gotClient!=null ? new ResponseEntity<>(gotClient, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }



}
