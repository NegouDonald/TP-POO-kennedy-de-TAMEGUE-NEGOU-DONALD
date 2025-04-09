package org.example.service;



import org.example.model.Message;
import java.util.List;

public interface MessageService {
    Message getMessageById(int id);
    List<Message> getAllMessages();
    List<Message> getMessagesBySenderId(int senderId);
    List<Message> getMessagesByReceiverId(int receiverId);
    boolean sendMessage(Message message);
    boolean deleteMessage(int id);
}