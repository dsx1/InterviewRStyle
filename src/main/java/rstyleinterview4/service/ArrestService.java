package rstyleinterview4.service;

import rstyleinterview4.model.Arrest;


import java.util.List;

public interface ArrestService {
    int create(Arrest arrest);
    List<Arrest> readAll();
    Arrest read(int arrestId);
    int update(int arrestId, String newPurpose, long newAmount, int newStatus);
    Arrest read(String refDocNumber);
}
