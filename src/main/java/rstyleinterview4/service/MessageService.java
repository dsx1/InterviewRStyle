package rstyleinterview4.service;

import rstyleinterview4.model.Message;

public interface MessageService {
    String create(Message message);
    String checkMessage(Message message);
}
