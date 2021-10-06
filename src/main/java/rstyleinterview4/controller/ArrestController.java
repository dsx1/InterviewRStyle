package rstyleinterview4.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import rstyleinterview4.model.Arrest;
import rstyleinterview4.service.ArrestService;

import java.util.List;


@RestController
public class ArrestController {
    private final ArrestService arrestService;

    @Autowired
    public ArrestController(ArrestService arrestService) {
        this.arrestService = arrestService;
    }

    @RequestMapping(value = "/arrests", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> create(@RequestBody Arrest arrest){
        arrestService.create(arrest);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @RequestMapping(value = "/arrests", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Arrest>> readAll(Model model){
        final List<Arrest> arrests = arrestService.readAll();
        model.addAttribute("arrest", arrests);
        return arrests != null && !arrests.isEmpty() ? new ResponseEntity<>(arrests,HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @RequestMapping(value="/arrest", method = RequestMethod.GET)
    public ResponseEntity<Arrest> read(@RequestParam("arrestid") int arrestId){
        final Arrest gotArrest = arrestService.read(arrestId);
        return gotArrest!=null ? new ResponseEntity<>(gotArrest, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
